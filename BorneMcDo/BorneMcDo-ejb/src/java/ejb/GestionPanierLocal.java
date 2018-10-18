/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entites.Choix;
import entites.Menu;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Kinou
 */
@Local
public interface GestionPanierLocal {

    public ArrayList<Choix> getMonPanier();

    public Choix add(String article);

    public float getPrixTotal();

    public Choix addSuppArt(String idArticle);

    public Choix addMenu(Menu m);

    public Choix addArticleMenu(String idArticle);

    public void linkMenuArticle(Choix menu, Choix article);
    
}
