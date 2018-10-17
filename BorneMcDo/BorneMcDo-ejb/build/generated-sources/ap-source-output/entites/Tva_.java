package entites;

import entites.Article;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:27:14")
@StaticMetamodel(Tva.class)
public class Tva_ { 

    public static volatile CollectionAttribute<Tva, Menu> lesMenus;
    public static volatile SingularAttribute<Tva, Float> taux;
    public static volatile CollectionAttribute<Tva, Article> lesArticles;
    public static volatile SingularAttribute<Tva, Long> id;

}