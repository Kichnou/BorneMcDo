package ejb;

import entites.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TestAjoutCatalogue implements TestAjoutCatalogueLocal {

    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    @Override
    public Article getArticle() {
        TypedQuery<Article> tq = em.createNamedQuery("entites.Article.selectArticle", Article.class);
        tq.setParameter("paramNom", "LE CHEESEBURGER");
        List<Article> la = tq.getResultList();

        Article a = null;

        for (Article i : la) {
            a = i;
        }
        
        return a;
    }

}
