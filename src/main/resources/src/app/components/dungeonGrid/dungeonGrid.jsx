import React, { Component, PropTypes } from 'react';
import { DropTarget } from 'react-dnd';
import update from 'react/lib/update';
import classNames from 'classnames';
import { newDragTypes, existingDragTypes } from '../../constants/constants';
import DraggableGridItem from '../draggableGridItem/draggableGridItem';
import Room from '../room/room';

const draggableTarget = {
    drop(props, monitor, component) {
        /** this method will not be called if canDrop fails. **/
        switch(monitor.getItemType()) {
            case newDragTypes.NEW_ROOM:
                component.addRoom(monitor.getItem(), monitor.getClientOffset());
                break;
            case existingDragTypes.ROOM:
                // existing room on grid
                break;
        }
        
        return {
            name: 'DungeonGrid'
        };
    },
    canDrop(props, monitor) {
        /** implement collision detection here **/
        return true;
    }
};

function collect(connect, monitor) {
    return {
        connectDropTarget: connect.dropTarget(),
        canDrop: monitor.canDrop()
    };
}

class DungeonGrid extends Component {
    static propTypes = {
        connectDropTarget: PropTypes.func.isRequired,
        canDrop: PropTypes.bool.isRequired,
        rows: PropTypes.number.isRequired,
        columns: PropTypes.number.isRequired
    };
    
    state = {
        offset: {
            top: 0,
            left: 0
        },
        rooms: []
    };
    
    addRoom(data, offset) {
        const { top, left } = this.state.offset;
        const room = {
            data: data,
            position: {
                x: Math.round((offset.x - left) / 25),
                y: Math.round((offset.y - top) / 25)
            }
        };
        
        this.setState(update(this.state, {
            rooms: {
                $push: [ room ]
            }
        }));
    }
    
    removeRoom() {
        
    }
    
    moveRoom() {
        
    }
    
    computeRoomPosition(i) {
        const { x, y } = this.state.rooms[i].position;
        return {
            transform: `translate3d(${x * 25}px, ${y * 25}px, 0)`
        };
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
    
    // TODO: How do you get element position in React?
    // Get the grid containers viewport offsets so we can place newly
    // dragged items on the correct grid location.
    componentDidMount() {
        let { top, left } = document.querySelector('.grid__container').getBoundingClientRect();
        this.setState({offset: { top: top, left: left } });
    }
    
    render() {
		const gridRows = [];
		for (let i = 0; i < this.props.rows; i++) {
		    gridRows.push(this.renderRow(i));
		}
		
		const { connectDropTarget } = this.props;
	    
	    return connectDropTarget(
            <div className="grid__container">
	            {this.state.rooms.map((obj, i) => 
                    <DraggableGridItem key={i} position={this.computeRoomPosition(i)} dragType={existingDragTypes.ROOM}>
	                    <Room width={obj.data.roomWidth * 25} height={obj.data.roomHeight * 25} />
	                </DraggableGridItem>
                )}
	            {gridRows}
            </div>
		);
	}
}

export default DropTarget([newDragTypes.NEW_ROOM, existingDragTypes.ROOM], draggableTarget, collect)(DungeonGrid);