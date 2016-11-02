import React from 'react'

import Grid from '../grid/grid.jsx'
import DeleteMenu from '../deleteMenu/deleteMenu.jsx'

export default class Content extends React.Component {
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