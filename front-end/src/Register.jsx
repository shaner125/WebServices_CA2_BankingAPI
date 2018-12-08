import React, { Component } from 'react';
import httpPost, { httpGet } from './http';
import './css/Register.css';

class Register extends Component {
  constructor(props){
    super(props);
    this.renderLogin = props.renderLogin;
    this.buttonTitle = props.btnTitle;
    this.register = this.register.bind(this);
    this.registerFunc = () => {
     this.register();
    };
  }
  
  register() {
    this.createCustomer();
    httpGet(`http://localhost:49000/api/customers/getByEmail/${this.state.email}`);
    this.renderLogin();
  }

  createAccount(customer) {
    httpPost(`http://localhost:49000/api/customers/${customer.customerID}/accounts/create/current`, {});
  }

  createCustomer() {
    const customerDetails = {
      name: this.state.name,
      address: this.state.address,
      email: this.state.email,
      password: this.state.password
    };
    httpPost('http://localhost:49000/api/customers/create', customerDetails);
    console.log(customerDetails);
  }

  handleChange(event) {
    const stateObj = {};
    stateObj[event.target.id] = event.target.value;
    this.setState(stateObj);
  }

  render() {
    return (
      <div className="RegisterContainer">
        <span className="AppTileLabel">Bank API</span>
        <div className="RegisterContent">
          <span className="RegisterLabel">Name: </span><input id="name" onChange={this.handleChange.bind(this)} className="RegisterInput" ></input>
          <span className="RegisterLabel"> Address: </span><input id="address" onChange={this.handleChange.bind(this)} className="RegisterInput" ></input>
          <br />
          <span className="RegisterLabel">Email: </span><input id="email" onChange={this.handleChange.bind(this)} className="RegisterInput" ></input>
          <span className="RegisterLabel"> Password: </span><input id="password" onChange={this.handleChange.bind(this)} type="password" className="RegisterInput"></input>
          <br />
          <br />
        </div>
        <button onClick={this.registerFunc}>{this.buttonTitle}</button>
      </div>
    );
  }
}

export default Register;
