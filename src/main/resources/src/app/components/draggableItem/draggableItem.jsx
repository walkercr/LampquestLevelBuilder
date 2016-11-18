import React, { Component, PropTypes } from 'react';
import { DraggableItemTypes } from '../draggableItemTypes/draggableItemTypes.jsx';
import { DragSource } from 'react-dnd';

const draggableItemSource = {
    beginDrag(props) {
        return {
            name: props.name
        };
    },
    endDrag(props, monitor) {
        const item = monitor.getItem();
        const dropResult = monitor.getDropResult();
        
        if (dropResult) {
          window.alert(`You dropped ${item.name} into ${dropResult.name}!`);
        }
    }
};

function collect(connect, monitor) {
    return {
        connectDragSource: connect.dragSource(),
        isDragging: monitor.isDragging()
    };
}

class DraggableItem extends Component {
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
        name: PropTypes.string.isRequired
    };
    
    render() {
        const styles = {
            color: '#fff',
            width: '50px',
            height: '50px',
            background: '#ff0000'
        };
        
        const { isDragging, connectDragSource, name } = this.props;
        const opacity = isDragging ? 0.5 : 1;
        
        return connectDragSource(
            <div style={{...styles, opacity}}>{name}</div>
        );
    }
}

export default DragSource(DraggableItemTypes.TEST, draggableItemSource, collect)(DraggableItem);