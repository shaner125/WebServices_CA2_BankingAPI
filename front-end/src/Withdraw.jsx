import React, { Component } from 'react';
import httpPost from './http';
import './css/Withdraw.css';
import NavBar from './navBar';

class Withdraw extends Component {
  constructor(props){
    super(props);
    this.customer = props.customer;
    this.renderHome = props.renderHome;
    this.buttonTitle = props.btnTitle;
    this.withdrawFunc = () => {
      this.withdraw();
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

  withdraw() {
    const customerDetails = {
      amount: this.state.amount,
      description: "Withdrawal",
      transactionDate: this.makeDate(),
      transactionType: "WITHDRAWAL"
    };
    httpPost(`http://localhost:49000/api/customer/${this.customer.customerID}/accounts/{accountID}/transaction?type=withdraw`, customerDetails);
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
        <span>Amount To Withdraw: </span><input id="amount" onChange={this.handleChange.bind(this)} className="Withdraw" ></input>
        <button onClick={this.withdrawFunc}>{this.buttonTitle}</button>
      </div>
    );
  }
}

export default Withdraw;
