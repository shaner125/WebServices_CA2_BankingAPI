export default function httpPost(targetURL, object) {
  const xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
  xmlhttp.open("POST", targetURL);
  xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xmlhttp.send(JSON.stringify(object));
}


export function httpGet(targetURL, callback) {
  const xhr = new XMLHttpRequest();
  xhr.open('GET', targetURL, true);
  xhr.send();

 xhr.onloadend = () => {
     callback(JSON.parse(xhr.response));
 }
}
