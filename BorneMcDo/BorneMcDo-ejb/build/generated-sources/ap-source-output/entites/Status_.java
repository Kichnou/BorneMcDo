package entites;

import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T11:04:56")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, String> libelle;
    public static volatile CollectionAttribute<Status, Commande> lesCommandes;
    public static volatile SingularAttribute<Status, Long> id;

}