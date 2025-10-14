<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f6fa;
            font-family: Arial, sans-serif;
        }
        .message-box {
            background: white;
            padding: 40px 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .message-box h2 {
            color: #2ecc71;
        }
        .message-box i {
            font-size: 40px;
            margin-bottom: 15px;
        }
        .message-box a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 25px;
            background-color: #00bcd4;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .message-box a:hover {
            background-color: #0097a7;
        }
    </style>

</head>
<body>
<div class="message-box">
    <h2><i class="fa-solid fa-circle-check"></i> Success!</h2>
    <p>${message}</p>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Go Back</a>
</div>
</body>
</html>
