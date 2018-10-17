/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sousControllers;

import java.time.Instant;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi315
 */
public class ScChoixConnexion implements SousController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //DBG System.out.println("=====================================================");
        //DBG System.out.println("DBG Vous entrâtes dans scChoixConnexion.execute : " + Instant.now().toString());
        
        //Par défaut, l'utilisateur restera sur la page ci-dessous :
        String url = "/WEB-INF/Accueil.jsp";
        
        //Si l'utilisateur a cliqué sur le bouton OUI :
        if (request.getParameter("choix").equals("Oui")) {           
            //DBG System.out.println("DBG Vous cliquâtes sur OUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + Instant.now().toString());
            url = "/WEB-INF/SaisieNumeroMembre.jsp";
        } else {
            //DBG System.out.println("DBG Vous cliquâtes sur non :-(..... " + Instant.now().toString());
            url = "/WEB-INF/Catalogue.jsp";
        }
        //DBG System.out.println("DBG Nous terminâmes l'exécution de ScChoixConnexion " + Instant.now().toString());   
        //DBG System.out.println("DBG À l'issue de l'exécution de ScChoixConnexion.execute, nous essayâmes de lancer ensuite url = <<" + url + ">>.");   
        return url;
    }
    
}









