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
<jsp:include page="../components/adminSidebar.jsp" />
    <div class="sidebar-section">Main Menu</div>

</div>

<!-- Main Content Area -->
<%--<main class="main-content">--%>
<%--    <h2>Welcome to Admin Dashboard</h2>--%>
<%--    <p>Here you can manage Patients, consultations</p>--%>
<%--</main>--%>

<!-- Footer -->
<jsp:include page="../components/footer.jsp" />

</body>
</html>
