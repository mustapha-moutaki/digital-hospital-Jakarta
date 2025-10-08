<%--
  Created by IntelliJ IDEA.
  User: mustapha
  Date: 10/7/25
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doctor form</title>
</head>
<body>
<h1>
    Creaate a doctor
</h1>
<form method="post" action="${pageContext.request.contextPath}/doctors">
    <label>enter age</label>
    <input type="number" age="age" />
    <label>enter name</label>
    <input type="text" name="name" />
    <button type="submit">Create Doctor</button>
</form>

</body>
</html>
