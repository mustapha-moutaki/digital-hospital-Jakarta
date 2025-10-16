<%@ page import="org.mustapha.digitalhospitaljee.model.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Doctor</title>
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
<jsp:include page="../assets/components/sideBar.jsp" />

<main class="main-content">
    <div class="form-container">
        <h2><i class="fa-solid fa-user-md"></i> Add New Doctor</h2>

        <form action="<%= request.getContextPath() %>/doctor/dashboard" method="post">
            <input type="hidden" name="action" value="addDoctor">

            <label for="fullName">First Name</label>
            <input type="text" id="fullName" name="firstName" placeholder="Enter doctor's full name" required>

            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="lastName" placeholder="Enter doctor's last name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter doctor's email" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter doctor's password" required>

            <label for="department">Department</label>

            <select id="department" name="department" required>
                <option value="" disabled>Select department</option>

                <%
                    List<Department> departments = (List<Department>) request.getAttribute("departments");
                    for (Department dep : departments) {
                %>
                <option  value="<%= dep.getId() %>"><%= dep.getName() %></option>
                <%
                    }
                %>
            </select>



            <label for="specialization">Specialization</label>
            <input type="text" id="specialization" name="specialization" placeholder="Enter doctor's specialization" required>

            <button type="submit">Add Doctor</button>
        </form>

        <div class="back-link">
            <a href="<%= request.getContextPath() %>/doctor/dashboard?action=list">
                <i class="fa-solid fa-arrow-left"></i> Back to Doctors List
            </a>
        </div>
    </div>
</main>

<jsp:include page="../assets/components/footer.jsp" />

</body>
</html>
