package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private float tauxTva;
    @Column(nullable = false)
    private float prix;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date livraison;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Preference unePreference;
    @OneToMany(mappedBy = "leChoix")
    private Collection<Choix> sousChoix;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Choix leChoix;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SupplementAutre unSuppAut;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Article unArticle;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Ingredient> lesIngredients;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SupplementArticle unSuppArt;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Menu unMenu;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Commande uneCommande;
    

    public Choix() {
        lesIngredients = new ArrayList();
        sousChoix = new ArrayList();
    }

    public Choix(float tauxTva, float prix) {
        this();
        this.tauxTva = tauxTva;
        this.prix = prix;
    }

    public Choix(Article unArticle) {
        this();
        this.unArticle = unArticle;
    }
    
    public Choix(float tauxTva, float prix, Date livraison) {
        this();
        this.tauxTva = tauxTva;
        this.prix = prix;
        this.livraison = livraison;
    }

    public Choix(Choix leChoix, SupplementAutre unSuppAut, Article unArticle, SupplementArticle unSuppArt) {
        this();
        this.leChoix = leChoix;
        this.unSuppAut = unSuppAut;
        this.unArticle = unArticle;
        this.unSuppArt = unSuppArt;
    }
    
    public Choix(float tauxTva,float prix, Date livraison, SupplementAutre unSuppAut, Article unArticle) {
        this();
        this.tauxTva = tauxTva;
        this.prix = prix;
        this.livraison = livraison;
        this.unSuppAut = unSuppAut;
        this.unArticle = unArticle;
        this.unMenu = unMenu;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(float tauxTva) {
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

    public Preference getUnePreference() {
        return unePreference;
    }

    public void setUnePreference(Preference unePreference) {
        this.unePreference = unePreference;
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
