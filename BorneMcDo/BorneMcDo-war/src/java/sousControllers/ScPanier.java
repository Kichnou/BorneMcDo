package sousControllers;

import ejb.GestionPanierLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScPanier implements SousController {

    

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GestionPanierLocal gestionPanier = lookupGestionPanierLocal();
        
        String url = "/WEB-INF/Panier.jsp";
        
        gestionPanier.add(request.getParameter("article"));
        
        List panier = gestionPanier.getMonPanier();
        request.setAttribute("panier", panier);
        
        return url;
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
