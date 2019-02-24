import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Welcome extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        // Send the request back to the user
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            // add a cookie object that stores the username
            Cookie ck[] = request.getCookies();
            
            writer.println("<html><body>");
            // writer.println("<h1>Hello "+ ck[0].getValue() + ", it's working!!</h1>" );
            writer.println("<h1>Hello "+ ", it's working!!</h1>" );
            writer.println("</body></html>");

            // close the stream
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}