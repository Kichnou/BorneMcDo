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
    public Choix add(String article) {
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
        c.setPrix(a.getPrix() + (a.getPrix() * c.getTauxTva()));
        c.setUnArticle(a);

        if (c.getUnArticle().getLesSupArt().isEmpty()) {
            this.getMonPanier().add(c);
        }
        
        return c;
    }

    @Override
    public Choix addSuppArt(String idArticle) {
        Long id = Long.valueOf(idArticle);
        Query tq = em.createQuery("select a from Article a where a.id = :paramId");
        tq.setParameter("paramId", id);
        List<Article> la = tq.getResultList();
        Article a = null;
        for (Article art : la) {
            a = art;
        }

        Choix c = new Choix();

        SupplementArticle supp = new SupplementArticle();

        supp.setUnArticle(a);
        supp.setPrix(0f);

        c.setTauxTva(a.getLaTva().getTaux());
        c.setPrix(supp.getPrix());
        c.setUnSuppArt(supp);

        return c;
    }
    
    public void ajoutMultiplePanier (List<Choix> listePanier) {
        for (Choix c : listePanier) {
            this.getMonPanier().add(c);
        }
    }
}
