package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class SupplementAutre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nom;
    private float prix;
    
    @ManyToMany
    private Collection<Article> lesArticles;
    @OneToMany(mappedBy = "unSuppAut")
    private Collection<Choix> lesChoix;

    public SupplementAutre() {
    }

    public SupplementAutre(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof SupplementAutre)) {
            return false;
        }
        SupplementAutre other = (SupplementAutre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SupplementAutre n°" + id + ": " + nom + " - " + prix + "€";
    }

    

}
