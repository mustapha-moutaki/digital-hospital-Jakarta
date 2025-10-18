
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Digital Hospital</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body, html {
            height: 100%;
            overflow: hidden;
        }

        .split-container {
            display: flex;
            height: 100vh;
        }

        /* Left Side - Animated Icons */
        .left-side {
            flex: 1;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            overflow: hidden;
        }

        .icon-container {
            position: relative;
            width: 100%;
            height: 100%;
        }

        .floating-icon {
            position: absolute;
            font-size: 3rem;
            color: rgba(255, 255, 255, 0.7);
            animation: float 6s ease-in-out infinite;
        }

        .floating-icon:nth-child(1) {
            top: 10%;
            left: 15%;
            animation-delay: 0s;
        }

        .floating-icon:nth-child(2) {
            top: 20%;
            right: 20%;
            animation-delay: 1s;
        }

        .floating-icon:nth-child(3) {
            top: 50%;
            left: 10%;
            animation-delay: 2s;
        }

        .floating-icon:nth-child(4) {
            bottom: 20%;
            right: 15%;
            animation-delay: 3s;
        }

        .floating-icon:nth-child(5) {
            bottom: 15%;
            left: 25%;
            animation-delay: 1.5s;
        }

        .floating-icon:nth-child(6) {
            top: 60%;
            right: 25%;
            animation-delay: 2.5s;
        }

        @keyframes float {
            0%, 100% {
                transform: translateY(0px) rotate(0deg);
            }
            25% {
                transform: translateY(-20px) rotate(5deg);
            }
            50% {
                transform: translateY(-40px) rotate(-5deg);
            }
            75% {
                transform: translateY(-20px) rotate(3deg);
            }
        }

        .welcome-text {
            position: absolute;
            text-align: center;
            color: white;
            z-index: 10;
        }

        .welcome-text h1 {
            font-size: 3rem;
            font-weight: 700;
            margin-bottom: 1rem;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
        }

        .welcome-text p {
            font-size: 1.2rem;
            opacity: 0.9;
        }

        /* Right Side - Login Form */
        .right-side {
            flex: 1;
            background: #ffffff;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 2rem;
        }

        .login-container {
            width: 100%;
            max-width: 450px;
        }

        .login-header {
            text-align: center;
            margin-bottom: 2rem;
        }

        .login-header h3 {
            color: #667eea;
            font-weight: 700;
            margin-bottom: 0.5rem;
        }

        .login-header p {
            color: #6c757d;
        }

        .form-control:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);
        }

        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border: none;
            padding: 0.75rem;
            font-weight: 600;
            transition: transform 0.2s;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(102, 126, 234, 0.4);
        }

        .alert {
            border-radius: 10px;
        }

        .form-label {
            font-weight: 600;
            color: #495057;
        }

        .card-footer {
            background: transparent;
            border-top: none;
            padding-top: 0;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .split-container {
                flex-direction: column;
            }

            .left-side {
                display: none;
            }

            .right-side {
                flex: 1;
            }

            .welcome-text h1 {
                font-size: 2rem;
            }
        }

        .input-group-text {
            background: transparent;
            border-right: none;
        }

        .form-control {
            border-left: none;
        }

        .form-control:focus + .input-group-text {
            border-color: #667eea;
        }
    </style>
</head>
<body>
<div class="split-container">
    <!-- Left Side - Animated Icons -->
    <div class="left-side">
        <div class="welcome-text">
            <h1>Digital Hospital</h1>
            <p>Your Health, Our Priority</p>
        </div>
        <div class="icon-container">
            <i class="bi bi-heart-pulse-fill floating-icon"></i>
            <i class="bi bi-hospital-fill floating-icon"></i>
            <i class="bi bi-capsule-pill floating-icon"></i>
            <i class="bi bi-clipboard2-pulse-fill floating-icon"></i>
            <i class="bi bi-file-medical-fill floating-icon"></i>
            <i class="bi bi-bandaid-fill floating-icon"></i>
        </div>
    </div>

    <!-- Right Side - Login Form -->
    <div class="right-side">
        <div class="login-container">
            <div class="login-header">
                <h3>Welcome Back!</h3>
                <p>Please login to your account</p>
            </div>

            <form action="<%= request.getContextPath() %>/login" method="post">
                <input type="hidden" name="action" value="login">

                <% if(request.getAttribute("ErrorMessage") != null) { %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <i class="bi bi-exclamation-triangle-fill me-2"></i>
                    <%= request.getAttribute("ErrorMessage")%>
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
                <% } %>

                <!-- Email -->
                <div class="mb-3">
                    <label for="email" class="form-label">
                        <i class="bi bi-envelope-fill me-1"></i>Email Address
                    </label>
                    <input type="email" class="form-control" id="email" name="email"
                           placeholder="Enter your email" required>
                </div>

                <!-- Password -->
                <div class="mb-3">
                    <label for="password" class="form-label">
                        <i class="bi bi-lock-fill me-1"></i>Password
                    </label>
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Enter your password" required>
                </div>

                <!-- Remember Me & Forgot Password -->
                <div class="mb-3 d-flex justify-content-between align-items-center">
<%--                    <div class="form-check">--%>
<%--                        <input class="form-check-input" type="checkbox" id="remember">--%>
<%--                        <label class="form-check-label" for="remember">--%>
<%--                            Remember me--%>
<%--                        </label>--%>
<%--                    </div>--%>
                    <a href="#" class="text-decoration-none" style="color: #667eea;">Forgot Password?</a>
                </div>

                <!-- Submit Button -->
                <div class="d-grid mb-3">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-box-arrow-in-right me-2"></i>Login
                    </button>
                </div>

<%--                <div class="text-center">--%>
<%--                    <small class="text-muted">--%>
<%--                        Don't have an account?--%>
<%--                        <a href="register.jsp" class="text-decoration-none fw-bold" style="color: #667eea;">--%>
<%--                            Register Now--%>
<%--                        </a>--%>
<%--                    </small>--%>
<%--                </div>--%>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>