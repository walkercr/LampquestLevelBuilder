import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';
import classNames from 'classnames';
import { existingDragTypes, unitSize } from '../../constants/constants';
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
            transform: `translate3d(${x * unitSize}px, ${y * unitSize}px, 0)`
        };
    }
    
    renderGridItem() {
        switch(this.props.dragType) {
            case existingDragTypes.ROOM:
                const { roomWidth, roomHeight } = this.props.gridItem.data;
                return (
                    <Room width={roomWidth * unitSize} height={roomHeight * unitSize} />
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