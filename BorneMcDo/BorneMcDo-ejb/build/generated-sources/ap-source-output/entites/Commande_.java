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
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-16T16:02:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:09:38")
>>>>>>> f1d605b9c7334bf2e35d5238f5d9feeddc8ff9e8
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