<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Consultation" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus" %>
<%@ page import="javax.swing.text.html.Option" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <meta charset="UTF-8">
    <title>All Consultations -- List --</title>
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
        <h2>Welcome to Consultations List</h2>
<%--        <span><a href="${pageContext.request.contextPath}/consultaton?action=add">Add</a></span>--%>
    </div>


    <%
        List<Consultation> allConsultation = (List<Consultation>) request.getAttribute("allConsultation");
//        List<ConsultationStatus>statusList = (List<ConsultationStatus>) request.getAttribute("status");
        if (allConsultation != null && !allConsultation.isEmpty()) {
    %>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>P.ID</th>
            <th>D.ID</th>
            <th>REPORT</th>
            <th>DATE</th>
            <th>STATUS</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Consultation cons : allConsultation) { %>
        <%
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            String formattedDate = cons.getDateTime().format(formatter);
        %>
        <tr>
            <td><%= cons.getId() %></td>
            <td><%= cons.getPatient().getId() %></td>
            <td><%= cons.getDoctor().getId()%></td>
            <td><%= cons.getReport() %></td>
            <td><%= formattedDate %></td>
            <td>
                <form action="${pageContext.request.contextPath}/consultation" method="post">
                    <input type="hidden" name="action" value="updateStatus">
                    <input type="hidden" name="id" value="<%= cons.getId() %>">

                    <select name="consultationStatus">
                        <c:forEach var="statusItem" items="${status}">

                            <option value="${statusItem}"
                                    <c:if test="${statusItem eq cons.consultationStatus}">selected</c:if>>
                                    ${statusItem}
                            </option>
                        </c:forEach>
                    </select>
                    <button type="submit">update</button>
                </form>

            </td>
            <td>
                <a href="<%= request.getContextPath() %>/consultation?action=delete&id=<%= cons.getId() %>">Delete</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <%
    } else {
    %>
    <p>No consultation found.</p>
    <%
        }
    %>
</main>

<jsp:include page="../assets/components/footer.jsp" />

</body>
</html>
