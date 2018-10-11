package entites;

import entites.Article;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T12:18:25")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-11T11:38:39")
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
@StaticMetamodel(Disponibilite.class)
public class Disponibilite_ { 

    public static volatile CollectionAttribute<Disponibilite, Menu> lesMenus;
    public static volatile SingularAttribute<Disponibilite, String> description;
    public static volatile CollectionAttribute<Disponibilite, Article> lesArticles;
    public static volatile SingularAttribute<Disponibilite, Long> id;

}