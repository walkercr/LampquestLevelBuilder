import React, { Component } from 'react';
import { DragDropContext } from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';
import Ajax from '../../ajax/ajax.jsx';
import DungeonBuilderMenu from '../dungeonBuilderMenu/dungeonBuilderMenu.jsx';
import DungeonGrid from '../dungeonGrid/dungeonGrid.jsx';
import DeleteMenu from '../deleteMenu/deleteMenu.jsx';

class Content extends Component {
    
    state = {
        sessionData: null
    };

    // Must call super here so props are injected into components.
    // Allows multiple dynamic draggableItemTypes to be supported
    constructor(props) {
        super(props);
        /** Set state here **/
    }
    
    componentDidMount() {
        this.fetchPageLoadData();
    }

    /**
     * Fetches page load data:
     *     sessionData = {
     *         dungeons: array of dungeons,
     *         rooms: array of rooms,
     *         monsters: array of monsters,
     *         items: NOT INCLUDED YET (task 12)
     *     }
     */
    fetchPageLoadData() {
        Ajax.httpGet('api/lampquest', (status, response) => {
            if (status === 200) {
                this.setState({sessionData: JSON.parse(response)});
            } else {
                console.warn('error loading session data...');
            }
        });
    }

    render() {
		/* DUMMY PLACEHOLDER INITIALIZER VARS - REMOVE EVENTUALLY */
        const rows = 100, cols = 100;
        
        return (
            <section className="root">
                <DungeonBuilderMenu />
                <section className="content">
                    <div className="content__header"></div>
    	            <DungeonGrid rows={rows} columns={cols} />
    	            <DeleteMenu />
                </section>
            </section>
		);
	}
}

export default DragDropContext(HTML5Backend)(Content);