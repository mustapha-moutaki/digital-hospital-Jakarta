<%@ page import="org.mustapha.digitalhospitaljee.model.Person" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Patient" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Admin" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl" %>
<%@ page import="org.mustapha.digitalhospitaljee.model.Doctor" %>
<%@ page import="org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

    .sidebar { position: fixed; left: 0; top: 0; width: 240px; background-color: #1e1f26; color: #fff; display: flex; flex-direction: column; padding: 20px 0; box-shadow: 2px 0 8px rgba(0,0,0,0.2); transition: width 0.3s ease; }
    .sidebar-header { text-align: center; margin-bottom: 20px; }
    .sidebar-header h2 { font-size: 1.4rem; color: #00bcd4; margin-bottom: 5px; }
    .sidebar-header p { font-size: 0.9rem; color: #aaa; }
    .sidebar-nav ul { list-style: none; padding: 0; }
    .sidebar-nav li { margin: 12px 0; }
    .sidebar-nav a { color: #ddd; text-decoration: none; display: flex; align-items: center; padding: 10px 20px; font-size: 0.95rem; transition: background 0.3s ease, color 0.3s ease; }
    .sidebar-nav a i { margin-right: 10px; font-size: 1.1rem; }
    .sidebar-nav a:hover, .sidebar-nav a.active { background-color: #00bcd4; color: #fff; border-radius: 4px; }
    .sidebar-footer { text-align: center; border-top: 1px solid #333; padding-top: 15px; }
    .sidebar-footer a { display: block; color: #bbb; text-decoration: none; padding: 8px 0; transition: color 0.3s ease; }
    .sidebar-footer .logout { color: #fff; font-weight: 500; }
    .sidebar-footer .logout:hover { color: #ff7979; }
    .main-content { margin-left: 240px; padding: 20px; }
    @media (max-width: 768px) { .sidebar { width: 70px; } .sidebar-header h2, .sidebar-header p, .sidebar-nav a span { display: none; } .sidebar-nav a { justify-content: center; } .sidebar-nav a i { margin: 0; } }
</style>

<%
    // جلب الجلسة
    HttpSession session1 = request.getSession(false);
    String role = null;
    Long userId = null;

    if(session1 != null) {
        userId = (Long) session1.getAttribute("currentUserId");
        role = (String) session1.getAttribute("role");
    }


    if(userId != null) {
        AdminRepositoryImpl adminRepo = new AdminRepositoryImpl();
        Admin admin = adminRepo.finfById(userId);
        if(admin != null) {
            role = admin.getRole();
        } else {
            DoctorRepositoryImpl doctorRepo = new DoctorRepositoryImpl();
            Doctor doctor = doctorRepo.findById(userId);
            if(doctor != null) {
                role = doctor.getRole();
            } else {
                PatientRepositoryImpl patientRepo = new PatientRepositoryImpl();
                Patient patient = patientRepo.findById(userId);
                if(patient != null) role = patient.getRole();
            }
        }


        session1.setAttribute("role", role);
    }
%>

<aside class="sidebar">
    <div class="sidebar-header">
        <h2>Dashboard</h2>
        <p>Digital Hospital</p>
    </div>

    <nav class="sidebar-nav">
        <% if("Admin".equalsIgnoreCase(role)){ %>
        <ul>
            <li><a href="dashboard" class="active"><i class="fa fa-home"></i> Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/doctor/manage?action=list"><i class="fa fa-user-md"></i> Doctors</a></li>
            <li><a href="${pageContext.request.contextPath}/patient/list?action=list"><i class="fa fa-users"></i> Patients</a></li>
            <li><a href="${pageContext.request.contextPath}/department?action=list"><i class="fa fa-building"></i> Departments</a></li>
            <li><a href="rooms"><i class="fa fa-bed"></i> Rooms</a></li>
            <li><a href="${pageContext.request.contextPath}/consultation?action=allList"><i class="fa fa-stethoscope"></i> Consultations</a></li>
            <li><a href="appointments"><i class="fa fa-calendar"></i> Appointments</a></li>
        </ul>
        <% } else if("Doctor".equalsIgnoreCase(role)) { %>
        <ul>
            <li><a href="${pageContext.request.contextPath}/patient/list?action=list"><i class="fa fa-users"></i> Patients</a></li>
            <li><a href="departments"><i class="fa fa-building"></i> My department</a></li>
            <li><a href="consultations"><i class="fa fa-stethoscope"></i> Consultations</a></li>
            <li><a href="consultations"><i class="fa fa-stethoscope"></i> My Info </a></li>
        </ul>
        <% } else if("Patient".equalsIgnoreCase(role)) { %>
        <ul>
            <li><a href="consultations"><i class="fa fa-stethoscope"></i> My info</a></li>
            <li><a href="consultations"><i class="fa fa-stethoscope"></i> Make an appointment</a></li>
            <li><a href="consultations"><i class="fa fa-stethoscope"></i> My appointments List</a></li>
            <li><a href="consultations"><i class="fa fa-stethoscope"></i> History</a></li>
        </ul>
        <% } else { %>
        <ul>
            <li>No data available</li>
        </ul>
        <% } %>
    </nav>

    <div class="sidebar-footer">
        <hr>
        <a href="<%= request.getContextPath() %>/logout">Logout</a>
    </div>
</aside>
