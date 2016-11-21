import React, { Component } from 'react';
import DraggableItem from '../draggableItem/draggableItem.jsx';
import { DraggableItemTypes } from '../draggableItemTypes/draggableItemTypes.jsx';

export default class DungeonBuilderMenu extends Component {
    render() {
        const rooms = [
            { roomId: 1, roomName: 'Room 1', roomWidth: 3, roomHeight: 3 },
            { roomId: 2, roomName: 'Room 2', roomWidth: 4, roomHeight: 4 },
            { roomId: 3, roomName: 'Room 3', roomWidth: 5, roomHeight: 5 }
        ],
        monsters = [
            { monsterId: 1, monsterName: 'Monster A', monsterChar: 'A', monsterColor: 'red' },
            { monsterId: 2, monsterName: 'Monster B', monsterChar: 'B', monsterColor: 'green' },
            { monsterId: 3, monsterName: 'Monster C', monsterChar: 'C', monsterColor: 'blue' }
        ],
        items = [
            { itemId: 1, itemName: 'Item X', itemChar: 'X', itemColor: 'orange' },
            { itemId: 2, itemName: 'Item Y', itemChar: 'Y', itemColor: 'yellow' },
            { itemId: 3, itemName: 'Item Z', itemChar: 'Z', itemColor: 'purple' }
        ],
        stairs = [
            // TODO: not sure what would go here... then again this is just a
            // crude mock-up so I will leave out stairs for now.
        ];
        
        const containerStyles = {
            paddingBottom: '10px'
        },
        containerTitleStyles = {
            color: '#fff'
        };
        
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
                                <DraggableItem key={i} data={data} type={DraggableItemTypes.ROOM}>
                                    <p className="draggable-menu-item__title">{data.roomName}</p>
                                    <p className="draggable-menu-item__subtitle">{'(' + data.roomWidth + 'x' + data.roomHeight + ')'}</p>
                                </DraggableItem>
                            )}
                        </div>
                    </div>
                    <div className="draggable-item-panel">
                        <div className="draggable-item-panel__header">
                            <p className="draggable-item-panel__title">Monsters</p>
                        </div>
                        <div className="draggable-item-panel__body">
                            {monsters.map((data, i) => 
                                <DraggableItem key={i} data={data} type={DraggableItemTypes.MONSTER}>
                                    <p className="draggable-menu-item__title">{data.monsterName}</p>
                                </DraggableItem>
                            )}
                        </div>
                    </div>
                    <div className="draggable-item-panel">
                        <div className="draggable-item-panel__header">
                            <p className="draggable-item-panel__title">Items</p>
                        </div>
                        <div className="draggable-item-panel__body">
                            {items.map((data, i) => 
                                <DraggableItem key={i} data={data} type={DraggableItemTypes.ITEM}>
                                    <p className="draggable-menu-item__title">{data.itemName}</p>
                                </DraggableItem>
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