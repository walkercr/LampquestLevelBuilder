import React, { Component, PropTypes } from 'react';
import { DropTarget } from 'react-dnd';

class DroppableGridItem extends Component {
    static propTypes = {
        
    };
    
    render() {
        return (
            <div class="droppable-grid-item">{this.props.children}</div>
        );
    }
}