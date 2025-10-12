<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    /* Header Styles */
    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
        background: linear-gradient(135deg, #2c3e50 0%, #34495e 100%);
        color: white;
        padding: 15px 30px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        z-index: 1000;
    }

    .header-left {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    .header .logo-container {
        display: flex;
        align-items: center;
        gap: 12px;
    }

    .header img {
        height: 45px;
        width: 45px;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.2);
    }

    .header .logo-text {
        font-size: 1.8rem;
        font-weight: bold;
        letter-spacing: 0.5px;
    }

    .user-info {
        display: flex;
        align-items: center;
        gap: 10px;
        padding: 8px 15px;
        background-color: rgba(255,255,255,0.1);
        border-radius: 20px;
    }

    .user-info span {
        font-size: 0.9rem;
    }

    @media (max-width: 768px) {
        .header {
            flex-direction: column;
            gap: 15px;
            padding: 15px;
        }
    }
</style>

<header class="header">
    <div class="header-left">
        <div class="logo-container">
            <div class="logo-text">Digital Clinic</div>
        </div>
    </div>
    <div class="user-info">
        <span>Mr. </span>
    </div>
</header>