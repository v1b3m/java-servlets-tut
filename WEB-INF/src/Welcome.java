import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Welcome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        // Send the request back to the user
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            // add a cookie object that stores the username
            Cookie ck[] = request.getCookies();

            //add cookie to the response
            response.addCookie(ck);
            
            writer.println("<html><body>");
            writer.println("<h1>Hello "+ ck[0].getValue() + ", it's working!!</h1>" );
            writer.println("</body></html>");

            // close the stream
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}