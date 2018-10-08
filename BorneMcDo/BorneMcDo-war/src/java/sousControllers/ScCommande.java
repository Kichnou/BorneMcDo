package sousControllers;

import ejb.GestionCommandeLocal;
import entites.Commande;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScCommande implements SousController {

    GestionCommandeLocal gestionCommande = lookupGestionCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/ConfCommande.jsp";
        GestionCommandeLocal command = lookupGestionCommandeLocal();
        List<Commande> lc = command.recupererCommandesEnPrep();
        
        List<Choix> lch = command.recupererChoixCommande(ID)
        request.setAttribute("comEnPrepa", lc);
        String ref = request.getParameter("ref");
        if (ref == null) {
            url = "/WEB-INF/ConfCommande.jsp";
        }
        if ("conf".equals(ref)) {
            url = "/WEB-INF/CommandeOk.jsp";
        }
        if ("cancel".equals(ref)) {
            url = "/WEB-INF/Catalogue.jsp";
        }
        if ("quit".equals(ref)) {
            url = "/WEB-INF/Accueil.jsp";
        }
        if ("control".equals(ref)) {
            url = "/WEB-INF/EcranBack.jsp";
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
