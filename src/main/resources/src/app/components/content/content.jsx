import React, { Component } from 'react'

import DungeonGrid from '../dungeonGrid/dungeonGrid.jsx'
import DeleteMenu from '../deleteMenu/deleteMenu.jsx'

import Ajax from '../../ajax/ajax.jsx'

export default class Content extends Component {

    state = {data: null, sessionData: null};

    componentDidMount() {
        //this.fetch();
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

    /* MARK FOR DELETION */
    fetch() {
        Ajax.httpGet('api/lampquest/1', (status, response) => {
            if (status === 200) {
                this.setState({data: JSON.parse(response)});
            } else {
                alert('fetch failed: ' + status);
            }
        });
    }

    render() {
		/* DUMMY PLACEHOLDER INITIALIZER VARS - REMOVE EVENTUALLY */
        const rows = 100, cols = 100;
        
        return (
            <section className="content">
                <div className="content__header"></div>
	            <DungeonGrid rows={rows} columns={cols} />
	            <DeleteMenu />
            </section>
		);
	}
}