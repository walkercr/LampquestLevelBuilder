"use strict";

import React, {Component} from 'react'
import {PanelGroup, Panel, ButtonGroup, Button} from 'react-bootstrap'

const headers = [
    "Dungeons",
    "Rooms",
    "Levels",
    "Items",
];

var dungeons = ["dungeon 1", "dungeon 2"];
var rooms = ["room 1", "room 2"];
var levels = ["level 1", "level 2"];
var items = ["item 1", "item 2"];

var content = [dungeons, rooms, levels, items];

function renderPanels(label, i) {
  return (
    <Panel key={i} header={label} eventKey={i}>
      {content[i].map(renderButtons)}
    </Panel>
  )
}

function renderButtons(label, i) {
  return (
    <ButtonGroup key={i} vertical fill block>
      <Button bsStyle="default">{label}</Button>
    </ButtonGroup>
  )
}

export default class SideMenu extends Component {
  constructor(props){
    super(props);
    this.state = {
      activeKey: 0,
    };
  }

  handleSelect(activeKey) {
    this.setState({ activeKey });
  }

  render() {
    return (
      <aside className="side-menu">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" />
      <PanelGroup activeKey={this.state.activeKey} onSelect={this.handleSelect.bind(this)} accordion>
        {headers.map(renderPanels)}
      </PanelGroup>
      </aside>
    )
  }
}