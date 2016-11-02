import React from 'react'
import ReactDOM from 'react-dom'

import Content from './components/content.jsx'

import '../sass/styles.scss'

class Main extends React.Component {
	render() {
		return (
			<section>
				<Content />
			</section>
		);
	}
}

ReactDOM.render(<Main />, document.getElementById('app'));