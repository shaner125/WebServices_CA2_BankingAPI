import React, { Component } from 'react';
import { httpGet } from './http';
import './css/Balance.css';

class Balance extends Component {
  constructor(props) {
    super(props);
    this.customer = props.customer;
    this.accounts = [
      {
        title: "Account No. 1",
        balance: 1000
      },
      {
        title: "Account No. 2",
        balance: 5000
      }
    ];
    this.balanceFunc = () => {
      // this.getAccounts();
    };
    this.displayAccounts = () => {
      return this.accounts.map((account, index) => {
        return <span key={index} className="BalanceSeg"><span className="AccountTitle">{account.title}: </span><span className="BalanceText">{account.balance}</span></span>;
      })
    };
  }

  getAccounts() {
    this.accounts = httpGet(`http://localhost:49000/api/customer/${this.customer.customerID}/accounts/balance`);
  }

  getBalance() {
    this.accounts = httpGet(`http://localhost:49000/api/customer/${this.customer.customerID}/accounts/balance`);
  }

  render() {
    this.balanceFunc();
    return (
      <div className="BalanceContainer">
        {this.displayAccounts()}
      </div>
    );
  }
}

export default Balance;
