# 🏥 Digital Clinic - Consultation Management System

## 📋 Project Description

**Digital Clinic** is a Java EE web application for complete digitalization of private clinic management. It provides a centralized platform to manage consultations, medical schedules, patient records, and clinic resource optimization.

The application follows a professional MVC architecture and adheres to object-oriented programming best practices.

---

## 🎯 Objectives

- Automate appointment booking and consultation management
- Optimize room occupancy with 30-minute time slots
- Centralize patient medical records
- Facilitate communication between patients, doctors, and administration
- Supervise activities and generate global statistics

---

## 👥 System Actors

### 👨‍⚕️ Patients
- Account creation and management
- View list of available doctors by department
- Book, modify, and cancel appointments
- Access personal medical history

### 🩺 Doctors
- View personal schedule
- Approve or decline appointment requests
- Conduct consultations with medical report entry
- Access medical history of followed patients
- Manage consultation statuses

### 🔧 Administration
- Manage departments (CRUD operations)
- Manage doctors and their department assignments
- Manage rooms and optimize occupancy
- Supervise all consultations globally
- Generate statistics and reports

---

## ✨ Key Features

### Consultation Management
- ✅ Booking with automatic time slot blocking (30 min)
- ✅ Approval/Rejection by doctor
- ✅ Status tracking: RESERVED → CONFIRMED → COMPLETED or CANCELLED
- ✅ Medical report (diagnosis, treatment)
- ✅ Complete accessible history

### Room Management
- ✅ Automatic assignment based on availability
- ✅ 30-minute time slots
- ✅ Real-time availability verification
- ✅ One consultation per time slot

### Department Management
- ✅ Organization by specialties (cardiology, dermatology, etc.)
- ✅ Doctor assignment to departments
- ✅ View doctors by department

---

## 🏗️ Technical Architecture

### Technology Stack

**Backend:**
- ☕ Java EE / Jakarta EE
- 🔄 Multi-layer MVC Architecture (Repository → Service → Controller → View)
- 🗄️ JPA/Hibernate for persistence
- 🐬 MySQL or PostgreSQL
- 📅 Java Time API for date/time management
- 🛡️ Servlet Filters for security

**Frontend:**
- 📄 JSP (Java Server Pages)
- 🏷️ JSTL (JSP Standard Tag Library)
- 🎨 CSS / Bootstrap / Tailwind
- ⚡ JavaScript (client-side validation)
- 🔐 Expression Language (EL) for data access

**Session Management:**
- HttpSession for authentication
- User type storage (PATIENT, DOCTOR, ADMIN)
- Role-based access control
- Security filters for protected pages

---

## 📊 Data Model

### Main Entities

```
Directory structure:
└── mustapha-moutaki-digital-hospital-jakarta/
    ├── docker-compose.yml
    ├── Dockerfile
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── watch-build.sh
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── org/
    │       │       └── mustapha/
    │       │           └── digitalhospitaljee/
    │       │               ├── HelloServlet.java
    │       │               ├── Main.java
    │       │               ├── Config/
    │       │               │   └── JPAinitializer.java
    │       │               ├── controller/
    │       │               │   ├── DoctorServlet.java
    │       │               │   └── PatientServlet.java
    │       │               ├── model/
    │       │               │   ├── Admin.java
    │       │               │   ├── Consultation.java
    │       │               │   ├── Department.java
    │       │               │   ├── Doctor.java
    │       │               │   ├── Patient.java
    │       │               │   ├── Person.java
    │       │               │   ├── Room.java
    │       │               │   └── enums/
    │       │               │       └── ConsultationStatus.java
    │       │               ├── Repository/
    │       │               │   ├── AdminRepository.java
    │       │               │   ├── DoctorRepository.java
    │       │               │   ├── PatientRepository.java
    │       │               │   └── impl/
    │       │               │       ├── AdminRepositoryImpl.java
    │       │               │       ├── DoctorRepositoryImpl.java
    │       │               │       └── PatientRepositoryImpl.java
    │       │               └── service/
    │       │                   ├── DoctorService.java
    │       │                   ├── PatientService.java
    │       │                   └── impl/
    │       │                       ├── DoctorServiceImpl.java
    │       │                       └── PatientServiceImpl.java
    │       ├── resources/
    │       │   └── META-INF/
    │       │       └── persistence.xml
    │       └── webapp/
    │           ├── index.jsp
    │           └── WEB-INF/
    │               ├── web.xml
    │               └── view/
    │                   ├── doctor.jsp
    │                   ├── list.jsp
    │                   ├── success.jsp
    │                   ├── admin/
    │                   │   ├── consultation-supervision.jsp
    │                   │   ├── department-managment.jsp
    │                   │   ├── doctor-managment.jsp
    │                   │   └── salle-menagment.jsp
    │                   ├── assets/
    │                   │   ├── components/
    │                   │   │   ├── footer.jsp
    │                   │   │   └── header.jsp
    │                   │   └── dashboards/
    │                   │       ├── admin-dashboard.jsp
    │                   │       ├── doctor-dashboard.jsp
    │                   │       └── patient-dashboard.jsp
    │                   ├── auth/
    │                   │   ├── login.jsp
    │                   │   └── register.jsp
    │                   ├── doctor/
    │                   │   ├── add.jsp
    │                   │   ├── consultation-detail.jsp
    │                   │   ├── details.jsp
    │                   │   ├── list.jsp
    │                   │   ├── planning.jsp
    │                   │   └── update.jsp
    │                   └── patient/
    │                       ├── add.jsp
    │                       ├── details.jsp
    │                       ├── list.jsp
    │                       ├── mes-consultations.jsp
    │                       ├── reservation-form.jsp
    │                       └── update.jsp
    └── .mvn/
        └── wrapper/
            └── maven-wrapper.properties

```

