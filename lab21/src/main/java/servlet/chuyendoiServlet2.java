package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/ketqua")
public class chuyendoiServlet2 extends HttpServlet {

 
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        double miles = Double.parseDouble(request.getParameter("mile"));

        double km = miles / 0.621371;

        
       
        request.setAttribute("result", km);

        request.getRequestDispatcher("result.jsp")
               .forward(request, response);

       
    }
}