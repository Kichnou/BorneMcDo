package sousControllers;

import ejb.CreationJeuEssaiLocal;
import entites.Preference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ScAccueil implements SousController {
    CreationJeuEssaiLocal creationJeuEssai = lookupCreationJeuEssaiLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/PrefSurPlace.jsp";
        HttpSession session = request.getSession();
        String ref = request.getParameter("ref");
        
        if (ref == null) {
            url = "/WEB-INF/PrefSurPlace.jsp";
        }
        if ("create".equals(ref)) {
            creationJeuEssai.creerDonnees();
            request.setAttribute("message", "donnée OK");
        }
        
        if ("surPlace".equals(ref)) {
            url = "/WEB-INF/Accueil.jsp";
            Preference p = creationJeuEssai.recupererPreference("sur place");
            session.setAttribute("prefConso", p);
        }
        
        if ("aEmporter".equals(ref)) {
            url = "/WEB-INF/Accueil.jsp";
            Preference p = creationJeuEssai.recupererPreference("a emporter");
            session.setAttribute("prefConso", p);
        }
        return url;
    }

    private CreationJeuEssaiLocal lookupCreationJeuEssaiLocal() {
        try {
            Context c = new InitialContext();
            return (CreationJeuEssaiLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/CreationJeuEssai!ejb.CreationJeuEssaiLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
