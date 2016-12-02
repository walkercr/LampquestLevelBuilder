import React, { Component } from 'react';
import { DragDropContext } from 'react-dnd';
import update from 'react/lib/update';
import HTML5Backend from 'react-dnd-html5-backend';
import Ajax from '../../libs/ajax';
import DungeonBuilderMenu from '../dungeonBuilderMenu/dungeonBuilderMenu';
import DungeonGrid from '../dungeonGrid/dungeonGrid';
import DraggableOverlay from '../draggableOverlay/draggableOverlay';

class Content extends Component {
    /**
     * default state should look like this:
     *      state = {
     *          selectedDungeon: -1,
     *          selectedLevel: -1,
     *          selectedDungeonData: {
     *              itemLevels: [],
     *              roomLevels: [],
     *              stairsLevels: [],
     *              staticMonsters: []
     *          },
     *          sessionData: {
     *              dungeons: [],
     *              rooms: [],
     *              monsters: [],
     *              items: [],
     *          }
     *      }
     */
    state = {
        selectedDungeon: -1,
        selectedLevel: -1,
        // When a dungeon is selected, we query for the existing data in the DB
        // and populate this object accordingly.
        // When a new [room, item, monster, staris] is/are dragged onto the grid,
        // it will be inserted here as well, so this object acts as a 'currentDungeonData'
        // -esque object.
        selectedDungeonData: {
            // itemId field identifies an item's INDEX within the itemLevels array. It is the
            // primary key in the items table in the DB and begins at 1, so to find an item's position
            // in this array, it would be at someItemPosition = itemLevels[someItem.itemId - 1].
            itemLevels: [{
                dungeonId: 1,
                itemId: 1,
                itemX: 1,
                itemY: 1,
                itemZ: 2,
                numberInstances: 1
            }],
            roomLevels: [{
                dungeonId: 1,   // Remove dungeonId from all selectedDungeonData fields bc already known
                roomId: 1,
                depth: 1,
                startX: 0,
                startY: 0
            }, {
                dungeonId: 1,
                roomId: 1,
                depth: 1,
                startX: 3,
                startY: 3
            }, {
                dungeonId: 1,
                roomId: 2,
                depth: 1,
                startX: 6,
                startY: 6
            }, {
                dungeonId: 1,
                roomId: 2,
                depth: 2,
                startX: 0,
                startY: 0
            }],
            stairsLevels: [],
            staticMonsters: [{
                dungeonId: 1,
                monsterId: 1,
                monsterX: 1,
                monsterY: 1,
                depth: 1
            }]
        },
        sessionData: {
            dungeons: [{
                dungeonId: 1, 
                dungeonName: 'Dungeon 1', 
                dungeonWidth: 15, 
                dungeonHeight: 15, 
                dungeonDepth: 3 
            },{
                dungeonId: 2, 
                dungeonName: 'Dungeon 2', 
                dungeonWidth: 30, 
                dungeonHeight: 30, 
                dungeonDepth: 2 
            }, {
                dungeonId: 3, 
                dungeonName: 'Dungeon 3', 
                dungeonWidth: 45, 
                dungeonHeight: 45, 
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
        this.handleLevelChange = this.handleLevelChange.bind(this);
        this.getSessionDataObject = this.getSessionDataObject.bind(this);
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
                $set: Number(e.target.value)
            },
            selectedLevel: {
                $set: -1
            }
        }));
    }
    
    handleLevelChange(e) {
        this.setState(update(this.state, {
            selectedLevel: {
                $set: Number(e.target.value)
            }
        }));
    }
    
    getSessionDataObject(dragType, idField) {
        return this.state.sessionData[dragType + 's'][idField - 1];
    }
    
    render() {
        const { selectedDungeon, selectedLevel, sessionData, selectedDungeonData } = this.state;
        // TODO: move grid elements to dungeonGrid and make an inner dragTarget component
        return (
            <section className="root">
                <DungeonBuilderMenu handleDungeonChange={this.handleDungeonChange} 
                                    handleLevelChange={this.handleLevelChange}
                                    selectedDungeon={selectedDungeon} 
                                    selectedLevel={selectedLevel}
                                    data={sessionData} />
                <section className="content">
                    <div className="content__header"></div>
                    <div className="content__body">
                        <div className="grid">
                            <div className="grid__wrapper">
                                <DungeonGrid selectedDungeonObj={sessionData.dungeons[selectedDungeon]} 
                                             selectedDungeonData={selectedDungeonData}
                                             selectedLevel={selectedLevel}
                                             getSessionDataObject={this.getSessionDataObject} />
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