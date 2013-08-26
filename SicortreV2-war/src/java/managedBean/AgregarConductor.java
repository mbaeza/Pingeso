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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ConductorFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "agregarConductor")
@RequestScoped
public class AgregarConductor {

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
    private String rutSeleccionado;
    
    public AgregarConductor() {
    }
    
    @PostConstruct
    public void init(){
        conductores= new ArrayList<Conductor>();
        conductores=conductorFacade.findAll();
    }
    
    public void insertarConductor(){
        Conductor conductor = new Conductor();
        conductor.setRut(Integer.parseInt(conductorBeans.getRut()));
        conductor.setFechaNacimiento(conductorBeans.getFechaNacimiento());
        conductor.setDireccion(conductorBeans.getDireccion());
        conductor.setCorreo(conductorBeans.getCorreo());
        conductor.setTelefono(conductorBeans.getTelefono());
        conductor.setNombres(conductorBeans.getNombres());
        conductor.setPrimerApellido(conductorBeans.getPrimerApellido());
        conductor.setSegundoApellido(conductorBeans.getSegundoApellido());
        conductor.setEstado("Activo");
        conductorFacade.create(conductor);
        
        conductorBeans.setRut(null);
        this.setRutSeleccionado(null);
        conductorBeans.setFechaNacimiento(null);
        conductorBeans.setDireccion(null);
        conductorBeans.setCorreo(null);
        conductorBeans.setTelefono(null);
        conductorBeans.setNombres(null);        
        conductorBeans.setPrimerApellido(null);
        conductorBeans.setSegundoApellido(null);
    }
    
    public void confirmacionAgregar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregación realizada",  "Se ha agregado un conductor al sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 

    public AsignacionConductorCamionFacadeLocal getAsignacionConductorCamionFacade() {
        return asignacionConductorCamionFacade;
    }

    public void setAsignacionConductorCamionFacade(AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade) {
        this.asignacionConductorCamionFacade = asignacionConductorCamionFacade;
    }

    public String getRutSeleccionado() {
        return rutSeleccionado;
    }

    public void setRutSeleccionado(String rutSeleccionado) {
        this.rutSeleccionado = rutSeleccionado;
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
