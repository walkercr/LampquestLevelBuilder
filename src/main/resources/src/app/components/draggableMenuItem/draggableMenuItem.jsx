import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';
import classNames from 'classnames';
import { newDragTypes } from '../../constants/constants';

const draggableSource = {
    beginDrag(props, monitor, component) {
        return props.data;
    },
    endDrag(props, monitor, component) {
        const item = monitor.getItem();
        const dropResult = monitor.getDropResult();
        // TODO: remove this ish
        if (dropResult) {
          //window.alert(`You dropped a(n) ${monitor.getItemType()} into ${dropResult.name}!`);
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
        dragType: PropTypes.oneOf(Object.values(newDragTypes)).isRequired
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

export default DragSource(props => props.dragType, draggableSource, collect)(DraggableMenuItem);