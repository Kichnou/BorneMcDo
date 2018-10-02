package entites;

import entites.Article;
import entites.Choix;
import entites.Commande;
import entites.Ingredient;
import entites.Menu;
import entites.Preference;
import entites.SupplementArticle;
import entites.SupplementAutre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T14:28:48")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T09:56:54")
>>>>>>> 3e34e8973dcedbc85b83a2898ef7fa5ae6ba0249
@StaticMetamodel(Choix.class)
public class Choix_ { 

    public static volatile SingularAttribute<Choix, Menu> unMenu;
    public static volatile SingularAttribute<Choix, Commande> uneCommande;
    public static volatile SingularAttribute<Choix, Article> unArticle;
    public static volatile SingularAttribute<Choix, Float> prix;
    public static volatile CollectionAttribute<Choix, Choix> sousChoix;
    public static volatile CollectionAttribute<Choix, Preference> lesPreferences;
    public static volatile SingularAttribute<Choix, Float> tauxTva;
    public static volatile SingularAttribute<Choix, SupplementAutre> unSuppAut;
    public static volatile SingularAttribute<Choix, SupplementArticle> unSuppArt;
    public static volatile SingularAttribute<Choix, Long> id;
    public static volatile SingularAttribute<Choix, Date> livraison;
    public static volatile SingularAttribute<Choix, Choix> leChoix;
    public static volatile CollectionAttribute<Choix, Ingredient> lesIngredients;

}