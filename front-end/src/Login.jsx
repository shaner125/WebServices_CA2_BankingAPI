import React, { Component } from 'react';
import httpPost, { httpGet } from './http';
import './css/Login.css';

class Login extends Component {
  constructor(props){
    super(props);
    this.setEmail = props.setEmail;
    this.renderHome = props.renderHome;
    this.buttonTitle = props.btnTitle;
    this.loginFunc = () => {
      this.login();
      this.setEmail(this.state.email);
      this.renderHome();
    };
  }

  login() {
    // httpGet(`http://localhost:49000/api/customers/getByEmail/${this.state.email}`);
  }

  handleChange(event) {
    const stateObj = {};
    stateObj[event.target.id] = event.target.value;
    this.setState(stateObj);
  }

  render() {
    return (
      <div className="LoginContainer">
        <span className="AppTileLabel">Bank API</span>
        <div className="LoginContent">
          <span className="LoginLabel">Email: </span><input id="email" onChange={this.handleChange.bind(this)} className="LoginInput" ></input>
          <span className="LoginLabel"> Password: </span><input id="password" onChange={this.handleChange.bind(this)} type="password" className="LoginInput"></input>
          <br />
          <br />
        </div>
        <button onClick={this.loginFunc}>{this.buttonTitle}</button>
      </div>
    );
  }
}

export default Login;
