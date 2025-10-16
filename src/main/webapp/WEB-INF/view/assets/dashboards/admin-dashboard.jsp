<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Digital Clinic</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f5f6fa;
            height: 100vh;
        }

        /* Main Content Styles */
        .main-content {
            margin-left: 250px;
            margin-top: 75px;
            padding: 30px;
            min-height: calc(100vh - 195px);
        }

        /* Sidebar Styles */
        .sidebar {
            width: 250px;
            height: 90vh;
            background: linear-gradient(180deg, #2c3e50 0%, #34495e 100%);
            position: fixed;
            left: 0;
            top: 0;
            color: white;
            padding: 20px 0;
            margin-top: 40px;
        }

        .sidebar-section {
            padding: 15px 20px;
            color: #95a5a6;
            font-size: 0.85rem;
            font-weight: bold;
            text-transform: uppercase;
        }

        .sidebar-menu {
            list-style: none;
            padding: 0;
            margin: 0 10px;
        }

        .sidebar-menu li {
            margin: 5px 0;
        }

        .sidebar-menu a {
            display: block;
            padding: 12px 15px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s;
        }

        .sidebar-menu a:hover {
            background: rgba(255,255,255,0.1);
        }

        .sidebar-footer {
            position: absolute;
            bottom: 20px;
            width: 100%;
            padding: 0 20px;
        }

        .sidebar-footer a {
            display: block;
            padding: 12px;
            background: #e74c3c;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .main-content {
                margin-left: 0;
                margin-top: 120px;
            }
        }
    </style>
</head>
<body>

<!-- Header -->
<jsp:include page="../components/header.jsp" />

<!-- Sidebar -->
<div class="sidebar">
<jsp:include page="../components/sideBar.jsp" />
    <div class="sidebar-section">Main Menu</div>

</div>

<!-- Main Content Area -->
<%
    Long userId = (Long) session.getAttribute("userId");
    String role = (String) session.getAttribute("role");

    if(userId != null && role != null) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");

        if(role.equalsIgnoreCase("admin")) {
            AdminRepositoryImpl repo = new AdminRepositoryImpl();
            Admin admin = repo.finfById(userId);
            role = (admin != null) ? admin.getRole() : null;
        } else if(role.equalsIgnoreCase("doctor")) {
            DoctorRepositoryImpl repo = new DoctorRepositoryImpl();
            Doctor doctor = repo.findById(userId);
            role = (doctor != null) ? doctor.getRole() : null;
        } else if(role.equalsIgnoreCase("patient")) {
            PatientRepositoryImpl repo = new PatientRepositoryImpl();
            Patient patient = repo.findById(userId);
            role = (patient != null) ? patient.getRole() : null;
        }

        emf.close();
    }
%>


<main class="main-content">
    <% if(role.equalsIgnoreCase("admin")) { %>
    <p>welcome in admin dashabord</p>
    <% } else if(role.equalsIgnoreCase("doctor")) {%>
    <p>welcome in doctor dashabord</p>
    <% } else if(role.equalsIgnoreCase("patient")){%>
    <p>welcome in patient dashabord</p>
    <% }%>
</main>

<!-- Footer -->
<jsp:include page="../components/footer.jsp" />

</body>
</html>
