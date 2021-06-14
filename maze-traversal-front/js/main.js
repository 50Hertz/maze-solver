// console.log(inputMaze);
var inputMaze;
var solvedMaze;
let _apiBody = {
  initialMaze: inputMaze
}

let restResponsePojo = {
  message : null,
  success : false,
  data : null,
  status : null
}

let _apiResponse = {
  initialMaze: inputMaze,
  solvedMaze: solvedMaze
}


const submitEventBtn = document.getElementById("submitEvent");
const showEventBtn = document.getElementById("showEvent");

submitEventBtn.addEventListener("click", solveMaze);
showEventBtn.addEventListener("click", showMaze);

function showMaze() {
  inputMaze = document.getElementById("inputMaze").value;
  if (!inputMaze) {
    displayAlert("Please input maze.");
  }
  generateMazeImage(inputMaze, "inputMazeImg");
}

function solveMaze() {
  inputMaze = document.getElementById("inputMaze").value;
  console.log(inputMaze);
  _apiBody.initialMaze = inputMaze;

  fetch('http://localhost:8700/api/nile/maze', {
    method: 'POST',
    headers: {'content-type': 'application/json'},
    body: JSON.stringify(_apiBody)
  })
    .catch(err => displayAlert(err))
    .then(response => response.json())
    .then(json => {
      console.log(json);
      restResponsePojo = json;

      if (!restResponsePojo) {
        displayAlert("Unable to process request. Contact system administrator.");
      }

      if (!restResponsePojo.success) {
        displayAlert(restResponsePojo.message);
      }

      _apiResponse = restResponsePojo.data;

      if (!_apiResponse) {
        displayAlert("Unable to process request. Contact system administrator.");
      }
      console.log(_apiResponse.solvedMaze);
      document.getElementById("solvedMaze").value = _apiResponse.solvedMaze;
      generateMazeImage(_apiResponse.solvedMaze, "solvedMazeImg");
    });

}

function generateMazeImage (map, divElementId) {
  document.getElementById(divElementId).innerHTML = "";
  map = map.split("\n");

  const fSpace = " ";
  map.forEach((row, index) => {
    row.trim().split("").forEach((path, i) => {
      var span = document.createElement("span");
      span.textContent = fSpace; // default
      span.classList.toggle("blue", path === "#");

      if (path === ".") {
        span.classList.toggle("path");
        span.textContent = " ";
      }
      if (path === "S") {
        span.classList.add("start");
        //span.textContent = "Start";
      }
      else if (path === "E") {
        span.classList.add("finish");
        //span.textContent = "End";
      }
      document.getElementById(divElementId).appendChild(span);
    });
    document.getElementById(divElementId).appendChild(document.createElement("br"))
  });
}

function displayAlert(message) {
  alert(message);
}
