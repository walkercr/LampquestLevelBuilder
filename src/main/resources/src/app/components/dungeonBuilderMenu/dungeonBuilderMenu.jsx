import React, { Component, PropTypes } from 'react';
import { newDragTypes } from '../../constants/constants';
import DraggablesMenuPanel from '../draggablesMenuPanel/draggablesMenuPanel';

export default class DungeonBuilderMenu extends Component {
    
    static propTypes = {
        data: PropTypes.object.isRequired,
        handleDungeonChange: PropTypes.func.isRequired
    };
    
    render() {
        const { dungeons, rooms, monsters, items } = this.props.data;
        
        return (
            <aside className="dungeon-builder-menu">
                <div className="dungeon-builder-menu__header">
                    <div className="dungeon-builder-menu__toggle"></div>
                </div>
                <div className="dungeon-builder-menu__body">
                    <select defaultValue='' onChange={this.props.handleDungeonChange}>
                        <option value='' disabled>Select a Dungeon</option>
                        {dungeons.map((dungeon, i) =>
                            <option key={'option-' + i} value={i}>{dungeon.dungeonName}</option>
                        )}
                    </select>
                    <DraggablesMenuPanel menuItems={rooms} menuItemType={newDragTypes.NEW_ROOM} />
                    <DraggablesMenuPanel menuItems={items} menuItemType={newDragTypes.NEW_ITEM} />
                    <DraggablesMenuPanel menuItems={monsters} menuItemType={newDragTypes.NEW_MONSTER} />
                </div>
            </aside>
        );
    }
}