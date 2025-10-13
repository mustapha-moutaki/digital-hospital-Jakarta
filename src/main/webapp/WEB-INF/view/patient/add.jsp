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
            height: 120vh;
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
            height: calc(100vh - 75px);
            background: linear-gradient(180deg, #2c3e50 0%, #34495e 100%);
            position: fixed;
            left: 0;
            top: 75px;
            color: white;
            padding: 20px 0;
            overflow-y: auto;
            box-shadow: 2px 0 10px rgba(0,0,0,0.1);
        }

        .sidebar::-webkit-scrollbar {
            width: 6px;
        }

        .sidebar::-webkit-scrollbar-track {
            background: rgba(255,255,255,0.05);
        }

        .sidebar::-webkit-scrollbar-thumb {
            background: rgba(255,255,255,0.3);
            border-radius: 10px;
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

        .sidebar-menu > li {
            margin: 5px 0;
        }

        /* Parent menu item */
        .menu-item {
            display: block;
            padding: 12px 15px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: all 0.3s;
            cursor: pointer;
            position: relative;
        }

        .menu-item:hover {
            background: rgba(255,255,255,0.1);
        }

        .menu-item.active {
            background: rgba(52, 152, 219, 0.3);
        }

        /* Arrow indicator */
        .menu-item .arrow {
            float: right;
            transition: transform 0.3s;
        }

        .menu-item.open .arrow {
            transform: rotate(90deg);
        }

        /* Submenu styles */
        .submenu {
            list-style: none;
            padding: 0;
            margin: 5px 0 0 0;
            max-height: 0;
            overflow: hidden;
            transition: max-height 0.3s ease;
        }

        .submenu.show {
            max-height: 200px;
        }

        .submenu li {
            margin: 2px 0;
        }

        .submenu a {
            display: block;
            padding: 10px 15px 10px 30px;
            color: #ecf0f1;
            text-decoration: none;
            border-radius: 5px;
            font-size: 0.9rem;
            transition: all 0.3s;
            background: rgba(0,0,0,0.1);
        }

        .submenu a:hover {
            background: rgba(52, 152, 219, 0.4);
            padding-left: 35px;
        }

        /* Simple menu item (no submenu) */
        .menu-link {
            display: block;
            padding: 12px 15px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: all 0.3s;
        }

        .menu-link:hover {
            background: rgba(255,255,255,0.1);
        }

        .sidebar-footer {
            padding: 20px;
            margin-top: 20px;
        }

        .sidebar-footer a {
            display: block;
            padding: 12px;
            background: #e74c3c;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            transition: all 0.3s;
        }

        .sidebar-footer a:hover {
            background: #c0392b;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .main-content {
                margin-left: 0;
                margin-top: 120px;
            }

            .sidebar {
                transform: translateX(-100%);
            }
        }
    </style>
</head>
<body>

<!-- Header -->
<jsp:include page="../assets/components/header.jsp" />

<!-- Sidebar -->
<div class="sidebar">
    <div class="sidebar-section">Main Menu</div>
    <ul class="sidebar-menu">
        <!-- Dashboard (simple link) -->
        <li>
            <a href="<%= request.getContextPath() %>/admin/dashboard" class="menu-link">

            </a>
        </li>

        <!-- Manage Doctors (with submenu) -->
        <li>
            <div class="menu-item" onclick="toggleSubmenu(this)">
                Manage Doctors
                <span class="arrow">▶</span>
            </div>
            <ul class="submenu">
                <li><a href="<%= request.getContextPath() %>/doctors?action=list">View All Doctors</a></li>
                <li><a href="<%= request.getContextPath() %>/doctors?action=add">Add New Doctor</a></li>
            </ul>
        </li>

        <!-- Manage Patients (with submenu) -->
        <li>
            <div class="menu-item" onclick="toggleSubmenu(this)">
                Manage Patients
                <span class="arrow">▶</span>
            </div>
            <ul class="submenu">
                <li><a href="<%= request.getContextPath() %>/patients?action=list">View All Patients</a></li>
                <li><a href="<%= request.getContextPath() %>/patients?action=addPatient">Add New Patient</a></li>
            </ul>
        </li>

        <!-- Manage Departments (with submenu) -->
        <li>
            <div class="menu-item" onclick="toggleSubmenu(this)">
                Manage Departments
                <span class="arrow">▶</span>
            </div>
            <ul class="submenu">
                <li><a href="<%= request.getContextPath() %>/departments?action=list">View All Departments</a></li>
                <li><a href="<%= request.getContextPath() %>/departments?action=add">Add New Department</a></li>
            </ul>
        </li>

        <!-- Manage Rooms (with submenu) -->
        <li>
            <div class="menu-item" onclick="toggleSubmenu(this)">
                Manage Rooms
                <span class="arrow">▶</span>
            </div>
            <ul class="submenu">
                <li><a href="<%= request.getContextPath() %>/rooms?action=list">View All Rooms</a></li>
                <li><a href="<%= request.getContextPath() %>/rooms?action=add">Add New Room</a></li>
            </ul>
        </li>

        <!-- Manage Consultations (with submenu) -->
        <li>
            <div class="menu-item" onclick="toggleSubmenu(this)">
                Manage Consultations
                <span class="arrow">▶</span>
            </div>
            <ul class="submenu">
                <li><a href="<%= request.getContextPath() %>/consultations?action=list">View All Consultations</a></li>
                <li><a href="<%= request.getContextPath() %>/consultations?action=add">Schedule Consultation</a></li>
            </ul>
        </li>
    </ul>

    <div class="sidebar-footer">
        <a href="<%= request.getContextPath() %>/logout">Logout</a>
    </div>
</div>

<!-- Main Content Area -->
<main class="main-content">
    <h2>Welcome to Admin Dashboard</h2>
    <p>Here you can manage doctors, patients, and departments.</p>
</main>

<!-- Footer -->
<jsp:include page="../components/footer.jsp" />

<script>
    function toggleSubmenu(element) {
        // Get the submenu
        const submenu = element.nextElementSibling;

        // Close all other submenus
        const allSubmenus = document.querySelectorAll('.submenu');
        const allMenuItems = document.querySelectorAll('.menu-item');

        allSubmenus.forEach(menu => {
            if (menu !== submenu) {
                menu.classList.remove('show');
            }
        });

        allMenuItems.forEach(item => {
            if (item !== element) {
                item.classList.remove('open');
            }
        });

        // Toggle current submenu
        submenu.classList.toggle('show');
        element.classList.toggle('open');
    }

    // Auto-open submenu if on a submenu page
    window.addEventListener('DOMContentLoaded', function() {
        const currentPath = window.location.pathname;
        const allSubmenuLinks = document.querySelectorAll('.submenu a');

        allSubmenuLinks.forEach(link => {
            if (currentPath.includes(link.getAttribute('href'))) {
                // Open the parent submenu
                const submenu = link.closest('.submenu');
                const menuItem = submenu.previousElementSibling;

                submenu.classList.add('show');
                menuItem.classList.add('open', 'active');

                // Highlight the active link
                link.style.background = 'rgba(52, 152, 219, 0.5)';
            }
        });
    });
</script>

</body>
</html>