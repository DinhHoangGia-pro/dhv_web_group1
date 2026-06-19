package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/login")
public class loginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        System.out.println("user:"+ user);
        System.out.println("pass:"+ pass);



         try
        {
            PrintWriter out = response.getWriter();

            if (user.equalsIgnoreCase("van") && pass.equalsIgnoreCase("123")) 
            {
                response.setContentType("text/html;charset=UTF-8");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>Login thành công</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Chào Vân </h1>");           
                out.println("</body>");
                out.println("</html>");
            }
            else
            {
                 String host = request.getHeader("X-Forwarded-Host");
                 String proto = request.getHeader("X-Forwarded-Proto");
                 response.sendRedirect(
                proto + "://" + host + "/login.html"
                );
                //response.sendRedirect("login.html");
            }



        }
        catch(Exception ex)
        {


        }

        
    }


    

    
}