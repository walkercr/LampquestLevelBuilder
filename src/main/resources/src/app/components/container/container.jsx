import React, { Component } from 'react';
import DungeonBuilderMenu from '../dungeonBuilderMenu/dungeonBuilderMenu.jsx';
import Content from '../content/content.jsx';
import { DragDropContext } from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';

class Container extends Component {
    render() {
        return(
            <section className="root">
                <DungeonBuilderMenu />
                <Content />
            </section>
        );
    }
}

export default DragDropContext(HTML5Backend)(Container);