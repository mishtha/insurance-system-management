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
@WebServlet(name = "userpolicyServlet", urlPatterns = {"/userpolicyServlet"})
public class userpolicyServlet extends HttpServlet {

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
            out.println("<title>Servlet userpolicyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userpolicyServlet at " + request.getContextPath() + "</h1>");
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
        
        policy p = new policy();
//      
        List lifepolicyList = p.viewlifepolicies();        
        request.setAttribute("lifepolicylist", lifepolicyList);
        
        List motopolicyList = p.viewmotopolicies();        
        request.setAttribute("motopolicylist", motopolicyList);
        
        List propolicyList = p.viewpropolicies();        
        request.setAttribute("propolicylist", propolicyList);
        
        
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("add_policy.jsp");
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
            HttpSession session = request.getSession();
            String uid=session.getAttribute("userId").toString();
            
            String arr[] = request.getParameterValues("policyID");
            PrintWriter out = response.getWriter();
            for(int i = 0; i < arr.length; i++){
                
//                out.println(arr[i]);
//                out.println(uid);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();  
                String cdate=formatter.format(date);
                String ctime=formatter2.format(date);

                String pid=arr[i];
                policy p=new policy();        
                p.adduserlifePolicy(uid,pid,cdate,ctime);
        
            }
            
//            
            
            response.sendRedirect("http://localhost:8080/SVS_Insurance/userprofileServlet?uid="+uid+"");
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
