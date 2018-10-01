package sousControllers;

import entites.Article;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScTestAjoutArticle implements SousController {
    //@PersistenceContext(unitName = "BorneMcDo-ejbPU")
    //private EntityManager em;
    
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/TestAjoutArticle.jsp";
        
        //TypedQuery tq = em.createQuery("select a from Article where a.nom = LE CHEESEBURGER", Article.class);
        //List<Article> la = tq.getResultList();
        
        //Article a = null;
        
        /*for (Article i : la) {
            a = i;
        }
        
        request.setAttribute("article", a);*/
        
        return url;
    }
    
}
