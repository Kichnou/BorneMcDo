package ejb;

import entites.Article;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class CreationJeuEssai implements CreationJeuEssaiLocal {

    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    public void creerDonnees() {
        Article cheeseBurger = new Article("LE CHEESEBURGER",
                "Le « Cheese » pour les intimes",
                "Un steak haché, une tranche de cheddar fondu, une rondelle de cornichon, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique.",
                "images/cheeseburger.png",
                1.45f);
        Article bigMac = new Article("LE BIG MAC™",
                "Le seul, l'unique",
                "Ses deux steaks hachés, son cheddar fondu, ses oignons, ses cornichons, son lit de salade et sa sauce inimitable, font du Big Mac un burger culte et indémodable.",
                "images/big-mac.png",
                3.45f);
        Article cbo = new Article("LE CBO™",
                "",
                "Pain spécial aux éclats de bacon, spécialité panée au poulet, bacon, fromage fondu goût bacon au poivre, oignons préparés et frits, salade, sauce",
                "images/CBO.png",
                4.27f);

        Article panCakes = new Article("LES PANCAKES",
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
                + "Original Taste = Goût Original",
                "images/petitCoca.png",
                1.73f);

        Article moyenCoca = new Article("moyen COCA-COLA®",
                "",
                "Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille !\n"
                + " \n"
                + "Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis !\n"
                + " \n"
                + "Coca-Cola est une marque déposée de The Coca-Cola Company.\n"
                + " \n"
                + "Original Taste = Goût Original",
                "images/moyenCoca.png",
                2.09f);

        Article grandCoca = new Article("grand COCA-COLA®",
                "",
                "Avec sa recette authentique et son goût unique, Coca-Cola Original Taste nous procure plaisir, rafraîchissement et nous donne au quotidien une énergie positive incomparable... Coca-Cola Original Taste, c'est du bonheur en bouteille !\n"
                + " \n"
                + "Rendez-vous chez McDonald's pour redécouvrir le goût original et rafraîchissant de cette boisson unique et vivre un moment de convivialité entre amis !\n"
                + " \n"
                + "Coca-Cola est une marque déposée de The Coca-Cola Company.\n"
                + " \n"
                + "Original Taste = Goût Original",
                "images/grandCoca.png",
                2.55f);

        Article petitFanta = new Article("petit FANTA®",
                "",
                "Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! \n"
                + "Fanta Orange contient du jus d'orange et des arômes naturels."
                + " \n"
                + "Fanta est une marque déposée de The Coca-Cola Company.",
                "images/petitFanta.png",
                1.73f);

        Article moyenFanta = new Article("moyen FANTA®",
                "",
                "Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! \n"
                + "Fanta Orange contient du jus d'orange et des arômes naturels."
                + " \n"
                + "Fanta est une marque déposée de The Coca-Cola Company.",
                "images/moyenFanta.png",
                2.09f);

        Article grandFanta = new Article("grand FANTA®",
                "",
                "Profitez d'un moment de plaisir en famille chez McDonald's pour découvrir ou redécouvrir le goût unique si fruité et délicieux de Fanta Orange ! \n"
                + "Fanta Orange contient du jus d'orange et des arômes naturels."
                + " \n"
                + "Fanta est une marque déposée de The Coca-Cola Company.",
                "images/grandFanta.png",
                2.55f);

        Article petitSprite = new Article("petit SPRITE ZERO®",
                "Plus qu'une boisson, un frisson !",
                "Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre !\n"
                + " \n"
                + "Sprite, born to refresh !*"
                + "*Créé pour rafraichir !\n"
                + "Sprite zero est une marque déposée de The Coca-Cola Company.",
                "images/petitSprite.png",
                1.73f);

        Article moyenSprite = new Article("moyen SPRITE ZERO®",
                "Plus qu'une boisson, un frisson !",
                "Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre !\n"
                + " \n"
                + "Sprite, born to refresh !*"
                + "*Créé pour rafraichir !\n"
                + "Sprite zero est une marque déposée de The Coca-Cola Company.",
                "images/moyenSprite.png",
                2.09f);

        Article grandSprite = new Article("grand SPRITE ZERO®",
                "Plus qu'une boisson, un frisson !",
                "Vivez l'expérience Sprite zero chez McDonald's et redécouvrez le goût unique de la célèbre boisson rafraîchissante aux arômes naturels de citron et citron vert, maintenant sans sucre !\n"
                + " \n"
                + "Sprite, born to refresh !*"
                + "*Créé pour rafraichir !\n"
                + "Sprite zero est une marque déposée de The Coca-Cola Company.",
                "images/grandSprite.png",
                2.55f);

        Article expresso = new Article("L'EXPRESSO",
                "Pour se réveiller, rien de tel qu'un EXPRESSO.",
                "Une jolie mousse. Un goût intense. Profitez de sa richesse et de ses arômes dès les premières lueurs de la journée. Notre café Segafredo, à l'exception de notre café décaféiné, est 100% Arabica, fraîchement moulu et issu de fermes vérifiées Rainforest Alliance.",
                "images/expresso.png",
                1.25f);

        Article cappuccino = new Article("LE CAPPUCCINO",
                "Une véritable recette à l'italienne.",
                "Sous une mousse de lait chaud, toute la puissance et l'arôme d'un expresso mélangé à une touche de lait.",
                "images/cappuccino.png",
                2.08f);

        Article nuggets4 = new Article("LES CHICKEN McNUGGETS™",
                "À déguster seul ou accompagné",
                "Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir !\n"
                + "\n"
                + "Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™.", 
                "images/nuggets.png", 
                2.58f);
        Article nuggets6 = new Article("LES CHICKEN McNUGGETS™",
                "À déguster seul ou accompagné",
                "Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir !\n"
                + "\n"
                + "Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™.", 
                "images/nuggets.png", 
                3.5f);
        Article nuggets9 = new Article("LES CHICKEN McNUGGETS™",
                "À déguster seul ou accompagné",
                "Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir !\n"
                + "\n"
                + "Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™.", 
                "images/nuggets.png", 
                4.42f);
        Article nuggets20 = new Article("LES CHICKEN McNUGGETS™",
                "À déguster seul ou accompagné",
                "Craquez pour ces nuggets croustillants, à savourer avec ou sans sauce, en famille ou entre amis, faîtes-vous plaisir !\n"
                + "\n"
                + "Disponibles en portions de 4, 6 ou 9 et 20 Chicken McNuggets™.", 
                "images/nuggets.png", 
                8.25f);

        em.persist(cheeseBurger);
        em.persist(bigMac);
        em.persist(cbo);
        em.persist(panCakes);
        em.persist(petitCoca);
        em.persist(moyenCoca);
        em.persist(grandCoca);
        em.persist(petitFanta);
        em.persist(moyenFanta);
        em.persist(grandFanta);
        em.persist(petitSprite);
        em.persist(moyenSprite);
        em.persist(grandSprite);
        em.persist(expresso);
        em.persist(cappuccino);
        em.persist(nuggets4);
        em.persist(nuggets6);
        em.persist(nuggets9);
        em.persist(nuggets20);

//        Article a = new Article("Coca","le titre");
//        em.persist(a);
    }

}
