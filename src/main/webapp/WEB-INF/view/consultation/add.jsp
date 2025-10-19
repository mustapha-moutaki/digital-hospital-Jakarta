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

<jsp:include page="../assets/components/header.jsp" />
<jsp:include page="../assets/components/sideBar.jsp" />

<div style="margin-left:250px; margin-top:75px; padding:30px;">
    <div class="container py-5">
        <div class="card shadow-sm p-4">
            <h3 class="mb-4 text-primary">Add New Consultation</h3>

            <form action="${pageContext.request.contextPath}/consultations" method="post">
                <input type="hidden" name="action" value="createConsultation"/>

                <div class="mb-3">
                    <label class="form-label">Patient</label>
                    <select class="form-select" name="patientId" required>
                        <option value="" disabled selected>Select Patient</option>
                        <c:forEach var="p" items="${patients}">
                            <option value="${p.id}">${p.firstName} ${p.lastname}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Doctor</label>
                    <select class="form-select" name="doctorId" id="doctorId" required>
                        <option value="" disabled selected>Select Doctor</option>
                        <c:forEach var="d" items="${doctors}">
                            <option value="${d.id}" data-department="${d.department.id}">
                                    ${d.firstName} ${d.lastname}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Date</label>
                    <input type="date" name="consultationDate" class="form-control"
                           required min="<%= java.time.LocalDate.now() %>">
                </div>

                <div class="mb-3">
                    <label class="form-label">Time</label>
                    <select class="form-select" name="startTime" required>
                        <option value="" disabled selected>Select Time</option>
                        <c:forEach var="t" items="${times}">
                            <option value="${t}">${t}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Room</label>
                    <select class="form-select" name="roomId" id="roomId" required>
                        <option value="" disabled selected>Select Room</option>
                        <c:forEach var="room" items="${rooms}">
                            <option value="${room.id}" data-department="${room.department != null ? room.department.id : 0}">
                                    ${room.name} -
                                <c:out value="${room.department != null ? room.department.name : 'No Department'}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="d-flex gap-2">
                    <button type="submit" class="btn btn-primary">Save Consultation</button>
                    <a href="${pageContext.request.contextPath}/consultations?action=list" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../assets/components/footer.jsp" />

<script>
    const doctorSelect = document.getElementById('doctorId');
    const roomSelect = document.getElementById('roomId');

    doctorSelect.addEventListener('change', () => {
        const selectedDept = doctorSelect.selectedOptions[0]?.dataset.department;
        Array.from(roomSelect.options).forEach(opt => {
            if (!opt.value) return;
            opt.hidden = opt.dataset.department !== selectedDept;
        });
        roomSelect.value = "";
    });
</script>

</body>
</html>
