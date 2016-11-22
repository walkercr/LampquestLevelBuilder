import React, { Component, PropTypes } from 'react';
import { DraggableTypes } from '../../constants/draggableTypes';
import { DropTarget } from 'react-dnd';
import update from 'react/lib/update';

const draggableTarget = {
    drop(props, monitor, component) {
        /** this method will not be called if canDrop fails. **/
        // Obtain the dragged item
        const room = monitor.getItem();
        const { x, y } = monitor.getClientOffset();
        room.x = x;
        room.y = y;
        component.addRoom(room);
        return {
            name: 'DungeonGrid'
        };
    },
    canDrop(props, monitor) {
        /** implement collision detection here **/
        // http://gaearon.github.io/react-dnd/docs-drop-target.html
        return true;
    }
};

function collect(connect, monitor) {
    return {
        connectDropTarget: connect.dropTarget(),
        isOver: monitor.isOver(),
        canDrop: monitor.canDrop()
    };
}

class DungeonGrid extends Component {
    static propTypes = {
        rows: PropTypes.number.isRequired,
        columns: PropTypes.number.isRequired,
        connectDropTarget: PropTypes.func.isRequired,
        isOver: PropTypes.bool.isRequired,
        canDrop: PropTypes.bool.isRequired
    };
    
    state = {
        dungeonRooms: []
    };
    
    addRoom(room) {
        this.setState(update(this.state, {
            dungeonRooms: {
                $push: [ room ]
            }
        }));
    }
    
    removeRoom() {
        
    }
    
    moveRoom() {
        
    }
    
    renderRow(i) {
        const gridCells = [];
        for (let j = 0; j < this.props.columns; j++) {
            gridCells.push(<div key={j} className="grid__cell"></div>);
        }
        
        return (
            <div key={i} className="grid__row">
                {gridCells}
            </div>
        );
    }
    
    
    render() {
		const gridRows = [];
		for (let i = 0; i < this.props.rows; i++) {
		    gridRows.push(this.renderRow(i));
		}
		
		const { canDrop, isOver, connectDropTarget } = this.props;
	    const isActive = canDrop && isOver;
	    
	    const styles = {};
	    if (isActive) {
	        styles.background = 'yellow';
	    }
	    
	    return connectDropTarget(
            <div style={styles} className="grid__container">
                {gridRows}
            </div>
		);
	}
}

export default DropTarget(DraggableTypes.ROOM, draggableTarget, collect)(DungeonGrid);