package sousControllers;

import ejb.GestionCatalogueLocal;
import entites.Article;
import entites.Categorie;
import entites.SousCategorie;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ScCatalogue implements SousController {
    GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/Catalogue.jsp";
        String cat = request.getParameter("ref");
        
        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
        List<Categorie> lc = gestionCatalogue.SelectAllCategorie();
        request.setAttribute("categorie", lc);
        
        if (cat == null) {
            request.setAttribute("central", lc);
        }
        
        
        
        
        return url;
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
