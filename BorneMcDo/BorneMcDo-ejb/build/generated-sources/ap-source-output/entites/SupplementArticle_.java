package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-01T14:58:44")
@StaticMetamodel(SupplementArticle.class)
public class SupplementArticle_ { 

    public static volatile SingularAttribute<SupplementArticle, Float> prix;
    public static volatile CollectionAttribute<SupplementArticle, Article> lesArticles;
    public static volatile SingularAttribute<SupplementArticle, Long> id;
    public static volatile CollectionAttribute<SupplementArticle, Choix> lesChoix;

}