<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Change Consultation Status</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 rounded-4">
        <h3 class="text-center mb-4 text-primary">Change Consultation Status</h3>

        <form action="${pageContext.request.contextPath}/consultations" method="post">
            <input type="hidden" name="action" value="updateStatusToNew">
            <input type="hidden" name="id" value="${consultationId}">

            <div class="mb-3">
                <label class="form-label fw-semibold">Select New Status:</label>
                <select name="newStatus" class="form-select" required>
                    <option value="">-- Choose Status --</option>
                    <c:forEach var="status" items="${statusTypes}">
                        <option value="${status}">${status}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="d-flex justify-content-between">
                <a href="${pageContext.request.contextPath}/consultations?action=list" class="btn btn-secondary">
                    Cancel
                </a>
                <button type="submit" class="btn btn-primary">Update Status</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
