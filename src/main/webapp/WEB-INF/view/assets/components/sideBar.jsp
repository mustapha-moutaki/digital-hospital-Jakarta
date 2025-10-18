
<%--    <%@ page import="org.mustapha.digitalhospitaljee.model.Person" %>--%>
<%--    <%@ page import="jakarta.servlet.http.HttpSession" %>--%>
<%--    <%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>--%>
<%--    <%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>--%>
<%--    <%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>--%>
<%--    <%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>--%>
<%--    <%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>--%>
<%--    <%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>--%>
<%--    <%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--    <!-- Bootstrap CSS -->--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <!-- Font Awesome -->--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">--%>

<%--    <style>--%>
<%--        .sidebar {--%>
<%--            position: fixed;--%>
<%--            left: 0;--%>
<%--            top: 0;--%>
<%--            width: 260px;--%>
<%--            height: 100vh;--%>
<%--            background: linear-gradient(180deg, #1e3c72 0%, #2a5298 100%);--%>
<%--            box-shadow: 2px 0 15px rgba(0,0,0,0.2);--%>
<%--            z-index: 1000;--%>
<%--            overflow-y: auto;--%>
<%--        }--%>

<%--        .sidebar::-webkit-scrollbar {--%>
<%--            width: 6px;--%>
<%--        }--%>

<%--        .sidebar::-webkit-scrollbar-thumb {--%>
<%--            background: rgba(255,255,255,0.3);--%>
<%--            border-radius: 10px;--%>
<%--        }--%>

<%--        .main-content {--%>
<%--            margin-left: 260px;--%>
<%--            padding: 20px;--%>
<%--        }--%>

<%--        @media (max-width: 768px) {--%>
<%--            .sidebar {--%>
<%--                width: 70px;--%>
<%--            }--%>
<%--            .sidebar .sidebar-text {--%>
<%--                display: none;--%>
<%--            }--%>
<%--            .main-content {--%>
<%--                margin-left: 70px;--%>
<%--            }--%>
<%--        }--%>
<%--    </style>--%>

<%--    <%--%>
<%--        // Get session--%>
<%--        HttpSession session1 = request.getSession(false);--%>
<%--        String role = null;--%>
<%--        Long userId = null;--%>

<%--        if(session1 != null) {--%>
<%--            userId = (Long) session1.getAttribute("currentUserId");--%>
<%--            role = (String) session1.getAttribute("role");--%>
<%--        }--%>

<%--        if(userId != null) {--%>
<%--            AdminRepositoryImpl adminRepo = new AdminRepositoryImpl();--%>
<%--            Admin admin = adminRepo.finfById(userId);--%>
<%--            if(admin != null) {--%>
<%--                role = admin.getRole();--%>
<%--            } else {--%>
<%--                DoctorRepositoryImpl doctorRepo = new DoctorRepositoryImpl();--%>
<%--                Doctor doctor = doctorRepo.findById(userId);--%>
<%--                if(doctor != null) {--%>
<%--                    role = doctor.getRole();--%>
<%--                } else {--%>
<%--                    PatientRepositoryImpl patientRepo = new PatientRepositoryImpl();--%>
<%--                    Patient patient = patientRepo.findById(userId);--%>
<%--                    if(patient != null) role = patient.getRole();--%>
<%--                }--%>
<%--            }--%>
<%--            session1.setAttribute("role", role);--%>
<%--        }--%>
<%--    %>--%>

<%--    <aside class="sidebar d-flex flex-column">--%>
<%--        <!-- Sidebar Header -->--%>
<%--        <div class="text-center py-4 border-bottom border-white border-opacity-10">--%>
<%--            <h4 class="text-white fw-bold mb-1">Dashboard</h4>--%>
<%--            <p class="text-white-50 mb-0 small">Digital Hospital</p>--%>
<%--        </div>--%>

<%--        <!-- Sidebar Navigation -->--%>
<%--        <nav class="flex-grow-1 py-3">--%>
<%--            <% if("Admin".equalsIgnoreCase(role)){ %>--%>
<%--            <ul class="nav flex-column">--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="dashboard" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-home me-3"></i>--%>
<%--                        <span class="sidebar-text">Dashboard</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="${pageContext.request.contextPath}/doctor/manage?action=list"--%>
<%--                       class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-user-md me-3"></i>--%>
<%--                        <span class="sidebar-text">Doctors</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="${pageContext.request.contextPath}/patient/list?action=list"--%>
<%--                       class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-users me-3"></i>--%>
<%--                        <span class="sidebar-text">Patients</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="${pageContext.request.contextPath}/department?action=list"--%>
<%--                       class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-building me-3"></i>--%>
<%--                        <span class="sidebar-text">Departments</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="rooms" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-bed me-3"></i>--%>
<%--                        <span class="sidebar-text">Rooms</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="${pageContext.request.contextPath}/consultation?action=allList"--%>
<%--                       class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-stethoscope me-3"></i>--%>
<%--                        <span class="sidebar-text">Consultations</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="appointments" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-calendar me-3"></i>--%>
<%--                        <span class="sidebar-text">Appointments</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>

<%--            <% } else if("Doctor".equalsIgnoreCase(role)) { %>--%>
<%--            <ul class="nav flex-column">--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="${pageContext.request.contextPath}/patient/list?action=list"--%>
<%--                       class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-users me-3"></i>--%>
<%--                        <span class="sidebar-text">Patients</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="departments" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-building me-3"></i>--%>
<%--                        <span class="sidebar-text">My Department</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="consultations" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-stethoscope me-3"></i>--%>
<%--                        <span class="sidebar-text">Consultations</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="consultations" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-user-circle me-3"></i>--%>
<%--                        <span class="sidebar-text">My Info</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>

<%--            <% } else if("Patient".equalsIgnoreCase(role)) { %>--%>
<%--            <ul class="nav flex-column">--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="consultations" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-user-circle me-3"></i>--%>
<%--                        <span class="sidebar-text">My Info</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="consultations" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-calendar-plus me-3"></i>--%>
<%--                        <span class="sidebar-text">Make Appointment</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="consultations" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-list me-3"></i>--%>
<%--                        <span class="sidebar-text">My Appointments</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="consultations" class="nav-link text-white d-flex align-items-center py-3 px-4">--%>
<%--                        <i class="fas fa-history me-3"></i>--%>
<%--                        <span class="sidebar-text">History</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>

<%--            <% } else { %>--%>
<%--            <div class="text-center text-white-50 py-3">--%>
<%--                <p class="mb-0">No data available</p>--%>
<%--            </div>--%>
<%--            <% } %>--%>
<%--        </nav>--%>

<%--        <!-- Sidebar Footer -->--%>
<%--        <div class="border-top border-white border-opacity-10 p-3">--%>
<%--            <a href="<%= request.getContextPath() %>/logout"--%>
<%--               class="btn btn-danger w-100 d-flex align-items-center justify-content-center">--%>
<%--                <i class="fas fa-sign-out-alt me-2"></i>--%>
<%--                <span class="sidebar-text">Logout</span>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--    </aside>--%>

<%--    <!-- Bootstrap JS -->--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>--%>

<%--    <script>--%>
<%--        // Active link highlighting--%>
<%--        document.addEventListener('DOMContentLoaded', function() {--%>
<%--            const currentPath = window.location.pathname;--%>
<%--            const links = document.querySelectorAll('.sidebar .nav-link');--%>

<%--            links.forEach(link => {--%>
<%--                if(link.getAttribute('href') && currentPath.includes(link.getAttribute('href'))) {--%>
<%--                    link.classList.add('active', 'bg-white', 'bg-opacity-25');--%>
<%--                }--%>

<%--                // Hover effect--%>
<%--                link.addEventListener('mouseenter', function() {--%>
<%--                    if(!this.classList.contains('active')) {--%>
<%--                        this.classList.add('bg-white', 'bg-opacity-10');--%>
<%--                    }--%>
<%--                });--%>

<%--                link.addEventListener('mouseleave', function() {--%>
<%--                    if(!this.classList.contains('active')) {--%>
<%--                        this.classList.remove('bg-white', 'bg-opacity-10');--%>
<%--                    }--%>
<%--                });--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

<%@ page import="org.mustapha.digitalhospitaljee.model.Person" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">

<style>
    :root {
        --sidebar-width: 280px;
        --sidebar-collapsed-width: 80px;
        --sidebar-bg: linear-gradient(180deg, #1e3c72 0%, #2a5298 100%);
    }

    .sidebar {
        position: fixed;
        left: 0;
        top: 0;
        width: var(--sidebar-width);
        height: 100vh;
        background: var(--sidebar-bg);
        box-shadow: 2px 0 20px rgba(0,0,0,0.1);
        z-index: 1000;
        transition: all 0.3s ease;
        overflow-x: hidden;
        overflow-y: auto;
    }

    .sidebar::-webkit-scrollbar {
        width: 6px;
    }

    .sidebar::-webkit-scrollbar-track {
        background: rgba(255,255,255,0.1);
    }

    .sidebar::-webkit-scrollbar-thumb {
        background: rgba(255,255,255,0.3);
        border-radius: 10px;
    }

    .sidebar::-webkit-scrollbar-thumb:hover {
        background: rgba(255,255,255,0.5);
    }

    /* Sidebar Header */
    .sidebar-header {
        padding: 1.5rem 1rem;
        border-bottom: 1px solid rgba(255,255,255,0.1);
        background: rgba(0,0,0,0.1);
    }

    .sidebar-brand {
        display: flex;
        align-items: center;
        justify-content: center;
        text-decoration: none;
        color: white;
        transition: all 0.3s;
    }

    .sidebar-brand:hover {
        transform: scale(1.05);
    }

    .brand-icon {
        font-size: 2rem;
        margin-right: 0.75rem;
        color: #4facfe;
    }

    .brand-text h4 {
        margin: 0;
        font-size: 1.25rem;
        font-weight: 700;
        color: white;
    }

    .brand-text p {
        margin: 0;
        font-size: 0.75rem;
        color: rgba(255,255,255,0.7);
    }

    /* Sidebar Navigation */
    .sidebar-nav {
        padding: 1rem 0;
    }

    .nav-section-title {
        padding: 1rem 1.5rem 0.5rem;
        font-size: 0.75rem;
        font-weight: 600;
        text-transform: uppercase;
        color: rgba(255,255,255,0.5);
        letter-spacing: 1px;
    }

    .sidebar-nav .nav-link {
        display: flex;
        align-items: center;
        padding: 0.875rem 1.5rem;
        color: rgba(255,255,255,0.8);
        text-decoration: none;
        transition: all 0.3s;
        position: relative;
        margin: 0.25rem 0.75rem;
        border-radius: 10px;
    }

    .sidebar-nav .nav-link:hover {
        background: rgba(255,255,255,0.1);
        color: white;
        transform: translateX(5px);
    }

    .sidebar-nav .nav-link.active {
        background: rgba(255,255,255,0.15);
        color: white;
        font-weight: 600;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    .sidebar-nav .nav-link.active::before {
        content: '';
        position: absolute;
        left: 0;
        top: 50%;
        transform: translateY(-50%);
        width: 4px;
        height: 60%;
        background: #4facfe;
        border-radius: 0 4px 4px 0;
    }

    .nav-icon {
        font-size: 1.25rem;
        margin-right: 1rem;
        width: 24px;
        text-align: center;
    }

    .nav-text {
        flex: 1;
        white-space: nowrap;
    }

    .nav-badge {
        padding: 0.25rem 0.5rem;
        font-size: 0.7rem;
        border-radius: 10px;
        background: rgba(255,255,255,0.2);
    }

    /* Sidebar Footer */
    .sidebar-footer {
        position: absolute;
        bottom: 0;
        width: 100%;
        padding: 1rem;
        border-top: 1px solid rgba(255,255,255,0.1);
        background: rgba(0,0,0,0.1);
    }

    .logout-btn {
        width: 100%;
        padding: 0.875rem;
        background: linear-gradient(135deg, #f5576c 0%, #f093fb 100%);
        border: none;
        border-radius: 10px;
        color: white;
        font-weight: 600;
        transition: all 0.3s;
        display: flex;
        align-items: center;
        justify-content: center;
        text-decoration: none;
    }

    .logout-btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 5px 15px rgba(245, 87, 108, 0.4);
        color: white;
    }

    /* Toggle Button */
    .sidebar-toggle {
        position: absolute;
        top: 1rem;
        right: -15px;
        width: 30px;
        height: 30px;
        background: white;
        border: none;
        border-radius: 50%;
        box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        transition: all 0.3s;
        z-index: 1001;
    }

    .sidebar-toggle:hover {
        transform: scale(1.1);
    }

    /* Collapsed Sidebar */
    .sidebar.collapsed {
        width: var(--sidebar-collapsed-width);
    }

    .sidebar.collapsed .brand-text,
    .sidebar.collapsed .nav-text,
    .sidebar.collapsed .nav-section-title,
    .sidebar.collapsed .nav-badge {
        display: none;
    }

    .sidebar.collapsed .brand-icon {
        margin: 0;
    }

    .sidebar.collapsed .nav-icon {
        margin: 0;
    }

    .sidebar.collapsed .sidebar-nav .nav-link {
        justify-content: center;
    }

    .sidebar.collapsed .logout-btn {
        padding: 0.875rem 0.5rem;
    }

    /* Main Content Adjustment */
    .main-content {
        margin-left: var(--sidebar-width);
        transition: margin-left 0.3s ease;
    }

    .main-content.expanded {
        margin-left: var(--sidebar-collapsed-width);
    }

    /* Responsive */
    @media (max-width: 768px) {
        .sidebar {
            transform: translateX(-100%);
        }

        .sidebar.show {
            transform: translateX(0);
        }

        .main-content {
            margin-left: 0 !important;
        }

        .sidebar-toggle {
            display: none;
        }

        .mobile-toggle {
            display: block;
        }
    }

    @media (min-width: 769px) {
        .mobile-toggle {
            display: none;
        }
    }
</style>

<%
    // Get session and user info
    HttpSession session1 = request.getSession(false);
    String role = null;
    Long userId = null;

    if(session1 != null) {
        userId = (Long) session1.getAttribute("currentUserId");
        role = (String) session1.getAttribute("role");
    }

    if(userId != null) {
        AdminRepositoryImpl adminRepo = new AdminRepositoryImpl();
        Admin admin = adminRepo.finfById(userId);
        if(admin != null) {
            role = admin.getRole();
        } else {
            DoctorRepositoryImpl doctorRepo = new DoctorRepositoryImpl();
            Doctor doctor = doctorRepo.findById(userId);
            if(doctor != null) {
                role = doctor.getRole();
            } else {
                PatientRepositoryImpl patientRepo = new PatientRepositoryImpl();
                Patient patient = patientRepo.findById(userId);
                if(patient != null) role = patient.getRole();
            }
        }
        session1.setAttribute("role", role);
    }
%>

<!-- Sidebar -->
<aside class="sidebar" id="sidebar">
    <!-- Toggle Button -->
    <button class="sidebar-toggle" id="sidebarToggle" onclick="toggleSidebar()">
        <i class="bi bi-chevron-left" id="toggleIcon"></i>
    </button>

    <!-- Sidebar Header -->
    <div class="sidebar-header">
        <a href="<%= request.getContextPath() %>/dashboard" class="sidebar-brand">
            <i class="bi bi-hospital brand-icon"></i>
            <div class="brand-text">
                <h4>Digital Hospital</h4>
                <p>Healthcare Management</p>
            </div>
        </a>
    </div>

    <!-- Sidebar Navigation -->
    <nav class="sidebar-nav">
        <% if("Admin".equalsIgnoreCase(role)){ %>
        <div class="nav-section-title">Main Menu</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/dashboard" class="nav-link">
                    <i class="bi bi-speedometer2 nav-icon"></i>
                    <span class="nav-text">Dashboard</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/doctor/manage?action=list" class="nav-link">
                    <i class="bi bi-person-badge nav-icon"></i>
                    <span class="nav-text">Doctors</span>
                    <span class="nav-badge">45</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/patient/list?action=list" class="nav-link">
                    <i class="bi bi-people nav-icon"></i>
                    <span class="nav-text">Patients</span>
                    <span class="nav-badge">1.2k</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/consultations?action=list" class="nav-link">Consultations List</a>
                <i class="bi bi-building nav-icon"></i>
                    <span class="nav-text">Departments</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/rooms" class="nav-link">
                    <i class="bi bi-door-open nav-icon"></i>
                    <span class="nav-text">Rooms</span>
                </a>
            </li>
        </ul>

        <div class="nav-section-title">Management</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/consultation?action=allList" class="nav-link">
                    <i class="bi bi-clipboard2-pulse nav-icon"></i>
                    <span class="nav-text">Consultations</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/appointments" class="nav-link">
                    <i class="bi bi-calendar-check nav-icon"></i>
                    <span class="nav-text">Appointments</span>
                    <span class="nav-badge">28</span>
                </a>
            </li>
        </ul>

        <div class="nav-section-title">Reports</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/reports" class="nav-link">
                    <i class="bi bi-graph-up nav-icon"></i>
                    <span class="nav-text">Analytics</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/settings" class="nav-link">
                    <i class="bi bi-gear nav-icon"></i>
                    <span class="nav-text">Settings</span>
                </a>
            </li>
        </ul>

        <% } else if("Doctor".equalsIgnoreCase(role)) { %>
        <div class="nav-section-title">My Workspace</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/dashboard" class="nav-link">
                    <i class="bi bi-speedometer2 nav-icon"></i>
                    <span class="nav-text">Dashboard</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/patient/list?action=list" class="nav-link">
                    <i class="bi bi-people nav-icon"></i>
                    <span class="nav-text">My Patients</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/consultations" class="nav-link">
                    <i class="bi bi-clipboard2-pulse nav-icon"></i>
                    <span class="nav-text">Consultations</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/appointments" class="nav-link">
                    <i class="bi bi-calendar-check nav-icon"></i>
                    <span class="nav-text">Appointments</span>
                    <span class="nav-badge">15</span>
                </a>
            </li>
        </ul>

        <div class="nav-section-title">Information</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/departments" class="nav-link">
                    <i class="bi bi-building nav-icon"></i>
                    <span class="nav-text">My Department</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/profile" class="nav-link">
                    <i class="bi bi-person-circle nav-icon"></i>
                    <span class="nav-text">My Profile</span>
                </a>
            </li>
        </ul>

        <% } else if("Patient".equalsIgnoreCase(role)) { %>
        <div class="nav-section-title">My Health</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/dashboard" class="nav-link">
                    <i class="bi bi-speedometer2 nav-icon"></i>
                    <span class="nav-text">Dashboard</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/profile" class="nav-link">
                    <i class="bi bi-person-circle nav-icon"></i>
                    <span class="nav-text">My Profile</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/appointments/book" class="nav-link">
                    <i class="bi bi-calendar-plus nav-icon"></i>
                    <span class="nav-text">Book Appointment</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/appointments/my" class="nav-link">
                    <i class="bi bi-calendar-check nav-icon"></i>
                    <span class="nav-text">My Appointments</span>
                    <span class="nav-badge">3</span>
                </a>
            </li>
        </ul>

        <div class="nav-section-title">Medical Records</div>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/consultations/history" class="nav-link">
                    <i class="bi bi-clock-history nav-icon"></i>
                    <span class="nav-text">History</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="<%= request.getContextPath() %>/prescriptions" class="nav-link">
                    <i class="bi bi-file-medical nav-icon"></i>
                    <span class="nav-text">Prescriptions</span>
                </a>
            </li>
        </ul>

        <% } else { %>
        <div class="text-center text-white-50 py-5">
            <i class="bi bi-exclamation-circle fs-1 mb-3"></i>
            <p class="mb-0">No menu available</p>
        </div>
        <% } %>
    </nav>

    <!-- Sidebar Footer -->
    <div class="sidebar-footer">
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">
            <i class="bi bi-box-arrow-right me-2"></i>
            <span class="nav-text">Logout</span>
        </a>
    </div>
</aside>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
    // Sidebar toggle functionality
    function toggleSidebar() {
        const sidebar = document.getElementById('sidebar');
        const mainContent = document.querySelector('.main-content');
        const toggleIcon = document.getElementById('toggleIcon');

        sidebar.classList.toggle('collapsed');
        if(mainContent) {
            mainContent.classList.toggle('expanded');
        }

        // Toggle icon
        if(sidebar.classList.contains('collapsed')) {
            toggleIcon.className = 'bi bi-chevron-right';
        } else {
            toggleIcon.className = 'bi bi-chevron-left';
        }

        // Save state to localStorage
        localStorage.setItem('sidebarCollapsed', sidebar.classList.contains('collapsed'));
    }

    // Restore sidebar state on page load
    document.addEventListener('DOMContentLoaded', function() {
        const sidebar = document.getElementById('sidebar');
        const mainContent = document.querySelector('.main-content');
        const toggleIcon = document.getElementById('toggleIcon');
        const isCollapsed = localStorage.getItem('sidebarCollapsed') === 'true';

        if(isCollapsed) {
            sidebar.classList.add('collapsed');
            if(mainContent) {
                mainContent.classList.add('expanded');
            }
            toggleIcon.className = 'bi bi-chevron-right';
        }

        // Active link highlighting
        highlightActiveLink();
    });

    // Highlight active link based on current URL
    function highlightActiveLink() {
        const currentPath = window.location.pathname;
        const links = document.querySelectorAll('.sidebar-nav .nav-link');

        links.forEach(link => {
            const href = link.getAttribute('href');
            if(href && currentPath.includes(href) && href !== '#') {
                link.classList.add('active');
            }
        });
    }

    // Mobile sidebar toggle
    function toggleMobileSidebar() {
        const sidebar = document.getElementById('sidebar');
        sidebar.classList.toggle('show');
    }
</script>