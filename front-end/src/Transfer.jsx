import React, { Component } from 'react';
import httpPost from './http';
import './css/Transfer.css';
import NavBar from './navBar';

class Transfer extends Component {
  constructor(props){
    super(props);
    this.customer = props.customer();
    this.renderHome = props.renderHome;
    this.buttonTitle = props.btnTitle;
    this.transferFunc = () => {
      this.transfer();
      this.renderHome();
    }
  }

  makeDate() {
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1;

    const yyyy = today.getFullYear();
    if (dd < 10) {
      dd = '0' + dd;
    }
    if (mm < 10) {
      mm = '0' + mm;
    }
    today = dd + '/' + mm + '/' + yyyy;
    return today;
  }

  transfer() {
    const customerDetails = {
      amount: this.state.amount,
      description: "Transferal",
      transactionDate: this.makeDate(),
      transactionType: "TRANSFERAL"
    };
    httpPost(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts/1/transaction?type=transfer`, customerDetails);
    console.log(customerDetails);
  }

  handleChange(event) {
    const stateObj = {};
    stateObj[event.target.id] = event.target.value;
    this.setState(stateObj);
  }

  render() {
    return (
      <div className="InputContainer">
        <NavBar routes={{ home: this.renderHome }}/>
        <span className="AppTileLabel">Bank API</span>
        <p className="TransferLabel">Account From: <input id="accountNum" onChange={this.handleChange.bind(this)} className="Transfer" ></input></p>
        <p className="TransferLabel">Amount: <input id="amount" onChange={this.handleChange.bind(this)} className="Transfer" ></input></p>
        <button onClick={this.transferFunc}>{this.buttonTitle}</button>
      </div>
    );
  }
}

export default Transfer;
