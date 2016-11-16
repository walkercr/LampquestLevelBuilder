import React, { Component } from 'react'

export default class DungeonBuilderMenu extends Component {
    render() {
        return (
            <aside className="dungeon-builder-menu">
                <div className="dungeon-builder-menu__header">
                    <div className="dungeon-builder-menu__toggle"></div>
                </div>
                <div className="dungeon-builder-menu__body"></div>
            </aside>
        );
    }
}