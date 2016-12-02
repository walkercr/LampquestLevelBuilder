import React, { Component, PropTypes } from 'react';
import { DropTarget } from 'react-dnd';
import update from 'react/lib/update';
import { findDOMNode } from 'react-dom';
import { newDragTypes, existingDragTypes, unitSize } from '../../constants/constants';
import DraggableGridItem from '../draggableGridItem/draggableGridItem';

const draggableTarget = {
    drop(props, monitor, component) {
        const dragType = monitor.getItemType();
        
        switch(dragType) {
            case newDragTypes.NEW_ITEM:
                component.addItem(monitor.getItem(), monitor.getClientOffset());
                break;
            case newDragTypes.NEW_ROOM:
                component.addRoom(monitor.getItem(), monitor.getClientOffset());
                break;
            case newDragTypes.NEW_MONSTER:
                component.addMonster(monitor.getItem(), monitor.getClientOffset());
                break;
            case newDragTypes.NEW_STAIRS:
                component.addStairs(monitor.getItem(), monitor.getClientOffset());
                break;
            case existingDragTypes.ROOM:
            case existingDragTypes.MONSTER:
            case existingDragTypes.ITEM:
            case existingDragTypes.STAIRS:
                component.moveGridItem(dragType, monitor.getItem().index, monitor.getClientOffset());
        }
        
        return {
            name: 'DungeonGrid'
        };
    }
};

function collect(connect, monitor) {
    return {
        connectDropTarget: connect.dropTarget(),
        canDrop: monitor.canDrop()
    };
}

class DungeonGrid extends Component {
    static propTypes = {
        connectDropTarget: PropTypes.func.isRequired,
        canDrop: PropTypes.bool.isRequired,
        selectedDungeonObj: PropTypes.object.isRequired,
        selectedDungeonData: PropTypes.objectOf(PropTypes.array).isRequired,
        selectedLevel: PropTypes.number.isRequired,
        getSessionDataObject: PropTypes.func.isRequired,
        handleMoveGridItem: PropTypes.func.isRequired,
        handleAddGridItem: PropTypes.func.isRequired,
        handleRemoveGridItem: PropTypes.func.isRequired
    };
    
    static defaultProps = {
        selectedDungeonObj: {
            dungeonId: -1, 
            dungeonName: '', 
            dungeonWidth: 0, 
            dungeonHeight: 0, 
            dungeonDepth: 0
        }
    };
    
    addItem(data, offset) {
        const { top, left } = this.getContainerOffset();
        const itemLevel = {
            dungeonId: this.props.selectedDungeon,
            itemId: data.itemId,
            itemX: Math.round((offset.x - left) / unitSize),
            itemY: Math.round((offset.y - top) / unitSize),
            itemZ: this.props.selectedLevel,
            numberInstances: 1
        };
        
        this.props.handleAddGridItem('itemLevels', itemLevel);
    }
    
    addMonster(data, offset) {
        const { top, left } = this.getContainerOffset();
        const staticMonster = {
            dungeonId: this.props.selectedDungeon,
            monsterId: data.monsterId,
            monsterX: Math.round((offset.x - left) / unitSize),
            monsterY: Math.round((offset.y - top) / unitSize),
            depth: this.props.selectedLevel
        };
        
        this.props.handleAddGridItem('staticMonsters', staticMonster);
    }
    
    addStairs(data, offset) {
        const { top, left } = this.getContainerOffset();
        const stairsLevel = {
            stairsX: Math.round((offset.x - left) / unitSize),
            stairsY: Math.round((offset.y - top) / unitSize),
            stairsZ: this.props.selectedLevel,
            dungeonId: this.props.selectedDungeon,
            stairsPK: data.stairsPK
        };
        
        this.props.handleAddGridItem('stairsLevels', stairsLevel);
    }
    
    addRoom(data, offset) {
        const { top, left } = this.getContainerOffset();
        const roomLevel = {
            dungeonId: this.props.selectedDungeon,
            roomId: data.roomId,
            depth: this.props.selectedLevel,
            startX: Math.round((offset.x - left) / unitSize),
            startY: Math.round((offset.y - top) / unitSize)
        };
        
        this.props.handleAddGridItem('roomLevels', roomLevel);
    }
    
    moveGridItem(dragType, index, offset) {
        const { top, left } = this.getContainerOffset();
        
        const newPos = {
            x: Math.round((offset.x - left) / unitSize), 
            y: Math.round((offset.y - top) / unitSize)
        };
        
        this.props.handleMoveGridItem(dragType, index, newPos);
    }
    
    getContainerOffset() {
        return findDOMNode(this).getBoundingClientRect();
    }
    
    filterSelectedLevelData(listName, lvlField, dragType) {
        const draggableGridItems = [];
        const arr = this.props.selectedDungeonData[listName];
        const { getSessionDataObject, handleRemoveGridItem } = this.props;
        
        for (let i = 0, key = 0; i < arr.length; i++) {
            if (arr[i][lvlField] == this.props.selectedLevel) {
                const itemData = getSessionDataObject(dragType, arr[i][dragType + 'Id']);
                draggableGridItems.push(
                        <DraggableGridItem key={dragType + key++} 
                                           index={i}
                                           gridItem={arr[i]} 
                                           dragType={dragType}
                                           itemData={itemData}
                                           deleteItem={handleRemoveGridItem} />
                );
            }
        }
        
        return draggableGridItems;
    }
    
    getSelectedLevelData() {
        const { ITEM, ROOM, STAIRS, MONSTER } = existingDragTypes;
        
        return {
            itemLevels: this.filterSelectedLevelData('itemLevels', 'itemZ', ITEM),
            roomLevels: this.filterSelectedLevelData('roomLevels', 'depth', ROOM),
            stairsLevels: this.filterSelectedLevelData('stairsLevels', 'stairsZ', STAIRS),
            staticMonsters: this.filterSelectedLevelData('staticMonsters', 'depth', MONSTER)
        };
    }
    
    render() {
		const { connectDropTarget } = this.props;
		const { dungeonWidth: rows, dungeonHeight: cols } = this.props.selectedDungeonObj;
	    const containerStyle = {
	        width: cols * unitSize + 'px',
	        height: rows * unitSize + 'px'
	    };
	    
		return connectDropTarget(
            <div style={containerStyle} className="grid__container">
	            {this.getSelectedLevelData().roomLevels}
	            {this.getSelectedLevelData().itemLevels}
	            {this.getSelectedLevelData().stairsLevels}
	            {this.getSelectedLevelData().staticMonsters}
	            {[...Array(rows)].map((x, i) => 
	                <div key={'row-' + i} className="grid__row">
    	                {[...Array(cols)].map((y, j) =>
    	                    <div key={'cell-' + j} className="grid__cell"></div>
    	                )}
    	            </div>
	            )}
            </div>
		);
	}
}

export default DropTarget(Object.values(Object.assign({}, newDragTypes, existingDragTypes)), draggableTarget, collect)(DungeonGrid);