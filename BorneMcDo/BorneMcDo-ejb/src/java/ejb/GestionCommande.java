package ejb;

import entites.Choix;
import entites.Commande;
import entites.SousCategorie;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateful
public class GestionCommande implements GestionCommandeLocal {

    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public Commande creerCommande(ArrayList<Choix> lesChoix) {
        Commande com = new Commande();
        
        return com;
    }

    @Override
    public List<Commande> recupererCommandesEnPrep() {
        TypedQuery<Commande> tq = em.createNamedQuery("entites.Commande.selectCommandeEnPrepa", Commande.class);
        List<Commande> lc = tq.getResultList();
        return lc;
    }

    @Override
    public List<Choix> recupererChoixCommande(Long comId) {
        TypedQuery<Choix> tq = em.createNamedQuery("entites.Choix.selectChoixByCommande", Choix.class);
        tq.setParameter("paramChoix", comId);
        List<Choix> lch = tq.getResultList();
        return lch;
    }

    @Override
    public List<Choix> GetChoixBurger(List<Choix> panier) {
        List<Choix> panierBurger = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos burgers")) {
                    panierBurger.add(c);
                }
            }
        }
        return panierBurger;
    }

    @Override
    public List<Choix> getChoixAccomp(List<Choix> panier) {
        List<Choix> panierAccomp = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("accompagnements")) {
                    panierAccomp.add(c);
                }
            }
        }
        return panierAccomp;
    }

    @Override
    public List<Choix> getChoixBoisson(List<Choix> panier) {
        List<Choix> choixBoisson = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos boissons")) {
                    choixBoisson.add(c);
                }
            }
        }
        return choixBoisson;
    }

    @Override
    public List<Choix> getChoixDessert(List<Choix> panier) {
        List<Choix> choixDessert = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos desserts")) {
                    choixDessert.add(c);
                }
            }
        }
        return choixDessert;
    }

    @Override
    public List<Choix> getChoixSauce(List<Choix> panier) {
        List<Choix> choixSauce = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("sauce")) {
                    choixSauce.add(c);
                }
            }
        }
        return choixSauce;
    }

    @Override
    public List<Choix> getChoixSalade(List<Choix> panier) {
        List<Choix> choixSalade = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos salades")) {
                    choixSalade.add(c);
                }
            }
        }
        return choixSalade;
    }

    @Override
    public List<Choix> getChoixCadeau(List<Choix> panier) {
        List<Choix> choixCadeau = new ArrayList();
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("cadeau")) {
                    choixCadeau.add(c);
                }
            }
        }
        return choixCadeau;
    }

    public String genererIdCourt() {
        String idCourt = "CB";
        Query q = em.createNamedQuery("entites.Commande.selectMaxId");
        int id = q.getMaxResults();
        TypedQuery<Commande> tq = em.createNamedQuery("entites.Commande.SelectLastCommande", Commande.class);
        tq.setParameter("paramMaxId", id);
        Commande c = tq.getSingleResult();
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar d1 = new GregorianCalendar();
        Date d = c.getHeure();
        d1.setTime(d);
        String oldId = c.getIdentifiantCourt().substring(2);
        if (today != d1) {
            id = 0;
        } else {
            id = Integer.getInteger(oldId) + 1;
        }
        return idCourt + id;
    }
}
