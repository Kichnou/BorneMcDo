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
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroMembre;
    @Column(nullable = false, length = 70)
    private String nom;
    @Column(nullable = false, length = 70)
    private String prenom;
    private int pointsFidelite;
    
    @OneToMany(mappedBy = "unClient")
    private Collection<Commande> lesCommandes;

    public Client() {
    }

    public Client(String nom, String prenom, int pointsFidelite) {
        this.nom = nom;
        this.prenom = prenom;
        this.pointsFidelite = pointsFidelite;
    }

    

    
    
    public Long getId() {
        return numeroMembre;
    }

    public void setId(Long numeroMembre) {
        this.numeroMembre = numeroMembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setPointsFidelite(int pointsFidelite) {
        this.pointsFidelite = pointsFidelite;
    }

    public Long getNumeroMembre() {
        return numeroMembre;
    }

    public void setNumeroMembre(Long numeroMembre) {
        this.numeroMembre = numeroMembre;
    }

    public Collection<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(Collection<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMembre != null ? numeroMembre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numeroMembre == null && other.numeroMembre != null) || (this.numeroMembre != null && !this.numeroMembre.equals(other.numeroMembre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client n°" + numeroMembre + " : " + prenom + " " + nom + " pointsFidelite=" + pointsFidelite;
    }

    //Méthodes publiques pour pouvoir ajouter ou soustraire des points de
    //fidélité :
    
    public void AjouterPointsFidelite(int nombrePoints) {
        this.pointsFidelite += nombrePoints;
    }
    
    public void SoustrairePointsFidelite(int nombrePoints) throws Exception {
        if (nombrePoints > this.pointsFidelite) {
            throw new Exception("Il vous est impossible de consommer plus " +
                    "de points de fidélité que ceux dont vous disposez " +
                    "actuellement, à savoir " + this.pointsFidelite + ".");
        } else {
            this.pointsFidelite -= nombrePoints;
        }
    }

}
