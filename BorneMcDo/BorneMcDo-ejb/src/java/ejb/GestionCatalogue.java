package ejb;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import entites.SousCategorie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    };
    
    @Override
    public List<Categorie> SelectAllCategorie(){
        TypedQuery<Categorie> qr = em.createNamedQuery("entites.Categorie.selectAllCategorie", Categorie.class);
        List<Categorie> c = qr.getResultList();
        return c;
    };
    
    @Override
    public List<SousCategorie> SelectSousCatByCat(Categorie laCat){
        TypedQuery<SousCategorie> tq = em.createNamedQuery("entites.SousCategorie.getLesSousCat", SousCategorie.class);
        tq.setParameter("paramSsCat", laCat);
        List<SousCategorie> ls = tq.getResultList();
        return ls;
    };
    
    @Override
    public List<Article> selectArticleByCat (List<SousCategorie> ls){
        List<Article> listA = new ArrayList();
        for (SousCategorie sc : ls) {
            TypedQuery<Article> tq = em.createNamedQuery("entites.Article.selectArticleByCategorie", Article.class);
            tq.setParameter("paramCategorie", sc);
            List<Article> la = tq.getResultList();
            listA.addAll(la);
        }
        return listA;
    };

}
