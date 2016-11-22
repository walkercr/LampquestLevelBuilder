import React, { Component } from 'react';
import { DragDropContext } from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';
import Ajax from '../../libs/ajax';
import DungeonBuilderMenu from '../dungeonBuilderMenu/dungeonBuilderMenu';
import DungeonGrid from '../dungeonGrid/dungeonGrid';

class Content extends Component {
    // TODO: set initial state = { sessionData: {} } 
    state = {
        sessionData: {
            dungeons: [{
                dungeonId: 1, 
                dungeonName: 'Dungeon 1', 
                dungeonWidth: 25, 
                dungeonHeight: 25, 
                dungeonDepth: 5 
            }],
            rooms: [{ 
                roomId: 1, 
                roomName: 'Room 1', 
                roomWidth: 3, 
                roomHeight: 3 
            }],
            monsters: [{
                monsterId: 1, 
                monsterName: 'Monster A', 
                monsterChar: 'A', 
                monsterColor: 'red' 
            }],
            items: [{
                itemId: 1, 
                itemName: 'Item X', 
                itemChar: 'X', 
                itemColor: 'orange' 
            }]
        } 
    };
    
    componentDidMount() {
        // TODO: uncomment!!!
        //this.fetchPageLoadData();
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
		// TODO: DUMMY PLACEHOLDER INITIALIZER VARS - REMOVE EVENTUALLY
        const rows = 25, cols = 25;
        // TODO: move grid elements to dungeonGrid and make an inner dragTarget component
        return (
            <section className="root">
                <DungeonBuilderMenu data={this.state.sessionData} />
                <section className="content">
                    <div className="content__header"></div>
                    <div className="content__body">
                        <div className="grid">
                            <div className="grid__wrapper">
                                <DungeonGrid rows={rows} columns={cols} />
        	                </div>
                        </div>
                    </div>
                </section>
            </section>
		);
	}
}

export default DragDropContext(HTML5Backend)(Content);