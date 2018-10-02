package sousControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScPanier implements SousController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/Panier.jsp";
        
        System.out.println("Dans le panier");
        
        request.setAttribute("message", "Panier");
        
        return url;
    }
    
}
