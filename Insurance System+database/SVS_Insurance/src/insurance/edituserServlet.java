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
 * @author dharmishtha
 */
@WebServlet(name = "edituserServlet", urlPatterns = {"/edituserServlet"})
public class edituserServlet extends HttpServlet {

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
            out.println("<title>Servlet edituserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet edituserServlet at " + request.getContextPath() + "</h1>");
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
        
        users u = new users();
        String uid=request.getParameter("uid");
        
        List userList = u.vieweditUser(uid);       
        request.setAttribute("ustatus", 1);
        request.setAttribute("userlist", userList);
        RequestDispatcher rd = request.getRequestDispatcher("create_user.jsp");
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
//         out.println(pid);
//out.println(pbody);
//out.println(utype);


        users u=new users();        
        u.updateUser(uid,pass,utype,uname,email,add,tel,cdate,ctime,lat,lng);
        response.sendRedirect("http://localhost:8080/SVS_Insurance/adduserServlet");
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
