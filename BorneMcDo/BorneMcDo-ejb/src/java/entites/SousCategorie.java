package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class SousCategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;
    private String image;
    
    @ManyToMany(mappedBy = "lesSousCategories")
    private Collection<Categorie> lesCategories;
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Menu> lesMenus;

    public SousCategorie() {
        lesCategories = new ArrayList();
        lesMenus = new ArrayList();
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

    public Collection<Categorie> getLesCategories() {
        return lesCategories;
    }

    public void setLesCategories(Collection<Categorie> lesCategories) {
        this.lesCategories = lesCategories;
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
