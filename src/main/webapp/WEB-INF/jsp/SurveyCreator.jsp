<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Survey Creator</title>
    <c:set var="counter" scope="session" value=""/>
</head>
<body>
<%!
String currentItem(int counter){
    String result = "option"+counter;
    return result;
}
%>
<h1>Survey Creator</h1>
<div id="currentSurvey">

</div>
<label>Select type of question:

<select>

    <c:forEach items="${optionList}" var="optionList">
        <option value='
        <c:out value="${optionList}"/>
        '>
        <c:out value="${optionList}"/>
        </option>
    </c:forEach>

</select>
</label>
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
