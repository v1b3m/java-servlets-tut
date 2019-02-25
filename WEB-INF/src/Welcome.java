import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Welcome extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) {

        // Send the request back to the user
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            // Create cookies for first and last name
            Cookie firstname = new Cookie("first_name", request.getParameter("firstname"));
            Cookie lastname = new Cookie("last_name", request.getParameter("lastname"));

            // Set expiry date after 24 Hours for cookies.
            firstname.setMaxAge(60*60*24);
            lastname.setMaxAge(60*60*12);

            // Add cookies to the response header
            response.addCookie( firstname );
            response.addCookie( lastname );

            // Set the response type
            response.setContentType("text/html");

            String title = "Cookies example";
            String docType = "<!DOCTYPE html>\n";

            writer.println(docType + 
                "<html>\n" +
                    "<head><title>" + title + "</title>" +
                    "+</head>\n" +

                    "<body bgcolor = \"#f0f0f0\">\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                            "  <li><b>First Name</b>: "
                            + request.getParameter("firstname") + "\n" +
                            "  <li><b>Last Name</b>: "
                            + request.getParameter("lastname") + "\n" +
                        "</ul>\n" +
                    "</body>" +
                "</html>"
            );

            // close the stream
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}