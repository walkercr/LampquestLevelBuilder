import React, { Component, PropTypes } from 'react';
import { DragLayer } from 'react-dnd';
import { DraggableTypes } from '../../constants/draggableTypes';
import Room from '../room/room';
import Monster from '../monster/monster';
import Item from '../item/item';

function collect(monitor) {
    return {
        menuItem: monitor.getItem(),
        menuItemType: monitor.getItemType(),
        initialOffset: monitor.getInitialClientOffset(),
        currentOffset: monitor.getClientOffset(),
        isDragging: monitor.isDragging()
    };
}

class MenuItemDragLayer extends Component {
    static propTypes = {
        menuItem: PropTypes.object,
        menuItemType: PropTypes.oneOf(Object.values(DraggableTypes)),
        initialOffset: PropTypes.shape({
            x: PropTypes.number.isRequired,
            y: PropTypes.number.isRequired
        }),
        currentOffset: PropTypes.shape({
            x: PropTypes.number.isRequired,
            y: PropTypes.number.isRequired
        }),
        isDragging: PropTypes.bool.isRequired
    };
    
    computePosition() {
        const { initialOffset, currentOffset } = this.props;
        if (!initialOffset || !currentOffset) {
            return {
                display: 'none'
            };
        }
       
        const { x, y } = currentOffset;
        
        return {
            transform: `translate(${x - 10}px, ${y - 10}px)`
        }
    }
    
    renderDragLayer() {
        const { menuItem, menuItemType } = this.props;
        
        switch(menuItemType) {
        case DraggableTypes.ROOM:
            return (<Room width={menuItem.roomWidth * 25} height={menuItem.roomHeight * 25} />);
        case DraggableTypes.MONSTER:
            return (<Monster />);
        case DraggableTypes.ITEM:
            return (<Item />);
        default:    // DraggableTypes.STAIRS
            return (<div>STAIRS</div>);
        }
    }
    
    render() {
        // TODO: is this check even necessary?
        const { isDragging } = this.props;
        if (!isDragging) {
            return null;
        }
        
        return (
            <div className="menu-item-drag-layer">
                <div style={this.computePosition()}>
                    {this.renderDragLayer()}
                </div>
            </div>
        );
    }
}

export default DragLayer(collect)(MenuItemDragLayer);