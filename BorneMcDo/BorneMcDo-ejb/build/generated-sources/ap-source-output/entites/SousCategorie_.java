package entites;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T19:27:05")
@StaticMetamodel(SousCategorie.class)
public class SousCategorie_ { 

    public static volatile SingularAttribute<SousCategorie, String> image;
    public static volatile CollectionAttribute<SousCategorie, Categorie> lesCategories;
    public static volatile CollectionAttribute<SousCategorie, Menu> lesMenus;
    public static volatile CollectionAttribute<SousCategorie, Article> lesArticles;
    public static volatile SingularAttribute<SousCategorie, String> nom;

}