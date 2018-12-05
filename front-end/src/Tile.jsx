import React, { Component } from 'react';
import './css/Tile.css';

class Tile extends Component {
  constructor(props) {
    super(props);
    this.title = props.title;
    this.icon = props.icon;
    this.action = props.action;
  }

  render() {
    return (
      <div className="TileContainer" role="button" onClick={this.action} onKeyPress={this.action} tabIndex={0}>
        <img className="TileIcon" src={this.icon} alt={`${this.title} Tile Icon`}/>
        <b className="TileLabel">{this.title}</b>
      </div>
    );
  }
}

export default Tile;
