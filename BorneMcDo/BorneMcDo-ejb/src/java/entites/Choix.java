package entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Choix implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Tva tauxTva;
    @Column(nullable = false)
    private float prix;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date livraison;
    
    @ManyToMany(mappedBy = "lesChoix")
    private Collection<Preference> lesPreferences;
    @OneToMany(mappedBy = "leChoix")
    private Collection<Choix> sousChoix;
    @ManyToOne
    private Choix leChoix;
    @ManyToOne
    private SupplementAutre unSuppAut;
    @ManyToOne
    private Article unArticle;
    @ManyToMany
    private Collection<Ingredient> lesIngredients; 
    @ManyToOne
    private SupplementArticle unSuppArt;
    @ManyToOne
    private Menu unMenu;
    @ManyToOne
    private Commande uneCommande;
    

    public Choix() {
    }

    public Choix(Tva tauxTva, float prix, Date livraison) {
        this.tauxTva = tauxTva;
        this.prix = prix;
        this.livraison = livraison;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tva getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(Tva tauxTva) {
        this.tauxTva = tauxTva;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getLivraison() {
        return livraison;
    }

    public void setLivraison(Date livraison) {
        this.livraison = livraison;
    }

    public Collection<Preference> getLesPreferences() {
        return lesPreferences;
    }

    public void setLesPreferences(Collection<Preference> lesPreferences) {
        this.lesPreferences = lesPreferences;
    }



    public Collection<Choix> getSousChoix() {
        return sousChoix;
    }

    public void setSousChoix(Collection<Choix> sousChoix) {
        this.sousChoix = sousChoix;
    }

    public Choix getLeChoix() {
        return leChoix;
    }

    public void setLeChoix(Choix leChoix) {
        this.leChoix = leChoix;
    }

    public SupplementAutre getUnSuppAut() {
        return unSuppAut;
    }

    public void setUnSuppAut(SupplementAutre unSuppAut) {
        this.unSuppAut = unSuppAut;
    }

    public Article getUnArticle() {
        return unArticle;
    }

    public void setUnArticle(Article unArticle) {
        this.unArticle = unArticle;
    }

    public Collection<Ingredient> getLesIngredients() {
        return lesIngredients;
    }

    public void setLesIngredients(Collection<Ingredient> lesIngredients) {
        this.lesIngredients = lesIngredients;
    }

    public SupplementArticle getUnSuppArt() {
        return unSuppArt;
    }

    public void setUnSuppArt(SupplementArticle unSuppArt) {
        this.unSuppArt = unSuppArt;
    }

    public Menu getUnMenu() {
        return unMenu;
    }

    public void setUnMenu(Menu unMenu) {
        this.unMenu = unMenu;
    }

    public Commande getUneCommande() {
        return uneCommande;
    }

    public void setUneCommande(Commande uneCommande) {
        this.uneCommande = uneCommande;
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
        if (!(object instanceof Choix)) {
            return false;
        }
        Choix other = (Choix) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Choix n°" + id + ": Tva de " + tauxTva + "%, prix=" + prix + ", livraison=" + livraison;
    }

    

}
