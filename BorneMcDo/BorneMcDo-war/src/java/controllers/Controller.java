package controllers;

import sousControllers.SousController;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    
    HashMap<String, SousController> map;
    
    @Override
    public void init() throws ServletException {
        super.init();
        
        map = new HashMap();
        for (Enumeration<String> e = this.getInitParameterNames();
                e.hasMoreElements();) {
            String name = e.nextElement();
            String value = this.getInitParameter(name);
            try {
                SousController s = (SousController) Class.forName(value).newInstance();
                map.put(name, s);
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFound>>>>" + ex.getMessage());
            } catch (InstantiationException ex) {
                System.out.println("Instantiation>>>>" + ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccess>>>>" + ex.getMessage());
            }
        }  
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String url = "/WEB-INF/Accueil.jsp";
        String section = request.getParameter("section");
        
        if (section != null) {
            if (map.containsKey(section)) {
                SousController s = map.get(section);
                url = s.execute(request, response);
            }
        }
        
        request.getRequestDispatcher(url).include(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
