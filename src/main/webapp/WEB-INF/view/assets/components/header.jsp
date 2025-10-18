<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Person" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>--%>
<%--<%@ page import="jakarta.persistence.EntityManagerFactory" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>--%>
<%--<%@ page import="jakarta.persistence.Persistence" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<style>--%>
<%--    /* Header Styles */--%>
<%--    .header {--%>
<%--        display: flex;--%>
<%--        align-items: center;--%>
<%--        justify-content: space-between;--%>
<%--        background: linear-gradient(135deg, #2c3e50 0%, #34495e 100%);--%>
<%--        color: white;--%>
<%--        padding: 15px 30px;--%>
<%--        box-shadow: 0 2px 10px rgba(0,0,0,0.1);--%>
<%--        position: fixed;--%>
<%--        top: 0;--%>
<%--        left: 0;--%>
<%--        right: 0;--%>
<%--        z-index: 1000;--%>
<%--    }--%>

<%--    .header-left {--%>
<%--        display: flex;--%>
<%--        align-items: center;--%>
<%--        gap: 15px;--%>
<%--    }--%>

<%--    .header .logo-container {--%>
<%--        display: flex;--%>
<%--        align-items: center;--%>
<%--        gap: 12px;--%>
<%--    }--%>

<%--    .header img {--%>
<%--        height: 45px;--%>
<%--        width: 45px;--%>
<%--        border-radius: 8px;--%>
<%--        box-shadow: 0 2px 8px rgba(0,0,0,0.2);--%>
<%--    }--%>

<%--    .header .logo-text {--%>
<%--        font-size: 1.8rem;--%>
<%--        font-weight: bold;--%>
<%--        letter-spacing: 0.5px;--%>
<%--    }--%>

<%--    .user-info {--%>
<%--        display: flex;--%>
<%--        align-items: center;--%>
<%--        gap: 10px;--%>
<%--        padding: 8px 15px;--%>
<%--        background-color: rgba(255,255,255,0.1);--%>
<%--        border-radius: 20px;--%>
<%--    }--%>

<%--    .user-info span {--%>
<%--        font-size: 0.9rem;--%>
<%--    }--%>

<%--    @media (max-width: 768px) {--%>
<%--        .header {--%>
<%--            flex-direction: column;--%>
<%--            gap: 15px;--%>
<%--            padding: 15px;--%>
<%--        }--%>
<%--    }--%>
<%--</style>--%>

<%--<header class="header">--%>
<%--    <%--%>
<%--        Long userId = (Long) session.getAttribute("userId");--%>
<%--        String role = (String) session.getAttribute("role");--%>

<%--        if(userId != null && role != null) {--%>
<%--            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");--%>

<%--            if(role.equalsIgnoreCase("admin")) {--%>
<%--                AdminRepositoryImpl repo = new AdminRepositoryImpl();--%>
<%--                Admin admin = repo.finfById(userId);--%>
<%--                role = (admin != null) ? admin.getRole() : null;--%>
<%--            } else if(role.equalsIgnoreCase("doctor")) {--%>
<%--                DoctorRepositoryImpl repo = new DoctorRepositoryImpl();--%>
<%--                Doctor doctor = repo.findById(userId);--%>
<%--                role = (doctor != null) ? doctor.getRole() : null;--%>
<%--            } else if(role.equalsIgnoreCase("patient")) {--%>
<%--                PatientRepositoryImpl repo = new PatientRepositoryImpl();--%>
<%--                Patient patient = repo.findById(userId);--%>
<%--                role = (patient != null) ? patient.getRole() : null;--%>
<%--            }--%>

<%--            emf.close();--%>
<%--        }--%>
<%--    %>--%>

<%--    <div class="header-left">--%>
<%--        <div class="logo-container">--%>
<%--            <div class="logo-text">Digital Clinic</div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="user-info">--%>
<%--&lt;%&ndash;        <% if(user != null ){ %>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <span>Mr. <%= user.getFirstName() + " " + user.getLastname()%> </span>&ndash;%&gt;--%>
<%--   <%String currentUserFirstName = (String) session.getAttribute("currentUserFirstName"); %>--%>
<%--        <span>Mr. <%= currentUserFirstName%></span>--%>
<%--&lt;%&ndash;        <% } %>&ndash;%&gt;--%>
<%--    </div>--%>
<%--</header>--%>

<%@ page import="org.mustapha.digitalhospitaljee.model.Person" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>
<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
    .header {
        position: fixed;
        top: 0;
        height: 100px;
        width: 100%;
        z-index: -1;
        background: #1c3869;
        box-shadow: 0 2px 15px rgba(0,0,0,0.2);
    }

    .header-content {
        margin-left: 260px;
    }

    @media (max-width: 768px) {
        .header-content {
            margin-left: 70px;
        }
    }
</style>

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
            role = (role != null) ? patient.getRole() : null;
        }

        emf.close();
    }

    String currentUserFirstName = (String) session.getAttribute("currentUserFirstName");
%>

<header class="header">
    <nav class="navbar navbar-dark header-content">
        <div class="container-fluid px-4">
            <!-- User Info & Actions -->
            <div class="d-flex align-items-center gap-3">
                <!-- Notifications -->
                <div class="dropdown">
                    <button class="btn btn-link text-white position-relative" type="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-bell fs-5"></i>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            3
                            <span class="visually-hidden">unread notifications</span>
                        </span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end shadow">
                        <li><h6 class="dropdown-header">Notifications</h6></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-user-plus me-2 text-info"></i> New patient registered</a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-calendar-check me-2 text-success"></i> Appointment confirmed</a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-file-medical me-2 text-warning"></i> New consultation request</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item text-center text-primary" href="#">View all</a></li>
                    </ul>
                </div>

                <!-- User Profile Dropdown -->
                <div class="dropdown">
                    <button class="btn btn-outline-light rounded-pill d-flex align-items-center gap-2 px-3"
                            type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-user-circle fs-5"></i>
                        <span class="d-none d-md-inline">
                            <%= currentUserFirstName != null ? currentUserFirstName : "User" %>
                        </span>
                        <i class="fas fa-chevron-down small"></i>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end shadow">
                        <li>
                            <div class="dropdown-header">
                                <div class="fw-bold"><%= currentUserFirstName != null ? currentUserFirstName : "User" %></div>
                                <small class="text-muted">
                                    <i class="fas fa-circle text-success" style="font-size: 0.5rem;"></i>
                                    <%= role != null ? role : "Guest" %>
                                </small>
                            </div>
                        </li>
                        <li><hr class="dropdown-divider"></li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user me-2"></i> My Profile
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cog me-2"></i> Settings
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-question-circle me-2"></i> Help
                            </a>
                        </li>
                        <li><hr class="dropdown-divider"></li>
                        <li>
                            <a class="dropdown-item text-danger" href="<%= request.getContextPath() %>/logout">
                                <i class="fas fa-sign-out-alt me-2"></i> Logout
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>

<!-- Add spacing for fixed header -->
<div style="height: 70px;"></div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>