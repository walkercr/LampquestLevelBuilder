import React, { Component, PropTypes } from 'react';
import { DragLayer } from 'react-dnd';
import { newDragTypes, existingDragTypes, unitSize } from '../../constants/constants';
import Room from '../room/room';
import Monster from '../monster/monster';
import Item from '../item/item';
import Stairs from '../stairs/stairs';

function collect(monitor) {
    return {
        dragItem: monitor.getItem(),
        dragType: monitor.getItemType(),
        currentOffset: monitor.getClientOffset(),
        isDragging: monitor.isDragging()
    };
}

class DraggableOverlay extends Component {
    static propTypes = {
        dragItem: PropTypes.object,
        dragType: PropTypes.oneOf(Object.values(Object.assign({}, newDragTypes, existingDragTypes))),
        currentOffset: PropTypes.shape({
            x: PropTypes.number.isRequired,
            y: PropTypes.number.isRequired
        }),        
        isDragging: PropTypes.bool.isRequired
    };
    
    computePosition() {
        const { currentOffset } = this.props;
        if (!currentOffset) {
            return {
                display: 'none'
            };
        }
        
        const { x, y } = currentOffset;
        return {
            transform: `translate3d(${x}px, ${y}px, 0)`
        }
    }
    
    renderDragLayer() {
        const { dragItem, dragType } = this.props;
        switch(dragType) {
            case newDragTypes.NEW_ROOM:
                return (<Room width={dragItem.roomWidth * unitSize} 
                              height={dragItem.roomHeight * unitSize} />);
            case existingDragTypes.ROOM:
                return (<Room width={dragItem.itemData.roomWidth * unitSize} 
                              height={dragItem.itemData.roomHeight * unitSize} />);
            case newDragTypes.NEW_MONSTER:
            case existingDragTypes.MONSTER:
                return (<Monster />);
            case newDragTypes.NEW_ITEM:
            case existingDragTypes.ITEM:
                return (<Item />);
            case newDragTypes.NEW_STAIRS:
            case existingDragTypes.STAIRS:
                return (<Stairs />);
        }
    }
    
    render() {
        // TODO: is this check even necessary?
        const { isDragging } = this.props;
        if (!isDragging) {
            return null;
        }
        
        return (
            <div className="draggable-overlay">
                <div style={this.computePosition()}>
                    {this.renderDragLayer()}
                </div>
            </div>
        );
    }
}

export default DragLayer(collect)(DraggableOverlay);