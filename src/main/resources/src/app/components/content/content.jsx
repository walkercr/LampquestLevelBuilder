import React from 'react'

import Grid from '../grid/grid.jsx'
import DeleteMenu from '../deleteMenu/deleteMenu.jsx'

import Ajax from '../../ajax/ajax.jsx'

export default class Content extends React.Component {

    state = {data: null};

    componentDidMount() {
        this.fetch();
    }

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