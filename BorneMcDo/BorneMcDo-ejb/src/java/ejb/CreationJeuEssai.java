package ejb;

import entites.Article;
import java.io.File;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class CreationJeuEssai implements CreationJeuEssaiLocal {

    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    public void creerDonnees() {
        Article cheeseBurger = new Article("Cheeseburger",
                "Le « Cheese » pour les intimes", 
                "Un steak haché, une tranche de cheddar fondu, une rondelle de cornichon, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique.",
                "images/cheeseburger.png",
                1.45f);
        Article bigMac = new Article("Big Mac",
                "Le seul, l'unique", 
                "Ses deux steaks hachés, son cheddar fondu, ses oignons, ses cornichons, son lit de salade et sa sauce inimitable, font du Big Mac un burger culte et indémodable.",
                "images/big-mac.png", 
                3.45f);
        Article cbo = new Article("CBO",
                "",
                "Pain spécial aux éclats de bacon, spécialité panée au poulet, bacon, fromage fondu goût bacon au poivre, oignons préparés et frits, salade, sauce",
                "images/CBO.png",
                4.27f);
				
		Article panCakes = new Article("Pancakes",
                "",
                "Sirop confiture d'abricot, framboise, orange, miel, Nutella, beurre",
                "images/pancakes.png",
                2.64f);

        Article petitCoca = new Article("petit COCA-COLA®",
                "",
                "Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille !\n"
                + " \n"
                + "Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis !\n"
                + " \n"
                + "Coca-Cola est une marque déposée de The Coca-Cola Company.\n"
                + " \n"
                + "Valeurs nutritionnelles pour une boisson de 25cl\n"
                + " \n"
                + "Original Taste = Goût Original", 
                "images/petitCoca", 
                1.73f);
        
        Article moyenCoca = new Article("moyen COCA-COLA®",
                "",
                "Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille !\n"
                + " \n"
                + "Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis !\n"
                + " \n"
                + "Coca-Cola est une marque déposée de The Coca-Cola Company.\n"
                + " \n"
                + "Valeurs nutritionnelles pour une boisson de 40cl\n"
                + " \n"
                + "Original Taste = Goût Original", 
                "images/moyenCoca", 
                2.09f);
        
        Article grandCoca = new Article("grand COCA-COLA®",
                "",
                "Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille !\n"
                + " \n"
                + "Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis !\n"
                + " \n"
                + "Coca-Cola est une marque déposée de The Coca-Cola Company.\n"
                + " \n"
                + "Valeurs nutritionnelles pour une boisson de 50cl\n"
                + " \n"
                + "Original Taste = Goût Original", 
                "images/grandCoca", 
                2.55f);
        
        
        
        
        em.persist(cheeseBurger);
        em.persist(bigMac);
        em.persist(cbo);
        em.persist(panCakes);
        em.persist(petitCoca);
        em.persist(moyenCoca);
        em.persist(grandCoca);

    }

}
