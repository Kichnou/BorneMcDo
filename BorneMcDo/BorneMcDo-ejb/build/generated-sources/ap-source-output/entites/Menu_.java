package entites;

import entites.Choix;
import entites.Disponibilite;
import entites.InfoArticle;
import entites.Promotion;
import entites.SousCategorie;
import entites.Tva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T11:46:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:57:52")
>>>>>>> 3120b32a37c8efe98b8b7d7aa816afbfb8770e44
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> image;
    public static volatile SingularAttribute<Menu, Disponibilite> uneDispo;
    public static volatile CollectionAttribute<Menu, InfoArticle> lesInfos;
    public static volatile SingularAttribute<Menu, Float> prix;
    public static volatile CollectionAttribute<Menu, SousCategorie> lesSousCategories;
    public static volatile SingularAttribute<Menu, String> titre;
    public static volatile SingularAttribute<Menu, Tva> uneTva;
    public static volatile SingularAttribute<Menu, String> description;
    public static volatile SingularAttribute<Menu, Long> id;
    public static volatile SingularAttribute<Menu, String> nom;
    public static volatile CollectionAttribute<Menu, Choix> lesChoix;
    public static volatile CollectionAttribute<Menu, Promotion> lesPromos;

}