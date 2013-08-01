/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Marco
 */
@Named(value = "loginBean")
@ApplicationScoped
public class LoginBean {

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
    
    public String login () {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)         
            context.getExternalContext().getRequest();
        try {
          request.login(this.username, this.password);
        } catch (ServletException e) {
          context.addMessage(null, new FacesMessage("Login failed."));
          return "error";
        }
        return "supervisor/Monitoreo?faces-redirect=true";
   //     resp.sendRedirect("faces/supervisor/Monitoreo.xhtml");
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
