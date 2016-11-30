import React, { Component, PropTypes } from 'react';
import { DropTarget } from 'react-dnd';
import update from 'react/lib/update';
import classNames from 'classnames';
import { newDragTypes, existingDragTypes, unitSize } from '../../constants/constants';
import DraggableGridItem from '../draggableGridItem/draggableGridItem';

const draggableTarget = {
    drop(props, monitor, component) {
        /** this method will not be called if canDrop fails. **/
        switch(monitor.getItemType()) {
            case newDragTypes.NEW_ROOM:
                component.addRoom(monitor.getItem(), monitor.getClientOffset());
                break;
            case existingDragTypes.ROOM:
                component.moveRoom(monitor.getItem().index, monitor.getClientOffset());
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
                x: Math.round((offset.x - left) / unitSize),
                y: Math.round((offset.y - top) / unitSize)
            }
        };
        
        this.setState(update(this.state, {
            rooms: {
                $push: [ room ]
            }
        }));
    }
    
    moveRoom(index, offset) {
        const { top, left } = this.state.offset;
        const newPos = {
            x: Math.round((offset.x - left) / unitSize), 
            y: Math.round((offset.y - top) / unitSize)
        };
        
        this.setState(update(this.state, {
            rooms: {
                [index]: {
                    position: {
                        $set: newPos
                    }
                }
            }
        }));
    }
    
    removeRoom() {
        this.setState(update(this.state, {
            rooms: {
                $splice: [[0, 1]]
            }
        }));
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
    
    updateContainerOffset() {
        let { top, left } = document.querySelector('.grid__container').getBoundingClientRect();
        this.setState({offset: { top: top, left: left } });
    }
    
    componentDidMount() {
        this.updateContainerOffset();
        window.addEventListener('resize', this.updateContainerOffset.bind(this));
    }
    
    componentWillUnmount() {
        window.removeEventListener('resize', this.updateContainerOffset.bind(this));
    }
    
    render() {
		const gridRows = [];
		for (let i = 0; i < this.props.rows; i++) {
		    gridRows.push(this.renderRow(i));
		}
		
		const { connectDropTarget } = this.props;
	    
	    return connectDropTarget(
            <div className="grid__container">
	            {this.state.rooms.map((room, i) => 
                    <DraggableGridItem key={i} index={i} gridItem={room} dragType={existingDragTypes.ROOM} />
                )}
	            {gridRows}
            </div>
		);
	}
}

export default DropTarget([newDragTypes.NEW_ROOM, existingDragTypes.ROOM], draggableTarget, collect)(DungeonGrid);