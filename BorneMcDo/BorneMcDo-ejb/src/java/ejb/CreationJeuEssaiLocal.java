package ejb;

import entites.Preference;
import javax.ejb.Local;

@Local
public interface CreationJeuEssaiLocal {

    public void creerDonnees();

    public Preference recupererPreference(String libelle);

}
