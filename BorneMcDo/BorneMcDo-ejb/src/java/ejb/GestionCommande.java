package ejb;

import entites.Choix;
import entites.Commande;
import entites.Preference;
import entites.SousCategorie;
import entites.Status;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void creerCommande(List<Choix> lesChoix, String idCourt, Preference p) {
        Date d = new GregorianCalendar().getTime();
        Commande com = new Commande(d, idCourt);
        TypedQuery<Status> tq = em.createNamedQuery("entites.Status.selectStatusByLibelle", Status.class);
        tq.setParameter("paramStatusLib", "en préparation");
        Status st = tq.getSingleResult();
        com.setUnStatus(st);
        com.setUnePreference(p);
        for (Choix ch : lesChoix) {
            ch.setUneCommande(com);
            em.persist(ch);
        }
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
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos burgers")) {
                    if (panierBurger.isEmpty()) {
                        panierBurger.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : panierBurger) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            panierBurger.add(c);
                        }
                    }
                }
            }
        }
        return panierBurger;
    }

    @Override
    public List<Choix> getChoixAccomp(List<Choix> panier) {
        List<Choix> panierAccomp = new ArrayList();
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("accompagnements")) {
                    if (panierAccomp.isEmpty()) {
                        panierAccomp.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : panierAccomp) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            panierAccomp.add(c);
                        }
                    }
                }
            }
        }
        return panierAccomp;
    }

    @Override
    public List<Choix> getChoixBoisson(List<Choix> panier) {
        List<Choix> choixBoisson = new ArrayList();
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos boissons")) {
                    if (choixBoisson.isEmpty()) {
                        choixBoisson.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : choixBoisson) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            choixBoisson.add(c);
                        }
                    }
                }
            }
        }
        return choixBoisson;
    }

    @Override
    public List<Choix> getChoixDessert(List<Choix> panier) {
        List<Choix> choixDessert = new ArrayList();
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos desserts")) {
                    if (choixDessert.isEmpty()) {
                        choixDessert.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : choixDessert) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            choixDessert.add(c);
                        }
                    }
                }
            }
        }
        return choixDessert;
    }

    @Override
    public List<Choix> getChoixSauce(List<Choix> panier) {
        List<Choix> choixSauce = new ArrayList();
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("sauce")) {
                    if (choixSauce.isEmpty()) {
                        choixSauce.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : choixSauce) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            choixSauce.add(c);
                        }
                    }
                }
            }
        }
        return choixSauce;
    }

    @Override
    public List<Choix> getChoixSalade(List<Choix> panier) {
        List<Choix> choixSalade = new ArrayList();
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos salades")) {
                    if (choixSalade.isEmpty()) {
                        choixSalade.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : choixSalade) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            choixSalade.add(c);
                        }
                    }
                }
            }
        }
        return choixSalade;
    }

    @Override
    public List<Choix> getChoixCadeau(List<Choix> panier) {
        List<Choix> choixCadeau = new ArrayList();
        int i;
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("cadeau")) {
                    if (choixCadeau.isEmpty()) {
                        choixCadeau.add(c);
                    } else {
                        i = 0;
                        for (Choix ch : choixCadeau) {
                            if (c == ch) {
                                i++;
                            }
                        }
                        if (i == 0) {
                            choixCadeau.add(c);
                        }
                    }
                }
            }
        }
        return choixCadeau;
    }

    @Override
    public String genererIdCourt() {
        String idCourt = "CB";
        TypedQuery<Long> q = em.createNamedQuery("entites.Commande.selectMaxId", Long.class);
        Long id = q.getSingleResult();
        TypedQuery<Commande> tq = em.createNamedQuery("entites.Commande.SelectLastCommande", Commande.class);
        tq.setParameter("paramMaxId", id);
        Commande c = tq.getSingleResult();
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar d1 = new GregorianCalendar();
        Date d = c.getHeure();
        d1.setTime(d);
        String oldId = c.getIdentifiantCourt().substring(2);
        if (today.get(Calendar.DAY_OF_MONTH) != d1.get(Calendar.DAY_OF_MONTH)) {
            id = 0L;
        } else {
            id = Long.parseLong(oldId) + 1;
        }
        if (id < 10) {
            idCourt = "CB0";
        }
        return idCourt + id;
    }
}
