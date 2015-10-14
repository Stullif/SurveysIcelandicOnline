<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
    <head>
        <title>Survey System</title>
        <link rel="stylesheet" href="/css/style.css" type='text/css'>
    </head>
    <body class="center">

    <h1>Survey Interface</h1>
    <p>Please Select </p>
    <a href="/user">Usershizzle</a>
    <br>
    <a href="/surveyviewer">View Surveys</a>
    <form action="/surveycreator" method="get">
        Survey name: <input type="text" name="name">
        <input type="submit" value="Create Survey">
    </form>
    </body>
    <footer>Class HBV501G, University of Iceland , Fall 2015</footer>
</html>
