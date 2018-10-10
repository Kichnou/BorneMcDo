package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = "entites.SousCategorie.getLesSousCat", query="select s from SousCategorie s where s.laCategorie.nom= :paramSsCat")    
})
public class SousCategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;
    private String image;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Categorie laCategorie;
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Menu> lesMenus;
    
    @ManyToMany (mappedBy = "lesSousCategories")
    private Collection<Article> lesArticles;

    public SousCategorie() {
        lesMenus = new ArrayList();
        lesArticles = new ArrayList();
    }

    public SousCategorie(String nom) {
        this();
        this.nom = nom;
    }
    
    

    public SousCategorie(String nom, String image) {
        this();
        this.nom = nom;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categorie getLaCategorie() {
        return laCategorie;
    }

    public void setLaCategorie(Categorie laCategorie) {
        this.laCategorie = laCategorie;
    }

    public Collection<Menu> getLesMenus() {
        return lesMenus;
    }

    public void setLesMenus(Collection<Menu> lesMenus) {
        this.lesMenus = lesMenus;
    }

    public Collection<Article> getLesArticles() {
        return lesArticles;
    }

    public void setLesArticles(Collection<Article> lesArticles) {
        this.lesArticles = lesArticles;
    }

    

    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCategorie)) {
            return false;
        }
        SousCategorie other = (SousCategorie) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.sousCategorie[ nom=" + nom + " ]";
    }

}
