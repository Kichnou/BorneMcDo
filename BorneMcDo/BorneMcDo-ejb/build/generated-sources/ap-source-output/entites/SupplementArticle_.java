package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T16:41:16")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T10:05:45")
>>>>>>> a78c4681261c9d314caf2700cc7de48f06cebd0a
@StaticMetamodel(SupplementArticle.class)
public class SupplementArticle_ { 

    public static volatile SingularAttribute<SupplementArticle, Float> prix;
    public static volatile CollectionAttribute<SupplementArticle, Article> lesArticles;
    public static volatile SingularAttribute<SupplementArticle, Long> id;
    public static volatile CollectionAttribute<SupplementArticle, Choix> lesChoix;

}