package ejb;

import entites.Article;
import entites.Choix;
import entites.SupplementArticle;
import entites.SupplementAutre;
import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class GestionPanier implements GestionPanierLocal {
    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    private ArrayList<Choix> monPanier;
    
    public GestionPanier() {
        monPanier = new ArrayList<>();
    }

    public ArrayList<Choix> getMonPanier() {
        return monPanier;
    }
    
    public void add(Long article) {
        Article a = em.find(Article.class, article);
        
        Choix c = new Choix();
        
        c.setTauxTva(a.getLaTva());
        c.setPrix(a.getPrix());
        
        Article articleChoix = new Article();
        
        articleChoix.setNom(a.getNom());
        articleChoix.setTitre(a.getTitre());
        articleChoix.setDescription(a.getDescription());
        articleChoix.setImage(a.getImage());
        articleChoix.setPrix(a.getPrix());
        articleChoix.setLesIngredients(a.getLesIngredients());
        articleChoix.setLaCategorie(a.getLaCategorie());
        
        
        c.setUnArticle(articleChoix);
        
        this.getMonPanier().add(c);
    }
    
    public void add(Long article, Long supplementArticle) {
        Article a = em.find(Article.class, article);
        SupplementArticle s = em.find(SupplementArticle.class, supplementArticle);
        
        Choix c = new Choix();
        
        c.setTauxTva(a.getLaTva());
        c.setPrix(a.getPrix());
        c.setUnSuppArt(s);
        
        Article articleChoix = new Article();
        
        articleChoix.setNom(a.getNom());
        articleChoix.setTitre(a.getTitre());
        articleChoix.setDescription(a.getDescription());
        articleChoix.setImage(a.getImage());
        articleChoix.setPrix(a.getPrix());
        articleChoix.setLesIngredients(a.getLesIngredients());
        articleChoix.setLaCategorie(a.getLaCategorie());
        
        
        c.setUnArticle(articleChoix);
        
        this.getMonPanier().add(c);
    }
    
    public void addSuppAutre(Long article, Long supplementArticle) {
        Article a = em.find(Article.class, article);
        SupplementAutre s = em.find(SupplementAutre.class, supplementArticle);
        
        Choix c = new Choix();
        
        c.setTauxTva(a.getLaTva());
        c.setPrix(a.getPrix());
        c.setUnSuppAut(s);
        
        Article articleChoix = new Article();
        
        articleChoix.setNom(a.getNom());
        articleChoix.setTitre(a.getTitre());
        articleChoix.setDescription(a.getDescription());
        articleChoix.setImage(a.getImage());
        articleChoix.setPrix(a.getPrix());
        articleChoix.setLesIngredients(a.getLesIngredients());
        articleChoix.setLaCategorie(a.getLaCategorie());       
        
        c.setUnArticle(articleChoix);
        
        this.getMonPanier().add(c);
    }
}
