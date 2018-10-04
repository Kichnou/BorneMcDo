package ejb;

import entites.Choix;
import entites.Commande;
import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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

    
}
