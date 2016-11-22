import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';
import { DraggableTypes } from '../../constants/draggableTypes';
import classNames from 'classnames';

const draggableSource = {
    beginDrag(props) {
        return props.data;
    },
    endDrag(props, monitor) {
        const item = monitor.getItem();
        const dropResult = monitor.getDropResult();
        if (dropResult) {
          window.alert(`You dropped a(n) ${monitor.getItemType()} into ${dropResult.name}!`);
        }
    }
};

function collect(connect, monitor) {
    return {
        connectDragSource: connect.dragSource(),
        connectDragPreview: connect.dragPreview(),
        isDragging: monitor.isDragging()
    };
}

class DraggableMenuItem extends Component {
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        connectDragPreview: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
        data: PropTypes.object.isRequired,
        type: PropTypes.oneOf(Object.values(DraggableTypes)).isRequired
    };
    
    componentDidMount() {
        this.props.connectDragPreview(getEmptyImage(), {
            captureDraggingState: true
        });
    }
    
    render() {
        const { isDragging, connectDragSource } = this.props;
        const classes = classNames({
            'draggable-menu-item': true,
            'draggable-menu-item--dragging': isDragging
        });
        
        return connectDragSource(
            <div className={classes}>
                {this.props.children}
            </div>
        );
    }
}

export default DragSource(props => props.type, draggableSource, collect)(DraggableMenuItem);