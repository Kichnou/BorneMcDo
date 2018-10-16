package ejb;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import entites.SousCategorie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class GestionCatalogue implements GestionCatalogueLocal {
    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Menu> SelectAllMenu(){
        TypedQuery<Menu> qr = em.createNamedQuery("entites.Menu.selectAllMenu", Menu.class);
        List<Menu> m = qr.getResultList();
        return m;
    }
    
    @Override
    public List<Categorie> SelectAllCategorie(){
        TypedQuery<Categorie> qr = em.createNamedQuery("entites.Categorie.selectAllCategorie", Categorie.class);
        List<Categorie> c = qr.getResultList();
        return c;
    }
    
    @Override
    public List<SousCategorie> SelectSousCatByCategorie(String Cat){
        TypedQuery<SousCategorie> qr = em.createNamedQuery("entites.SousCategorie.getLesSousCat", SousCategorie.class);
        qr.setParameter("paramSsCat", Cat);
        List<SousCategorie> lsc = qr.getResultList();
        return lsc;
    }

    @Override
    public List<Article> SelectArticleBySousCategorie(SousCategorie ssCat){
        TypedQuery<Article> qr = em.createNamedQuery("entites.Article.selectArticleByCategorie", Article.class);
        qr.setParameter("paramSsCat", ssCat);
        List<Article> la = qr.getResultList();
        return la;
    }
    
    @Override
    public List<SousCategorie> getSousCategorieByMenu(String idMenu){
        TypedQuery<SousCategorie> qr = em.createNamedQuery("entites.Menu.getSousCategorieByIdMenu", SousCategorie.class);
        qr.setParameter("param", Integer.valueOf(idMenu));
        List<SousCategorie> lsc = qr.getResultList();
        return lsc;
    }
    
    @Override
    public boolean isArticleSuppArt (String idArt) {
        Long id = Long.valueOf(idArt);
        Query tq = em.createQuery("select a from Article a where a.id = :paramId");
        tq.setParameter("paramId", id);
        List<Article> la = tq.getResultList();
        Article a = null;
        for (Article art : la) {
            a = art;
        }
        
        if (a.getLesSupArt().isEmpty()) {
            return false;
        }
        
        return true;
    }
    
        @Override
    public List<Article> afficheArticleByCategorie(String categorie){
        List<Article> laListe = new ArrayList<Article>();
        List<SousCategorie> lsc = SelectSousCatByCategorie(categorie);
        for (SousCategorie lsc1 : lsc) {
            List<Article> la = SelectArticleBySousCategorie(lsc1);
            for (Article la1 : la) {
                laListe.add(la1);
            }
        }
        List<Article> filtre = new ArrayList<Article>(supprimerLesDoublons(laListe));
        return filtre;                
    }
    
    @Override
    public List<Article> afficherArticleBySousCategorie(String SsCat){
       SousCategorie sousCat = new SousCategorie(SsCat);
        List<Article> la = SelectArticleBySousCategorie(sousCat);
        List<Article> filtre = new ArrayList<Article>(supprimerLesDoublons(la));
        return filtre;
    }
    
    @Override
    public List<Article> afficherArticleBySousCategorie(List<String> SsCat) {
        List<Article> laListe = new ArrayList<>();
        for (String SsCat1 : SsCat) {
            List<Article> la1 = afficherArticleBySousCategorie(SsCat1);
            for (Article ar : la1) {
                laListe.add(ar);
            }
        }
        List<Article> filtre = new ArrayList<Article>(supprimerLesDoublons(laListe));
        return filtre;
    }
    
         @Override
     public Article getArticleByid(String id){
         TypedQuery<Article> qr = em.createNamedQuery("entites.Article.getArticleById", Article.class);
         qr.setParameter("param", Integer.valueOf(id));
         Article a = qr.getSingleResult();
         return a;
     }
     
     @Override
     public Menu getMenuById(String id){
         TypedQuery<Menu> qr = em.createNamedQuery("entites.Menu.getMenuById", Menu.class);
         qr.setParameter("param", Integer.valueOf(id));
         Menu m = qr.getSingleResult();
         return m;
     }
     
     @Override
     public Long getIdMenu(String nom){
         TypedQuery<Long> qr = em.createNamedQuery("entites.Menu.getIdMenu", Long.class);
         qr.setParameter("param", nom);
        Long id = qr.getSingleResult();
        return id;
    }
     
    @Override
     public List<Article> afficherBurgerByMenu(String idMenu){
         List<Article> la = new ArrayList<>();
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU HAPPY MEAL™")) {
             List<String> ls = new ArrayList<>();
             ls.add("petit burger");
             ls.add("autre petit plat");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU BEST OF") || getMenuById(idMenu).getNom().equalsIgnoreCase("MENU MAXI BEST OF")) {
             List<String> ls = new ArrayList<>();
             ls.add("burger");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU SALADE")) {
             List<String> ls = new ArrayList<>();
             ls.add("salade");
             la = afficherArticleBySousCategorie(ls);
         }
         return la;
     }
     
    @Override
          public List<Article> afficherBoissonByMenu(String idMenu){
         List<Article> la = new ArrayList<>();
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU HAPPY MEAL™")) {
             List<String> ls = new ArrayList<>();
             ls.add("petite boisson");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU BEST OF")) {
             List<String> ls = new ArrayList<>();
             ls.add("moyenne boisson");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU MAXI BEST OF")) {
             List<String> ls = new ArrayList<>();
             ls.add("grande boisson");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU SALADE")) {
             List<String> ls = new ArrayList<>();
             ls.add("jus de fruit");
             la = afficherArticleBySousCategorie(ls);
         }
         return la;
     }
     
          
    @Override
        public List<Article> supprimerLesDoublons (List<Article> la){
            Set<Article> set = new HashSet<Article>() ;
            set.addAll(la);
            return new ArrayList<Article>(set);
        }
        
    
         @Override
          public List<Article> afficherAccompagnementByMenu(String idMenu){
         List<Article> la = new ArrayList<>();
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU HAPPY MEAL™")) {
             List<String> ls = new ArrayList<>();
             ls.add("petit accompagnement");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU BEST OF")) {
             List<String> ls = new ArrayList<>();
             ls.add("moyen accompagnement");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU MAXI BEST OF")) {
             List<String> ls = new ArrayList<>();
             ls.add("grand accompagnement");
             la = afficherArticleBySousCategorie(ls);
         }
         if (getMenuById(idMenu).getNom().equalsIgnoreCase("MENU SALADE")) {
             List<String> ls = new ArrayList<>();
             ls.add("petit accompagnement");
             la = afficherArticleBySousCategorie(ls);
         }
         return la;
     }

     
}
