import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Container from './components/container/container.jsx';
import '../scss/styles.scss';

class Main extends React.Component {
	render() {
		return (
			<Container />
		);
	}
}

ReactDOM.render(<Main />, document.getElementById('app'));