package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String nom;
    @Column(length = 200)
    private String titre;
    @Column(length = 500)
    private String description;
    private String image;
    private float prix;
    
    @OneToMany(mappedBy = "unArticle")
    private Collection<InfoArticle> lesInfos;
    @ManyToMany(mappedBy = "lesArticles")
    private Collection<Preference> lesPreferences;
    @ManyToMany(mappedBy = "lesArticles")
    private Collection<SupplementAutre> lesSuppAut;
    @ManyToMany(mappedBy = "lesArticles")
    private Collection<Ingredient>lesIngredients;
    @ManyToMany(mappedBy = "lesArticles")
    private Collection<SupplementArticle>lesSupArt;
    @ManyToMany(mappedBy = "lesArticles")
    private Collection<Promotion>lesPromo;
    @ManyToOne
    private Categorie laCategorie;
    @ManyToOne
    private Tva laTva;
    @ManyToOne
    private Disponibilite laDispo;
    @OneToMany(mappedBy = "unArticle")
    private Collection<Choix>lesChoix;

    
    
    public Article() {
    }

    public Article(String nom,String titre, String description, String image, float prix) {
        this.nom = nom;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }

    public Article(String nom) {
        this.nom = nom;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Collection<InfoArticle> getLesInfos() {
        return lesInfos;
    }

    public void setLesInfos(Collection<InfoArticle> lesInfos) {
        this.lesInfos = lesInfos;
    }

    public Collection<Preference> getLesPreferences() {
        return lesPreferences;
    }

    public void setLesPreferences(Collection<Preference> lesPreferences) {
        this.lesPreferences = lesPreferences;
    }



    public Collection<SupplementAutre> getLesSuppAut() {
        return lesSuppAut;
    }

    public void setLesSuppAut(Collection<SupplementAutre> lesSuppAut) {
        this.lesSuppAut = lesSuppAut;
    }

    public Collection<Ingredient> getLesIngredients() {
        return lesIngredients;
    }

    public void setLesIngredients(Collection<Ingredient> lesIngredients) {
        this.lesIngredients = lesIngredients;
    }

    public Collection<SupplementArticle> getLesSupArt() {
        return lesSupArt;
    }

    public void setLesSupArt(Collection<SupplementArticle> lesSupArt) {
        this.lesSupArt = lesSupArt;
    }

    public Collection<Promotion> getLesPromo() {
        return lesPromo;
    }

    public void setLesPromo(Collection<Promotion> lesPromo) {
        this.lesPromo = lesPromo;
    }

    public Categorie getLaCategorie() {
        return laCategorie;
    }

    public void setLaCategorie(Categorie laCategorie) {
        this.laCategorie = laCategorie;
    }

    public Tva getLaTva() {
        return laTva;
    }

    public void setLaTva(Tva laTva) {
        this.laTva = laTva;
    }

    public Disponibilite getLaDispo() {
        return laDispo;
    }

    public void setLaDispo(Disponibilite laDispo) {
        this.laDispo = laDispo;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Article" + " n°" + id + " : " + nom + " (" + description + ") " + " " + prix + "€";
    }

    

}
