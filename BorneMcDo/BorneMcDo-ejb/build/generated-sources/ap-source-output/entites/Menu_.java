package entites;

import entites.Categorie;
import entites.Choix;
import entites.Disponibilite;
import entites.Promotion;
import entites.Tva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-25T12:12:24")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> image;
    public static volatile SingularAttribute<Menu, Disponibilite> uneDispo;
    public static volatile CollectionAttribute<Menu, Categorie> lesCategories;
    public static volatile SingularAttribute<Menu, Float> prix;
    public static volatile SingularAttribute<Menu, Tva> uneTva;
    public static volatile SingularAttribute<Menu, String> description;
    public static volatile SingularAttribute<Menu, Long> id;
    public static volatile SingularAttribute<Menu, String> nom;
    public static volatile CollectionAttribute<Menu, Choix> lesChoix;
    public static volatile CollectionAttribute<Menu, Promotion> lesPromos;

}