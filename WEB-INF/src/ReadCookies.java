import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ReadCookies extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        // Send the request back to the user
        try {

            Cookie cookie = null;
            Cookie[] cookies = null;

            // Get an array of cookies associated with this domain
            cookies = request.getCookies();

            // Set the response content type
            response.setContentType("text/html");

            PrintWriter writer = response.getWriter();
            String title = "Reading Cookies";
            String docType = "<!DOCTYPE html>\n";

            writer.println(docType +
                "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" );
            
            if( cookies != null ) {
                writer.println("<h2> Found Cookies Name and Value</h2>");
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    writer.print("Name : " + cookie.getName( ) + ",  ");
                        writer.print("Value: " + cookie.getValue( ) + " <br/>");
                }
            } else {
                writer.println("<h2>No cookies founds</h2>");
            }
            writer.println("</body>");
            writer.println("</html>");
            
            // close the stream
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}