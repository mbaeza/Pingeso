/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named("editCamion")
@RequestScoped
public class EditCamion {
 
    @Inject Camion camion;
    
    
    
}
