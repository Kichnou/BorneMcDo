package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Preference.SelectPrefByLibelle", query = "SELECT p FROM Preference p WHERE p.libele = :ParamPrefLib")
})
public class Preference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libele;
    
    @OneToMany(mappedBy = "unePreference")
    private Collection<Article> lesArticles;
    @OneToMany (mappedBy = "unePreference")
    private Collection<Choix> lesChoix;
    @OneToMany(mappedBy = "unePreference")
    private Collection<Commande> lesCommandes;

    public Preference() {
        lesArticles = new ArrayList();
        lesChoix = new ArrayList();
        lesCommandes = new ArrayList();
        
    }

    public Preference(String libele) {
        this();
        this.libele = libele;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
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

    public Collection<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(Collection<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
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
        if (!(object instanceof Preference)) {
            return false;
        }
        Preference other = (Preference) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Option{" + "id=" + id + ", libele=" + libele + '}';
    }

    

}
