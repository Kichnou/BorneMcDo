package entites;

import entites.Choix;
import entites.Client;
import entites.Information;
import entites.Preference;
import entites.Status;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:54:13")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T11:44:17")
>>>>>>> 7f326228c36ba5bf42eb6618847c19ee6cf6b58d
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Date> heure;
    public static volatile SingularAttribute<Commande, Status> unStatus;
    public static volatile CollectionAttribute<Commande, Information> lesInfos;
    public static volatile SingularAttribute<Commande, Preference> unePreference;
    public static volatile SingularAttribute<Commande, Client> unClient;
    public static volatile SingularAttribute<Commande, Long> id;
    public static volatile SingularAttribute<Commande, String> identifiantCourt;
    public static volatile CollectionAttribute<Commande, Choix> lesChoix;

}