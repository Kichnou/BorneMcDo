package entites;

import entites.Article;
import entites.Choix;
import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-16T16:02:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:09:38")
>>>>>>> f1d605b9c7334bf2e35d5238f5d9feeddc8ff9e8
@StaticMetamodel(Preference.class)
public class Preference_ { 

    public static volatile SingularAttribute<Preference, String> libele;
    public static volatile CollectionAttribute<Preference, Commande> lesCommandes;
    public static volatile CollectionAttribute<Preference, Article> lesArticles;
    public static volatile SingularAttribute<Preference, Long> id;
    public static volatile CollectionAttribute<Preference, Choix> lesChoix;

}