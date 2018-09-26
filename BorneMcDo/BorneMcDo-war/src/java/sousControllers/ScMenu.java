/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sousControllers;

import ejb.CreationJeuEssaiLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ScMenu implements SousController{

CreationJeuEssaiLocal creationJeuEssai = lookupCreationJeuEssaiLocal();
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/Menu.jsp";
        return url;
    }

    private CreationJeuEssaiLocal lookupCreationJeuEssaiLocal() {
        try {
            Context c = new InitialContext();
            return (CreationJeuEssaiLocal) c.lookup("java:global/BorneMcDo/BorneMcDo-ejb/CreationJeuEssai!ejb.CreationJeuEssaiLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
}
