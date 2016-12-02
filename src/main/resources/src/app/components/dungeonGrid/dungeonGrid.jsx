import React, { Component, PropTypes } from 'react';
import { DropTarget } from 'react-dnd';
import update from 'react/lib/update';
import { findDOMNode } from 'react-dom';
import { newDragTypes, existingDragTypes, unitSize } from '../../constants/constants';
import DraggableGridItem from '../draggableGridItem/draggableGridItem';

const draggableTarget = {
    drop(props, monitor, component) {
        /** this method will not be called if canDrop fails. **/
        switch(monitor.getItemType()) {
            case newDragTypes.NEW_ROOM:
                component.addRoom(monitor.getItem(), monitor.getClientOffset());
                break;
            case existingDragTypes.ROOM:
                component.moveRoom(monitor.getItem().index, monitor.getClientOffset());
                break;
        }
        
        return {
            name: 'DungeonGrid'
        };
    },
    canDrop(props, monitor) {
        /** implement collision detection here **/
        return true;
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
        getSessionDataObject: PropTypes.func.isRequired
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
    
    addRoom(data, offset) {
        const { top, left } = this.getContainerOffset();
        const room = {
            data: data,
            position: {
                x: Math.round((offset.x - left) / unitSize),
                y: Math.round((offset.y - top) / unitSize)
            }
        };
        
        this.setState(update(this.state, {
            rooms: {
                $push: [ room ]
            }
        }));
    }
    
    moveRoom(index, offset) {
        const { top, left } = this.getContainerOffset();
        const newPos = {
            x: Math.round((offset.x - left) / unitSize), 
            y: Math.round((offset.y - top) / unitSize)
        };
        
        this.setState(update(this.state, {
            rooms: {
                [index]: {
                    position: {
                        $set: newPos
                    }
                }
            }
        }));
    }
    
    removeRoom() {
        this.setState(update(this.state, {
            rooms: {
                $splice: [[0, 1]]
            }
        }));
    }
    
    getContainerOffset() {
        return findDOMNode(this).getBoundingClientRect();
    }
    
    filterSelectedLevelData(listName, lvlField, dragType) {
        const draggableGridItems = [];
        const arr = this.props.selectedDungeonData[listName];
        const { getSessionDataObject } = this.props;
        
        for (let i = 0, key = 0; i < arr.length; i++) {
            if (arr[i][lvlField] == this.props.selectedLevel) {
                let itemData = getSessionDataObject(dragType, arr[i][dragType + 'Id']);
                draggableGridItems.push(
                        <DraggableGridItem key={dragType + key++} 
                                           index={i}
                                           gridItem={arr[i]} 
                                           dragType={dragType}
                                           itemData={itemData} />
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
	    
		return connectDropTarget(
            <div className="grid__container">
	            {this.getSelectedLevelData().roomLevels}
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

export default DropTarget([newDragTypes.NEW_ROOM, existingDragTypes.ROOM], draggableTarget, collect)(DungeonGrid);