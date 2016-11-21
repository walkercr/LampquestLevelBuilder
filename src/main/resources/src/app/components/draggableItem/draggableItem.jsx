import React, { Component, PropTypes } from 'react';
import { DraggableItemTypes } from '../draggableItemTypes/draggableItemTypes.jsx';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';

const draggableItemSource = {
    beginDrag(props) {
        return {
            type: props.type
        };
    },
    endDrag(props, monitor) {
        const item = monitor.getItem();
        const dropResult = monitor.getDropResult();
        
        if (dropResult) {
          window.alert(`You dropped a(n) ${item.type} into ${dropResult.name}!`);
        }
    }
};

function collect(connect, monitor) {
    return {
        connectDragSource: connect.dragSource(),
        //connectDragPreview: connect.dragPreview(),
        isDragging: monitor.isDragging()
    };
}

class DraggableItem extends Component {
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        //connectDragPreview: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
        type: PropTypes.string.isRequired,
        data: PropTypes.object.isRequired
    };
    
    /*componentDidMount() {
        this.props.connectDragPreview(getEmptyImage(), {
            captureDraggingState: true
        });
    }*/
    
    render() {
        const styles = {
            color: '#fff',
            padding: '10px',
            marginBottom: '5px',
            background: '#ff0000',
            opacity: 1
        };
        
        const { isDragging, connectDragSource } = this.props;
        styles.opacity = isDragging ? 0.5 : 1;
        
        return connectDragSource(
            <div className="draggable-menu-item">{this.props.children}</div>
        );
    }
}

export default DragSource(props => props.type, draggableItemSource, collect)(DraggableItem);