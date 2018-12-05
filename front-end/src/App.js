import React, { Component } from 'react';
import Home from './Home';
import Lodge from './Lodge';
import Transfer from './Transfer';
import './css/App.css';
import Withdraw from './Withdraw';
import Create from './Create';
import Register from './Register';
import Login from './Login';

class App extends Component {
  constructor(props) {
    super(props);
    this.renderWithdrawScreen = () => { this.setState( { screen: this.withdrawScreen })};
    this.renderLodgeScreen = () => { this.setState( { screen: this.lodgeScreen })};
    this.renderCreateScreen = () => { this.setState( { screen: this.createScreen })};
    this.renderTransferScreen = () => { this.setState( { screen: this.transferScreen })};
    this.renderLoginScreen = () => { this.setState( { screen: this.loginScreen })};
    this.renderHomeScreen = () => { this.setState( { screen: this.homeScreen })};
    this.lodgeScreen = (<Lodge btnTitle="Lodge Cash" renderHome={this.renderHomeScreen}/>);
    this.withdrawScreen = (<Withdraw btnTitle="Withdraw Cash" renderHome={this.renderHomeScreen}/>);
    this.transferScreen = (<Transfer btnTitle="Transfer" renderHome={this.renderHomeScreen}/>);
    this.getEmail = this.getEmail.bind(this);
    this.setEmail = this.setEmail.bind(this);
    this.registerScreen = (<Register btnTitle="Register" renderLogin={this.renderLoginScreen}/>);
    this.createScreen = (<Create btnTitle="Create Account" renderHome={this.renderHomeScreen}/>);
    this.loginScreen = (<Login btnTitle="Login" renderHome={this.renderHomeScreen} setEmail={this.setEmail}/>);
    this.state = {
      screen: this.registerScreen,
      email: ""
    }
    this.homeScreen = (
      <Home
        renderWithdraw={this.renderWithdrawScreen}
        renderTransfer={this.renderTransferScreen}
        renderLodge={this.renderLodgeScreen}
        renderHome={this.renderHomeScreen}
        email={this.getEmail}
      />
    );

  }

  getEmail() {
    return this.state.email;
  }

  setEmail(email) {
    this.setState({email: email});
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
