package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;


/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {	
		System.out.println("[LoginServlet] GET");
		
		doPost(req, resp);
	}
	 private static final long serialVersionUID = 1L;
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        LoginService loginService = new LoginService();
        boolean result = loginService.login(username, password, dob);

        if (result) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<html><head><title>success</title></head><body>Login Successful</body></html>");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("<html><head><title>fail</title></head><body>Login Failed</body></html>");
        }
    }
	
}
