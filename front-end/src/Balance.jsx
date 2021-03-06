import React, { Component } from 'react';
import { httpGet, httpDelete } from './http';
import './css/Balance.css';
import NavBar from "./navBar";

class Balance extends Component {
  constructor(props) {
    super(props);
    this.customer = props.customer();
    this.renderHome = props.renderHome;
    this.deleteAccount = this.deleteAccount.bind(this);
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
    this.displayAccounts = () => {
      return this.state.accounts.map((account, index) => {
          return <span key={index} onClick={ () => { this.renderTransactions(index) } } className="BalanceSeg"><span className="AccountTitle">{account.accountNumber}: </span><span className="BalanceText">{account.currentBalance}</span></span>;
      })
    };
  }

  setAccounts(response) {
    this.setState({accounts: response});
  }

  getAccounts() {
    httpGet(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts`, this.setAccounts);
  }

  deleteAccount() {
    httpDelete(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts`, this.setAccounts);
  }

  getBalance() {
    this.accounts = httpGet(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts/balance`);
  }

  renderTransactions(index) {
      let s = "";
      for (let i = 0; i < this.state.accounts[index].transactions.length; i+=1) {
          const t = this.state.accounts[index].transactions[i];
          s += "Amount: " + t.amount + " Type: " + t.description + " - " + t.modifier + " Balance: " + t.postBalance + "\n";
      }
      alert(s);
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
