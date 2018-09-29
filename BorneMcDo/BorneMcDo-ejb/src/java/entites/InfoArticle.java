package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class InfoArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 800)
    private String description;
    @Column(length = 100)
    private String sousTitre;
    @Column(length = 100)
    private String titre;
    private String image;
    
    @ManyToMany(mappedBy = "lesInfos")
    private Collection<Article> lesArticle;
    
    @ManyToMany(mappedBy = "lesInfos")
    private Collection<Menu> lesMenus;

    public InfoArticle() {
        lesArticle = new ArrayList();
        lesMenus = new ArrayList();
    }

    public InfoArticle(String image) {
        this();
        this.image = image;
    }

    public InfoArticle(String description, String sousTitre, String titre) {
        this();
        this.description = description;
        this.sousTitre = sousTitre;
        this.titre = titre;
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

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Article> getLesArticle() {
        return lesArticle;
    }

    public void setLesArticle(Collection<Article> lesArticle) {
        this.lesArticle = lesArticle;
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
        if (!(object instanceof InfoArticle)) {
            return false;
        }
        InfoArticle other = (InfoArticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InfoArticle{" + "id=" + id + ", description=" + description + '}';
    }

    

}
