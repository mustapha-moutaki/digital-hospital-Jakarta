
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Consultations</title>--%>
<%--    <style>--%>
<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--            border: 1px solid #ddd;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: #34495e;--%>
<%--            color: white;--%>
<%--        }--%>

<%--        tr:nth-child(even) {background-color: #f2f2f2;}--%>
<%--        tr:hover {background-color: #e0f3ff;}--%>

<%--        .action-btn {--%>
<%--            margin-right: 5px;--%>
<%--            padding: 3px 8px;--%>
<%--            border: none;--%>
<%--            border-radius: 4px;--%>
<%--            cursor: pointer;--%>
<%--        }--%>

<%--        .edit-btn { background-color: #3498db; color: white; }--%>
<%--        .delete-btn { background-color: #e74c3c; color: white; }--%>
<%--        .status-btn { background-color: #2ecc71; color: white; }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<jsp:include page="../assets/components/header.jsp" />--%>
<%--<jsp:include page="../assets/components/sideBar.jsp" />--%>

<%--<div style="margin-left:250px; margin-top:75px; padding:30px;">--%>
<%--    <h2>Consultations</h2>--%>
<%--    <div style="margin-bottom: 15px;">--%>
<%--        <a href="${pageContext.request.contextPath}/consultations?action=add" class="btn btn-success">--%>
<%--            Add New Consultation--%>
<%--        </a>--%>
<%--    </div>--%>

<%--    <table>--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Patient</th>--%>
<%--            <th>Doctor</th>--%>
<%--            <th>Room</th>--%>
<%--            <th>StartTime</th>--%>
<%--            &lt;%&ndash; <th>EndTime</th> &ndash;%&gt;--%>
<%--            <th>Status</th>--%>
<%--            <th>Report</th>--%>
<%--            <th>Consultation Date</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="c" items="${consultations}">--%>
<%--            <tr>--%>
<%--                <td>${c.id}</td>--%>
<%--                <td>${c.patient.firstName} ${c.patient.lastname}</td>--%>
<%--                <td>${c.doctor.firstName} ${c.doctor.lastname}</td>--%>
<%--                <td>${c.room.name}</td>--%>
<%--                <td>${c.startTime}</td>--%>
<%--                    &lt;%&ndash; <td>${c.endTime}</td> &ndash;%&gt;--%>
<%--                <td>${c.consultationStatus}</td>--%>
<%--                <td>${c.report}</td>--%>
<%--                <td>${c.dateTime}</td>--%>
<%--                <td>--%>
<%--                    <form action="${pageContext.request.contextPath}/consultations" method="post" style="display:inline;">--%>
<%--                        <input type="hidden" name="action" value="changeStatus"/>--%>
<%--                        <input type="hidden" name="id" value="${c.id}"/>--%>
<%--                        <button type="submit" class="action-btn status-btn">Change Status</button>--%>
<%--                    </form>--%>

<%--                    <a href="${pageContext.request.contextPath}/consultations?action=edit&id=${c.id}" class="action-btn edit-btn">Edit</a>--%>
<%--                    <a href="${pageContext.request.contextPath}/consultations?action=delete&id=${c.id}" class="action-btn delete-btn">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>

<%--<jsp:include page="../assets/components/footer.jsp" />--%>

<%--</body>--%>
<%--</html>--%>


<%--&lt;%&ndash;mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm&ndash;%&gt;--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consultations</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #34495e;
            color: white;
        }

        tr:nth-child(even) {background-color: #f2f2f2;}
        tr:hover {background-color: #e0f3ff;}

        .action-btn {
            margin-right: 5px;
            padding: 3px 8px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .edit-btn { background-color: #3498db; color: white; }
        .delete-btn { background-color: #e74c3c; color: white; }
        .status-btn { background-color: #2ecc71; color: white; }
    </style>
</head>
<body>

<jsp:include page="../assets/components/header.jsp" />
<jsp:include page="../assets/components/sideBar.jsp" />

<div style="margin-left:250px; margin-top:75px; padding:30px;">
    <h2>Consultations</h2>
    <div style="margin-bottom: 15px;">
        <a href="${pageContext.request.contextPath}/consultations?action=add" class="btn btn-success">
            Add New Consultation
        </a>
    </div>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Patient</th>
            <th>Doctor</th>
            <th>Room</th>
            <th>StartTime</th>
            <%-- <th>EndTime</th> --%>
            <th>Status</th>
            <th>Report</th>
            <th>Consultation Date</th>
            <c:if test="${sessionScope.role eq 'Admin'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${consultations}">
            <tr>
                <td>${c.id}</td>
                <td>${c.patient.firstName} ${c.patient.lastname}</td>
                <td>${c.doctor.firstName} ${c.doctor.lastname}</td>
                <td>${c.room.name}</td>
                <td>${c.startTime}</td>
                    <%-- <td>${c.endTime}</td> --%>
                <td>${c.consultationStatus}</td>
                <td>${c.report}</td>
                <td>${c.dateTime}</td>

                <!-- Actions only for admin -->
                <c:if test="${sessionScope.role eq 'Admin'}">
                    <td>
                        <form action="${pageContext.request.contextPath}/consultations" method="get" style="display:inline;">
                            <input type="hidden" name="action" value="changeStatus"/>
                            <input type="hidden" name="id" value="${c.id}"/>
                            <button type="submit" class="action-btn status-btn">Change Status</button>
                        </form>


                        <a href="${pageContext.request.contextPath}/consultations?action=edit&id=${c.id}" class="action-btn edit-btn">Edit</a>
                        <a href="${pageContext.request.contextPath}/consultations?action=delete&id=${c.id}" class="action-btn delete-btn">Delete</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../assets/components/footer.jsp" />

</body>