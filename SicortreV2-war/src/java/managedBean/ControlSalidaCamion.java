/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Camion;
import entitiesClass.Control;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ControlFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "controlSalidaCamion")
@RequestScoped
public class ControlSalidaCamion {
    @EJB
    private ControlFacadeLocal controlFacade;
    @EJB
    private AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade;
    @EJB
    private CamionFacadeLocal camionFacade;

    private int cantidad_basura;
    private AsignacionConductorCamion camion_seleccionado;
    private String conductor_nombres;
    private String conductor_apellidos;
    private List<AsignacionConductorCamion> asignaciones;
    private String patente;
    private String fecha;
    private String hora_salida;
    private String hora_entrada;
    
    public ControlSalidaCamion() {       
    }
    
    @PostConstruct
    public void init(){       
        asignaciones = asignacionConductorCamionFacade.BuscarPorCamion();          
    }
    
    public void ingresarControl(){
        
        try {
            System.out.println(camion_seleccionado.getIdCamion().getPatente());
            Control control = new Control();
            
            SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_con_formato = formato_fecha.parse(fecha);
            control.setFecha(fecha_con_formato);
            
            SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm:ss");
            Date hora_con_formato = formato_hora.parse(hora_salida);
            control.setHoraSalida(hora_con_formato);
            
            control.setCantidadBasura(null);
            control.setHoraLlegada(null);
            control.setIdCamion(camion_seleccionado.getIdCamion());

            controlFacade.create(control);
            
            camion_seleccionado.getIdCamion().setControl("En Ruta");
            camionFacade.edit(camion_seleccionado.getIdCamion());
        
        } catch (ParseException ex) {
            Logger.getLogger(ControlSalidaCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void onRowSelect(SelectEvent event) {         
       conductor_nombres = camion_seleccionado.getIdConductor().getNombres();
       conductor_apellidos = camion_seleccionado.getIdConductor().getPrimerApellido() + camion_seleccionado.getIdConductor().getSegundoApellido();
       patente = camion_seleccionado.getIdCamion().getPatente();
    } 
    
    public void confirmacionControlSalida(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Control de salida realizado",  "Se ha controlado la salida de un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }

    public ControlFacadeLocal getControlFacade() {
        return controlFacade;
    }

    public void setControlFacade(ControlFacadeLocal controlFacade) {
        this.controlFacade = controlFacade;
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

    public int getCantidad_basura() {
        return cantidad_basura;
    }

    public void setCantidad_basura(int cantidad_basura) {
        this.cantidad_basura = cantidad_basura;
    }

    public AsignacionConductorCamion getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(AsignacionConductorCamion camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }

    public String getConductor_nombres() {
        return conductor_nombres;
    }

    public void setConductor_nombres(String conductor_nombres) {
        this.conductor_nombres = conductor_nombres;
    }

    public String getConductor_apellidos() {
        return conductor_apellidos;
    }

    public void setConductor_apellidos(String conductor_apellidos) {
        this.conductor_apellidos = conductor_apellidos;
    }

    public List<AsignacionConductorCamion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionConductorCamion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

}
