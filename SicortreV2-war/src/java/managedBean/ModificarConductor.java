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

    public String getCamion() {
        return camion;
    }

    public void setCamion(String camion) {
        this.camion = camion;
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
     
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un conductor del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    
    public void validaNombre(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[a-zA-Z[ x0Bf ]]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de nombre incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Nombres"));
        }
    }
    
    public void validaPrimerApellido(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[a-zA-Z]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de primer apellido incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Primer apellido"));
        }
    }
    
    public void validaSegundoApellido(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[a-zA-Z]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de segundo apellido incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Segundo apellido"));
        }
    }
    
    public void validaFechaNacimiento(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Fecha de nacimiento"));
        }
    }
    
    public void validaDireccion(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Direccion"));
        }
    }
    
    public void validaMail(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches(".+@.+\\.[a-z]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de correo incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Correo"));
        }
    }
    
    public void validaTelefono(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Telefono"));
        }
    }
}
