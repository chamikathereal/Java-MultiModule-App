package lk.jiat.ee.web;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    @EJB
    private UserDetails userDetails;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDetails details = null;

        if (request.getSession().getAttribute("userbean") == null) {
            try{
                InitialContext context = new InitialContext();
                details = (UserDetails) context.lookup("lk.jiat.ee.ejb.remote.UserDetails");
                request.getSession().setAttribute("userbean", details);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            details = (UserDetails) request.getSession().getAttribute("userbean");
        }

        response.getWriter().println(details.getName());
        details.remove();
        request.getSession().removeAttribute("userbean");


        //Portable JNDI names for EJB UserDetailsBean: [java:global/ejb-module/UserDetailsBean, java:global/ejb-module/UserDetailsBean!lk.jiat.ee.ejb.remote.UserDetails]]]
        //Glassfish-specific (Non-portable) JNDI names for EJB UserDetailsBean: [lk.jiat.ee.ejb.remote.UserDetails#lk.jiat.ee.ejb.remote.UserDetails, lk.jiat.ee.ejb.remote.UserDetails]]]


        //Portable JNDI names for EJB AppSettingsBean: [java:global/ejb-module/AppSettingsBean, java:global/ejb-module/AppSettingsBean!lk.jiat.ee.ejb.remote.AppSettings]]]
    }

}
