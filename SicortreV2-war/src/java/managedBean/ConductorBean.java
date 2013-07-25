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
    private String rut_seleccionado;
    private String fecha_nacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String nombres;
    private String primer_apellido;
    private String segundo_apellido;
    private String camion;
    private List<Conductor> conductores;
    private Conductor conductor_seleccionado;
    private Conductor conductor_seleccionado_CamEst;
    private Camion camion_seleccionado;
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

    public Camion getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(Camion camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }

    public Conductor getConductor_seleccionado_CamEst() {
        return conductor_seleccionado_CamEst;
    }

    public void setConductor_seleccionado_CamEst(Conductor conductor_seleccionado_CamEst) {
        this.conductor_seleccionado_CamEst = conductor_seleccionado_CamEst;
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

    public String getRut_seleccionado() {
        return rut_seleccionado;
    }

    public void setRut_seleccionado(String rut_seleccionado) {
        this.rut_seleccionado = rut_seleccionado;
    }

    public Conductor getConductor_seleccionado() {
        return conductor_seleccionado;
    }

    public void setConductor_seleccionado(Conductor conductor_seleccionado) {
        this.conductor_seleccionado = conductor_seleccionado;
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


    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }
    
    public void insertarConductor(){
        Conductor conductor = new Conductor();
        conductor.setRut(Integer.parseInt(rut));
        conductor.setFechaNacimiento(fecha_nacimiento);
        conductor.setDireccion(direccion);
        conductor.setCorreo(correo);
        conductor.setTelefono(telefono);
        conductor.setNombres(nombres);
        conductor.setPrimerApellido(primer_apellido);
        conductor.setSegundoApellido(segundo_apellido);
        conductor.setEstado("Activo");
        conductorFacade.create(conductor);
        
        rut=null;
        rut_seleccionado=null;
        fecha_nacimiento=null;
        direccion=null;
        correo=null;
        telefono=null;
        nombres=null;
        primer_apellido=null;
        segundo_apellido=null;
    }

    public void cambiarEstadoConductor(){
        
        conductor_seleccionado_CamEst.setEstado("Inactivo");
        conductorFacade.edit(conductor_seleccionado_CamEst);
        
    }
    
    public void onRowSelect(SelectEvent event) {  
       /* FacesMessage msg = new FacesMessage("Car Selected", ((Camion) event.getObject()).getPatente());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
      //  Modelo miModelo = modeloFacade.BuscarPorID(String.valueOf(camion_seleccionado.getId()));
        nombres = conductor_seleccionado.getNombres();
        primer_apellido = conductor_seleccionado.getPrimerApellido();
        segundo_apellido=conductor_seleccionado.getSegundoApellido();
        rut= String.valueOf(conductor_seleccionado.getRut());
        fecha_nacimiento = conductor_seleccionado.getFechaNacimiento();
        direccion = conductor_seleccionado.getDireccion();
        correo = conductor_seleccionado.getCorreo();
        telefono = conductor_seleccionado.getTelefono();
        
    }
    
     public void modificarConductor(){
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Conductor conductor = new Conductor();
        conductor.setRut(Integer.parseInt(rut));
        conductor.setNombres(nombres);
        conductor.setPrimerApellido(primer_apellido);
        conductor.setSegundoApellido(segundo_apellido);
        conductor.setFechaNacimiento(fecha_nacimiento);
        conductor.setDireccion(direccion);
        conductor.setCorreo(correo);
        conductor.setTelefono(telefono);
        conductor.setEstado("Activo");

        
        conductorFacade.edit(conductor);
    }
     
    public void asignarCamion(){
        //conductor_seleccionado_CamEst.setIdCamion(camionFacade.BuscarPorID(Integer.parseInt(camion)));
        //conductorFacade.edit(conductor_seleccionado_CamEst);
        AsignacionConductorCamion asignacion =  new AsignacionConductorCamion();
        asignacion.setFecha(new Date());
        asignacion.setIdCamion(camionFacade.BuscarPorID(Integer.parseInt(camion)));
        asignacion.setIdConductor(conductor_seleccionado_CamEst);
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
