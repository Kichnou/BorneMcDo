/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sousControllers;

import ejb.GestionClientLocal;
import entites.Client;
import entites.Information;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi315
 */
public class ScSaisieNumeroMembre implements SousController {
    GestionClientLocal gestionClient = lookupGestionClientLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //DBG System.out.println("DBG Vous entrâtes dans ScSaisieNumeroMembre.execute : " + Instant.now().toString());

        //Par défaut, l'utilisateur restera sur la page ci-dessous :
        String url = "/WEB-INF/SaisieNumeroMembre.jsp";

/* TRACE :
        Enumeration en=request.getParameterNames();
        while(en.hasMoreElements())
        {
                Object objOri=en.nextElement();
                String param=(String)objOri;
                String value=request.getParameter(param);
                System.out.println("DBG le paramètre : '" + param + "' vaut '" + value + "'.");
        }		
*/        
        
        //Par défaut, il n'y a pas d'erreur de saisie du numéro de membre :
        request.setAttribute("messageErreurNumeroMembreInvalide", "");            
        
        //Récupérer (sous forme de chaîne) le numéro de membre saisi par
        //l'utilisateur :
        String numeroMembreSaisi = request.getParameter("numeroMembre");
        
        //DBG System.out.println("DBG Vous saisissâtes le numéro de membre suivant : <<" + numeroMembreSaisi + ">>.");
        
        //Vérifier la validité du numéro de membre saisi :
        /*
            1°) Vérifier que le numéro de membre respecte le format indiqué
            par l'expression régulière "[1-9]+[0-9]*" :
        */
        if (numeroMembreSaisi.matches("[1-9]+[0-9]*")) {
            /*
                2°) Vérifier que le numéro de membre figure bien dans la table
                Client :
            */
            //Convertir le numéro de membre de String en Long :
            Long numeroMembreLong = 0L;
            try
            {
                numeroMembreLong = Long.parseLong(numeroMembreSaisi);
            } catch(NumberFormatException ex) {
                System.out.println("Erreur de conversion du numéro de " +
                        "membre en nombre entier : " + ex.getMessage());
            }
            
            //ATTENTION : bien respecter le nom de la "Persistence Unit Name"
            //qui est dans persistence.xml
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                    "BorneMcDo-ejbPU");
            EntityManager em = emf.createEntityManager();

            //Le client est recherché dans la table Client par son numéro de membre :
            Client clientQuiCommande = gestionClient.getClient(numeroMembreLong);
            
            //Si le client a bien été trouvé dans la table Client :
            if (clientQuiCommande != null) {
                //Récupérer la session :
                HttpSession session = request.getSession();
                
                //Récupérer des informations dans la table Information :                
                Information infoEnseigne = em.find(Information.class, "Enseigne");
                Information infoNom = em.find(Information.class, "Nom");
                
                /*
                    Affecter le Client en tant qu'attributs de la session :
                */
                session.setAttribute("client",clientQuiCommande);
                
                /*
                    Informations concernant le restaurant :
                */
                if (infoEnseigne != null) {
                    session.setAttribute("infoEnseigne",infoEnseigne.getDescription());
                }
                if (infoNom != null) {
                    session.setAttribute("infoNom",infoNom.getDescription());
                }
                //Passer à la page d'affichage du compte client :
                url = "/WEB-INF/AffichageCompteClient.jsp";
            } else {
                //Si le client n'a PAS été trouvé dans la table Client :
                request.setAttribute("messageErreurNumeroMembreInvalide",
                        "Votre numéro de membre n'existe pas.<br />" +
                        "Veuillez recommencer la saisie.");            
                /*
                    NOTA : De façon à rester sur la page actuelle, aucune
                    nouvelle valeur n'est affectée à la variable "url".
                */        
            }
        } else {
            request.setAttribute("messageErreurNumeroMembreInvalide",
                    "Le numéro de membre que vous avez saisi n'est pas " +
                    "conforme.<br />Veuillez saisir un nombre comportant " +
                    "au moins un chiffre et ne commençant pas par zéro.");            
            /*
                NOTA : De façon à rester sur la page actuelle, aucune nouvelle
                valeur n'est affectée à la variable "url".
            */        
        }
        //DBG System.out.println("DBG Nous terminâmes l'exécution de ScSaisieNumeroMembre " + Instant.now().toString());   
        //DBG System.out.println("DBG À l'issue de l'exécution de ScSaisieNumeroMembre.execute, nous essayâmes de lancer ensuite url = <<" + url + ">>.");   
        return url;
    }

    private GestionClientLocal lookupGestionClientLocal() {
        try {
            Context c = new InitialContext();
            return (GestionClientLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/GestionClient!ejb.GestionClientLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
