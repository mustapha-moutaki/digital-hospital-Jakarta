<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consultations</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #34495e;
            color: white;
        }

        tr:nth-child(even) {background-color: #f2f2f2;}
        tr:hover {background-color: #e0f3ff;}
    </style>
</head>
<body>
<div>
    <h2>Consultations</h2>
    <div style="margin-bottom: 15px;">
        <a href="${pageContext.request.contextPath}/consultations?action=add" class="btn btn-success">
            Add New Consultation
        </a>
    </div>


</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Patient</th>
        <th>Doctor</th>
        <th>Room</th>
        <th>StartTime</th>
        <th>EndTime</th>
        <th>Status</th>
        <th>Report</th>
        <th>Consultation Date</th>
        <th>Patient ID</th>
        <th>Doctor ID</th>
        <th>Room ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${consultations}">
        <tr>
            <td>${c.id}</td>
            <td>${c.patient.firstName} ${c.patient.lastName}</td>
            <td>${c.doctor.firstName} ${c.doctor.lastName}</td>
            <td>${c.room.name}</td>
            <td>${c.startTime}</td>
            <td>${c.endTime}</td>
            <td>${c.consultationStatus}</td>
            <td>${c.report}</td>
            <td>${c.dateTime}</td>
            <td>${c.patient.id}</td>
            <td>${c.doctor.id}</td>
            <td>${c.room.id}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
