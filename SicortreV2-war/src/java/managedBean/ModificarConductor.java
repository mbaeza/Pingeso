/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Camion;
import entitiesClass.Conductor;
import entitiesClass.Modelo;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import sessionBeans.ConductorFacadeLocal;
import sessionBeans.ConductorFacade;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItemGroup;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
/**
 *
 * @author Marco
 */
@Named(value = "modificarConductor")
@RequestScoped
public class ModificarConductor {

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
    
    public ModificarConductor() {
    }
    
    @PostConstruct
    public void init(){
        conductores= new ArrayList<Conductor>();
        conductores=conductorFacade.findAll();
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
    
    public void onRowSelect(SelectEvent event) {  
    
        conductorBeans.setNombres(conductorSeleccionado.getNombres());
        conductorBeans.setPrimerApellido(conductorSeleccionado.getPrimerApellido());
        conductorBeans.setSegundoApellido(conductorSeleccionado.getSegundoApellido());
        conductorBeans.setRut(String.valueOf(conductorSeleccionado.getRut()));
        conductorBeans.setFechaNacimiento(conductorSeleccionado.getFechaNacimiento());
        conductorBeans.setDireccion(conductorSeleccionado.getDireccion());
        conductorBeans.setCorreo(conductorSeleccionado.getCorreo());
        conductorBeans.setTelefono(conductorSeleccionado.getTelefono());;
        
    }
    
     public void modificarConductor(){
         
        conductorSeleccionado.setNombres(conductorBeans.getNombres());
        conductorSeleccionado.setPrimerApellido(conductorBeans.getPrimerApellido());
        conductorSeleccionado.setSegundoApellido(conductorBeans.getSegundoApellido());
        conductorSeleccionado.setFechaNacimiento(conductorBeans.getFechaNacimiento());
        conductorSeleccionado.setDireccion(conductorBeans.getDireccion());
        conductorSeleccionado.setCorreo(conductorBeans.getCorreo());
        conductorSeleccionado.setTelefono(conductorBeans.getTelefono());
        conductorSeleccionado.setEstado("Activo");

        conductorFacade.edit(conductorSeleccionado);
    }
     
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un conductor del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
}
