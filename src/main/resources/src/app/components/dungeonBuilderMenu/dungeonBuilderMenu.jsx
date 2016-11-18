import React, { Component } from 'react';
import Draggable from '../draggableItem/draggableItem.jsx';

export default class DungeonBuilderMenu extends Component {
    render() {
        return (
            <aside className="dungeon-builder-menu">
                <div className="dungeon-builder-menu__header">
                    <div className="dungeon-builder-menu__toggle"></div>
                </div>
                <div className="dungeon-builder-menu__body">
                    <Draggable name="Test" />
                </div>
            </aside>
        );
    }
}