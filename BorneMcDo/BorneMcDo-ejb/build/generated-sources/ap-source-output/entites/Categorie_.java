package entites;

import entites.SousCategorie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T14:45:23")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile SingularAttribute<Categorie, String> image;
    public static volatile CollectionAttribute<Categorie, SousCategorie> lesSousCategories;
    public static volatile SingularAttribute<Categorie, String> nom;

}