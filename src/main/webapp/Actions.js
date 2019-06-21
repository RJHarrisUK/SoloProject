// Javascript File for SoloProject

const GCP = "http://34.76.51.109:8888"
const LOCAL = "http://localhost:8080"

// READ - get all ingredients function
function showAllIngredients() {

    // remove any rows already on table before new search
    const container = document.getElementById('table');

    if (container.rows.length > 1) {

        let tableSize = container.rows.length;
        for (i = tableSize; i > 1; i--) {
            container.deleteRow(i - 1);
        }
    }
    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.response);

        // testing the response is correct in console
        console.log(response);
        console.log(response[0].ingredientName);

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
                + '</td><td>' + `<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#updateModal" onClick="setUpdateID(${response[i].ingredientId});">Update</button>`
                + '</td><td>' + `<button type="button" class="btn btn-secondary" onclick="deleteIngredient(${response[i].ingredientId})">Delete</button>`
                + '</tr>'
            response[i].ingredientId
            $("table").append(tableBuild);
        }

    }
    req.open("GET", GCP + "/SoloProject/nutrition/ingredients/getAllIngredients");
    req.send();
}

// READ - get all recipes function
function showAllRecipes() {

    // remove any rows already on table before new search
    const container = document.getElementById('table');

    if (container.rows.length > 1) {

        let tableSize = container.rows.length;
        for (i = tableSize; i > 1; i--) {
            container.deleteRow(i - 1);
        }
    }
    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.response);

        // testing the response is correct in console
        console.log(response);
        console.log(response[0].recipeName);
        console.log(response[0].ingredientSet);
        console.log(response[0].ingredientSet[0].ingredientId);
        console.log(response[0].ingredientSet[0].calories);
        console.log(response[0].ingredientSet[0].ingredientName);
        console.log(response[0].ingredientSet[0].protein);
        console.log(response[0].ingredientSet[0].totalCarbs);
        console.log(response[0].ingredientSet[0].totalFat);

        // // setting up table variables
        let tableBuild2 = null;


        // // for loop through response.Search to populate table with results
        let len = response.length;
        for (var i = 0; i < len; i++) {

            let ingreds = "";
            for (let ingredient of response[i].ingredientSet) {

                ingreds +=

                    + '<tr>'
                    + '<td>' + "-"
                    + '</td><td>' + ingredient.ingredientName
                    + '</td><td>' + ingredient.calories
                    + '</td><td>' + ingredient.protein
                    + '</td><td>' + ingredient.totalCarbs
                    + '</td><td>' + ingredient.totalFat
                    + '</td><td>' + "-"
                    + '</td><td>' + "-"
                    + '</td></tr>'
            }

            tableBuild2 = '<tr><td>' + response[i].recipeId
                + '</td><td>' + response[i].recipeName
                + '</td><td>' + "-"
                + '</td><td>' + "-"
                + '</td><td>' + "-"
                + '</td><td>' + "-"
                + '</td><td>' + `<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#updateModal" onClick="">Update</button>`
                + '</td><td>' + `<button type="button" class="btn btn-secondary" onclick="deleteRecipe(${response[i].recipeId})">Delete</button>`
                + '</td>' + ingreds
                + '</tr>'
            response[i].recipeId
            $("table").append(tableBuild2);
        }


    }
    req.open("GET", GCP + "/SoloProject/nutrition/recipes/getAllRecipes");
    req.send();
}

let updateID = 0;

function unSetUpdateID() {
    updateID = 0;
}
function setUpdateID(id) {
    updateID = id;
}
// CREATE - add ingredient function
function addIngredient() {

    // set ingredient object as inputs
    let ingredient = {
        "ingredientName": document.getElementById("ingredientNameBox").value,
        "calories": document.getElementById("caloriesBox").value,
        "totalFat": document.getElementById("fatBox").value,
        "totalCarbs": document.getElementById("carbsBox").value,
        "protein": document.getElementById("proteinBox").value
    }

    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.response);
        console.log(response);

    }
    req.open("POST", GCP + "/SoloProject/nutrition/ingredients/createIngredient");
    req.send(JSON.stringify(ingredient));
    $('#exampleModal').modal('hide');
    showAllIngredients();
}

// CREATE - add recipe function
function addRecipe() {

    // set ingredient object as inputs
    let recipe = {
        "recipeName": document.getElementById("recipeNameBox").value
    }

    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.response);
        console.log(response);

    }
    req.open("POST", GCP + "/SoloProject/nutrition/recipes/createRecipe");
    req.send(JSON.stringify(recipe));
    $('#recipeModal').modal('hide');
    showAllRecipes();
}

// DELETE - delete ingredient function
function deleteIngredient(id) {
    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.responseText);
        console.log(response);
    }
    req.open("DELETE", GCP + "/SoloProject/nutrition/ingredients/deleteIngredient/" + id);
    req.send();

    console.log(req);
    $('#exampleModal').modal('hide');
    showAllIngredients();
}

// DELETE - delete recipe function
function deleteRecipe(id) {
    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.responseText);
        console.log(response);
    }
    req.open("DELETE", GCP + "/SoloProject/nutrition/recipes/deleteRecipe/" + id);
    req.send();

    console.log(req);
    $('#exampleModal').modal('hide');
    showAllRecipes();
}

// UPDATE PART 2: THE UPDATE STRIKES BACK - update ingredient function http request
function updateIngredient() {

    // set ingredient object as inputs
    let ingredient2 = {
        "ingredientName": document.getElementById("updateingredientNameBox").value,
        "calories": document.getElementById("updatecaloriesBox").value,
        "totalFat": document.getElementById("updatefatBox").value,
        "totalCarbs": document.getElementById("updatecarbsBox").value,
        "protein": document.getElementById("updateproteinBox").value
    }

    let req = new XMLHttpRequest();

    req.onload = function () {
        let response = JSON.parse(req.response);
        console.log(response);
        showAllIngredients();
        clearUpdateModal();
    }
    req.open("PUT", GCP + "/SoloProject/nutrition/ingredients/updateIngredient/" + updateID);
    req.send(JSON.stringify(ingredient2));
}

function clearUpdateModal() {
    for (let i of $("#updateModal input")) {
        i.value = ""
    }
}

// UPDATE PART 1 - update ingredient button - open modal and save id number
function updateIngredientModal(updateId) {

    // set ingredient object as inputs
    let ingredient2 = {
        "ingredientName": document.getElementById("updateingredientNameBox").value,
        "calories": document.getElementById("updatecaloriesBox").value,
        "totalFat": document.getElementById("updatefatBox").value,
        "totalCarbs": document.getElementById("updatecarbsBox").value,
        "protein": document.getElementById("updateproteinBox").value
    }

}
