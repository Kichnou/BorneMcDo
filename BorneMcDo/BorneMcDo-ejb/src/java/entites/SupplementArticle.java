package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class SupplementArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float prix;
    
    @ManyToMany
    private Collection<Article> lesArticles;
    @OneToMany(mappedBy = "unSuppArt")
    private Collection<Choix> lesChoix;

    public SupplementArticle() {
    }

    public SupplementArticle(float prix) {
        this.prix = prix;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Collection<Article> getLesArticles() {
        return lesArticles;
    }

    public void setLesArticles(Collection<Article> lesArticles) {
        this.lesArticles = lesArticles;
    }

    public Collection<Choix> getLesChoix() {
        return lesChoix;
    }

    public void setLesChoix(Collection<Choix> lesChoix) {
        this.lesChoix = lesChoix;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplementArticle)) {
            return false;
        }
        SupplementArticle other = (SupplementArticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SupplementArticle{" + "id=" + id + ", prix=" + prix + '}';
    }

    

}
