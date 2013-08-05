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
    private Conductor conductor_seleccionado;
    private Conductor conductor_seleccionado_CamEst;
    
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

    public Conductor getConductor_seleccionado() {
        return conductor_seleccionado;
    }

    public void setConductor_seleccionado(Conductor conductor_seleccionado) {
        this.conductor_seleccionado = conductor_seleccionado;
    }

    public Conductor getConductor_seleccionado_CamEst() {
        return conductor_seleccionado_CamEst;
    }

    public void setConductor_seleccionado_CamEst(Conductor conductor_seleccionado_CamEst) {
        this.conductor_seleccionado_CamEst = conductor_seleccionado_CamEst;
    }
    
    public void onRowSelect(SelectEvent event) {  
       /* FacesMessage msg = new FacesMessage("Car Selected", ((Camion) event.getObject()).getPatente());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
      //  Modelo miModelo = modeloFacade.BuscarPorID(String.valueOf(camion_seleccionado.getId()));
        conductorBeans.setNombres(conductor_seleccionado.getNombres());
        conductorBeans.setPrimer_apellido(conductor_seleccionado.getPrimerApellido());
        conductorBeans.setSegundo_apellido(conductor_seleccionado.getSegundoApellido());
        conductorBeans.setRut(String.valueOf(conductor_seleccionado.getRut()));
        conductorBeans.setFecha_nacimiento(conductor_seleccionado.getFechaNacimiento());
        conductorBeans.setDireccion(conductor_seleccionado.getDireccion());
        conductorBeans.setCorreo(conductor_seleccionado.getCorreo());
        conductorBeans.setTelefono(conductor_seleccionado.getTelefono());;
        
    }
    
     public void modificarConductor(){
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Conductor conductor = new Conductor();
        conductor.setRut(Integer.parseInt(conductorBeans.getRut()));
        conductor.setNombres(conductorBeans.getNombres());
        conductor.setPrimerApellido(conductorBeans.getPrimer_apellido());
        conductor.setSegundoApellido(conductorBeans.getSegundo_apellido());
        conductor.setFechaNacimiento(conductorBeans.getFecha_nacimiento());
        conductor.setDireccion(conductorBeans.getDireccion());
        conductor.setCorreo(conductorBeans.getCorreo());
        conductor.setTelefono(conductorBeans.getTelefono());
        conductor.setEstado("Activo");

        
        conductorFacade.edit(conductor);
    }
     
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un conductor del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
}
