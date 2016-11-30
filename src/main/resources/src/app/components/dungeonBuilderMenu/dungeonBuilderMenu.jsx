import React, { Component, PropTypes } from 'react';
import { newDragTypes } from '../../constants/constants';
import DraggableMenuItem from '../draggableMenuItem/draggableMenuItem';

export default class DungeonBuilderMenu extends Component {
    
    static propTypes = {
        data: PropTypes.object.isRequired
    };
    
    constructor(props) {
        super(props);
        this.state = props.data;
    }
    
    render() {
        const { rooms, monsters, items } = this.state;
        
        return (
            <aside className="dungeon-builder-menu">
                <div className="dungeon-builder-menu__header">
                    <div className="dungeon-builder-menu__toggle"></div>
                </div>
                <div className="dungeon-builder-menu__body">
                    <div className="draggable-item-panel">
                        <div className="draggable-item-panel__header">
                            <p className="draggable-item-panel__title">Rooms</p>
                        </div>
                        <div className="draggable-item-panel__body">
                            {rooms.map((data, i) => 
                                <DraggableMenuItem key={i} data={data} dragType={newDragTypes.NEW_ROOM}>
                                    <p className="draggable-menu-item__title">{data.roomName}</p>
                                    <p className="draggable-menu-item__subtitle">{'(' + data.roomWidth + 'x' + data.roomHeight + ')'}</p>
                                </DraggableMenuItem>
                            )}
                        </div>
                    </div>
                    <div className="draggable-item-panel">
                        <div className="draggable-item-panel__header">
                            <p className="draggable-item-panel__title">Monsters</p>
                        </div>
                        <div className="draggable-item-panel__body">
                            {monsters.map((data, i) => 
                                <DraggableMenuItem key={i} data={data} dragType={newDragTypes.NEW_MONSTER}>
                                    <p className="draggable-menu-item__title">{data.monsterName}</p>
                                </DraggableMenuItem>
                            )}
                        </div>
                    </div>
                    <div className="draggable-item-panel">
                        <div className="draggable-item-panel__header">
                            <p className="draggable-item-panel__title">Items</p>
                        </div>
                        <div className="draggable-item-panel__body">
                            {items.map((data, i) => 
                                <DraggableMenuItem key={i} data={data} dragType={newDragTypes.NEW_ITEM}>
                                    <p className="draggable-menu-item__title">{data.itemName}</p>
                                </DraggableMenuItem>
                            )}
                        </div>
                    </div>
                    <div className="draggable-item-panel">
                        <div className="draggable-item-panel__header">
                            <p className="draggable-item-panel__title">Stairs</p>
                        </div>
                        <div className="draggable-item-panel__body">
                            
                        </div>
                    </div>
                </div>
            </aside>
        );
    }
}