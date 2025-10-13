<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><jsp:include page="../components/title.jsp" flush="true" /></title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

<!-- Header -->
<jsp:include page="../components/header.jsp" />

<!-- Sidebar -->
<jsp:include page="adminSidebar.jsp" />

<!-- Dynamic Main Content -->
<main class="main-content">

</main>

<!-- Footer -->
<jsp:include page="../components/footer.jsp" />

</body>
</html>
