package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:35:02")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T10:27:14")
>>>>>>> 301cf6071ebed4bc1ccbaec8437af2ffaf203baf
@StaticMetamodel(Ingredient.class)
public class Ingredient_ { 

    public static volatile CollectionAttribute<Ingredient, Article> lesArticles;
    public static volatile SingularAttribute<Ingredient, String> nom;
    public static volatile CollectionAttribute<Ingredient, Choix> lesChoix;

}