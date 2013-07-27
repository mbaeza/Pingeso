/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Conductor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionBeans.AsignacionConductorCamionFacadeLocal;

/**
 *
 * @author alex
 */
@Named(value = "verAsignacionBean")
@RequestScoped
public class VerAsignacionBean {
    
    @EJB
    private AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade;

    private List<AsignacionConductorCamion> asignaciones;
    
    public VerAsignacionBean() {
    }
    
    @PostConstruct
    public void init(){
        asignaciones= new ArrayList<AsignacionConductorCamion>();
        asignaciones=asignacionConductorCamionFacade.findAll();
    }

    public AsignacionConductorCamionFacadeLocal getAsignacionConductorCamionFacade() {
        return asignacionConductorCamionFacade;
    }

    public void setAsignacionConductorCamionFacade(AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade) {
        this.asignacionConductorCamionFacade = asignacionConductorCamionFacade;
    }

    public List<AsignacionConductorCamion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionConductorCamion> asignaciones) {
        this.asignaciones = asignaciones;
    }
    
}
