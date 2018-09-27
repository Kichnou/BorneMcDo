
package ejb;

import entites.Categorie;
import entites.Menu;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GestionCatalogueLocal {

    public List<Menu> SelectAllMenu();

    public List<Categorie> SelectAllCategorie();
    
}
