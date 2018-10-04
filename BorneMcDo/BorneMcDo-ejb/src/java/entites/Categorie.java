package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Categorie.selectAllCategorie", query ="select c from Categorie c")
})
public class Categorie implements Serializable {
    @Id
    private String nom;
    private String image;
    
    @OneToMany(mappedBy = "laCategorie")
    private Collection<SousCategorie> lesSousCategories;
    

    public Categorie() {
        lesSousCategories = new ArrayList();
    }

    public Categorie(String nom) {
        this();
        this.nom = nom;
    }

    public Categorie(String nom, String image) {
        this();
        this.nom = nom;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
       
    public String getNom() {
        return nom;
    }

    public void setNom(String id) {
        this.nom = id;
    }

    public Collection<SousCategorie> getLesSousCategories() {
        return lesSousCategories;
    }

    public void setLesSousCategories(Collection<SousCategorie> lesSousCategories) {
        this.lesSousCategories = lesSousCategories;
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
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Categorie[ id=" + nom + " ]";
    }

}
