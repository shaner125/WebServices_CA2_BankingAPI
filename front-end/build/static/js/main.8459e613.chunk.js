(window.webpackJsonp=window.webpackJsonp||[]).push([[0],[,,,,,,,,,function(e,t,n){e.exports=n.p+"static/media/add.5de58c43.svg"},function(e,t,n){e.exports=n.p+"static/media/withdraw.522c4cd5.svg"},function(e,t,n){e.exports=n.p+"static/media/lodgenent.c34dd796.svg"},function(e,t,n){e.exports=n.p+"static/media/transfer.c985ee2e.svg"},function(e,t,n){e.exports=n.p+"static/media/homeButton.6782fddb.svg"},function(e,t,n){e.exports=n(44)},,,,,,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){},,function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),c=n(8),i=n.n(c),s=(n(20),n(1)),o=n(2),l=n(4),u=n(3),m=n(5),h=n(6),d=(n(22),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).title=e.title,n.icon=e.icon,n.action=e.action,n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("div",{className:"TileContainer",role:"button",onClick:this.action,onKeyPress:this.action,tabIndex:0},r.a.createElement("img",{className:"TileIcon",src:this.icon,alt:"".concat(this.title," Tile Icon")}),r.a.createElement("b",{className:"TileLabel"},this.title))}}]),t}(a.Component)),p=n(9),b=n.n(p),g=n(10),f=n.n(g),E=n(11),v=n.n(E),C=n(12),O=n.n(C);function j(e,t){var n=new XMLHttpRequest;n.open("POST",e),n.setRequestHeader("Content-Type","application/json;charset=UTF-8"),n.setRequestHeader("Access-Control-Allow-Origin","*"),n.send(JSON.stringify(t))}function T(e){var t=new XMLHttpRequest;return t.setRequestHeader("Access-Control-Allow-Origin","*"),t.open("GET",e,!1),t.send(),JSON.parse(t.responseText)}n(24),n(26);var N=function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).customer=e.customer,n.accounts=[{title:"Account No. 1",balance:1e3},{title:"Account No. 2",balance:5e3}],n.balanceFunc=function(){},n.displayAccounts=function(){return n.accounts.map(function(e,t){return r.a.createElement("span",{key:t,className:"BalanceSeg"},r.a.createElement("span",{className:"AccountTitle"},e.title,": "),r.a.createElement("span",{className:"BalanceText"},e.balance))})},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"getAccounts",value:function(){this.accounts=T("http://cors.io/?http://localhost:49000/api/customer/".concat(this.customer.customerID,"/accounts/balance"))}},{key:"getBalance",value:function(){this.accounts=T("http://cors.io/?http://localhost:49000/api/customer/".concat(this.customer.customerID,"/accounts/balance"))}},{key:"render",value:function(){return this.balanceFunc(),r.a.createElement("div",{className:"BalanceContainer"},this.displayAccounts())}}]),t}(a.Component),k=(n(28),n(13)),w=n.n(k),y=function(e){function t(){return Object(s.a)(this,t),Object(l.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){var e=this.props.routes;return r.a.createElement("div",null,r.a.createElement("img",{id:"navBarHomeBtn",className:"navBarBtn",onClick:e.home,onKeyPress:e.home,src:w.a,alt:"Home Navigation Bar Button"}))}}]),t}(r.a.Component),S=function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).email=e.email(),n.customer=T("http://cors.io/?http://localhost:49000/api/getByEmail/".concat(n.email)),n.create=function(){j("http://cors.io/?http://localhost:49000/api/customer/${this.customer.customerID}/accounts/create",{})},n.renderWithdraw=e.renderWithdraw,n.renderTransfer=e.renderTransfer,n.renderLodge=e.renderLodge,n.renderHome=e.renderLogin,n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return console.log(this.email),r.a.createElement("div",{className:"HomeContainer"},r.a.createElement(y,{routes:{home:this.renderHome}}),r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement(N,{customer:this.customer}),r.a.createElement(d,{title:"Create Account",icon:b.a,action:this.create,customer:this.customer}),r.a.createElement(d,{title:"Lodgement",icon:v.a,action:this.renderLodge,customer:this.customer}),r.a.createElement(d,{title:"Transfer",icon:O.a,action:this.renderTransfer,customer:this.customer}),r.a.createElement(d,{title:"Withdraw",icon:f.a,action:this.renderWithdraw,customer:this.customer}))}}]),t}(a.Component),L=(n(30),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).customer=e.customer,n.renderHome=e.renderHome,n.buttonTitle=e.btnTitle,n.lodgeFunc=function(){n.lodge(),n.renderHome()},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"makeDate",value:function(){var e=new Date,t=e.getDate(),n=e.getMonth()+1,a=e.getFullYear();return t<10&&(t="0"+t),n<10&&(n="0"+n),e=t+"/"+n+"/"+a}},{key:"lodge",value:function(){var e={amount:this.state.amount,description:"Lodgement",transactionDate:this.makeDate(),transactionType:"LODGEMENT"};j("http://cors.io/?http://localhost:49000/api/customer/".concat(this.customer.customerID,"/accounts/{accountID}/transaction?type=lodge"),e),console.log(e)}},{key:"handleChange",value:function(e){var t={};t[e.target.id]=e.target.value,this.setState(t)}},{key:"render",value:function(){return r.a.createElement("div",{className:"InputContainer"},r.a.createElement(y,{routes:{home:this.renderHome}}),r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement("input",{id:"amount",onChange:this.handleChange.bind(this),className:"Lodge"}),r.a.createElement("button",{onClick:this.lodgeFunc},this.buttonTitle))}}]),t}(a.Component)),H=(n(32),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).customer=e.customer,n.renderHome=e.renderHome,n.buttonTitle=e.btnTitle,n.transferFunc=function(){n.transfer(),n.renderHome()},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"makeDate",value:function(){var e=new Date,t=e.getDate(),n=e.getMonth()+1,a=e.getFullYear();return t<10&&(t="0"+t),n<10&&(n="0"+n),e=t+"/"+n+"/"+a}},{key:"transfer",value:function(){var e={amount:this.state.amount,description:"Transferal",transactionDate:this.makeDate(),transactionType:"TRANSFERAL"};j("http://cors.io/?http://localhost:49000/api/customer/".concat(this.customer.customerID,"/accounts/").concat(this.customer.accountID,"/transaction?type=transfer"),e),console.log(e)}},{key:"handleChange",value:function(e){var t={};t[e.target.id]=e.target.value,this.setState(t)}},{key:"render",value:function(){return r.a.createElement("div",{className:"InputContainer"},r.a.createElement(y,{routes:{home:this.renderHome}}),r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement("span",null,"To: "),r.a.createElement("input",{id:"amount",onChange:this.handleChange.bind(this),className:"Transfert"}),r.a.createElement("button",{onClick:this.transferFunc},this.buttonTitle))}}]),t}(a.Component)),A=(n(34),n(36),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).customer=e.customer,n.renderHome=e.renderHome,n.buttonTitle=e.btnTitle,n.withdrawFunc=function(){n.withdraw(),n.renderHome()},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"makeDate",value:function(){var e=new Date,t=e.getDate(),n=e.getMonth()+1,a=e.getFullYear();return t<10&&(t="0"+t),n<10&&(n="0"+n),e=t+"/"+n+"/"+a}},{key:"withdraw",value:function(){var e={amount:this.state.amount,description:"Withdrawal",transactionDate:this.makeDate(),transactionType:"WITHDRAWAL"};j("http://cors.io/?http://localhost:49000/api/customer/".concat(this.customer.customerID,"/accounts/{accountID}/transaction?type=withdraw"),e),console.log(e)}},{key:"handleChange",value:function(e){var t={};t[e.target.id]=e.target.value,this.setState(t)}},{key:"render",value:function(){return r.a.createElement("div",{className:"InputContainer"},r.a.createElement(y,{routes:{home:this.renderHome}}),r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement("span",null,"Amount To Withdraw: "),r.a.createElement("input",{id:"amount",onChange:this.handleChange.bind(this),className:"Withdraw"}),r.a.createElement("button",{onClick:this.withdrawFunc},this.buttonTitle))}}]),t}(a.Component)),I=(n(38),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).renderHome=e.renderLogin,n.buttonTitle=e.btnTitle,n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("div",{className:"InputContainer"},r.a.createElement(y,{routes:{home:this.renderHome}}),r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement("span",null,"Name: "),r.a.createElement("input",{className:"Create",id:""}),r.a.createElement("span",null," Name: "),r.a.createElement("input",{className:"Create",id:""}),r.a.createElement("br",null),r.a.createElement("span",null,"Name: "),r.a.createElement("input",{className:"Create",id:""}),r.a.createElement("span",null," Name: "),r.a.createElement("input",{className:"Create",id:""}),r.a.createElement("br",null),r.a.createElement("button",null,this.buttonTitle))}}]),t}(a.Component)),D=(n(40),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).renderLogin=e.renderLogin,n.buttonTitle=e.btnTitle,n.registerFunc=function(){n.createCustomer();var e=T("http://cors.io/?http://localhost:49000/api/getByEmail/".concat(n.state.email));n.createAccount(e),n.renderLogin()},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"createAccount",value:function(e){j("http://cors.io/?http://localhost:49000/api/customer/".concat(e.customerID,"/accounts/create"),{})}},{key:"createCustomer",value:function(){var e={name:this.state.name,address:this.state.address,email:this.state.email,password:this.state.password};j("http://cors.io/?http://localhost:49000/api/customer/create",e),console.log(e)}},{key:"handleChange",value:function(e){var t={};t[e.target.id]=e.target.value,this.setState(t)}},{key:"render",value:function(){return r.a.createElement("div",{className:"RegisterContainer"},r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement("div",{className:"RegisterContent"},r.a.createElement("span",{className:"RegisterLabel"},"Name: "),r.a.createElement("input",{id:"name",onChange:this.handleChange.bind(this),className:"RegisterInput"}),r.a.createElement("span",{className:"RegisterLabel"}," Address: "),r.a.createElement("input",{id:"address",onChange:this.handleChange.bind(this),className:"RegisterInput"}),r.a.createElement("br",null),r.a.createElement("span",{className:"RegisterLabel"},"Email: "),r.a.createElement("input",{id:"email",onChange:this.handleChange.bind(this),className:"RegisterInput"}),r.a.createElement("span",{className:"RegisterLabel"}," Password: "),r.a.createElement("input",{id:"password",onChange:this.handleChange.bind(this),type:"password",className:"RegisterInput"}),r.a.createElement("br",null),r.a.createElement("br",null)),r.a.createElement("button",{onClick:this.registerFunc},this.buttonTitle))}}]),t}(a.Component)),B=(n(42),function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).setEmail=e.setEmail,n.renderHome=e.renderHome,n.buttonTitle=e.btnTitle,n.loginFunc=function(){n.login(),n.setEmail(n.state.email),n.renderHome()},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"login",value:function(){}},{key:"handleChange",value:function(e){var t={};t[e.target.id]=e.target.value,this.setState(t)}},{key:"render",value:function(){return r.a.createElement("div",{className:"LoginContainer"},r.a.createElement("span",{className:"AppTileLabel"},"Bank API"),r.a.createElement("div",{className:"LoginContent"},r.a.createElement("span",{className:"LoginLabel"},"Email: "),r.a.createElement("input",{id:"email",onChange:this.handleChange.bind(this),className:"LoginInput"}),r.a.createElement("span",{className:"LoginLabel"}," Password: "),r.a.createElement("input",{id:"password",onChange:this.handleChange.bind(this),type:"password",className:"LoginInput"}),r.a.createElement("br",null),r.a.createElement("br",null)),r.a.createElement("button",{onClick:this.loginFunc},this.buttonTitle))}}]),t}(a.Component)),R=function(e){function t(e){var n;return Object(s.a)(this,t),(n=Object(l.a)(this,Object(u.a)(t).call(this,e))).renderWithdrawScreen=function(){n.setState({screen:n.withdrawScreen})},n.renderLodgeScreen=function(){n.setState({screen:n.lodgeScreen})},n.renderCreateScreen=function(){n.setState({screen:n.createScreen})},n.renderTransferScreen=function(){n.setState({screen:n.transferScreen})},n.renderLoginScreen=function(){n.setState({screen:n.loginScreen})},n.renderHomeScreen=function(){n.setState({screen:n.homeScreen})},n.lodgeScreen=r.a.createElement(L,{btnTitle:"Lodge Cash",renderHome:n.renderHomeScreen}),n.withdrawScreen=r.a.createElement(A,{btnTitle:"Withdraw Cash",renderHome:n.renderHomeScreen}),n.transferScreen=r.a.createElement(H,{btnTitle:"Transfer",renderHome:n.renderHomeScreen}),n.getEmail=n.getEmail.bind(Object(h.a)(Object(h.a)(n))),n.setEmail=n.setEmail.bind(Object(h.a)(Object(h.a)(n))),n.registerScreen=r.a.createElement(D,{btnTitle:"Register",renderLogin:n.renderLoginScreen}),n.createScreen=r.a.createElement(I,{btnTitle:"Create Account",renderHome:n.renderHomeScreen}),n.loginScreen=r.a.createElement(B,{btnTitle:"Login",renderHome:n.renderHomeScreen,setEmail:n.setEmail}),n.homeScreen=r.a.createElement(S,{renderWithdraw:n.renderWithdrawScreen,renderTransfer:n.renderTransferScreen,renderLodge:n.renderLodgeScreen,renderHome:n.renderHomeScreen,email:n.getEmail}),n.state={screen:n.registerScreen,email:""},n}return Object(m.a)(t,e),Object(o.a)(t,[{key:"getEmail",value:function(){return this.state.email}},{key:"setEmail",value:function(e){this.setState({email:e})}},{key:"render",value:function(){return r.a.createElement("div",{className:"App"},this.state.screen)}}]),t}(a.Component);i.a.render(r.a.createElement(R,null),document.getElementById("root"))}],[[14,2,1]]]);
//# sourceMappingURL=main.8459e613.chunk.js.map