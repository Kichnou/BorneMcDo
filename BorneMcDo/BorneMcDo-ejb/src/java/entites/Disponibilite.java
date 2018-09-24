package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Disponibilite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String description;
    
    @OneToMany(mappedBy = "laDispo")
    private Collection<Article> lesArticles;
    @OneToMany(mappedBy = "uneDispo")
    private Collection<Menu> lesMenus;
    

    public Disponibilite() {
    }

    public Disponibilite(String description) {
        this.description = description;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Disponibilite)) {
            return false;
        }
        Disponibilite other = (Disponibilite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disponibilite{" + "id=" + id + ", description=" + description + '}';
    }

    

}
