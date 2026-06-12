package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/convert")
public class chuyendoiServlet extends HttpServlet {

 
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        double miles = Double.parseDouble(request.getParameter("mile"));

        double km = miles / 0.621371;

        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter())
        {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Kết quả chuyển đổi</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet có địa chỉ: " + request.getContextPath() + "</h1>");
        out.println("<h2>Kết quả chuyển đôi " + miles + "miles --> km:"+ km+"</h2>");
        out.println("</body>");
        out.println("</html>");

        }
       
    }
}