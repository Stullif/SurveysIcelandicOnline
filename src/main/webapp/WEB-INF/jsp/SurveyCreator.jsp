<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en"  xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Survey Creator</title>
    <link rel="stylesheet" href="/css/style.css" type='text/css'>
</head>
<body>
<h1>Survey Creator</h1>

    <form action="/surveycreator" method="POST">
        <label>Select type of question:
            <select name="typeQuestion" id="typeQuestion">
                <c:forEach items="${optionList}" var="optionList">
                    <option value='
                        <c:out value="${optionList}"/>
                    '>
                        <c:out value="${optionList}"/>
                    </option>
                </c:forEach>
            </select>
        </label>
        <br>
        <label>Write Question:
            <input type="text" name="question" id="question">
        </label>
        <br>
        <input type="checkbox" name="finished" id="finished">Survey Finished</input>
        <br>
        <input type="submit" value="Submit">
    </form>
    <div class="workingSurvey">
        <c:forEach items="${survey.getQuestions()}" var="surveyQuestions">
            <p>
                <c:out value="${surveyQuestions.getQuestion()}"/>
                <c:out value="${surveyQuestions.getType()}"/>
            </p>
        </c:forEach>
    </div>
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
