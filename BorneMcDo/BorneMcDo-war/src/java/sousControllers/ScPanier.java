package sousControllers;

import ejb.GestionCatalogueLocal;
import ejb.GestionPanierLocal;
import entites.Article;
import entites.Choix;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ScPanier implements SousController {

    GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();

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

        request.setAttribute("prixTotal", gestionPanier.getPrixTotal());

        if (gestionPanier.getMonPanier().isEmpty()) {
            request.setAttribute("panierVide", "Le panier est vide");
        }

        ArrayList<Article> listeArticle = new ArrayList<Article>();

        for (Choix c : gestionPanier.getMonPanier()) {
            if (c.getUnArticle() != null) {
                listeArticle.add(c.getUnArticle());
            }
        }

        request.setAttribute("listeArticle", listeArticle);

        if (request.getParameter("article") != null) {
            request.setAttribute("suppArticle", gestionCatalogue.isArticleSuppArt(request.getParameter("article")));
        }

        if (request.getParameter("article") != null) {
            System.out.println("=============> supplement article : " + gestionCatalogue.isArticleSuppArt(request.getParameter("article")));
        }

        if (request.getParameter("article") != null) {
            if (gestionCatalogue.isArticleSuppArt(request.getParameter("article"))) {
                return "/WEB-INF/SuppArticle.jsp";
            }
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

    private GestionCatalogueLocal lookupGestionCatalogueLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCatalogueLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/GestionCatalogue!ejb.GestionCatalogueLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
