import {initFruitTable} from "./fruitTable.js";

document.addEventListener("DOMContentLoaded", () => {
    const tbody = document.querySelector('tbody');
    initFruitTable(tbody);
});


// Create button toggles the create new fruit form
document.getElementById('toggle-button').addEventListener('click', () => {
    const box = document.getElementById('until-found-box');
    box.hidden = !box.hidden;
});