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
    @NamedQuery(name = "entites.Article.selectArticleByCategorie", query="select a from Article a WHERE a.lesSousCategories= :paramSsCat")
})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 80, nullable = false)
    private String nom;
    @Column(length = 400)
    private String titre;
    @Column(length = 800)
    private String description;
    private String image;
    private float prix;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<InfoArticle> lesInfos;
    
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Preference unePreference;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<SupplementAutre> lesSuppAut;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Ingredient>lesIngredients;
    
    @ManyToMany(mappedBy = "lesArticles")
    private Collection<SupplementArticle>lesSupArt;
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Promotion>lesPromo;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<SousCategorie> lesSousCategories;
    
    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Tva laTva;
    
    @ManyToOne
    private Disponibilite laDispo;
    
    @OneToMany(mappedBy = "unArticle")
    private Collection<Choix>lesChoix;

    
    
    public Article() {
        lesSousCategories = new ArrayList();
        lesInfos = new ArrayList();
        lesSuppAut = new ArrayList();
        lesSupArt = new ArrayList();
        lesIngredients = new ArrayList();
        lesPromo = new ArrayList();
        lesChoix= new ArrayList();
    }

    public Article(String nom,String titre, String description, String image, float prix) {
        this();
        this.nom = nom;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }

    public Article(String nom) {
        this.nom = nom;
    }
    
    public Article(String nom, String titre) {
        this();
        this.nom = nom;
        this.titre = titre;
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

    public Preference getUnePreference() {
        return unePreference;
    }

    public void setUnePreference(Preference unePreference) {
        this.unePreference = unePreference;
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

    public Collection<SousCategorie> getLesSousCategories() {
        return lesSousCategories;
    }

    public void setLesSousCategories(Collection<SousCategorie> lesSousCategories) {
        this.lesSousCategories = lesSousCategories;
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
