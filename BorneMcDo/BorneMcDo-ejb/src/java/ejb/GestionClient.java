/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entites.Client;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi315
 */
@Stateful
public class GestionClient implements GestionClientLocal {

    @PersistenceContext(unitName = "BorneMcDo-ejbPU")
    private EntityManager em;

    public GestionClient() {
    }

    @Override
    public Client getClient(final Long numeroMembre) {
        
        return em.find(Client.class, numeroMembre);
    }

}
