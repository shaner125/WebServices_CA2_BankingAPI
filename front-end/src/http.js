export default function httpPost(targetURL, object) {
  const xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
  xmlhttp.open("POST", targetURL);
  xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xmlhttp.send(JSON.stringify(object));
}


export function httpGet(targetURL) {
  const xhr = new XMLHttpRequest();
  xhr.open('GET', targetURL, false);
  xhr.send();

  return JSON.parse(xhr.responseText);
}
