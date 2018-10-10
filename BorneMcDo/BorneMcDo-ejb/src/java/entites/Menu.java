package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Menu.selectAllMenu", query= "select m from Menu m"),
    @NamedQuery(name = "entites.Menu.getSousCategorieByIdMenu", query="select m.lesSousCategories from Menu m where m.id= :param")
})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(length = 500)
    private String description;
    @Column(nullable = false)
    private float prix;
    private String image;
    private String titre;
    
    @OneToMany(mappedBy = "unMenu")
    private Collection<Choix> lesChoix;
    
    @ManyToMany(mappedBy = "lesMenus")
    private Collection<Promotion> lesPromos;
    
    @ManyToMany(mappedBy = "lesMenus")
    private Collection<SousCategorie> lesSousCategories;
    
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Tva uneTva;
    
    @ManyToOne
    private Disponibilite uneDispo;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<InfoArticle> lesInfos;

    public Menu() {
        lesSousCategories = new ArrayList();
        lesChoix = new ArrayList();
        lesPromos = new ArrayList();
        lesInfos = new ArrayList();
    }

    public Menu(String nom,String titre, String description, float prix, String image) {
        this();
        this.nom = nom;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.image = image;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Choix> getLesChoix() {
        return lesChoix;
    }

    public void setLesChoix(Collection<Choix> lesChoix) {
        this.lesChoix = lesChoix;
    }

    public Collection<Promotion> getLesPromos() {
        return lesPromos;
    }

    public void setLesPromos(Collection<Promotion> lesPromos) {
        this.lesPromos = lesPromos;
    }

    public Collection<SousCategorie> getLesSousCategories() {
        return lesSousCategories;
    }

    public void setLesSousCategories(Collection<SousCategorie> lesSousCategories) {
        this.lesSousCategories = lesSousCategories;
    }

    public Tva getUneTva() {
        return uneTva;
    }

    public void setUneTva(Tva uneTva) {
        this.uneTva = uneTva;
    }

    public Disponibilite getUneDispo() {
        return uneDispo;
    }

    public void setUneDispo(Disponibilite uneDispo) {
        this.uneDispo = uneDispo;
    }

    public Collection<InfoArticle> getLesinfos() {
        return lesInfos;
    }

    public void setLesinfos(Collection<InfoArticle> lesinfos) {
        this.lesInfos = lesinfos;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu n°" + id + ": " + nom + " - " + prix + "€";
    }

    

}
