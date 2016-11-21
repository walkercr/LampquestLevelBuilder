import React, { Component, PropTypes } from 'react';
import { DraggableItemTypes } from '../draggableItemTypes/draggableItemTypes.jsx';
import { DropTarget } from 'react-dnd';

const draggableTarget = {
    drop() {
        return {
            name: 'DungeonGrid'
        };
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
        roomsOnGrid: []
    };
    
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
		    <div className="grid">
		        <div className="grid__wrapper">
	                <div style={styles} className="grid__container">
	                    {gridRows}
	                </div>
	            </div>
            </div>
		);
	}
}

export default DropTarget(DraggableItemTypes.ROOM, draggableTarget, collect)(DungeonGrid);