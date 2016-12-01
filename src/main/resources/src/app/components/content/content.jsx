import React, { Component } from 'react';
import { DragDropContext } from 'react-dnd';
import update from 'react/lib/update';
import HTML5Backend from 'react-dnd-html5-backend';
import Ajax from '../../libs/ajax';
import DungeonBuilderMenu from '../dungeonBuilderMenu/dungeonBuilderMenu';
import DungeonGrid from '../dungeonGrid/dungeonGrid';
import DraggableOverlay from '../draggableOverlay/draggableOverlay';

class Content extends Component {
    state = {
        selectedDungeon: -1,
        sessionData: {
            dungeons: [{
                dungeonId: 1, 
                dungeonName: 'Dungeon 1', 
                dungeonWidth: 10, 
                dungeonHeight: 10, 
                dungeonDepth: 3 
            },{
                dungeonId: 2, 
                dungeonName: 'Dungeon 2', 
                dungeonWidth: 20, 
                dungeonHeight: 20, 
                dungeonDepth: 2 
            }, {
                dungeonId: 3, 
                dungeonName: 'Dungeon 3', 
                dungeonWidth: 30, 
                dungeonHeight: 30, 
                dungeonDepth: 1 
            }],
            rooms: [{ 
                roomId: 1, 
                roomName: 'Room 1', 
                roomWidth: 3, 
                roomHeight: 3 
            }, { 
                roomId: 2, 
                roomName: 'Room 2', 
                roomWidth: 5, 
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
    
    constructor(props) {
        super(props);
        this.handleDungeonChange = this.handleDungeonChange.bind(this);
    }
    
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

    handleDungeonChange(e) {
        this.setState(update(this.state, {
            selectedDungeon: {
                $set: e.target.value
            }
        }));
    }
    
    render() {
        const rows = 0, cols = 0;
        const { selectedDungeon, sessionData } = this.state;
        const dungeon = selectedDungeon >= 0 
                            ? sessionData.dungeons[selectedDungeon]
                            : { dungeonName: '', dungeonWidth: 0, dungeonHeight: 0 };
        // TODO: move grid elements to dungeonGrid and make an inner dragTarget component
        return (
            <section className="root">
                <DungeonBuilderMenu handleDungeonChange={this.handleDungeonChange} data={sessionData} />
                <section className="content">
                    <div className="content__header"></div>
                    <div className="content__body">
                        <div className="grid">
                            <div className="grid__wrapper">
                                <DungeonGrid dungeon={dungeon} />
        	                </div>
                        </div>
                    </div>
                </section>
                <DraggableOverlay />
            </section>
		);
	}
}

export default DragDropContext(HTML5Backend)(Content);