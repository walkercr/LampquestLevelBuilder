import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';
import classNames from 'classnames';
import { existingDragTypes, unitSize } from '../../constants/constants';
import Item from '../item/item';
import Room from '../room/room';
import Monster from '../monster/monster';
import Stairs from '../stairs/stairs';

const draggableSource = {
    beginDrag(props, monitor, component) {
        return {
            index: props.index,
            gridItem: props.gridItem,
            itemData: props.itemData
        };
    }
};

function collect(connect, monitor) {
    return {
        connectDragSource: connect.dragSource(),
        connectDragPreview: connect.dragPreview(),
        isDragging: monitor.isDragging()
    };
}

class DraggableGridItem extends Component {
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        connectDragPreview: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
        dragType: PropTypes.oneOf(Object.values(existingDragTypes)).isRequired,
        gridItem: PropTypes.object.isRequired,
        index: PropTypes.number.isRequired,
        itemData: PropTypes.object.isRequired,
        deleteItem: PropTypes.func.isRequired
    };
    
    computePosition() {
        const { gridItem } = this.props;
        let x = 0, y = 0;
        
        switch(this.props.dragType) {
            case existingDragTypes.ITEM:
                x = gridItem.itemX;
                y = gridItem.itemY;
                break;
            case existingDragTypes.ROOM:
                x = gridItem.startX;
                y = gridItem.startY;
                break;
            case existingDragTypes.STAIRS:
                x = gridItem.stairsX;
                y = gridItem.stairsY;
                break;
            case existingDragTypes.MONSTER:
                x = gridItem.monsterX;
                y = gridItem.monsterY;
        }
        
        return {
            transform: `translate3d(${x * unitSize}px, ${y * unitSize}px, 0)`
        };
    }
    
    renderGridItem() {
        const { itemData } = this.props;
        let el = (<div></div>);
        
        switch(this.props.dragType) {
            case existingDragTypes.ITEM:
                el = (<Item />);
                break;
            case existingDragTypes.ROOM:
                el = (<Room width={itemData.roomWidth * unitSize} 
                            height={itemData.roomHeight * unitSize} />);
                break;
            case existingDragTypes.STAIRS:
                el = (<Stairs />);
                break;
            case existingDragTypes.MONSTER:
                el = (<Monster />);
        }
        
        return el;
    }
    
    componentDidMount() {
        this.props.connectDragPreview(getEmptyImage(), {
            captureDraggingState: true
        });
    }
    
    onRightClick(e) {
        e.preventDefault();
        const { dragType, deleteItem, index } = this.props;
        let listName;
        switch(dragType) {
            case existingDragTypes.ITEM:
                listName = 'itemLevels';
                break;
            case existingDragTypes.ROOM:
                listName = 'roomLevels';
                break;
            case existingDragTypes.STAIRS:
                listName = 'stairsLevels';
                break;
            case existingDragTypes.MONSTER:
                listName = 'staticMonsters';
        }
        this.props.deleteItem(listName, index);
    }
    
    render() {
        const { connectDragSource, isDragging } = this.props;
        const classes = classNames({
            'draggable-grid-item': true,
            'draggable-grid-item--dragging': isDragging
        });
        
        return connectDragSource(
            <div style={this.computePosition()} className={classes} onContextMenu={this.onRightClick.bind(this)}>
                {this.renderGridItem()}
            </div>
        );
    }
}

export default DragSource(props => props.dragType, draggableSource, collect)(DraggableGridItem);