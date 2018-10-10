package entites;

import entites.Article;
import entites.Menu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T11:46:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:57:52")
>>>>>>> 3120b32a37c8efe98b8b7d7aa816afbfb8770e44
@StaticMetamodel(Promotion.class)
public class Promotion_ { 

    public static volatile SingularAttribute<Promotion, String> image;
    public static volatile CollectionAttribute<Promotion, Menu> lesMenus;
    public static volatile SingularAttribute<Promotion, Date> dateDebut;
    public static volatile SingularAttribute<Promotion, String> description;
    public static volatile CollectionAttribute<Promotion, Article> lesArticles;
    public static volatile SingularAttribute<Promotion, Long> id;
    public static volatile SingularAttribute<Promotion, Float> remise;
    public static volatile SingularAttribute<Promotion, Date> dateFin;
    public static volatile SingularAttribute<Promotion, String> codePromo;
    public static volatile SingularAttribute<Promotion, String> nom;

}