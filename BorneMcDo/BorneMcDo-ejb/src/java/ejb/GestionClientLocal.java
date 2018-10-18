/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entites.Client;
import javax.ejb.Local;

/**
 *
 * @author cdi315
 */
@Local
public interface GestionClientLocal {

    Client getClient(final Long numeroMembre);
    
}
