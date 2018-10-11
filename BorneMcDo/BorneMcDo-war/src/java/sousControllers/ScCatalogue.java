package sousControllers;

import ejb.GestionCatalogueLocal;
import ejb.GestionPanierLocal;
import entites.Article;
import entites.Categorie;
import entites.Choix;
import entites.Menu;
import entites.SousCategorie;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ScCatalogue implements SousController {
    GestionPanierLocal gestionPanier = lookupGestionPanierLocal();
    GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/Catalogue.jsp";
        String cat = request.getParameter("cat");
        String ssCat = request.getParameter("souscat");
        String idMenu = request.getParameter("menu");
        String burger = request.getParameter("burger");
        String etape = request.getParameter("etape");
        Menu m = new Menu();
        Choix choixMenu = new Choix();
        
        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
         List<Categorie> lc = gestionCatalogue.SelectAllCategorie();
         request.setAttribute("categorie", lc);
         
//         if(idMenu != null){
//              m = gestionCatalogue.getMenuById(idMenu);
//         }
         
         if (cat == null) {
             request.setAttribute("central", lc);
        }
        
        if (cat != null) {
            if (cat.equalsIgnoreCase("nos burgers") || cat.equalsIgnoreCase("nos desserts") || cat.equalsIgnoreCase("nos salades")) {
                request.setAttribute("article", gestionCatalogue.afficheArticleByCategorie(cat));
            }

            if (cat.equalsIgnoreCase("nos frites et sauces")) {
                List<String> ls = new ArrayList<>();
                ls.add("accompagnements");
                ls.add("sauce");

                request.setAttribute("article", gestionCatalogue.afficherArticleBySousCategorie(ls)); 
            }
            
            if (cat.equalsIgnoreCase("petite faim")) {
                request.setAttribute("article", gestionCatalogue.afficherArticleBySousCategorie(ssCat));
            }
            
            if(cat.equalsIgnoreCase("nos boissons") && (ssCat == null)){
                url = "/WEB-INF/choixBoisson.jsp";     
            }
            if(cat.equalsIgnoreCase("nos boissons") && (ssCat != null)){
                url = "/WEB-INF/Catalogue.jsp";
               request.setAttribute("article", gestionCatalogue.afficherArticleBySousCategorie(ssCat)); 
            }
            
            if(cat.equalsIgnoreCase("nos menus") && idMenu == null){
                url = "/WEB-INF/choix.jsp";
                request.setAttribute("liste", gestionCatalogue.SelectAllMenu());
                request.setAttribute("etape", "1");
                request.setAttribute("attribut", "menu");
                request.setAttribute("titre", "Sélectionnez votre Menu");
            }
           
            if(cat.equalsIgnoreCase("nos menus") && idMenu != null){
                //section pour le burger
                url = "/WEB-INF/choix.jsp";
                if(burger == null){
                    request.setAttribute("liste", gestionCatalogue.afficherBurgerByMenu(idMenu));
                    request.setAttribute("etape", "2");
                    request.setAttribute("attribut", "burger");
                    request.setAttribute("titre", "Sélectionnez votre Burger");
                    choixMenu.setUnMenu(gestionCatalogue.getMenuById(idMenu));
                }
                if(burger != null){
                    choixMenu.setUnArticle(gestionCatalogue.getArticleByid(burger));
                }
                
            }
            
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

    private GestionPanierLocal lookupGestionPanierLocal() {
        try {
            Context c = new InitialContext();
            return (GestionPanierLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/GestionPanier!ejb.GestionPanierLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
