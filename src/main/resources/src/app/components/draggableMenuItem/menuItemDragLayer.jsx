import React, { Component, PropTypes } from 'react';
import { DragLayer } from 'react-dnd';
import { newDragTypes, existingDragTypes } from '../../constants/constants';
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
        menuItemType: PropTypes.oneOf(Object.values(Object.assign({}, newDragTypes, existingDragTypes))),
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
            transform: `translate3d(${x}px, ${y}px, 0)`
        }
    }
    
    renderDragLayer() {
        const { menuItem, menuItemType } = this.props;
        
        switch(menuItemType) {
            case newDragTypes.NEW_ROOM:
            case existingDragTypes.ROOM:
                return (<Room width={menuItem.roomWidth * 25} height={menuItem.roomHeight * 25} />);
            case newDragTypes.NEW_MONSTER:
            case existingDragTypes.MONSTER:
                return (<Monster />);
            case newDragTypes.NEW_ITEM:
            case existingDragTypes.ITEM:
                return (<Item />);
            case newDragTypes.NEW_STAIRS:
            case existingDragTypes.STAIRS:
                return (<div>STAIRS</div>);
            default:
                console.warn('invalid draggable-menu-item type.');
                return (<div>UNKNOWN</div>);
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