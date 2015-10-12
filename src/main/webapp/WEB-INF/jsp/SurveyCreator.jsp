<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Survey Creator</title>
    <c:set var="counter" scope="session" value=""/>
</head>
<body>
<h1>Survey Creator</h1>
<div id="currentSurvey">

</div>
<label>Select type of question:

<select>
    <%
        String numberOfAttributes = ""+request.getAttribute("numAttributes");
        int optionCounter = Integer.parseInt(numberOfAttributes);
        for(int i = 0; i < optionCounter; i++) {
            switch (i){
                case 0:
    %>
                    <option value="dropDown"> ${option0}</option>
    <%
                    break;
                case 1:
    %>
                    <option value="dropDown"> ${option1}</option>
    <%
                    break;
                case 2:
    %>
                    <option value="dropDown"> ${option2}</option>
    <%
                    break;
                case 3:
    %>
                    <option value="dropDown"> ${option3}</option>

    <!--
    <option value="radio">Radio Button Question</option>
    <option value="choice">Multiple Choice Question</option>
    <option value="written">Written Answer</option>
    -->
    <%
            }
        }
    %>

</select>
</label>
<p>Entry in database: ${surveyName}</p>
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
