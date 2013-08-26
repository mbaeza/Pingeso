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
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItemGroup;
import org.primefaces.event.SelectEvent;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;


/**
 *
 * @author alex
 */
@Named(value = "conductorBean")
@RequestScoped
public class ConductorBean {
    @EJB
    private AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade;
    @EJB
    private CamionFacadeLocal camionFacade;
    @EJB
    private ConductorFacadeLocal conductorFacade;
    
    private String rut;
    private String rutSeleccionado;
    private String fechaNacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String camion;
    private List<Conductor> conductores;
    private Conductor conductorSeleccionado;
    private Conductor conductorSeleccionadoCamEst;
    private Camion camionSeleccionado;
    /**
     * Creates a new instance of ConductorBean
     */
    
    public ConductorBean() {
        //conductores= new ArrayList<Conductor>();
        //conductores=conductorFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        conductores= new ArrayList<Conductor>();
        conductores=conductorFacade.findAll();
    }

    public String getCamion() {
        return camion;
    }

    public void setCamion(String camion) {
        this.camion = camion;
    }

    public Camion getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(Camion camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
    }

    public Conductor getConductorSeleccionadoCamEst() {
        return conductorSeleccionadoCamEst;
    }

    public void setConductorSeleccionadoCamEst(Conductor conductorSeleccionadoCamEst) {
        this.conductorSeleccionadoCamEst = conductorSeleccionadoCamEst;
    }

    public CamionFacadeLocal getCamionFacade() {
        return camionFacade;
    }

    public void setCamionFacade(CamionFacadeLocal camionFacade) {
        this.camionFacade = camionFacade;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRutSeleccionado() {
        return rutSeleccionado;
    }

    public void setRutSeleccionado(String rutSeleccionado) {
        this.rutSeleccionado = rutSeleccionado;
    }

    public Conductor getConductorSeleccionado() {
        return conductorSeleccionado;
    }

    public void setConductorSeleccionado(Conductor conductorSeleccionado) {
        this.conductorSeleccionado = conductorSeleccionado;
    }

    public ConductorFacadeLocal getConductorFacade() {
        return conductorFacade;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public void setConductorFacade(ConductorFacadeLocal conductorFacade) {
        this.conductorFacade = conductorFacade;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    
    public void insertarConductor(){
        Conductor conductor = new Conductor();
        conductor.setRut(Integer.parseInt(rut));
        conductor.setFechaNacimiento(fechaNacimiento);
        conductor.setDireccion(direccion);
        conductor.setCorreo(correo);
        conductor.setTelefono(telefono);
        conductor.setNombres(nombres);
        conductor.setPrimerApellido(primerApellido);
        conductor.setSegundoApellido(segundoApellido);
        conductor.setEstado("Activo");
        conductorFacade.create(conductor);
        
        rut=null;
        rutSeleccionado=null;
        fechaNacimiento=null;
        direccion=null;
        correo=null;
        telefono=null;
        nombres=null;
        primerApellido=null;
        segundoApellido=null;
    }

    public void cambiarEstadoConductor(){
        
        conductorSeleccionadoCamEst.setEstado("Inactivo");
        conductorFacade.edit(conductorSeleccionadoCamEst);
        
    }
    
    public void onRowSelect(SelectEvent event) {  
       /* FacesMessage msg = new FacesMessage("Car Selected", ((Camion) event.getObject()).getPatente());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
      //  Modelo miModelo = modeloFacade.BuscarPorID(String.valueOf(camionSeleccionado.getId()));
        nombres = conductorSeleccionado.getNombres();
        primerApellido = conductorSeleccionado.getPrimerApellido();
        segundoApellido=conductorSeleccionado.getSegundoApellido();
        rut= String.valueOf(conductorSeleccionado.getRut());
        fechaNacimiento = conductorSeleccionado.getFechaNacimiento();
        direccion = conductorSeleccionado.getDireccion();
        correo = conductorSeleccionado.getCorreo();
        telefono = conductorSeleccionado.getTelefono();
        
    }
    
     public void modificarConductor(){
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Conductor conductor = new Conductor();
        conductor.setRut(Integer.parseInt(rut));
        conductor.setNombres(nombres);
        conductor.setPrimerApellido(primerApellido);
        conductor.setSegundoApellido(segundoApellido);
        conductor.setFechaNacimiento(fechaNacimiento);
        conductor.setDireccion(direccion);
        conductor.setCorreo(correo);
        conductor.setTelefono(telefono);
        conductor.setEstado("Activo");

        
        conductorFacade.edit(conductor);
    }
     
    public void asignarCamion(){
        //conductor_seleccionado_CamEst.setIdCamion(camionFacade.BuscarPorID(Integer.parseInt(camion)));
        //conductorFacade.edit(conductorSeleccionadoCamEst);
        AsignacionConductorCamion asignacion =  new AsignacionConductorCamion();
        asignacion.setFecha(new Date());
        asignacion.setIdCamion(camionFacade.BuscarPorID(Integer.parseInt(camion)));
        asignacion.setIdConductor(conductorSeleccionadoCamEst);
        asignacionConductorCamionFacade.create(asignacion);
    }
     
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un conductor del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
     
    public void confirmacionAgregar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregación realizada",  "Se ha agregado un conductor al sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 
        
    public void confirmacionCambiarEstado(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio de estado realizado",  "Se ha cambiado el estado de un conductor del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 
}
