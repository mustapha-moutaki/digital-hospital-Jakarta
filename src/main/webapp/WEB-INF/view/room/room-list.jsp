<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
<h2>Rooms</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Capacity</th>
        <th>Department</th>
    </tr>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.id}</td>
            <td>${room.name}</td>
            <td>${room.capacity}</td>
            <td>${room.department.name}</td>
        </tr>
    </c:forEach>
</table>

<h3>Create Room</h3>
<form action="rooms" method="post">
    <input type="hidden" name="action" value="create"/>

    Name: <input type="text" name="name" required/><br/>
    Capacity: <input type="number" name="capacity" min="1" max="55" required/><br/>

    Department:
    <select name="departmentId" required>
        <option value="">-- Select Department --</option>
        <c:forEach var="dept" items="${departments}">
            <option value="${dept.id}">${dept.name}</option>
        </c:forEach>
    </select><br/><br/>

    <button type="submit">Create</button>
</form>
</body>
</html>
