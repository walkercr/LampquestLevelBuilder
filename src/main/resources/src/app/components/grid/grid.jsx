import React, { Component, PropTypes } from 'react'

export default class Grid extends Component {
    
    static propTypes = {
        rows: PropTypes.number.isRequired,
        columns: PropTypes.number.isRequired
    }
    
    renderRow(i) {
        const gridCells = [];
        for (let j = 0; j < this.props.columns; j++) {
            gridCells.push(<div key={j} className="grid__cell"></div>);
        }
        
        return (
            <div key={i} className="grid__row">
                {gridCells}
            </div>
        );
    }
    
    
    render() {
		const gridRows = [];
		for (let i = 0; i < this.props.rows; i++) {
		    gridRows.push(this.renderRow(i));
		}
        
	    return (
		    <div className="grid">
		        <div className="grid__wrapper">
	                <div className="grid__container">
	                    {gridRows}
	                </div>
	            </div>
            </div>
		);
	}
}