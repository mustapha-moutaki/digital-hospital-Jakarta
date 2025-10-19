<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Consultation</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        .main-content {
            margin-left: 250px;
            margin-top: 75px;
            padding: 30px;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 8px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        select, input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            border-radius: 4px;
            margin-bottom: 10px;
        }
        button {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            background-color: #2ecc71;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>

<jsp:include page="../assets/components/header.jsp" />
<jsp:include page="../assets/components/sideBar.jsp" />

<main class="main-content">
    <h2>Edit Consultation</h2>

    <form action="${pageContext.request.contextPath}/consultations" method="post">
        <input type="hidden" name="action" value="updateConsultation">
        <input type="hidden" name="id" value="${consultation.id}"/>

        <!-- Patient -->
        <label for="patientId">Patient</label>
        <select name="patientId" id="patientId" required>
            <c:forEach var="p" items="${patients}">
                <option value="${p.id}" <c:if test="${p.id eq consultation.patient.id}">selected</c:if>>
                        ${p.firstName} ${p.lastname}
                </option>
            </c:forEach>
        </select>

        <!-- Doctor -->
        <label for="doctorId">Doctor</label>
        <select name="doctorId" id="doctorId" required>
            <c:forEach var="d" items="${doctors}">
                <option value="${d.id}" <c:if test="${d.id eq consultation.doctor.id}">selected</c:if>>
                        ${d.firstName} ${d.lastname}
                </option>
            </c:forEach>
        </select>

        <!-- Room -->
        <label for="roomId">Room</label>
        <select name="roomId" id="roomId" required>
            <c:forEach var="r" items="${rooms}">
                <option value="${r.id}" <c:if test="${r.id eq consultation.room.id}">selected</c:if>>
                        ${r.name}
                </option>
            </c:forEach>
        </select>

        <!-- Start Time -->
        <label for="startTime">Start Time</label>
        <select name="startTime" id="startTime" required>
            <c:forEach var="t" items="${times}">
                <option value="${t}" <c:if test="${t eq consultation.startTime}">selected</c:if>>
                        ${t}
                </option>
            </c:forEach>
        </select>


        <!-- Report -->
        <label for="report">Report</label>
        <textarea name="report" id="report" rows="4">${consultation.report}</textarea>

        <button type="submit">Update Consultation</button>
    </form>
</main>

<jsp:include page="../assets/components/footer.jsp" />

</body>
</html>
