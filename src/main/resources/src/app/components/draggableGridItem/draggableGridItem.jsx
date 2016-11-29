import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { existingDragTypes } from '../../constants/constants';

const draggableSource = {
    beginDrag(props, monitor, component) {
        return {};
    }
};

function collect(connect, monitor) {
    return {
        connectDragSource: connect.dragSource(),
        isDragging: monitor.isDragging()
    };
}

class DraggableGridItem extends Component {
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
        dragType: PropTypes.oneOf(Object.values(existingDragTypes)).isRequired,
        position: PropTypes.object.isRequired
    };
    
    render() {
        const { position, connectDragSource } = this.props;
        
        return connectDragSource(
            <div style={position} className="draggable-grid-item">
                {this.props.children}
            </div>
        );
    }
}

export default DragSource(props => props.dragType, draggableSource, collect)(DraggableGridItem);