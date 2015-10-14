<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>User Page</title>
        <link rel="stylesheet" href="/css/style.css" type='text/css'>
    </head>
    <body>

    <h1>User Page</h1>
    <p>Here could be some user information</p>

    <table border="1px gray">
        <thead>
            <tr class="font-weight">
                <td>Name</td>
                <td>Job</td>
                <td>email</td>
                <td>Description</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${name}</td>
                <td>${job}</td>
                <td>${email}</td>
                <td>${description}</td>
            </tr>
        </tbody>
    </table>

    </body>
</html>