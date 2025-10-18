<%--<%@ page import="jakarta.persistence.EntityManagerFactory" %>--%>
<%--<%@ page import="jakarta.persistence.Persistence" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>--%>
<%--<%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Digital Clinic</title>--%>
<%--    <style>--%>
<%--        * {--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>

<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f5f6fa;--%>
<%--            height: 100vh;--%>
<%--        }--%>

<%--        /* Main Content Styles */--%>
<%--        .main-content {--%>
<%--            margin-left: 250px;--%>
<%--            margin-top: 75px;--%>
<%--            padding: 30px;--%>
<%--            min-height: calc(100vh - 195px);--%>
<%--        }--%>

<%--        /* Sidebar Styles */--%>
<%--        .sidebar {--%>
<%--            width: 250px;--%>
<%--            height: 90vh;--%>
<%--            background: linear-gradient(180deg, #2c3e50 0%, #34495e 100%);--%>
<%--            position: fixed;--%>
<%--            left: 0;--%>
<%--            top: 0;--%>
<%--            color: white;--%>
<%--            padding: 20px 0;--%>
<%--            margin-top: 40px;--%>
<%--        }--%>

<%--        .sidebar-section {--%>
<%--            padding: 15px 20px;--%>
<%--            color: #95a5a6;--%>
<%--            font-size: 0.85rem;--%>
<%--            font-weight: bold;--%>
<%--            text-transform: uppercase;--%>
<%--        }--%>

<%--        .sidebar-menu {--%>
<%--            list-style: none;--%>
<%--            padding: 0;--%>
<%--            margin: 0 10px;--%>
<%--        }--%>

<%--        .sidebar-menu li {--%>
<%--            margin: 5px 0;--%>
<%--        }--%>

<%--        .sidebar-menu a {--%>
<%--            display: block;--%>
<%--            padding: 12px 15px;--%>
<%--            color: white;--%>
<%--            text-decoration: none;--%>
<%--            border-radius: 5px;--%>
<%--            transition: background 0.3s;--%>
<%--        }--%>

<%--        .sidebar-menu a:hover {--%>
<%--            background: rgba(255,255,255,0.1);--%>
<%--        }--%>

<%--        .sidebar-footer {--%>
<%--            position: absolute;--%>
<%--            bottom: 20px;--%>
<%--            width: 100%;--%>
<%--            padding: 0 20px;--%>
<%--        }--%>

<%--        .sidebar-footer a {--%>
<%--            display: block;--%>
<%--            padding: 12px;--%>
<%--            background: #e74c3c;--%>
<%--            color: white;--%>
<%--            text-align: center;--%>
<%--            text-decoration: none;--%>
<%--            border-radius: 5px;--%>
<%--        }--%>

<%--        /* Responsive */--%>
<%--        @media (max-width: 768px) {--%>
<%--            .main-content {--%>
<%--                margin-left: 0;--%>
<%--                margin-top: 120px;--%>
<%--            }--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<!-- Header -->--%>
<%--<jsp:include page="../components/header.jsp" />--%>

<%--<!-- Sidebar -->--%>
<%--<div class="sidebar">--%>
<%--<jsp:include page="../components/sideBar.jsp" />--%>
<%--    <div class="sidebar-section">Main Menu</div>--%>

<%--</div>--%>

<%--<!-- Main Content Area -->--%>

<%--<main class="main-content">--%>

<%--    <p>welcome in admin dashabord</p>--%>

<%--</main>--%>

<%--<!-- Footer -->--%>
<%--<jsp:include page="../components/footer.jsp" />--%>

<%--</body>--%>
<%--</html>--%>
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
    <title>${param.pageTitle != null ? param.pageTitle : 'Digital Hospital'}</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        /* Main Layout Container */
        .layout-wrapper {
            display: flex;
            flex: 1;
            padding-top: 70px; /* Height of fixed header */
        }

        /* Content Area */
        .main-content {
            flex: 1;
            margin-left: 260px;
            padding: 30px;
            background-color: #f8f9fa;
            min-height: calc(100vh - 70px);
            transition: margin-left 0.3s ease;
        }

        /* Page Header */
        .page-header {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
            margin-bottom: 25px;
        }

        .page-header h1 {
            font-size: 1.75rem;
            font-weight: 600;
            color: #2c3e50;
            margin-bottom: 5px;
        }

        .page-header .breadcrumb {
            background: transparent;
            padding: 0;
            margin: 0;
            font-size: 0.9rem;
        }

        /* Content Card */
        .content-card {
            background: white;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
            padding: 25px;
            margin-bottom: 20px;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .main-content {
                margin-left: 70px;
                padding: 20px 15px;
            }

            .page-header h1 {
                font-size: 1.5rem;
            }
        }

        @media (max-width: 576px) {
            .main-content {
                margin-left: 0;
                padding: 15px 10px;
            }
        }

        /* Utility Classes */
        .section-title {
            font-size: 1.25rem;
            font-weight: 600;
            color: #2c3e50;
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 2px solid #e9ecef;
        }

        .stat-card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border-radius: 10px;
            padding: 20px;
            color: white;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }

        .stat-card:hover {
            transform: translateY(-5px);
        }

        .stat-card .stat-icon {
            font-size: 2.5rem;
            opacity: 0.8;
        }

        .stat-card .stat-number {
            font-size: 2rem;
            font-weight: 700;
            margin: 10px 0 5px 0;
        }

        .stat-card .stat-label {
            font-size: 0.9rem;
            opacity: 0.9;
        }

        /* Loading Spinner */
        .spinner-overlay {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(255,255,255,0.9);
            display: none;
            justify-content: center;
            align-items: center;
            z-index: 9999;
        }

        .spinner-overlay.active {
            display: flex;
        }
    </style>

    <!-- Custom Page Styles -->
    <% if(request.getAttribute("customStyles") != null) { %>
    <%= request.getAttribute("customStyles") %>
    <% } %>
</head>
<body>

<!-- Include Header -->
<jsp:include page="../components/header.jsp" />

<!-- Include Sidebar -->
<jsp:include page="../components/sideBar.jsp" />

<!-- Layout Wrapper -->
<div class="layout-wrapper">
    <!-- Main Content Area -->
    <main class="main-content">
        <!-- Page Header -->
        <div class="page-header">

        </div>

        <!-- Alert Messages -->
        <% if(request.getAttribute("successMessage") != null) { %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <i class="fas fa-check-circle me-2"></i>
            <%= request.getAttribute("successMessage") %>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <% } %>

        <% if(request.getAttribute("errorMessage") != null) { %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <i class="fas fa-exclamation-triangle me-2"></i>
            <%= request.getAttribute("errorMessage") %>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <% } %>

        <% if(request.getAttribute("infoMessage") != null) { %>
        <div class="alert alert-info alert-dismissible fade show" role="alert">
            <i class="fas fa-info-circle me-2"></i>
            <%= request.getAttribute("infoMessage") %>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <% } %>

        <!-- Main Content Area - This is where page-specific content goes -->
        <jsp:include page="${param.contentPage}" />
    </main>
</div>

<!-- Loading Spinner -->
<div class="spinner-overlay" id="loadingSpinner">
    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
        <span class="visually-hidden">Loading...</span>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- Common JavaScript -->
<script>
    // Auto-hide alerts after 5 seconds
    document.addEventListener('DOMContentLoaded', function() {
        const alerts = document.querySelectorAll('.alert:not(.alert-permanent)');
        alerts.forEach(alert => {
            setTimeout(() => {
                const bsAlert = new bootstrap.Alert(alert);
                bsAlert.close();
            }, 5000);
        });
    });

    // Loading spinner functions
    function showLoading() {
        document.getElementById('loadingSpinner').classList.add('active');
    }

    function hideLoading() {
        document.getElementById('loadingSpinner').classList.remove('active');
    }

    // Confirmation dialog
    function confirmAction(message) {
        return confirm(message || 'Are you sure you want to perform this action?');
    }

    // Form validation
    function validateForm(formId) {
        const form = document.getElementById(formId);
        if (form) {
            return form.checkValidity();
        }
        return false;
    }
</script>

<!-- Custom Page Scripts -->
<% if(request.getAttribute("customScripts") != null) { %>
<%= request.getAttribute("customScripts") %>
<% } %>
</body>
</html>