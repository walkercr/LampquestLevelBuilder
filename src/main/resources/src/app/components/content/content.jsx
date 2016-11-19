import React from 'react'

import Grid from '../grid/grid.jsx'
import DeleteMenu from '../deleteMenu/deleteMenu.jsx'

import Ajax from '../../ajax/ajax.jsx'

export default class Content extends React.Component {

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