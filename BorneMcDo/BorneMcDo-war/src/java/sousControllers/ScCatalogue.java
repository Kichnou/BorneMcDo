package sousControllers;

import ejb.GestionCatalogueLocal;
import entites.Article;
import entites.Categorie;
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
    GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/Catalogue.jsp";
        String cat = request.getParameter("cat");
        String ssCat = request.getParameter("souscat");
        String idMenu = request.getParameter("menu");
        String leBurger = request.getParameter("burger");
        String boisson = request.getParameter("boisson");
        String accompagnement = request.getParameter("accompagnement");
        
        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
        List<Categorie> lc = gestionCatalogue.SelectAllCategorie();
        request.setAttribute("categorie", lc);
        
        if (cat == null) {
            request.setAttribute("central", lc);
        }
        
        if (cat != null) {
            if (cat.equalsIgnoreCase("nos burgers")) {
                SousCategorie burger = new SousCategorie("burger");
                List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(burger);
                request.setAttribute("article", la);
            }
            if (cat.equalsIgnoreCase("nos desserts")) {
                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lsc = gestionCatalogue.SelectSousCatByCategorie(cat);
                for (SousCategorie lsc1 : lsc) {
                   List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lsc1);
                    for (Article la1 : la) {
                        laListe.add(la1);
                    }
                }

                request.setAttribute("article", laListe);
            }
            if (cat.equalsIgnoreCase("nos frites et sauces")) {
                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lsc = gestionCatalogue.SelectSousCatByCategorie(cat);
                for (SousCategorie lsc1 : lsc) {
                    if ((lsc1.getNom().equalsIgnoreCase("accompagnements")) || (lsc1.getNom().equalsIgnoreCase("sauce"))) {
                        List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lsc1);
                        for (Article la1 : la) {
                            laListe.add(la1);
                        }
                    }
                }

                request.setAttribute("article", laListe);
            }
            if (cat.equalsIgnoreCase("petite faim")) {
                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lsc = gestionCatalogue.SelectSousCatByCategorie(cat);
                for (SousCategorie lsc1 : lsc) {
                    List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lsc1);
                    for (Article la1 : la) {
                        laListe.add(la1);
                    }
                }

                request.setAttribute("article", laListe);
            }
            
            if(cat.equalsIgnoreCase("nos boissons") && (ssCat == null)){
                url = "/WEB-INF/choixBoisson.jsp";     
            }
            if(cat.equalsIgnoreCase("nos boissons") && (ssCat != null)){
                url = "/WEB-INF/Catalogue.jsp";
                SousCategorie ss = new SousCategorie(ssCat);
                List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(ss);
                
                request.setAttribute("article", la);
            }
            
            if(cat.equalsIgnoreCase("nos salades")){
                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lsc = gestionCatalogue.SelectSousCatByCategorie(cat);
                for (SousCategorie lsc1 : lsc) {
                   List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lsc1);
                    for (Article la1 : la) {
                        laListe.add(la1);
                    }
                }

                request.setAttribute("article", laListe); 
            }
            
            if(cat.equalsIgnoreCase("nos menus") && idMenu == null ){
                url = "/WEB-INF/choixMenu.jsp";
                List<Menu> lm = gestionCatalogue.SelectAllMenu();
                request.setAttribute("burger", lm);
            }
            
            if (cat.equalsIgnoreCase("nos menus") && idMenu != null && leBurger == null) {
                url = "/WEB-INF/choixBurger.jsp";
                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lm = gestionCatalogue.getSousCategorieByMenu(idMenu);
                for (SousCategorie lm1 : lm) {
                    if(lm1.getNom().equalsIgnoreCase("burger") || lm1.getNom().equalsIgnoreCase("salade") || lm1.getNom().equalsIgnoreCase("petit burger") || lm1.getNom().equalsIgnoreCase("autre petit plat")){
                        List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lm1);
                        for (Article la1 : la) {
                            laListe.add(la1);
                        }
                    }  
                }
                request.setAttribute("liste", laListe);
                request.setAttribute("chemin", "cat=" + cat +"&menu=" + idMenu);
            }
            
            if (cat.equalsIgnoreCase("nos menus") && idMenu != null && leBurger != null &&boisson == null){
                url="/WEB-INF/choixBoissonMenu.jsp";
                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lm = gestionCatalogue.getSousCategorieByMenu(idMenu);
                for (SousCategorie lm1 : lm) {
                    if (lm1.getNom().equalsIgnoreCase("moyenne boisson") || lm1.getNom().equalsIgnoreCase("jus de fruit") || lm1.getNom().equalsIgnoreCase("grande boisson")) {
                        List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lm1);
                        for (Article la1 : la) {
                            laListe.add(la1);
                        }
                    }
                }
                request.setAttribute("liste", laListe);
                request.setAttribute("chemin", "cat=" + cat +"&menu=" + idMenu + "&burger=" + leBurger);
            }
            
            if (cat.equalsIgnoreCase("nos menus") && idMenu != null && leBurger != null &&boisson != null && accompagnement == null){
                url="/WEB-INF/choixAccompagnement.jsp";
                                List<Article> laListe = new ArrayList<Article>();
                List<SousCategorie> lm = gestionCatalogue.getSousCategorieByMenu(idMenu);
                for (SousCategorie lm1 : lm) {
                    if (lm1.getNom().equalsIgnoreCase("moyen accompagnement") || lm1.getNom().equalsIgnoreCase("grand accompagnement") || lm1.getNom().equalsIgnoreCase("petit accompagnement")) {
                        List<Article> la = gestionCatalogue.SelectArticleBySousCategorie(lm1);
                        for (Article la1 : la) {
                            laListe.add(la1);
                        }
                    }
                }
                request.setAttribute("liste", laListe);
                request.setAttribute("chemin", "Controller?section=ScPanier&" + "cat=" + cat +"&menu=" + idMenu + "&burger=" + leBurger);
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
    
    
    
}
