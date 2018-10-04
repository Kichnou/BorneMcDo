
package ejb;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import entites.SousCategorie;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GestionCatalogueLocal {

    public List<Menu> SelectAllMenu();

    public List<Categorie> SelectAllCategorie();

    public List<SousCategorie> SelectSousCatByCat(Categorie laCat);

    public List<Article> selectArticleByCat(List<SousCategorie> ls);
    
}
