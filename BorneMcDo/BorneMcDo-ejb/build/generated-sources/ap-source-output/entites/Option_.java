package entites;

import entites.Article;
import entites.Choix;
import entites.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-23T20:28:09")
@StaticMetamodel(Option.class)
public class Option_ { 

    public static volatile SingularAttribute<Option, String> libele;
    public static volatile CollectionAttribute<Option, Commande> lesCommandes;
    public static volatile CollectionAttribute<Option, Article> lesArticles;
    public static volatile SingularAttribute<Option, Long> id;
    public static volatile CollectionAttribute<Option, Choix> lesChoix;

}