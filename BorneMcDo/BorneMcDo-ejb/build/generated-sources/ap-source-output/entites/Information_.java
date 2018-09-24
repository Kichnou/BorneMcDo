package entites;

import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-24T16:07:01")
@StaticMetamodel(Information.class)
public class Information_ { 

    public static volatile CollectionAttribute<Information, Commande> lesCommandes;
    public static volatile SingularAttribute<Information, String> description;
    public static volatile SingularAttribute<Information, Long> id;

}