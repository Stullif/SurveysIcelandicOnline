<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Survey System</title>
</head>
<body>

<h1>Survey Viewer</h1>
<p>Please Select </p>
<p>Entries in database: </p>
<c:forEach items="${surveys}" var="survey">
    <p>
        <c:out value="${survey.getName()}"/>
    </p>
</c:forEach>
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
