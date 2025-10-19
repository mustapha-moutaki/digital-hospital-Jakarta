<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Department</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
        }
        .container {
            margin-top: 100px;
            max-width: 700px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            padding: 40px;
        }
        .dept-title {
            font-size: 28px;
            font-weight: bold;
            color: #34495e;
            margin-bottom: 20px;
        }
        .dept-box {
            background-color: #00bcd4;
            color: white;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            font-size: 22px;
            font-weight: 600;
        }
        .btn-back {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<jsp:include page="../assets/components/header.jsp" />
<jsp:include page="../assets/components/sideBar.jsp" />

<div class="container">
    <h2 class="dept-title text-center">Doctor's Department</h2>

    <div class="dept-box">
        <c:choose>
            <c:when test="${not empty myDepartment}">
                ${myDepartment}
            </c:when>
            <c:otherwise>
                No department assigned.
            </c:otherwise>
        </c:choose>
    </div>

    <div class="text-center btn-back">
        <a href="${pageContext.request.contextPath}/departments?action=list" class="btn btn-secondary">
            ← Back to Departments
        </a>
    </div>
</div>

</body>
</html>
