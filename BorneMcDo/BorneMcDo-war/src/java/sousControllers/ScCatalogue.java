package sousControllers;

import ejb.GestionCatalogueLocal;
import entites.Article;
import entites.Categorie;
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
        String ref = request.getParameter("ref");
        
        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
        List<Categorie> lc = gestionCatalogue.SelectAllCategorie();
        request.setAttribute("categorie", lc);
        
        if (ref == null) {
            request.setAttribute("central", lc);
        }
        
        if(ref != null){
            String SC = "burger";
            System.out.println("ref >>>> " + ref);
            List<Article> la = gestionCatalogue.SelectArticleByCategorie(ref);
            request.setAttribute("test", la);
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
