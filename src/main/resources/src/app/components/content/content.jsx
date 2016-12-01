import React from 'react'
import Grid from '../grid/grid.jsx'
import DeleteMenu from '../deleteMenu/deleteMenu.jsx'
import Ajax from '../../ajax/ajax.jsx'

export default class Content extends React.Component {

    state = {data: null, sessionData: null, selectedDungeonData: null};

    componentDidMount() {
        //this.fetch();
        this.fetchPageLoadData();
        this.fetchSelectedDungeonData(12);
        this.postDungeonLevel();
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
        Ajax.httpGet('/api/lampquest', (status, response) => {
            if (status === 200) {
                this.setState({sessionData: JSON.parse(response)});
            } else {
                alert('error loading session data...');
            }
        });
    }

    /* MARK FOR DELETION */
    fetch() {
        Ajax.httpGet('/api/lampquest/1', (status, response) => {
            if (status === 200) {
                this.setState({data: JSON.parse(response)});
            } else {
                alert('fetch failed: ' + status);
            }
        });
    }

    fetchSelectedDungeonData(dungeonId) {
        Ajax.httpGet('/api/lampquest/' + dungeonId, (status, response) => {
            if (status == 200) {
                this.setState({selectedDungeonData: JSON.parse(response)});
            } else {
                console.warn("fetch selected dungeon data failed");
            }
        });
    }

    postDungeonLevel() {
        let dungeonLevel = {
            dungeonId: 12,
            level: 0,
            rooms: [
                {roomId: 3, startX: 10, startY: 10},
                {roomId: 7, startX: 22, startY: 30}
            ],
            monsters: [
                {monsterId: 17, monsterX: 10, monsterY: 12, isBoss: false},
                {monsterId: 17, monsterX: 23, monsterY: 19, isBoss: true}
            ],
            stairs: [
                {stairsX: 4, stairsY: 8},
                {stairsX: 22, stairsY: 34}
            ],
            items: [
                {itemId: 1, itemX: 3, itemY: 12, numberInstances: 2}
            ]
        };

        Ajax.httpPost('/api/lampquest', dungeonLevel, () => {});
    }

    render() {
		return (
		    <section>
                <section className="content">
                    <div className="content__header"></div>
		            <Grid />
		            <DeleteMenu />
                </section>
            </section>
		);
	}
}