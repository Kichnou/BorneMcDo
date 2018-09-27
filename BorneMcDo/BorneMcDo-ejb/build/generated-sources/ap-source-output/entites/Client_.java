package entites;

import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T15:56:34")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T14:59:50")
>>>>>>> 4993513b4b80a9f058ab9ad1da9bdba3b024dbea
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> pointsFidelite;
    public static volatile CollectionAttribute<Client, Commande> lesCommandes;
    public static volatile SingularAttribute<Client, Long> numeroMembre;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;

}