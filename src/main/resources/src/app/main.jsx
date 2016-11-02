import React from 'react'
import ReactDOM from 'react-dom'

import ControlPanel from './components/controlPanel/controlPanel.jsx'
import Content from './components/content/content.jsx'

import '../scss/styles.scss'

class Main extends React.Component {
	render() {
		return (
			<section>
		        <ControlPanel />
				<Content />
			</section>
		);
	}
}

ReactDOM.render(<Main />, document.getElementById('app'));