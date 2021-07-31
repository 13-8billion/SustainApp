function searchFunction() {
    // Declare variables
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('input'); // take input from the user
    filter = input.value.toUpperCase(); // make all input uppercase
    ul = document.getElementById("productList");
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

function TestsFunction() {
    var T = document.getElementById("res");
    setTimeout( function () { T.style.display = "block"; }, 2000);
}



function validateFood()
{

//email not blank
    var grams=document.forms["addFood"]["grams"].value;
    if (grams === 0.0) //if name is null or blank
    {
        alert("Please enter grams");
        return false;
    }

// //password not blank and 8 characters
//     var password=document.forms["loginForm"]["password"].value;
//     if (password.length <8 || password=="") //if password less than 8 characters or blank
//     {
//         alert("Password must be eight characters in length");
//         return false;
//     }
//
// //if email and password meet stipulations then alert successful login
//     var all=document.forms["loginForm"]["contactEmail1" && "password"].value;
//     if (all != null || all!="") //if all input is not null or blank
//     {
//         alert("Successful login. You will now be redirected to our home page.");
//         return true;
//     }
}