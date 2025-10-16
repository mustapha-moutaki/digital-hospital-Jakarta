    package org.mustapha.digitalhospitaljee.controller;

    import jakarta.servlet.ServletConfig;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import jakarta.servlet.http.HttpSession;
    import org.mindrot.jbcrypt.BCrypt;
    import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
    import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
    import org.mustapha.digitalhospitaljee.Repository.PatientRepository;
    import org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl;
    import org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl;
    import org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl;
    import org.mustapha.digitalhospitaljee.model.Person;
    import org.mustapha.digitalhospitaljee.service.AdminService;
    import org.mustapha.digitalhospitaljee.service.DoctorService;
    import org.mustapha.digitalhospitaljee.service.PatientService;
    import org.mustapha.digitalhospitaljee.service.impl.AdminServiceImpl;
    import org.mustapha.digitalhospitaljee.service.impl.DoctorServiceImpl;
    import org.mustapha.digitalhospitaljee.service.impl.PatientServiceImpl;

    import java.io.IOException;
    import java.io.Writer;

    @WebServlet("/login")
    public class LoginController extends HttpServlet {


        private DoctorService doctorService;
        private PatientService patientService;
        private AdminService adminService;
        @Override
        public void init(ServletConfig config) throws ServletException {
            AdminRepository adminRepository = new AdminRepositoryImpl();
            adminService = new AdminServiceImpl(adminRepository);

            DoctorRepository doctorRepository = new DoctorRepositoryImpl();
            doctorService = new DoctorServiceImpl(doctorRepository);

            PatientRepository patientRepository = new PatientRepositoryImpl();
            patientService = new PatientServiceImpl(patientRepository);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if("login".equals(action)){
                String email = req.getParameter("email");
                String password = req.getParameter("password");

                // search for user
                Person user = adminService.findByEmail(email);
                System.out.println("***********************");
                System.out.println( user.getRole());
                System.out.println(user);

                if(user == null){

                    user = doctorService.findByEmail(email);
                }
                if(user == null){
                    user = patientService.findByEmail(email);
                }

                if(user != null && password.equals(user.getPassword()) ){//&& BCrypt.checkpw(password, user.getPassword())

                    HttpSession session = req.getSession();
                    session.setAttribute("currentUserId", user.getId());
                    session.setAttribute("role", user.getRole());
                    System.out.println("**************************");
//                    System.out.println(session.getAttribute("role"));
                    System.out.println(user);

                    switch (user.getRole()){
                        case "Admin":
                            req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/admin-dashboard.jsp").forward(req, resp);
                        break;
                        case "Doctor":
                            req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/doctor-dashboard.jsp").forward(req, resp);
                        break;
                        case "Patient":
                            req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/patient-dashboard.jsp").forward(req, resp);
                        break;
                        default:
                            req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
                    }
                }else{
                    String message = "invalid credentials";
                    req.setAttribute("ErrorMessage", message);
                    req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
                }
            }
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            String action = req.getParameter("action");
//            if("login".equals(action)){
                    req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
//            }
        }
    }
