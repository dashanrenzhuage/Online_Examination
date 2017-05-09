<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<form id="my-form" method="post">

    <select name="first-list" multiple="multiple" size="10">
        <option value="0"></option>
        <option value="1">first</option>
        <option value="2">second</option>
        <option value="3">third</option>
    </select>

    <select name="second-list" multiple="multiple" size="10">
        <option value="0"></option>
        <option value="1">first</option>
        <option value="2">second</option>
        <option value="3">third</option>
    </select>

    <!-- use this for client-side processing -->
    <input type="button" name="button" value="submit" />

    <!-- use this for server-side processing -->
    <input type="submit" name="submit" value="submit" />

</form>

<script>
window.onload = function(){
    document.getElementById("button").onclick = function(){
    var lists = document.getElementsByTagName('SELECT'), chosen = [], temp = [], list = {}, i, j; 
    for(i = 0; i < lists.length; i++) {
        list = lists[i];
        temp = [];
        for(j = 0; j < list.length; j++) {
          if(list[j].selected) temp.push(list[j].value);  
        }
        chosen.push(temp);
    }
    console.log(JSON.stringify(chosen));
    
    // Sending and receiving data in JSON format using POST mothod
//
xhr = new XMLHttpRequest();
var url = "/answer/result/1";
xhr.open("POST", url, true);
xhr.setRequestHeader("Content-type", "application/json");
xhr.onreadystatechange = function () { 
    if (xhr.readyState == 4 && xhr.status == 200) {
        var json = JSON.parse(xhr.responseText);
        console.log(json.email + ", " + json.password)
    }
}

xhr.send(temp);
    }
    
}
</script>
</body>
</html>