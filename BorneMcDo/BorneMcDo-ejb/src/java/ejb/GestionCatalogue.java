package ejb;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import entites.SousCategorie;
import java.util.List;
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
}
