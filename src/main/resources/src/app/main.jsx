import React from 'react'
import ReactDOM from 'react-dom'

import ControlPanel from './components/controlPanel/controlPanel.jsx'
import Content from './components/content/content.jsx'
import SideMenu from './components/sideMenu/sideMenu.jsx'

import '../scss/styles.scss'

class Main extends React.Component {
	render() {
		return (
			<section>
				<SideMenu />
			</section>
		);
	}
}

ReactDOM.render(<Main />, document.getElementById('app'));