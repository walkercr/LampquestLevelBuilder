import React, { Component, PropTypes } from 'react';
import { DragSource } from 'react-dnd';
import { getEmptyImage } from 'react-dnd-html5-backend';
import classNames from 'classnames';
import { newDragTypes } from '../../constants/constants';

const draggableSource = {
    beginDrag(props, monitor, component) {
        return props.data;
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
    
    renderTitle() {
        const { dragType, data } = this.props;
        
        switch(dragType) {
            case newDragTypes.NEW_ROOM:
                return data.roomName;
            case newDragTypes.NEW_ITEM:
                return data.itemName;
            case newDragTypes.NEW_MONSTER:
                return data.monsterName;
            case newDragTypes.NEW_STAIRS:
                return 'some stairs';
        }
    }
    
    renderSubtitle() {
        const { dragType, data } = this.props;
        
        switch(dragType) {
            case newDragTypes.NEW_ROOM:
                return '(' + data.roomWidth + 'x' + data.roomHeight + ')';
            default:
                return '';
        }
    }
    
    render() {
        const { isDragging, connectDragSource, dragType } = this.props;
        const classes = classNames({
            'draggable-menu-item': true,
            'draggable-menu-item--dragging': isDragging
        });
        
        return connectDragSource(
            <div className={classes}>
                <p className="draggable-menu-item__title">{this.renderTitle()}</p>
                <p className="draggable-menu-item__subtitle">{this.renderSubtitle()}</p>
            </div>
        );
    }
}

export default DragSource(props => props.dragType, draggableSource, collect)(DraggableMenuItem);