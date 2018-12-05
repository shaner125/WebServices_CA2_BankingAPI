import React from 'react';
import './css/navBar.css';
import home from './svg/homeButton.svg';

export default class NavBar extends React.Component {
  render() {
    const { routes } = this.props;
    return (
      <div>
        <img id="navBarHomeBtn" className="navBarBtn" onClick={routes.home} onKeyPress={routes.home} src={home} alt="Home Navigation Bar Button" />
      </div>
    );
  }
}
