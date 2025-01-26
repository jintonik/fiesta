### From FF console
```js
(function() {
  "use strict"
  var data = getData();
  let list = document.getElementById("listOutput");
  for (let index = 1; index < data.length; index++) {
    let li = document.createElement("li");
    li.innerText = data[index];
    list.appendChild(li);
  };
  async function getData() {
    var response = await fetch('api/users');
    var data = await response.json();
    console.log(JSON.stringify(data));
    return JSON.stringify(data);
  };
})();
```