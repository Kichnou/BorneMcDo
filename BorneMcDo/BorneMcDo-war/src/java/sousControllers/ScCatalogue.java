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
import javax.servlet.http.HttpSession;

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
//        String boisson = request.getParameter("boisson");

        HttpSession session = request.getSession();

        if (session.getAttribute("articleMenu") == null) {
            ArrayList<Choix> articleMenu = new ArrayList<>();
            session.setAttribute("articleMenu", articleMenu);
        }

        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
        List<Categorie> lc = gestionCatalogue.SelectAllCategorie();
        request.setAttribute("categorie", lc);

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

            if (cat.equalsIgnoreCase("nos boissons") && (ssCat == null)) {
                url = "/WEB-INF/choixBoisson.jsp";
            }
            if (cat.equalsIgnoreCase("nos boissons") && (ssCat != null)) {
                url = "/WEB-INF/Catalogue.jsp";
                request.setAttribute("article", gestionCatalogue.afficherArticleBySousCategorie(ssCat));
            }

            if (cat.equalsIgnoreCase("nos menus") && idMenu == null) {
                url = "/WEB-INF/choix.jsp";
                request.setAttribute("liste", gestionCatalogue.SelectAllMenu());
                request.setAttribute("add", "burger");
                request.setAttribute("attribut", "menu");
                request.setAttribute("titre", "Sélectionnez votre Menu");
                request.setAttribute("cat", "nos menus");
            }

            if (cat.equalsIgnoreCase("nos menus") && ("burger").equalsIgnoreCase(request.getParameter("add"))) {
                //section pour le burger
                url = "/WEB-INF/choix.jsp";
                request.setAttribute("liste", gestionCatalogue.afficherBurgerByMenu(idMenu));
                request.setAttribute("attribut", "burger");
                request.setAttribute("add", "boisson");
                request.setAttribute("titre", "Sélectionnez votre Burger");
                request.setAttribute("cat", "nos menus");

                session.setAttribute("choixMenu", gestionPanier.addMenu(gestionCatalogue.getMenuById(idMenu)));

            }

            if (cat.equalsIgnoreCase("nos menus") && ("boisson").equalsIgnoreCase(request.getParameter("add"))) {
                //section pour la boisson
                url = "/WEB-INF/choix.jsp";
                Choix menu = (Choix) session.getAttribute("choixMenu");

                request.setAttribute("liste", gestionCatalogue.afficherBoissonByMenu(String.valueOf(menu.getUnMenu().getId())));
                request.setAttribute("attribut", "boisson");
                request.setAttribute("add", "accompagnement");
                request.setAttribute("titre", "Sélectionnez votre Boisson");
                request.setAttribute("cat", "nos menus");
                
                Choix burgerMenu = (Choix) gestionPanier.addArticleMenu(request.getParameter("burger"));
                gestionPanier.linkMenuArticle((Choix) session.getAttribute("choixMenu"), burgerMenu);
                ((ArrayList) session.getAttribute("articleMenu")).add(gestionPanier.addArticleMenu(request.getParameter("burger")));                
            
            }

            if (cat.equalsIgnoreCase("nos menus") && ("accompagnement").equalsIgnoreCase(request.getParameter("add"))) {
                //section pour les accompagnements
                url = "/WEB-INF/choix.jsp";
                Choix menu = (Choix) session.getAttribute("choixMenu");

                request.setAttribute("liste", gestionCatalogue.afficherAccompagnementByMenu(String.valueOf(menu.getUnMenu().getId())));
                request.setAttribute("attribut", "accompagnement");
                request.setAttribute("add", "sauce");
                request.setAttribute("titre", "Sélectionnez votre accompagnement");
                request.setAttribute("cat", "nos menus");
            }

            if (cat.equalsIgnoreCase("nos menus") && ("sauce").equalsIgnoreCase(request.getParameter("add"))) {
                //section pour les accompagnements
                url = "/WEB-INF/choix.jsp";
                Choix menu = (Choix) session.getAttribute("choixMenu");

                request.setAttribute("liste", gestionCatalogue.afficherArticleBySousCategorie("sauce"));
                request.setAttribute("attribut", "accompagnement");
                if (menu.getUnMenu().getNom().equalsIgnoreCase("MENU HAPPY MEAL™")) {
                    request.setAttribute("add", "cadeau");
                } else {
                    request.setAttribute("add", "autre");
                }

                request.setAttribute("titre", "Sélectionnez votre sauce");
                request.setAttribute("cat", "nos menus");
            }

            if (cat.equalsIgnoreCase("nos menus") && ("cadeau").equalsIgnoreCase(request.getParameter("add"))) {
                //section pour les cadeaux
                url = "/WEB-INF/choix.jsp";
                Choix menu = (Choix) session.getAttribute("choixMenu");

                request.setAttribute("liste", gestionCatalogue.afficherArticleBySousCategorie("cadeau"));
                request.setAttribute("attribut", "cadeau");

                request.setAttribute("add", "autre");

                request.setAttribute("titre", "Sélectionnez votre cadeau");
                request.setAttribute("cat", "nos menus");
            }

            if (cat.equalsIgnoreCase("happy meal") && idMenu == null) {
                url = "/WEB-INF/choix.jsp";
                Long id = gestionCatalogue.getIdMenu("MENU HAPPY MEAL™");
                request.setAttribute("liste", gestionCatalogue.afficherBurgerByMenu(String.valueOf(id)));
                request.setAttribute("add", "boisson");
                request.setAttribute("attribut", "burger");
                request.setAttribute("titre", "Sélectionnez votre burger");
                request.setAttribute("cat", "happy meal");
            }

            if (cat.equalsIgnoreCase("happy meal") && ("boisson").equalsIgnoreCase(request.getParameter("add"))) {
                url = "/WEB-INF/choix.jsp";
                Long id = gestionCatalogue.getIdMenu("MENU HAPPY MEAL™");
                request.setAttribute("liste", gestionCatalogue.afficherBoissonByMenu(String.valueOf(id)));
                request.setAttribute("add", "accompagnement");
                request.setAttribute("attribut", "boisson");
                request.setAttribute("titre", "Sélectionnez votre boisson");
                request.setAttribute("cat", "happy meal");
            }
            if (cat.equalsIgnoreCase("happy meal") && ("accompagnement").equalsIgnoreCase(request.getParameter("add"))) {
                url = "/WEB-INF/choix.jsp";
                Long id = gestionCatalogue.getIdMenu("MENU HAPPY MEAL™");
                request.setAttribute("liste", gestionCatalogue.afficherAccompagnementByMenu(String.valueOf(id)));
                request.setAttribute("add", "sauce");
                request.setAttribute("attribut", "accompagnement");
                request.setAttribute("titre", "Sélectionnez votre accompagnement");
                request.setAttribute("cat", "happy meal");
            }
            if (cat.equalsIgnoreCase("happy meal") && ("sauce").equalsIgnoreCase(request.getParameter("add"))) {
                url = "/WEB-INF/choix.jsp";

                request.setAttribute("liste", gestionCatalogue.afficherArticleBySousCategorie("sauce"));
                request.setAttribute("add", "cadeau");
                request.setAttribute("attribut", "sauce");
                request.setAttribute("titre", "Sélectionnez votre sauce");
                request.setAttribute("cat", "happy meal");
            }

            if (cat.equalsIgnoreCase("happy meal") && ("cadeau").equalsIgnoreCase(request.getParameter("add"))) {
                url = "/WEB-INF/choix.jsp";

                request.setAttribute("liste", gestionCatalogue.afficherArticleBySousCategorie("cadeau"));
                request.setAttribute("add", "autre");
                request.setAttribute("attribut", "cadeau");
                request.setAttribute("titre", "Sélectionnez votre cadeau");

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
