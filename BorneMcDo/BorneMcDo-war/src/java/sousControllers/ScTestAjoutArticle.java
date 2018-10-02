package sousControllers;

import ejb.TestAjoutCatalogueLocal;
import entites.Article;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScTestAjoutArticle implements SousController {    
    TestAjoutCatalogueLocal testAjoutCatalogue = lookupTestAjoutCatalogueLocal();
        
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/TestAjoutArticle.jsp";                
        
        Article a = testAjoutCatalogue.getArticle();
        
        request.setAttribute("article", a);
        
        return url;
    }

    private TestAjoutCatalogueLocal lookupTestAjoutCatalogueLocal() {
        try {
            Context c = new InitialContext();
            return (TestAjoutCatalogueLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/TestAjoutCatalogue!ejb.TestAjoutCatalogueLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
