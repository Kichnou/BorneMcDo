/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entites.Choix;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Kinou
 */
@Local
public interface GestionPanierLocal {

    public ArrayList<Choix> getMonPanier();

    public void add(String article);
    
}
