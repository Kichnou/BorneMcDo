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

        if (request.getParameter("article") != null) {
            gestionPanier.add(request.getParameter("article"));
        }

        Float prixTotal = gestionPanier.getPrixTotal();

        request.setAttribute("prixTotal", prixTotal);

        if (!gestionPanier.getMonPanier().isEmpty()) {
            List panier = gestionPanier.getMonPanier();
            System.out.println(panier);
            request.setAttribute("panier", panier);
            request.setAttribute("panierEstVide", gestionPanier.getMonPanier().isEmpty());
        } else {
            request.setAttribute("panierVide", "Votre commande est vide.");
            request.setAttribute("panierEstVide", gestionPanier.getMonPanier().isEmpty());
        }        
        
        String url = "/WEB-INF/Accueil.jsp";
        
        if ("traitement".equals(request.getParameter("part"))) {
        url = "/WEB-INF/Accueil.jsp";
        }
        
        if ("affichage".equals(request.getParameter("part"))) {
        url = "/WEB-INF/Panier.jsp";
        }

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
