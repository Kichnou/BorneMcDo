package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Tva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float taux;
    
    @OneToMany(mappedBy = "laTva")
    private Collection<Article> lesArticles;
    @OneToMany(mappedBy = "uneTva")
    private Collection<Menu> lesMenus;

    public Tva() {
    }

    public Tva(float taux) {
        this.taux = taux;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public Collection<Article> getLesArticles() {
        return lesArticles;
    }

    public void setLesArticles(Collection<Article> lesArticles) {
        this.lesArticles = lesArticles;
    }

    public Collection<Menu> getLesMenus() {
        return lesMenus;
    }

    public void setLesMenus(Collection<Menu> lesMenus) {
        this.lesMenus = lesMenus;
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
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tva{" + "id=" + id + ", taux=" + taux + '}';
    }

    

}
