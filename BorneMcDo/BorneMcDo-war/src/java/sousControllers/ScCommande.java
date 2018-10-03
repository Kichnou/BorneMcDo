package sousControllers;

import ejb.GestionCommandeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScCommande implements SousController{
    GestionCommandeLocal gestionCommande = lookupGestionCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/CommandeOk.jsp";
        GestionCommandeLocal command = lookupGestionCommandeLocal();
        if (request.getParameter("doQuit") != null) {
            url = "/WEB-INF/Accueil.jsp";
        }
        
        return url;
    }

    private GestionCommandeLocal lookupGestionCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCommandeLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/GestionCommande!ejb.GestionCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
