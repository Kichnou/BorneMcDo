package entites;

import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:54:13")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T11:44:17")
>>>>>>> 7f326228c36ba5bf42eb6618847c19ee6cf6b58d
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, String> libelle;
    public static volatile CollectionAttribute<Status, Commande> lesCommandes;
    public static volatile SingularAttribute<Status, Long> id;

}