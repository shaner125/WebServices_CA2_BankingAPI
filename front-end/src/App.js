import React, { Component } from 'react';
import Home from './Home';
import Lodge from './Lodge';
import Transfer from './Transfer';
import './css/App.css';
import Withdraw from './Withdraw';
import Create from './Create';
import Register from './Register';
import Login from './Login';
import Balance from "./Balance";

class App extends Component {
  constructor(props) {
    super(props);
    this.customer = {};
    this.getCustomer = this.getCustomer.bind(this);
    this.renderScreen = this.renderScreen.bind(this);
    this.renderWithdrawScreen =(customer) => { this.renderScreen(customer, this.withdrawScreen)};
    this.renderBalanceScreen =(customer) => { this.renderScreen(customer, this.balanceScreen)};
    this.renderLodgeScreen = (customer) => { this.renderScreen(customer, this.lodgeScreen); };
    this.renderCreateScreen = () => { this.setState( { screen: this.createScreen })};
    this.renderTransferScreen = (customer) => { this.renderScreen(customer, this.transferScreen); };
    this.renderLoginScreen = () => { this.setState( { screen: this.loginScreen })};
    this.renderRegisterScreen = () => { this.setState( { screen: this.registerScreen })};
    this.renderHomeScreen = () => { this.setState( { screen: this.homeScreen })};
    this.lodgeScreen = (<Lodge btnTitle="Lodge Cash" renderHome={this.renderHomeScreen} customer={this.getCustomer}/>);
    this.withdrawScreen = (<Withdraw btnTitle="Withdraw Cash" renderHome={this.renderHomeScreen} customer={this.getCustomer}/>);
    this.balanceScreen = (<Balance renderHome={this.renderHomeScreen} customer={this.getCustomer}/>);
    this.transferScreen = (<Transfer btnTitle="Transfer" renderHome={this.renderHomeScreen} customer={this.getCustomer}/>);
    this.getEmail = this.getEmail.bind(this);
    this.setEmail = this.setEmail.bind(this);
    this.registerScreen = (<Register btnTitle="Register" renderLogin={this.renderLoginScreen}/>);
    this.createScreen = (<Create btnTitle="Create Account" renderHome={this.renderHomeScreen}/>);
    this.loginScreen = (<Login btnTitle="Login" renderHome={this.renderHomeScreen} renderRegister={this.renderRegisterScreen} setEmail={this.setEmail}/>);
    this.state = {
      screen: this.loginScreen,
      email: ""
    };
    this.homeScreen = (
      <Home
        renderWithdraw={this.renderWithdrawScreen}
        renderTransfer={this.renderTransferScreen}
        renderLodge={this.renderLodgeScreen}
        renderHome={this.renderHomeScreen}
        renderBalance={this.renderBalanceScreen}
        email={this.getEmail}
      />
    );

  }

  getCustomer() {
        return this.customer;
  }

  renderScreen(customer, screen) {
    this.customer = customer;
    this.setState( { screen: screen });
  }

  getEmail() {
    return this.state.email;
  }

  setEmail(email) {
    this.setState({email: email});
  }

  setScreen(screen) {
        this.setState({screen});
  }

  render() {
    return (
      <div className="App">
        {this.state.screen}
      </div>
    );
  }
}

export default App;
