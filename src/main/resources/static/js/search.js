function searchFunction() {
    // Declare variables
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('dietaryPref'); // take input from the user
    filter = input.value.toUpperCase(); // make all input uppercase
    ul = document.getElementById("foodList");
    li = ul.getElementsByTagName('li');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) { // if input value equals product display
            li[i].style.display = "";
        }else{
            li[i].style.display = "none"; //else hide product
        }
    }
}