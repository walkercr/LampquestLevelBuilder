import React, { Component, PropTypes } from 'react';

export default class Room extends Component {
    static propTypes = {
        width: PropTypes.number.isRequired,
        height: PropTypes.number.isRequired
    };
    
    render() {
        const styles = {
            width: this.props.width,
            height: this.props.height
        };
        
        return (
            <div style={styles} className="room"></div>
        );
    }
}