package ejb;

import entites.Choix;
import entites.Commande;
<<<<<<< HEAD
=======
import entites.Preference;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
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

<<<<<<< HEAD
    
    @Override
    public void creerCommande(List<Choix> lesChoix, String idCourt) {
        Date d = new GregorianCalendar().getTime();
        Commande com = new Commande(d, idCourt);
        TypedQuery<Status> tq = em.createNamedQuery("selectStatusByLibelle", Status.class);
        tq.setParameter("paramStatusLib", "en préparation");
        Status st = tq.getSingleResult();
        com.setUnStatus(st);
=======
    @Override
    public void creerCommande(List<Choix> lesChoix, String idCourt, Preference p) {
        Date d = new GregorianCalendar().getTime();
        Commande com = new Commande(d, idCourt);
        TypedQuery<Status> tq = em.createNamedQuery("entites.Status.selectStatusByLibelle", Status.class);
        tq.setParameter("paramStatusLib", "en préparation");
        Status st = tq.getSingleResult();
        com.setUnStatus(st);
        com.setUnePreference(p);
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
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
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos burgers")) {
<<<<<<< HEAD
                    panierBurger.add(c);
=======
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

>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
                }
            }
        }
        return panierBurger;
    }

    @Override
    public List<Choix> getChoixAccomp(List<Choix> panier) {
        List<Choix> panierAccomp = new ArrayList();
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("accompagnements")) {
<<<<<<< HEAD
                    panierAccomp.add(c);
=======
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
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
                }
            }
        }
        return panierAccomp;
    }

    @Override
    public List<Choix> getChoixBoisson(List<Choix> panier) {
        List<Choix> choixBoisson = new ArrayList();
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos boissons")) {
<<<<<<< HEAD
                    choixBoisson.add(c);
=======
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
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
                }
            }
        }
        return choixBoisson;
    }

    @Override
    public List<Choix> getChoixDessert(List<Choix> panier) {
        List<Choix> choixDessert = new ArrayList();
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos desserts")) {
<<<<<<< HEAD
                    choixDessert.add(c);
=======
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
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
                }
            }
        }
        return choixDessert;
    }

    @Override
    public List<Choix> getChoixSauce(List<Choix> panier) {
        List<Choix> choixSauce = new ArrayList();
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("sauce")) {
<<<<<<< HEAD
                    choixSauce.add(c);
=======
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
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
                }
            }
        }
        return choixSauce;
    }

    @Override
    public List<Choix> getChoixSalade(List<Choix> panier) {
        List<Choix> choixSalade = new ArrayList();
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getLaCategorie().getNom().equals("nos salades")) {
<<<<<<< HEAD
                    choixSalade.add(c);
=======
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
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
                }
            }
        }
        return choixSalade;
    }

    @Override
    public List<Choix> getChoixCadeau(List<Choix> panier) {
        List<Choix> choixCadeau = new ArrayList();
<<<<<<< HEAD
=======
        int i;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        for (Choix c : panier) {
            List<SousCategorie> lsc = (List<SousCategorie>) c.getUnArticle().getLesSousCategories();
            for (SousCategorie sc : lsc) {
                if (sc.getNom().equals("cadeau")) {
<<<<<<< HEAD
                    choixCadeau.add(c);
=======
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
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
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
<<<<<<< HEAD
        if (today.get(Calendar.DAY_OF_MONTH)!= d1.get(Calendar.DAY_OF_MONTH)) {
            System.out.println("today = "+ today.get(Calendar.DAY_OF_MONTH) + " d1 = " + d1.get(Calendar.DAY_OF_MONTH) + " >>>>>>>>>>>>>>>>> le jour a changé :");
            id = 0L;
            System.out.println("id = " + id);
        } else {
            id = Long.parseLong(oldId)+1;
            System.out.println("today = "+ today.get(Calendar.DAY_OF_MONTH) + " d1 = " + d1.get(Calendar.DAY_OF_MONTH) + " >!>!>!>!>!>!>!>!> le jour n'a pas changé!! id = " + id);
=======
        if (today.get(Calendar.DAY_OF_MONTH) != d1.get(Calendar.DAY_OF_MONTH)) {
            id = 0L;
        } else {
            id = Long.parseLong(oldId) + 1;
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
        }
        if (id < 10) {
            idCourt = "CB0";
        }
        return idCourt + id;
    }
}
