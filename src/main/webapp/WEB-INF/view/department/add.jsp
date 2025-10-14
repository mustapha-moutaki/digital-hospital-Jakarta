<%@ page import="org.mustapha.digitalhospitaljee.model.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Department</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        .main-content {
            margin-left: 250px;
            margin-top: 75px;
            padding: 30px;
        }

        .form-container {
            background: white;
            border-radius: 10px;
            padding: 25px 35px;
            max-width: 600px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            margin-bottom: 20px;
            text-align: center;
            color: #34495e;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 15px;
            color: #2c3e50;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15px;
        }

        input:focus, select:focus {
            border-color: #00bcd4;
            outline: none;
            box-shadow: 0 0 5px rgba(0,188,212,0.3);
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #00bcd4;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            margin-top: 25px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background-color: #0097a7;
        }

        .back-link {
            display: block;
            margin-top: 15px;
            text-align: center;
        }

        .back-link a {
            text-decoration: none;
            color: #34495e;
            font-weight: bold;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<jsp:include page="../assets/components/header.jsp" />
<jsp:include page="../assets/components/adminSidebar.jsp" />

<main class="main-content">
    <div class="form-container">
        <h2><i class="fa-solid fa-user-md"></i> Add New Department</h2>

        <form action="<%= request.getContextPath() %>/department" method="post">
            <input type="hidden" name="action" value="addDepartment">

            <label for="departmentname">Department Name</label>
            <input type="text" id="departmentname" name="departmentname" placeholder="Enter department name" required>
            <button type="submit">create Department</button>
        </form>

        <div class="back-link">
            <a href="<%= request.getContextPath() %>/department?action=list">
                <i class="fa-solid fa-arrow-left"></i> Back to departments List
            </a>
        </div>
    </div>
</main>

<jsp:include page="../assets/components/footer.jsp" />

</body>
</html>
