import React, { Component } from 'react';
import './css/Create.css';
import NavBar from './navBar';

class Create extends Component {
  constructor(props){
    super(props);
    this.renderHome = props.renderLodge;
    this.buttonTitle = props.btnTitle;
  }
  render() {
    return (
      <div className="InputContainer">
        <NavBar routes={{ home: this.renderHome }}/>
        <span className="AppTileLabel">Bank API</span>
        <span>Name: </span><input className="Create" id="" ></input>
        <span> Name: </span><input className="Create" id="" ></input>
        <br />
        <span>Name: </span><input className="Create" id="" ></input>
        <span> Name: </span><input className="Create" id="" ></input>
        <br />
        <button>{this.buttonTitle}</button>
      </div>
    );
  }
}

export default Create;
