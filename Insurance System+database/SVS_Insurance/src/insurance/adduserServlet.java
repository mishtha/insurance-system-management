/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lasitha G Gunasinghe
 */
@WebServlet(name = "adduserServlet", urlPatterns = {"/adduserServlet"})
public class adduserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adduserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adduserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
          HttpSession session = request.getSession();
          users u = new users();
//        String uid=request.getParameter("uid");
        List userList = u.viewUsers();        
        request.setAttribute("userslist", userList);
        RequestDispatcher rd = request.getRequestDispatcher("show_users.jsp");
        rd.forward(request, response);
        


    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
         SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
         Date date = new Date();  
         String cdate=formatter.format(date);
         String ctime=formatter2.format(date);

         String uid=request.getParameter("uid");
         String pass=request.getParameter("pass");
         String utype=request.getParameter("utype");
         String uname=request.getParameter("uname");
         String email=request.getParameter("email");
         String add=request.getParameter("add");
         int tel=Integer.parseInt(request.getParameter("tel"));
         double lat=Double.parseDouble(request.getParameter("lat1"));
         double lng=Double.parseDouble(request.getParameter("lng1"));
          HttpSession session = request.getSession();
          
         
//         PrintWriter out=response.getWriter();
//         out.println(uid);
//out.println(pass);
//out.println(utype);
//out.println(email);
//out.println(uname);
//out.println(add);
//out.println(tel);
//out.println(lat);
//out.println(lng);
//out.println(prov);
//out.println(tel);
//out.println(gen);
//out.println(utype);
//out.println(cdate);
//out.println(ctime);

        users u=new users();        
        u.addUser(uid,pass,utype,uname,email,add,tel,cdate,ctime,lat,lng);
        response.sendRedirect("create_user.jsp");
           
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
