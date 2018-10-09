package sousControllers;

import ejb.GestionPanierLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ScPanier implements SousController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        GestionPanierLocal gestionPanier;
        
        if (session.getAttribute("panier") != null) {
            gestionPanier = (GestionPanierLocal) session.getAttribute("panier");
        } else {
        gestionPanier = lookupGestionPanierLocal();
        session.setAttribute("panier", gestionPanier);
        }        

        if (gestionPanier.getMonPanier().isEmpty()) {
            
        }
        
        if (request.getParameter("article") != null) {
            gestionPanier.add(request.getParameter("article"));
        }

        Float prixTotal = gestionPanier.getPrixTotal();

        request.setAttribute("prixTotal", prixTotal);

        PrintWriter out;
        try {
            out = response.getWriter();
            
            out.println("coucou");
        } catch (IOException ex) {
            Logger.getLogger(ScPanier.class.getName()).log(Level.SEVERE, null, ex);
        }                
        
        return "/WEB-INF/Panier.jsp";
    }

    private GestionPanierLocal lookupGestionPanierLocal() {
        try {
            Context c = new InitialContext();
            return (GestionPanierLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/GestionPanier!ejb.GestionPanierLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
