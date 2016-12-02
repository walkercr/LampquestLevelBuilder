import React, { Component, PropTypes } from 'react';
import classNames from 'classnames';
import { newDragTypes } from '../../constants/constants';
import DraggablesMenuPanel from '../draggablesMenuPanel/draggablesMenuPanel';

export default class DungeonBuilderMenu extends Component {
    
    static propTypes = {
        data: PropTypes.object.isRequired,
        handleDungeonChange: PropTypes.func.isRequired,
        selectedDungeon: PropTypes.number.isRequired,
        selectedLevel: PropTypes.number.isRequired
    };
    
    render() {
        const { handleDungeonChange, handleLevelChange, selectedDungeon, selectedLevel } = this.props;
        const { dungeons, rooms, monsters, items } = this.props.data;
        const levelClasses = classNames({
            'menu-select': true,
            'menu-select--disabled': selectedDungeon < 0
        });
        
        return (
            <aside className="dungeon-builder-menu">
                <div className="dungeon-builder-menu__header">
                    <div className="dungeon-builder-menu__toggle"></div>
                </div>
                <div className="dungeon-builder-menu__body">
                    <select className="menu-select" 
                            value={selectedDungeon} 
                            onChange={handleDungeonChange}>
                        <option value={-1} disabled>Select a Dungeon</option>
                        {dungeons.map((dungeon, i) =>
                            <option key={'option-' + i} value={i}>{dungeon.dungeonName}</option>
                        )}
                    </select>
                    
                    <select className={levelClasses}
                            value={selectedLevel}
                            onChange={handleLevelChange}
                            disabled={selectedDungeon < 0}>
                        <option value={-1} disabled>Select a Level</option>
                        {(selectedDungeon >= 0) ? [...Array(dungeons[selectedDungeon].dungeonDepth)].map((x, i) =>
                            <option key={'option-' + i} value={i}>Level {i + 1}</option>
                        ) : ''}
                    </select>
                    <DraggablesMenuPanel menuItems={rooms} menuItemType={newDragTypes.NEW_ROOM} />
                    <DraggablesMenuPanel menuItems={items} menuItemType={newDragTypes.NEW_ITEM} />
                    <DraggablesMenuPanel menuItems={monsters} menuItemType={newDragTypes.NEW_MONSTER} />
                </div>
            </aside>
        );
    }
}