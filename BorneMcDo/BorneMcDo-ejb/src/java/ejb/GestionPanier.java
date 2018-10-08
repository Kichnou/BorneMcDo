package ejb;

import entites.Article;
import entites.Choix;
import entites.SupplementArticle;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionPanier implements GestionPanierLocal {

    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    private ArrayList<Choix> monPanier;

    public GestionPanier() {
        monPanier = new ArrayList<>();
    }

    @Override
    public ArrayList<Choix> getMonPanier() {
        return monPanier;
    }
    
    @Override
    public float getPrixTotal() {
        float prix = 0f;
        
        for (Choix c : monPanier) {
            prix += c.getPrix();
        }
        
        return prix;
    }

    @Override
    public void add(String article) {
        Long id = Long.valueOf(article);
        Query tq = em.createQuery("select a from Article a where a.id = :paramId");
        tq.setParameter("paramId", id);
        List<Article> la = tq.getResultList();
        Article a = null;
        for (Article art : la) {
            a = art;
        }

        Choix c = new Choix();

        c.setTauxTva(a.getLaTva().getTaux());
        c.setPrix(a.getPrix());
        c.setUnArticle(a);       

        this.getMonPanier().add(c);
    }
    
    public void addSuppArticle(String supplement) {
        Long id = Long.valueOf(supplement);
        Query tq = em.createQuery("select s from SupplementArticle s where s.id = :paramId");
        tq.setParameter("paramId", id);
        List<SupplementArticle> ls = tq.getResultList();
        SupplementArticle s = null;
        for (SupplementArticle sup : ls) {
            s = sup;
        }
        
        this.getMonPanier().get(this.getMonPanier().size() - 1).setUnSuppArt(null);
    }
}
