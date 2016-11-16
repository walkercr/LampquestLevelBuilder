import React, { Component } from 'react'
import ReactDOM from 'react-dom'

import DungeonBuilderMenu from './components/dungeonBuilderMenu/dungeonBuilderMenu.jsx'
import Content from './components/content/content.jsx'

import '../scss/styles.scss'

class Main extends React.Component {
	render() {
		return (
			<section className="root">
		        <DungeonBuilderMenu />
				<Content />
			</section>
		);
	}
}

ReactDOM.render(<Main />, document.getElementById('app'));