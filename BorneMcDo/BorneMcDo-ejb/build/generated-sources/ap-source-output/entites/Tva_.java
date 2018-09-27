package entites;

import entites.Article;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T15:56:34")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T14:59:50")
>>>>>>> 4993513b4b80a9f058ab9ad1da9bdba3b024dbea
@StaticMetamodel(Tva.class)
public class Tva_ { 

    public static volatile CollectionAttribute<Tva, Menu> lesMenus;
    public static volatile SingularAttribute<Tva, Float> taux;
    public static volatile CollectionAttribute<Tva, Article> lesArticles;
    public static volatile SingularAttribute<Tva, Long> id;

}