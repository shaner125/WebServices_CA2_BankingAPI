import React, { Component } from 'react';
import { httpGet } from './http';
import './css/Balance.css';
import NavBar from "./navBar";

class Balance extends Component {
  constructor(props) {
    super(props);
    this.customer = props.customer();
    this.renderHome = props.renderHome;
    this.setAccounts = this.setAccounts.bind(this);
    this.accounts = [
      {
        accountNumber: "Account No. 1",
        currentBalance: 1000
      },
      {
        accountNumber: "Account No. 2",
        currentBalance: 5000
      }
    ];
    this.state = { accounts: this.accounts };
    this.balanceFunc = () => {
      this.getAccounts();
    };
    this.renderTransactions = (index) => {
        return this.state.accounts[index].transactions.map((account, index) => {
            return <span key={index} className="BalanceSeg"><span className="AccountTitle">{account.amount}: </span><span className="BalanceText">{account.description}</span></span>;
        })
    };
    this.displayAccounts = () => {
      return this.state.accounts.map((account, index) => {
        this.renderTransactions(index);
      })
    };
  }

  setAccounts(response) {
    this.setState({accounts: response});
  }

  getAccounts() {
    httpGet(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts`, this.setAccounts);
  }

  getBalance() {
    this.accounts = httpGet(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts/balance`);
  }

  render() {
    this.balanceFunc();
    return (
      <div className="BalanceContainer">
          <NavBar routes={{ home: this.renderHome }}/>
          <span className="AccountNumHeader">Account Number</span>
          <span className="BalanceHeader">Balance</span>
          {this.displayAccounts()}
      </div>
    );
  }
}

export default Balance;
