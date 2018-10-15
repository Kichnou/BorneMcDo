
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

    public List<SousCategorie> SelectSousCatByCategorie(String Cat);

    public List<Article> SelectArticleBySousCategorie(SousCategorie ssCat);

    public List<SousCategorie> getSousCategorieByMenu(String idMenu);

    public boolean isArticleSuppArt(String idArt);

    public List<Article> afficheArticleByCategorie(String categorie);

    public List<Article> afficherArticleBySousCategorie(String SsCat);

    public List<Article> afficherArticleBySousCategorie(List<String> SsCat);

    public Article getArticleByid(String id);

    public Menu getMenuById(String id);

    public Long getIdMenu(String nom);

    public List<Article> afficherBurgerByMenu(String idMenu);

    public List<Article> afficherBoissonByMenu(String idMenu);

    
    
}
