package ejb;

import entites.Choix;
import entites.Commande;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Commande creerCommande(ArrayList<Choix> lesChoix){
        Commande com = new Commande();
        
        
        return com;
    }
    
    @Override
    public List<Commande> recupererCommandesEnPrep(){
        TypedQuery<Commande> tq = em.createNamedQuery("entites.Commande.selectCommandeEnPrepa", Commande.class);
        List<Commande> lc = tq.getResultList();   
        return lc;
    }
    
    @Override
    public List<Choix> recupererChoixCommande(Long comId){
        TypedQuery<Choix> tq = em.createNamedQuery("entites.Choix.selectChoixByCommande", Choix.class);
        tq.setParameter("paramChoix", comId);
        List<Choix> lch = tq.getResultList();
        return lch;
    }

    
}
