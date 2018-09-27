package ejb;

import entites.Categorie;
import entites.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GestionCatalogue implements GestionCatalogueLocal {
    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Menu> SelectAllMenu(){
        TypedQuery<Menu> qr = em.createNamedQuery("entites.Menu.selectAllMenu", Menu.class);
        List<Menu> m = qr.getResultList();
        return m;
    };
    
    @Override
    public List<Categorie> SelectAllCategorie(){
        TypedQuery<Categorie> qr = em.createNamedQuery("entites.Categorie.selectAllCategorie", Categorie.class);
        List<Categorie> c = qr.getResultList();
        return c;
    };

}
