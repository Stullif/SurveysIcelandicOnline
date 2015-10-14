<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<<<<<<< HEAD
    <head>
        <title>Survey System</title>
        <link rel="stylesheet" href="/css/style.css" type='text/css'>
    </head>
    <body>
        <h1>Survey Viewer</h1>
        <h2>Entries in database: </h2>
        <c:forEach items="${surveys}" var="survey">
            <p>
                <c:out value="${survey.getName()}"/>
            </p>
        </c:forEach>
        <a href="/">Home</a>
    </body>
    <footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
