package entites;

import entites.Article;
import entites.Categorie;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T09:56:54")
@StaticMetamodel(SousCategorie.class)
public class SousCategorie_ { 

    public static volatile SingularAttribute<SousCategorie, String> image;
    public static volatile SingularAttribute<SousCategorie, Categorie> laCategorie;
    public static volatile CollectionAttribute<SousCategorie, Menu> lesMenus;
    public static volatile CollectionAttribute<SousCategorie, Article> lesArticles;
    public static volatile SingularAttribute<SousCategorie, String> nom;

}