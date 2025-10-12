<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/header.jsp" %>


<div class="container">
    <h1>Welcome to Admin Dashboard</h1>

    <div class="cards">
        <div class="card">
            <h2>Manage Doctors</h2>
            <a href="<%= request.getContextPath() %>/doctors?action=list">Go</a>
        </div>

        <div class="card">
            <h2>Manage Patients</h2>
            <a href="<%= request.getContextPath() %>/patients?action=list">Go</a>
        </div>

        <div class="card">
            <h2>Manage Departments</h2>
            <a href="<%= request.getContextPath() %>/departments?action=list">Go</a>
        </div>

        <div class="card">
            <h2>Manage Rooms</h2>
            <a href="<%= request.getContextPath() %>/rooms?action=list">Go</a>
        </div>
    </div>
</div>

<%@ include file="../assets/components/footer.jsp" %>
