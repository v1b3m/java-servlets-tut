import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Get the parameter from the request
        String username = request.getParameter("username");

        // Send the request back to the user
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<h1>Hello "+ username + ", it's working!!</h1>" );
            writer.println("</body></html>");

            // close the stream
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}