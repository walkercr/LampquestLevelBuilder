import React from 'react'

export default class ControlPanel extends React.Component {
    render() {
        return (
            <aside className="control-panel">
                <div className="control-panel__header">
                    <div className="control-panel__toggle"></div>
                </div>
                <div className="control-panel__body"></div>
            </aside>
        );
    }
}