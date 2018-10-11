package entites;

import entites.Article;
import entites.Choix;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T12:18:25")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-11T11:38:39")
>>>>>>> de69781f9865392e51f64723d7aeb39f594fd234
@StaticMetamodel(Ingredient.class)
public class Ingredient_ { 

    public static volatile CollectionAttribute<Ingredient, Article> lesArticles;
    public static volatile SingularAttribute<Ingredient, String> nom;
    public static volatile CollectionAttribute<Ingredient, Choix> lesChoix;

}