function validateMovieform() {
    var title= document.forms["editmovie"]["title"].value;
    if(title == "")
{
    alert("Title is required");
    return false;
}
var titlelength = title.length;
if(title.length < 2 || titlelength > 65){
    alert("Title should have 2 to 100 characters");
    return false;
}

var gross = document.forms["editmovie"]["gross"].value;
if(isNaN(gross))
{
    alert("Box Office has to be a number");
    return false;
}
if(gross==""){
    alert("Box Office is required");
    return false;
}

var dateOfLaunch= document.forms["editmovie"]["dateOfLaunch"].value;
if(dateOfLaunch == ""){
    alert("Date Of Launch is required");
    return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
    alert("Incorrect date format.Expected format(dd/mm/yyyy)");
    return false;
}

var genre=document.forms["editmovie"]["genre"].value;
if(genre=="0"){
    alert("Select one genre");
    return false;
}
}
function deleteRow(r){
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("table_id").deleteRow(i);
    document.getElementById("span").innerHTML="Movie removed from Favorites successfully";
    addcolumn();
}

function addcolumn(){
    var totalrows= document.getElementById("table_id").rows.length;
    datarows = (totalrows-2);
    document.getElementById("val").innerHTML=datarows;
    }