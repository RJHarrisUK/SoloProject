// Javascript File for SoloProject

// get result function
function showAllIngredients() {

    // remove any rows already on table before new search
    const container = document.getElementById('table');

    if (container.rows.length > 1) {

        let tableSize = container.rows.length;
        for (i = tableSize; i > 1; i--) {
            container.deleteRow(i - 1);
        }
    }

    // http request
    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.response);

        // testing the response is correct in console
        console.log(response);
        console.log(response[1].ingredientName);

        // // setting up table variables
        let tableBuild = null;

        // // for loop through response.Search to populate table with results
        let len = response.length;
        for (var i = 0; i < len; i++) {

            tableBuild = '<tr><td>' + response[i].ingredientId
                + '</td><td>' + response[i].ingredientName
                + '</td><td>' + response[i].calories
                + '</td><td>' + response[i].protein
                + '</td><td>' + response[i].totalCarbs
                + '</td><td>' + response[i].totalFat
                + '</td><td>' + '<button type="button" class="btn btn-secondary" onclick="moreDetails()">More Details</button>'
                + '</tr>'
            $("table").append(tableBuild);
        }

    }
    req.open("GET", "http://localhost:8080/SoloProject/nutrition/ingredients/getAllIngredients");
    req.send();
}
// function addIngredient() {

//     // http request
//     let req = new XMLHttpRequest();

//     req.onload = function () {
//         let response = JSON.parse(req.response);

//         // testing the response is correct in console
//         console.log(response.Search);
//     }
//     req.open("POST", "http://localhost:8080/SoloProject/nutrition/ingredients/createIngredient");
// }