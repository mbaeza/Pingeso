/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Camion;
import entitiesClass.Conductor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ConductorFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "cambiarEstadoConductor")
@RequestScoped
public class CambiarEstadoConductor {

    @EJB
    private AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade;
    @EJB
    private CamionFacadeLocal camionFacade;
    @EJB
    private ConductorFacadeLocal conductorFacade;
    @Inject ConductorBeans conductorBeans;
    
    private List<Conductor> conductores;
    private Conductor conductorSeleccionado;
    private Conductor conductorSeleccionadoCamEst;
    private Camion camionSeleccionado;
    
    public CambiarEstadoConductor() {
    }
    
    @PostConstruct
    public void init(){
        conductores= new ArrayList<Conductor>();
        conductores=conductorFacade.findAll();
    }
    
    public void cambiarEstadoConductor(){        
        conductorSeleccionadoCamEst.setEstado("Inactivo");
        conductorFacade.edit(conductorSeleccionadoCamEst);        
    }
    
     public void confirmacionCambiarEstado(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio de estado realizado",  "Se ha cambiado el estado de un conductor del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 

    public AsignacionConductorCamionFacadeLocal getAsignacionConductorCamionFacade() {
        return asignacionConductorCamionFacade;
    }

    public void setAsignacionConductorCamionFacade(AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade) {
        this.asignacionConductorCamionFacade = asignacionConductorCamionFacade;
    }

    public CamionFacadeLocal getCamionFacade() {
        return camionFacade;
    }

    public void setCamionFacade(CamionFacadeLocal camionFacade) {
        this.camionFacade = camionFacade;
    }

    public ConductorFacadeLocal getConductorFacade() {
        return conductorFacade;
    }

    public void setConductorFacade(ConductorFacadeLocal conductorFacade) {
        this.conductorFacade = conductorFacade;
    }  

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public Conductor getConductorSeleccionado() {
        return conductorSeleccionado;
    }

    public void setConductorSeleccionado(Conductor conductorSeleccionado) {
        this.conductorSeleccionado = conductorSeleccionado;
    }

    public Conductor getConductorSeleccionadoCamEst() {
        return conductorSeleccionadoCamEst;
    }

    public void setConductorSeleccionadoCamEst(Conductor conductorSeleccionadoCamEst) {
        this.conductorSeleccionadoCamEst = conductorSeleccionadoCamEst;
    }

    public Camion getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(Camion camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
    }
    
}
