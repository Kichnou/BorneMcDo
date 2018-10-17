package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-16T16:02:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:09:38")
>>>>>>> f1d605b9c7334bf2e35d5238f5d9feeddc8ff9e8
@StaticMetamodel(SupplementAutre.class)
public class SupplementAutre_ { 

    public static volatile SingularAttribute<SupplementAutre, Float> prix;
    public static volatile CollectionAttribute<SupplementAutre, Article> lesArticles;
    public static volatile SingularAttribute<SupplementAutre, Long> id;
    public static volatile SingularAttribute<SupplementAutre, String> nom;
    public static volatile CollectionAttribute<SupplementAutre, Choix> lesChoix;

}