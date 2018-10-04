package ejb;

import entites.Article;
import entites.Choix;
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

        System.out.println("TVA ====> " + a.getLaTva());
        //c.setTauxTva(a.getLaTva().getTaux());
        c.setPrix(a.getPrix());
        c.setUnArticle(a);

        this.getMonPanier().add(c);
    }
}
