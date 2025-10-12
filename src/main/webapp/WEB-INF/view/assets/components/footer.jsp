<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        .footer {
            background-color: #2c3e50;
            color: #ecf0f1;
            text-align: center;
            padding: 15px 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
            font-family: Arial, sans-serif;
            font-size: 0.9rem;
        }

        .footer a {
            color: #ecdbff;
            text-decoration: none;
            margin: 0 5px;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
    <title>footer</title>
</head>
<body>
<div class="footer">
    &copy; <%= java.time.Year.now() %> Digital Clinic. Created by Mustapha. All rights reserved.
    <br>
</div>
</body>
</html>
