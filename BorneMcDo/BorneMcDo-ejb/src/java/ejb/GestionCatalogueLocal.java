
package ejb;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GestionCatalogueLocal {

    public List<Menu> SelectAllMenu();

    public List<Categorie> SelectAllCategorie();

    public List<Article> SelectArticleByCategorie(String refCategorie);
    
}
