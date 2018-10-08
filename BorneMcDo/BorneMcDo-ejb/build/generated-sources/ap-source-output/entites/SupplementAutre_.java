package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-08T14:47:54")
@StaticMetamodel(SupplementAutre.class)
public class SupplementAutre_ { 

    public static volatile SingularAttribute<SupplementAutre, Float> prix;
    public static volatile CollectionAttribute<SupplementAutre, Article> lesArticles;
    public static volatile SingularAttribute<SupplementAutre, Long> id;
    public static volatile SingularAttribute<SupplementAutre, String> nom;
    public static volatile CollectionAttribute<SupplementAutre, Choix> lesChoix;

}