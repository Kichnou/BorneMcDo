package entites;

import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T12:18:25")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-11T11:38:39")
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, String> libelle;
    public static volatile CollectionAttribute<Status, Commande> lesCommandes;
    public static volatile SingularAttribute<Status, Long> id;

}