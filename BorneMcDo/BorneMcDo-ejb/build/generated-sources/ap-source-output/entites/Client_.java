package entites;

import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T11:46:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T16:57:52")
>>>>>>> 3120b32a37c8efe98b8b7d7aa816afbfb8770e44
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> pointsFidelite;
    public static volatile CollectionAttribute<Client, Commande> lesCommandes;
    public static volatile SingularAttribute<Client, Long> numeroMembre;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;

}