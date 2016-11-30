import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';
import classNames from 'classnames';
import { existingDragTypes } from '../../constants/constants';
import Room from '../room/room';

const draggableSource = {
    beginDrag(props, monitor, component) {
        // TODO: this is ugly and bad. REFACTOR.
        const { data, position } = props.gridItem;
        
        return {
            index: props.index,
            roomWidth: data.roomWidth,
            roomHeight: data.roomHeight,
            position: position
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
    /**
     * @param dragType Array of existing drag types; 
     *      any of ['room', 'monster', 'item', 'stairs']
     * 
     * @param position The grid coordinates of the given draggable grid
     *      item.
     */
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        connectDragPreview: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
        dragType: PropTypes.oneOf(Object.values(existingDragTypes)).isRequired,
        gridItem: PropTypes.object.isRequired,
        index: PropTypes.number.isRequired
    };
    
    constructor(props) {
        super(props);
        this.state = {
            position: props.position 
        };
    }
    
    computePosition() {
        const { x, y } = this.props.gridItem.position;
        return {
            transform: `translate3d(${x * 25}px, ${y * 25}px, 0)`
        };
    }
    
    // TODO: replace hard-coded 25 with dynamic value
    renderGridItem() {
        switch(this.props.dragType) {
            case existingDragTypes.ROOM:
                const { roomWidth, roomHeight } = this.props.gridItem.data;
                return (
                    <Room width={roomWidth * 25} height={roomHeight * 25} />
                );
            case existingDragTypes.MONSTER:
                break;
            case existingDragTypes.ITEM:
                break;
            case existingDragTypes.STAIRS:
                break;
            default:
                console.warn('Invalid dragType in renderGridItem() - draggableGridItem.jsx');
        }
    }
    
    componentDidMount() {
        this.props.connectDragPreview(getEmptyImage(), {
            captureDraggingState: true
        });
    }
    
    render() {
        const { connectDragSource, isDragging } = this.props;
        const classes = classNames({
            'draggable-grid-item': true,
            'draggable-grid-item--dragging': isDragging
        });
        
        return connectDragSource(
            <div style={this.computePosition()} className={classes}>
                {this.renderGridItem()}
            </div>
        );
    }
}

export default DragSource(props => props.dragType, draggableSource, collect)(DraggableGridItem);