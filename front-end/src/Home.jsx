import React, { Component } from 'react';
import Tile from './Tile';
import add from './svg/add.svg';
import withdraw from './svg/withdraw.svg';
import lodge from './lodgenent.svg';
import transfer from './svg/transfer.svg';
import httpPost, { httpGet } from './http';
import './css/Home.css';
import Balance from './Balance';
import NavBar from './navBar';

class Home extends Component {
  constructor(props){
    super(props);
    this.email = props.email();
    this.getCustomer = this.getCustomer.bind(this);
    this.setCustomer = this.setCustomer.bind(this);
    this.customer = httpGet(`http://localhost:49000/api/customers/getByEmail/${this.email}`, this.setCustomer );
    this.create = () => {
      httpPost(`http://localhost:49000/api/customers/${this.customer.customerID}/accounts/create`, {});
    };
    this.renderWithdraw = () => {
        props.renderWithdraw(this.getCustomer());
    };
    this.renderTransfer = () => {
          props.renderTransfer(this.getCustomer());
    };
    this.renderLodge = () => {
        props.renderLodge(this.getCustomer());
    };
      this.renderBalance = () => {
          props.renderBalance(this.getCustomer());
      };
    this.renderHome = props.renderHome;
  }

  getCustomer() {
      return this.customer;
  }

  setCustomer(response) {
    this.customer = response;
  }

  render() {
    console.log(this.email);
    return (
      <div className="HomeContainer">
        <NavBar routes={{ home: this.renderHome}}/>
        <span className="AppTileLabel">Bank API</span>
        <Tile title="Balances" icon={add} action={this.renderBalance} />
        <Tile title="Create Account" icon={add} action={this.create} />
        <Tile title="Lodgement" icon={lodge} action={this.renderLodge} />
        <Tile title="Transfer" icon={transfer} action={this.renderTransfer} />
        <Tile title="Withdraw" icon={withdraw} action={this.renderWithdraw} />
      </div>
    );
  }
}

export default Home;
