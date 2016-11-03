import React from 'react'
import Ajax from '../ajax/ajax';

export default class Content extends React.Component {
    static testDungeonId = 1;

    /*
     * EXAMPLE PALETTE
     *
     * palette: {
     *     dungeon: {
     *         dungeonId: 1
     *     },
     *     rooms: [
     *         {
     *             roomHeight: 1,
     *             roomId: 1,
     *             roomName: "1x1",
     *             roomWidth: 1
     *         },
     *         {
     *             // same format
     *         }
     *     ],
     *     roomLevels: [
     *         {
     *             depth: 0,
     *             dungeonId: 1,
     *             roomId: 3,
     *             roomPK: 1,
     *             startX: 2,
     *             startY: 4
     *         },
     *         {
     *             // same format
     *         }
     *     ]
     * }
     */
    state = {palette: null};

    componentDidMount() {
        this.fetchPalette(Content.testDungeonId);
        this.postLevel();
    }

    fetchPalette(id) {
        Ajax.httpGet('/api/palette/' + id, (status, response) => {
            if (status === 200) {
                this.setState({palette: JSON.parse(response)});
            }
        });
    }

    postLevel() {
        // Example dungeonLevel
        let dungeonLevel = {
            dungeonId: Content.testDungeonId,
            depth: 1,
            rooms: [
                {roomId: 1, startX: 0, startY: 0},
                {roomId: 2, startX: 2, startY: 3},
                {roomId: 4, startX: 7, startY: 4}
            ],
            filename: 'testScript.sql'
        };

        Ajax.httpPost('/api/dungeonLevel', dungeonLevel, status => {
            if (status !== 201) {
                alert('Level creation failed');
            }
        })
    }

	render() {
		return (
		    <h1>React.js starter template with hot reload webpack-dev-server.</h1>
		);
	}
}