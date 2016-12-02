import React, { Component } from 'react';
import { DragDropContext } from 'react-dnd';
import update from 'react/lib/update';
import HTML5Backend from 'react-dnd-html5-backend';
import Ajax from '../../libs/ajax';
import { existingDragTypes } from '../../constants/constants';
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
     */addGridItem
    state = {
        selectedDungeon: -1,
        selectedLevel: -1,
        selectedDungeonData: {
            itemLevels: [{
                dungeonId: 1,
                itemId: 1,
                itemX: 1,
                itemY: 1,
                itemZ: 2,
                numberInstances: 1
            }],
            roomLevels: [{
                dungeonId: 1,
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
                "dungeonId": 1,
                "dungeonName": "Dungeon One",
                "dungeonWidth": 80,
                "dungeonHeight": 24,
                "dungeonDepth": 2,
                "playerX": 12,
                "playerY": 12,
                "boss": 4,
                "bossX": 3,
                "bossY": 18,
                "bossZ": 1,
                "description": "A simple dungeon with hidden passages and lots of kobolds."
            }, {
                "dungeonId": 2,
                "dungeonName": "Curse of the Blob",
                "dungeonWidth": 200,
                "dungeonHeight": 200,
                "dungeonDepth": 6,
                "playerX": 55,
                "playerY": 55,
                "boss": 6,
                "bossX": 55,
                "bossY": 55,
                "bossZ": 5,
                "description": "The alien pink thing invaded the earth deep within the bowels of this dungeon. Kill it before the evil blobs fill the world!"
            }, {
                "dungeonId": 3,
                "dungeonName": "Arena",
                "dungeonWidth": 80,
                "dungeonHeight": 24,
                "dungeonDepth": 1,
                "playerX": 45,
                "playerY": 13,
                "boss": 7,
                "bossX": 35,
                "bossY": 13,
                "bossZ": 0,
                "description": "One room. One Ogre. Kill him to win."
            }, {
                "dungeonId": 5,
                "dungeonName": "Random One",
                "dungeonWidth": 80,
                "dungeonHeight": 80,
                "dungeonDepth": 5,
                "playerX": 40,
                "playerY": 40,
                "boss": 7,
                "bossX": 40,
                "bossY": 40,
                "bossZ": 4,
                "description": "Randomly generated dungeon. Cool, huh?"
            }, {
                "dungeonId": 6,
                "dungeonName": "Random Two",
                "dungeonWidth": 80,
                "dungeonHeight": 80,
                "dungeonDepth": 6,
                "playerX": 40,
                "playerY": 40,
                "boss": 5,
                "bossX": 40,
                "bossY": 40,
                "bossZ": 5,
                "description": "Randomly generated dungeon. Cool, huh?"
            }, {
                "dungeonId": 8,
                "dungeonName": "Random Three",
                "dungeonWidth": 80,
                "dungeonHeight": 80,
                "dungeonDepth": 7,
                "playerX": 40,
                "playerY": 40,
                "boss": 14,
                "bossX": 67,
                "bossY": 42,
                "bossZ": 3,
                "description": "Sneaky. I see what you did there. "
            }, {
                "dungeonId": 10,
                "dungeonName": "Dragons Below",
                "dungeonWidth": 80,
                "dungeonHeight": 80,
                "dungeonDepth": 3,
                "playerX": 40,
                "playerY": 40,
                "boss": 12,
                "bossX": 40,
                "bossY": 40,
                "bossZ": 2,
                "description": "Here be Dragons. Currently, this is an impossible dungeon, but it should be beatable in the future. "
            }, {
                "dungeonId": 11,
                "dungeonName": "Connor Hanson",
                "dungeonWidth": 97,
                "dungeonHeight": 81,
                "dungeonDepth": 2,
                "playerX": 12,
                "playerY": 12,
                "boss": 15,
                "bossX": 3,
                "bossY": 18,
                "bossZ": 1,
                "description": "Beware of the HANSONATOR..."
            }],
            rooms: [{
                "roomId": 1,
                "roomName": "1x1",
                "roomWidth": 1,
                "roomHeight": 1
            }, {
                "roomId": 2,
                "roomName": "2x2",
                "roomWidth": 2,
                "roomHeight": 2
            }, {
                "roomId": 3,
                "roomName": "3x3",
                "roomWidth": 3,
                "roomHeight": 3
            }, {
                "roomId": 4,
                "roomName": "4x4",
                "roomWidth": 4,
                "roomHeight": 4
            }, {
                "roomId": 5,
                "roomName": "5x5",
                "roomWidth": 5,
                "roomHeight": 5
            }, {
                "roomId": 6,
                "roomName": "xHall",
                "roomWidth": 5,
                "roomHeight": 1
            }, {
                "roomId": 7,
                "roomName": "yHall",
                "roomWidth": 1,
                "roomHeight": 5
            }, {
                "roomId": 8,
                "roomName": "Open",
                "roomWidth": 75,
                "roomHeight": 20
            }, {
                "roomId": 9,
                "roomName": "10x10",
                "roomWidth": 10,
                "roomHeight": 10
            }, {
                "roomId": 10,
                "roomName": "15x15",
                "roomWidth": 15,
                "roomHeight": 15
            }, {
                "roomId": 11,
                "roomName": "Great Hall",
                "roomWidth": 30,
                "roomHeight": 30
            }],
            monsters: [{
                "monsterId": 1,
                "monsterName": "fungus",
                "monsterChar": "F",
                "monsterColor": "green",
                "monsterHp": 10,
                "monsterSpeed": 250,
                "attacker": "N",
                "destructible": "Y",
                "corpse": "N",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "N",
                "special": "N",
                "monsterAttack": 0,
                "monsterVision": 5,
                "monsterDefense": 2
            }, {
                "monsterId": 2,
                "monsterName": "blob",
                "monsterChar": "B",
                "monsterColor": "pink",
                "monsterHp": 10,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "N",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 10,
                "monsterVision": 1,
                "monsterDefense": 2
            }, {
                "monsterId": 3,
                "monsterName": "kobold",
                "monsterChar": "k",
                "monsterColor": "red",
                "monsterHp": 8,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 6,
                "monsterVision": 5,
                "monsterDefense": 3
            }, {
                "monsterId": 4,
                "monsterName": "kobold king",
                "monsterChar": "K",
                "monsterColor": "red",
                "monsterHp": 35,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 15,
                "monsterVision": 6,
                "monsterDefense": 5
            }, {
                "monsterId": 5,
                "monsterName": "bat",
                "monsterChar": "b",
                "monsterColor": "grey",
                "monsterHp": 6,
                "monsterSpeed": 2000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "N",
                "special": "N",
                "monsterAttack": 4,
                "monsterVision": 5,
                "monsterDefense": 2
            }, {
                "monsterId": 6,
                "monsterName": "pink thing",
                "monsterChar": "P",
                "monsterColor": "pink",
                "monsterHp": 100,
                "monsterSpeed": 1000,
                "attacker": "N",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "N",
                "special": "N",
                "monsterAttack": 0,
                "monsterVision": 5,
                "monsterDefense": 2
            }, {
                "monsterId": 7,
                "monsterName": "ogre",
                "monsterChar": "O",
                "monsterColor": "white",
                "monsterHp": 40,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 10,
                "monsterVision": 9,
                "monsterDefense": 5
            }, {
                "monsterId": 8,
                "monsterName": "Ankheg",
                "monsterChar": "A",
                "monsterColor": "yellow",
                "monsterHp": 15,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 5,
                "monsterVision": 5,
                "monsterDefense": 5
            }, {
                "monsterId": 9,
                "monsterName": "Ape",
                "monsterChar": "a",
                "monsterColor": "brown",
                "monsterHp": 5,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 3,
                "monsterVision": 5,
                "monsterDefense": 3
            }, {
                "monsterId": 10,
                "monsterName": "Centaur",
                "monsterChar": "C",
                "monsterColor": "brown",
                "monsterHp": 20,
                "monsterSpeed": 2000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 8,
                "monsterVision": 8,
                "monsterDefense": 8
            }, {
                "monsterId": 11,
                "monsterName": "crocodile",
                "monsterChar": "c",
                "monsterColor": "green",
                "monsterHp": 5,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 5,
                "monsterVision": 5,
                "monsterDefense": 5
            }, {
                "monsterId": 12,
                "monsterName": "Dragon",
                "monsterChar": "D",
                "monsterColor": "red",
                "monsterHp": 100,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 30,
                "monsterVision": 10,
                "monsterDefense": 30
            }, {
                "monsterId": 13,
                "monsterName": "dwarf",
                "monsterChar": "d",
                "monsterColor": "grey",
                "monsterHp": 7,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "N",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 7,
                "monsterVision": 5,
                "monsterDefense": 4
            }, {
                "monsterId": 14,
                "monsterName": "living wall",
                "monsterChar": "#",
                "monsterColor": "goldenrod",
                "monsterHp": 6,
                "monsterSpeed": 1000,
                "attacker": "Y",
                "destructible": "Y",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 10,
                "monsterVision": 1,
                "monsterDefense": 2
            }, {
                "monsterId": 15,
                "monsterName": "Hansonator",
                "monsterChar": "M",
                "monsterColor": "orange",
                "monsterHp": 74,
                "monsterSpeed": 750,
                "attacker": "Y",
                "destructible": "N",
                "corpse": "Y",
                "xp": "Y",
                "levelUp": "Y",
                "sight": "Y",
                "special": "N",
                "monsterAttack": 15,
                "monsterVision": 6,
                "monsterDefense": 5
            }],
            items: [{
                "itemId": 1,
                "itemName": "melon",
                "itemChar": "%",
                "itemColor": "lightGreen",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 2,
                "itemName": "pumpkin",
                "itemChar": "*",
                "itemColor": "orange",
                "edible": "Y",
                "wearable": "Y",
                "wieldable": "Y"
            }, {
                "itemId": 3,
                "itemName": "corpse",
                "itemChar": "%",
                "itemColor": "",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 4,
                "itemName": "sword",
                "itemChar": ")",
                "itemColor": "white",
                "edible": "N",
                "wearable": "N",
                "wieldable": "Y"
            }, {
                "itemId": 5,
                "itemName": "chainmail",
                "itemChar": "]",
                "itemColor": "white",
                "edible": "N",
                "wearable": "Y",
                "wieldable": "N"
            }, {
                "itemId": 6,
                "itemName": "staff",
                "itemChar": ")",
                "itemColor": "yellow",
                "edible": "N",
                "wearable": "N",
                "wieldable": "Y"
            }, {
                "itemId": 7,
                "itemName": "spiked chain",
                "itemChar": "]",
                "itemColor": "white",
                "edible": "N",
                "wearable": "Y",
                "wieldable": "N"
            }, {
                "itemId": 8,
                "itemName": "apple",
                "itemChar": "%",
                "itemColor": "red",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 9,
                "itemName": "banana",
                "itemChar": "%",
                "itemColor": "yellow",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 10,
                "itemName": "blueberry",
                "itemChar": "%",
                "itemColor": "light blue",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 11,
                "itemName": "healing potion",
                "itemChar": "%",
                "itemColor": "pink",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 12,
                "itemName": "big healing potion",
                "itemChar": "%",
                "itemColor": "pink",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 13,
                "itemName": "strong healing potion",
                "itemChar": "%",
                "itemColor": "pink",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 14,
                "itemName": "strong big healing potion",
                "itemChar": "%",
                "itemColor": "pink",
                "edible": "Y",
                "wearable": "N",
                "wieldable": "N"
            }, {
                "itemId": 15,
                "itemName": "plate mail",
                "itemChar": "]",
                "itemColor": "gold",
                "edible": "N",
                "wearable": "Y",
                "wieldable": "N"
            }, {
                "itemId": 17,
                "itemName": "Enchanted Donut Ring",
                "itemChar": "O",
                "itemColor": "brown",
                "edible": "Y",
                "wearable": "Y",
                "wieldable": "Y"
            }]
        }
    };
    
    constructor(props) {
        super(props);
        this.handleDungeonChange = this.handleDungeonChange.bind(this);
        this.handleLevelChange = this.handleLevelChange.bind(this);
        this.getSessionDataObject = this.getSessionDataObject.bind(this);
        this.handleMoveGridItem = this.handleMoveGridItem.bind(this);
        this.handleAddGridItem = this.handleAddGridItem.bind(this);
        this.handleRemoveGridItem = this.handleRemoveGridItem.bind(this);
        this.handleExport = this.handleExport.bind(this);
    }
    
    componentDidMount() {
        // TODO: uncomment!!!
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

    getSessionDataObject(dragType, idVal) {
        return this.state.sessionData[dragType + 's'].find((obj) =>
            obj[dragType + 'Id'] == idVal
        );
    }
    
    handleExport(e) {
        let dungeonLevel = {
            dungeonId: this.state.selectedDungeon,
            level: this.state.selectedLevel,
            rooms: [],
            monsters: [],
            stairs: [
                {stairsX: 4, stairsY: 8},
                {stairsX: 22, stairsY: 34}
            ],
            items: []
        };
        
        const { selectedDungeonData: sd } = this.state;
        for (let i = 0; i < sd.roomLevels.length; i++) {
            dungeonLevel.rooms.push({
                roomId: sd.roomLevels[i].roomId,
                startX: sd.roomLevels[i].startX,
                startY: sd.roomLevels[i].startY
            });
        }
        for (let i = 0; i < sd.itemLevels.length; i++) {
            dungeonLevel.items.push({
                itemId: sd.itemLevels[i].itemId,
                itemX: sd.itemLevels[i].itemX,
                itemY: sd.itemLevels[i].itemY,
                numberInstances: sd.itemLevels[i].numberInstances
            });
        }
        for (let i = 0; i < sd.staticMonsters.length; i++) {
            dungeonLevel.monsters.push({
                monsterId: sd.staticMonsters[i].monsterId,
                monsterX: sd.staticMonsters[i].monsterX,
                monsterY: sd.staticMonsters[i].monsterY,
                isBoss: false
            });
        }
        for (let i = 0; i < sd.stairsLevels.length; i++) {
            dungeonLevel.stairs.push({
                stairsX: sd.stairsLevels[i].stairsX,
                stairsY: sd.stairsLevels[i].stairsY
            });
        }
        Ajax.httpPost('/api/lampquest', dungeonLevel, (status, response) => {
            if (status === 200) {
                alert('Successfully exported dungeon.');
            } else {
                alert('An error occurred while exporting the dungeon.');
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
    
    handleAddGridItem(listName, obj) {
        this.setState(update(this.state, {
            selectedDungeonData: {
                [listName]: {
                    $push: [ obj ]
                }
            }
        }));
    }
    
    handleRemoveGridItem(listName, index) {
        this.setState(update(this.state, {
            selectedDungeonData: {
                [listName]: {
                    $splice: [[index, 1]]
                }
            }
        }));
    }
    
    handleMoveGridItem(dragType, index, newPos) {
        let listName, x, y;
        
        switch(dragType) {
            case existingDragTypes.ITEM:
                listName = 'itemLevels';
                x = 'itemX';
                y = 'itemY';
                break;
            case existingDragTypes.ROOM:
                listName = 'roomLevels';
                x = 'startX';
                y = 'startY';
                break;
            case existingDragTypes.STAIRS:
                listName = 'stairsLevels';
                x = 'stairsX';
                y = 'stairsY';
                break;
            case existingDragTypes.MONSTER:
                listName = 'staticMonsters';
                x = 'monsterX';
                y = 'monsterY';
        }
        
        this.setState(update(this.state, {
            selectedDungeonData: {
                [listName]: {
                    [index]: {
                        [x]: {
                            $set: newPos.x
                        },
                        [y]: {
                            $set: newPos.y
                        }
                    }
                }
            }
        }));
    }
    
    render() {
        const { selectedDungeon, selectedLevel, sessionData, selectedDungeonData } = this.state;
        // TODO: move grid elements to dungeonGrid and make an inner dragTarget component
        return (
            <section className="root">
                <DungeonBuilderMenu handleDungeonChange={this.handleDungeonChange} 
                                    handleLevelChange={this.handleLevelChange}
                                    handleExport={this.handleExport}
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
                                             getSessionDataObject={this.getSessionDataObject}
                                             handleMoveGridItem={this.handleMoveGridItem}
                                             handleAddGridItem={this.handleAddGridItem}
                                             handleRemoveGridItem={this.handleRemoveGridItem} />
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