### Consultation Statuses
- 🟡 **RESERVED** : Initial booking by patient
- 🟢 **CONFIRMED** : Validated by doctor
- 🔴 **CANCELLED** : Cancelled by patient or doctor
- ✅ **COMPLETED** : Consultation performed with report

---

## 📝 Business Rules

1. ✔️ A patient can have multiple consultations, but only one reservation per time slot
2. ✔️ A doctor belongs to one department but can handle multiple consultations
3. ✔️ A consultation follows the cycle: RESERVED → CONFIRMED → COMPLETED or CANCELLED
4. ✔️ A room accommodates maximum one consultation per 30-minute slot
5. ✔️ Past consultations remain in history
6. ✔️ Automatic availability verification before booking

---

## 🚀 Installation and Configuration

### Prerequisites
- ☕ JDK 11 or higher
- 🐬 MySQL 8.0+ or PostgreSQL 12+
- 🦊 Apache Tomcat 9+ or Jakarta EE compatible server
- 🔧 Maven 3.6+

### Installation Steps

1. **Clone the repository**
```bash
git clone https://github.com/your-repo/digital-clinic.git
cd digital-clinic
```

2. **Configure the database**
```sql
CREATE DATABASE clinic_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **Configure persistence.xml**
```xml
<!-- Modify connection parameters in src/main/resources/META-INF/persistence.xml -->
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/clinic_db"/>
<property name="javax.persistence.jdbc.user" value="your_user"/>
<property name="javax.persistence.jdbc.password" value="your_password"/>
```

4. **Compile the project**
```bash
mvn clean install
```

5. **Deploy to Tomcat**
```bash
# Copy the generated WAR file to Tomcat's webapps folder
cp target/digital-clinic.war $TOMCAT_HOME/webapps/
```

6. **Start the application**
```bash
# Start Tomcat
$TOMCAT_HOME/bin/startup.sh
```

7. **Access the application**
```
http://localhost:8080/digital-clinic
```

---

## 🧪 User Stories

### 👨‍⚕️ Patients
- ✅ As a patient, I want to book an appointment with a doctor
- ✅ As a patient, I want to cancel or modify my reservation
- ✅ As a patient, I want to view my consultation history

### 🩺 Doctors
- ✅ As a doctor, I want to view my schedule
- ✅ As a doctor, I want to approve or decline a reservation
- ✅ As a doctor, I want to enter a consultation report

### 🔧 Admin
- ✅ As an admin, I want to manage departments and doctors
- ✅ As an admin, I want to manage rooms to optimize occupancy
- ✅ As an admin, I want to supervise all consultations

---

## 🔒 Security

- 🔐 HTTP session-based authentication
- 🛡️ Security filters to protect sensitive pages
- 👤 Role management (PATIENT, DOCTOR, ADMIN)
- 🚪 Automatic logout (session.invalidate())
- ✔️ Server-side and client-side data validation

---

## 📈 Statistics and Reports

The application generates:
- 📊 Total number of patients
- 📊 Number of consultations per period
- 📊 Room occupancy rate
- 📊 Statistics by department
- 📊 Doctor performance metrics

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the project
2. Create a branch (`git checkout -b feature/enhancement`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/enhancement`)
5. Open a Pull Request

---

