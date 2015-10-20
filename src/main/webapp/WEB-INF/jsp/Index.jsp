<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <title>Survey System</title>
        <link rel="stylesheet" href="/css/style.css" type='text/css'>
    </head>
    <body class="center">
        <h1>Survey Interface</h1>
        <p>Please Select </p>
        <br>
        <a href="/surveyviewer">View Surveys</a>
        <form action="/surveycreator" method="get">
            Survey name: <input type="text" name="name">
            <input type="submit" value="Create Survey">
        </form>
    </body>
    <footer>Class HBV501G, University of Iceland , Fall 2015</footer>
</html>
