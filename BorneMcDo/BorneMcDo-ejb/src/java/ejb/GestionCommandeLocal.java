package ejb;

import entites.Choix;
import entites.Commande;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionCommandeLocal {

    public void persist(Object object);

    public List<Commande> recupererCommandesEnPrep();

    public List<Choix> recupererChoixCommande(Long comId);

    public List<Choix> GetChoixBurger(List<Choix> panier);

    public List<Choix> getChoixAccomp(List<Choix> panier);

    public List<Choix> getChoixBoisson(List<Choix> panier);

    public List<Choix> getChoixDessert(List<Choix> panier);

    public List<Choix> getChoixSauce(List<Choix> panier);

    public List<Choix> getChoixSalade(List<Choix> panier);

    public List<Choix> getChoixCadeau(List<Choix> panier);

    public String genererIdCourt();

    public void creerCommande(List<Choix> lesChoix, String idCourt);
    
    
}
