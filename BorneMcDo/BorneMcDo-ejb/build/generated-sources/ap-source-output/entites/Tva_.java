package entites;

import entites.Article;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T11:46:30")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:57:52")
>>>>>>> 3120b32a37c8efe98b8b7d7aa816afbfb8770e44
@StaticMetamodel(Tva.class)
public class Tva_ { 

    public static volatile CollectionAttribute<Tva, Menu> lesMenus;
    public static volatile SingularAttribute<Tva, Float> taux;
    public static volatile CollectionAttribute<Tva, Article> lesArticles;
    public static volatile SingularAttribute<Tva, Long> id;

}