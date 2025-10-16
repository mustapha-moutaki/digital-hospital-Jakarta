<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Department" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <meta charset="UTF-8">
    <title>Doctors List</title>
    <style>
        .main-content {
            margin-left: 250px;
            margin-top: 75px;
            padding: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
        }

        th {
            background: #34495e;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }

        tr:hover {
            background: #e0f3ff;
        }

        h2 {
            margin-bottom: 20px;
        }

        .main-content-list{
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .main-content-list span{
            background-color: #00bcd4;
            border: none;
            border-radius: 40%;
            padding: 8px 8px;
        }
        .main-content-list span a{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>

<jsp:include page="../assets/components/header.jsp" />
<jsp:include page="../assets/components/sideBar.jsp" />

<main class="main-content">
    <div class="main-content-list">
        <h2>Welcome to Department List</h2>
        <span><a href="${pageContext.request.contextPath}/department?action=add">Add</a></span>
    </div>


    <%
        List<Department> departments = (List<Department>) request.getAttribute("departments");
        if (departments != null && !departments.isEmpty()) {
    %>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Department name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Department depa : departments) { %>
        <tr>
            <td><%= depa.getId() %></td>
            <td><%= depa.getName()%></td>
            <td>
                <a href="<%= request.getContextPath() %>/department?action=edit&id=<%= depa.getId() %>">Edit</a> |
                <a href="<%= request.getContextPath() %>/department?action=delete&id=<%= depa.getId() %>">Delete</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <%
    } else {
    %>
    <p>No department found.</p>
    <%
        }
    %>
</main>

<jsp:include page="../assets/components/footer.jsp" />

</body>
</html>
