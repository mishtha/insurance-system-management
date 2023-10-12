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
@WebServlet(name = "editpolicyServlet", urlPatterns = {"/editpolicyServlet"})
public class editpolicyServlet extends HttpServlet {

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
            out.println("<title>Servlet editpolicyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editpolicyServlet at " + request.getContextPath() + "</h1>");
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

//         HttpSession session = request.getSession();
        policy p = new policy();
        int pid=Integer.parseInt(request.getParameter("pid"));
        
        List policyList = p.vieweditpolicie(pid);       
        request.setAttribute("pstatus", 1);
        request.setAttribute("policylist", policyList);
        RequestDispatcher rd = request.getRequestDispatcher("create_policy.jsp");
         rd.forward(request, response);

//            response.sendRedirect("create_policy.jsp?pstatus=1");



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

         String pid=request.getParameter("pid");
         String ptitle=request.getParameter("ptitle");
         String pbody=request.getParameter("pbody");
         String ptype=request.getParameter("ptype");
         
          HttpSession session = request.getSession();
        
//         PrintWriter out=response.getWriter();
//         out.println(pid);
//out.println(pbody);
//out.println(utype);


        policy p=new policy();        
        p.updatePolicy(pid,ptitle,pbody,ptype,cdate,ctime);
        response.sendRedirect("http://localhost:8080/SVS_Insurance/addpolicyServlet");
           



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
