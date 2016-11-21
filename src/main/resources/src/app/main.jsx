import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Content from './components/content/content.jsx';
import '../scss/styles.scss';

class Main extends Component {
	render() {
		return (
			<Content />
		);
	}
}

ReactDOM.render(<Main />, document.getElementById('app'));