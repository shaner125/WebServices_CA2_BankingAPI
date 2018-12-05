import React, { Component } from 'react';
import httpPost from './http';
import './css/Lodge.css';
import NavBar from './navBar';

class Lodge extends Component {
  constructor(props){
    super(props);
    this.customer = props.customer;
    this.renderHome = props.renderHome;
    this.buttonTitle = props.btnTitle;
    this.lodgeFunc = () => {
      this.lodge();
      this.renderHome();
    };
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

  lodge() {
    const customerDetails = {
      amount: this.state.amount,
      description: "Lodgement",
      transactionDate: this.makeDate(),
      transactionType: "LODGEMENT"
    };
    httpPost(`http://localhost:49000/api/customer/${this.customer.customerID}/accounts/{accountID}/transaction?type=lodge`, customerDetails);
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
        <input id="amount" onChange={this.handleChange.bind(this)} className="Lodge" ></input>
        <button onClick={this.lodgeFunc}>{this.buttonTitle}</button>
      </div>
    );
  }
}

export default Lodge;
