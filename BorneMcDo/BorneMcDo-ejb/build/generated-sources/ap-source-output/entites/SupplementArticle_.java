package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T14:28:48")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T09:56:54")
>>>>>>> 3e34e8973dcedbc85b83a2898ef7fa5ae6ba0249
@StaticMetamodel(SupplementArticle.class)
public class SupplementArticle_ { 

    public static volatile SingularAttribute<SupplementArticle, Float> prix;
    public static volatile CollectionAttribute<SupplementArticle, Article> lesArticles;
    public static volatile SingularAttribute<SupplementArticle, Long> id;
    public static volatile CollectionAttribute<SupplementArticle, Choix> lesChoix;

}