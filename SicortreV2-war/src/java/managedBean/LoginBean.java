/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Marco
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login () {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
        
        try {
            System.out.println("usuario logueado anteriormente: " + request.getRemoteUser());
          request.login(this.username, this.password);
          System.out.println("se hizo login: " + request.getRemoteUser());
          System.out.println("Es gerente: " + request.isUserInRole("Gerente"));
          System.out.println("Es supervisor: " + request.isUserInRole("Supervisor de Camiones"));
          
        } catch (ServletException e) {
            System.out.println("error: " + e.getMessage());
          context.addMessage(null, new FacesMessage("Login failed."));
          return ;
        }
        try {
            //return "supervisor/Monitoreo?faces-redirect=true";
            externalContext.redirect(externalContext.getRequestContextPath()+"/faces/supervisor/Monitoreo.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
      FacesContext context = FacesContext.getCurrentInstance();
      HttpServletRequest request = (HttpServletRequest) 
          context.getExternalContext().getRequest();
      try {
        request.logout();
      } catch (ServletException e) {   
        context.addMessage(null, new FacesMessage("Logout failed."));
      }
    }
}
