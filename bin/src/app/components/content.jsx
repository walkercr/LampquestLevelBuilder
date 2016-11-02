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
     *             roomHeight: 2,
     *             roomId: 2,
     *             roomName: "some room",
     *             roomWidth: 2
     *         }
     *     ]
     * }
     */
    state = {palette: null};

    componentDidMount() {
        this.fetchPalette(Content.testDungeonId);
    }

    fetchPalette(id) {
        Ajax.httpGet('/api/palette/' + id, (status, response) => {
            let palette = null;
            if (status === 200) {
                this.setState({palette: JSON.parse(response)});
            }
        });
    }

	render() {
		return (
		    <h1>React.js starter template with hot reload webpack-dev-server.</h1>
		);
	}
}