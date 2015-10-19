<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Survey Creation Completed</title>
    <link rel="stylesheet" href="/css/style.css" type='text/css'>
</head>
    <body>
        <h1>Select where to save</h1>
        <div class="workingSurvey">
            <c:forEach items="${survey.getQuestions()}" var="surveyQuestions">
                <p>
                    <c:out value="${surveyQuestions.getQuestion()}"/>
                    <c:out value="${surveyQuestions.getType()}"/>
                </p>
            </c:forEach>
            <form action="/surveyviewer" method="POST">
                location: <input type="text" name="location"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
