/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sousControllers;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi315
 */
public class ScChoixPreferenceCommande implements SousController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("=====================================================");
        System.out.println("DBG Vous entrâtes dans ScChoixPreferenceCommande.execute : " + Instant.now().toString());
        
        //Par défaut, l'utilisateur restera sur la page ci-dessous :
        String url = "/WEB-INF/ChoixPreferenceCommande.jsp";
        
        if (request.getParameter("choix") != null) {
            //Si l'utilisateur a cliqué sur le bouton "Manger sur place :
            if (request.getParameter("choix").equals("MangerSurPlace")) {           
                System.out.println("DBG Vous cliquâtes sur MangerSurPlace !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + Instant.now().toString());
                //FLCàfaire : affecter un attribut de session ?
                url = "/WEB-INF/FLCàfaireSaisieNumeroMembreMiamOnPlace.jsp"; //FLCàfaire : page suivante : call "xxxxxxxxxxxxxxxxxx, càd jsp de commande développé par [yyyyyy]" en lui passant :
    /* FLCàfaire
    (via cookies ????)
    - l'ID de la préférence correspondante
    - le numéro de client => session, GetAttribute("numeroMembre")
    - ?????? utilisation des points de fidélité ???????
    */        
            } else {
                System.out.println("DBG Vous cliquâtes sur EmporterVotreCommande :-(..... " + Instant.now().toString());
                //FLCàfaire : affecter un attribut de session ?
                url = "/WEB-INF/FLCàfaireChoixPreferenceCommandeMiamElsewhere.jsp"; //FLCàfaire : page suivante : call "xxxxxxxxxxxxxxxxxx, càd jsp de commande développé par [yyyyyy]" en lui passant :
    /* FLCàfaire
    (via cookies ????)
    - l'ID de la préférence correspondante
    - le numéro de client => session, GetAttribute("numeroMembre")
    - ?????? utilisation des points de fidélité ???????
    */        
            }
        }
        System.out.println("DBG Nous terminâmes l'exécution de ScChoixPreferenceCommande " + Instant.now().toString());   
        System.out.println("DBG À l'issue de l'exécution de ScChoixPreferenceCommande.execute, nous essayâmes de lancer ensuite url = <<" + url + ">>.");   
        return url;
        
    }
    
}
