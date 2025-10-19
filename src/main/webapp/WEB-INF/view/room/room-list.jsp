<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rooms Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">

    <h2 class="mb-4 text-primary">Rooms List</h2>

    <div class="table-responsive mb-5">
        <table class="table table-striped table-bordered align-middle">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Capacity</th>
                <th>Department</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td>${room.id}</td>
                    <td>${room.name}</td>
                    <td>${room.capacity}</td>
                    <td>${room.department.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="card shadow-sm p-4">
        <h3 class="mb-4 text-primary">Create Room</h3>
        <form action="rooms" method="post" class="row g-3">
            <input type="hidden" name="action" value="create"/>

            <div class="col-md-6">
                <label for="name" class="form-label">Room Name</label>
                <input type="text" name="name" id="name" class="form-control" required>
            </div>

            <div class="col-md-3">
                <label for="capacity" class="form-label">Capacity</label>
                <input type="number" name="capacity" id="capacity" class="form-control" min="1" max="55" required>
            </div>

            <div class="col-md-3">
                <label for="departmentId" class="form-label">Department</label>
                <select name="departmentId" id="departmentId" class="form-select" required>
                    <option value="">-- Select Department --</option>
                    <c:forEach var="dept" items="${departments}">
                        <option value="${dept.id}">${dept.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-12 mt-3">
                <button type="submit" class="btn btn-primary">Create Room</button>
            </div>
        </form>
    </div>

</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
