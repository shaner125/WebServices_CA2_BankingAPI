import React, { Component } from 'react';
import './css/Result.css';
import NavBar from './navBar';

class Result extends Component {
  constructor(props){
    super(props);
    this.renderCreate = props.renderWithdraw;
    this.renderHome = props.renderLogin;
  }
  render() {
    return (
      <div className="ResultContainer">
        <NavBar routes={{ home: this.renderHome }}/>
        <span className="AppTileLabel">Bank API</span>
        <span className="Result">Text</span>
      </div>
    );
  }
}

export default Result;
