package entites;

import entites.Article;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:54:13")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T11:44:17")
>>>>>>> 7f326228c36ba5bf42eb6618847c19ee6cf6b58d
@StaticMetamodel(Disponibilite.class)
public class Disponibilite_ { 

    public static volatile CollectionAttribute<Disponibilite, Menu> lesMenus;
    public static volatile SingularAttribute<Disponibilite, String> description;
    public static volatile CollectionAttribute<Disponibilite, Article> lesArticles;
    public static volatile SingularAttribute<Disponibilite, Long> id;

}