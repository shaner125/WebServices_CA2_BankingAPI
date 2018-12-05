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
    this.customer = httpGet(`http://localhost:49000/api/getByEmail/${this.email}`);
    this.create = () => {
      httpPost('http://localhost:49000/api/customer/${this.customer.customerID}/accounts/create', {});
    };
    this.renderWithdraw = props.renderWithdraw;
    this.renderTransfer = props.renderTransfer;
    this.renderLodge = props.renderLodge;
    this.renderHome = props.renderLogin;
  }
  render() {
    console.log(this.email);
    return (
      <div className="HomeContainer">
        <NavBar routes={{ home: this.renderHome}}/>
        <span className="AppTileLabel">Bank API</span>
        <Balance customer={this.customer} />
        <Tile title="Create Account" icon={add} action={this.create} customer={this.customer} />
        <Tile title="Lodgement" icon={lodge} action={this.renderLodge} customer={this.customer} />
        <Tile title="Transfer" icon={transfer} action={this.renderTransfer} customer={this.customer} />
        <Tile title="Withdraw" icon={withdraw} action={this.renderWithdraw} customer={this.customer} />
      </div>
    );
  }
}

export default Home;
