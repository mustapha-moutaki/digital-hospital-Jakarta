<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Consultation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="card shadow-sm p-4">
        <h3 class="mb-4 text-primary">Add Consultation</h3>

        <form action="${pageContext.request.contextPath}/consultations" method="post">
            <input type="hidden" name="action" value="createConsultation"/>

            <div class="mb-3">
                <label for="patientId" class="form-label">Patient</label>
                <select class="form-select" id="patientId" name="patientId" required>
                    <c:forEach var="p" items="${patients}">
                        <option value="${p.id}">${p.firstName} ${p.lastname}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="doctorId" class="form-label">Doctor</label>
                <select class="form-select" id="doctorId" name="doctorId" required>
                    <c:forEach var="d" items="${doctors}">
                        <option value="${d.id}">${d.firstName} ${d.lastname}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="consultationDate" class="form-label">Select Day</label>
                <input type="date" id="consultationDate" name="consultationDate" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="consultationTime" class="form-label">Select Time</label>
                <select id="consultationTime" name="startTime" class="form-select" required>
                    <option value="">Select Time</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="roomId" class="form-label">Room</label>
                <select class="form-select" id="roomId" name="roomId" required>
                    <option value="">Select Room</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Save Consultation</button>
        </form>
    </div>
</div>

<script>
    const contextPath = "${pageContext.request.contextPath}";

    document.getElementById("doctorId").addEventListener("change", function() {
        document.getElementById("consultationDate").dispatchEvent(new Event('change'));
    });

    document.getElementById("consultationDate").addEventListener("change", function() {
        const date = this.value;
        const doctorId = document.getElementById("doctorId").value;
        if(!date || !doctorId) return;

        fetch(`${contextPath}/consultations?action=availableTimes&doctorId=${doctorId}&date=${date}`)
            .then(res => res.json())
            .then(times => {
                const timeSelect = document.getElementById("consultationTime");
                timeSelect.innerHTML = '<option value="">Select Time</option>';
                times.forEach(t => {
                    const option = document.createElement("option");
                    option.value = t;
                    option.textContent = t;
                    timeSelect.appendChild(option);
                });
            });
    });

    document.getElementById("consultationTime").addEventListener("change", function() {
        const date = document.getElementById("consultationDate").value;
        const time = this.value;
        if(!date || !time) return;

        fetch(`${contextPath}/consultations?action=availableRooms&date=${date}&time=${time}`)
            .then(res => res.json())
            .then(rooms => {
                const roomSelect = document.getElementById("roomId");
                roomSelect.innerHTML = '<option value="">Select Room</option>';
                rooms.forEach(r => {
                    const option = document.createElement("option");
                    option.value = r.id;
                    option.textContent = r.name;
                    roomSelect.appendChild(option);
                });
            });
    });
</script>
</body>
</html>
