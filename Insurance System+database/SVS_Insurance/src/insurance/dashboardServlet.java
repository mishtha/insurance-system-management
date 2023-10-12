/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "dashboardServlet", urlPatterns = {"/dashboardServlet"})
public class dashboardServlet extends HttpServlet {

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
            out.println("<title>Servlet dashboardServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dashboardServlet at " + request.getContextPath() + "</h1>");
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
           String uid=session.getAttribute("userId").toString();
           String utype=session.getAttribute("userType").toString();

                
               

           
        policy p = new policy();
        users u =new users();
        
        
        
        
        if("Manager".equals(utype)){
        List totalagents = u.totalAgents();        
        request.setAttribute("totalagents", totalagents);
        List totalclients = u.totalClients();        
        request.setAttribute("totalclients", totalclients);
        List totalpolicy = p.totalPolicy();        
        request.setAttribute("totalpolicy", totalpolicy);
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
       
        }
        else if ("Agent".equals(utype)){
        List totalclients = u.totalClients();        
        request.setAttribute("totalclients", totalclients);
        List totalpolicy = p.totalPolicy();        
        request.setAttribute("totalpolicy", totalpolicy); 
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
        
        }else{
            response.sendRedirect("http://localhost:8080/SVS_Insurance/userprofileServlet?uid="+uid+"");
        }
        
      
//       PrintWriter out = response.getWriter() ;
//     out.println(uid);
//     out.println(utype);
//        
        
        
        
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
