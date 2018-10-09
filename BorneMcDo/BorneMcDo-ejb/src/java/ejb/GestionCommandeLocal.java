package ejb;

import entites.Choix;
import entites.Commande;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionCommandeLocal {

    public void persist(Object object);

    public Commande creerCommande(ArrayList<Choix> lesChoix);

    public List<Commande> recupererCommandesEnPrep();

    public List<Choix> recupererChoixCommande(Long comId);
    
    
}
