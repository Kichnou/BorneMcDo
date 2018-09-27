package entites;

import entites.Article;
import entites.Menu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T15:56:34")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T14:59:50")
>>>>>>> 4993513b4b80a9f058ab9ad1da9bdba3b024dbea
@StaticMetamodel(Promotion.class)
public class Promotion_ { 

    public static volatile CollectionAttribute<Promotion, Menu> lesMenux;
    public static volatile SingularAttribute<Promotion, Date> dateDebut;
    public static volatile SingularAttribute<Promotion, String> description;
    public static volatile CollectionAttribute<Promotion, Article> lesArticles;
    public static volatile SingularAttribute<Promotion, Long> id;
    public static volatile SingularAttribute<Promotion, Float> remise;
    public static volatile SingularAttribute<Promotion, Date> dateFin;
    public static volatile SingularAttribute<Promotion, String> codePromo;
    public static volatile SingularAttribute<Promotion, String> nom;

}