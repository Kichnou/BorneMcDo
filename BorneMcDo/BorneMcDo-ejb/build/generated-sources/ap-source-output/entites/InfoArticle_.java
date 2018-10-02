package entites;

import entites.Article;
import entites.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T14:28:48")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-02T09:56:54")
>>>>>>> 3e34e8973dcedbc85b83a2898ef7fa5ae6ba0249
@StaticMetamodel(InfoArticle.class)
public class InfoArticle_ { 

    public static volatile SingularAttribute<InfoArticle, String> image;
    public static volatile CollectionAttribute<InfoArticle, Menu> lesMenus;
    public static volatile SingularAttribute<InfoArticle, String> titre;
    public static volatile CollectionAttribute<InfoArticle, Article> lesArticle;
    public static volatile SingularAttribute<InfoArticle, String> description;
    public static volatile SingularAttribute<InfoArticle, Long> id;
    public static volatile SingularAttribute<InfoArticle, String> sousTitre;

}