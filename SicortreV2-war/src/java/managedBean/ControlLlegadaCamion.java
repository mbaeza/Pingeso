/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Control;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ControlFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "controlLlegadaCamion")
@RequestScoped
public class ControlLlegadaCamion {
    @EJB
    private ControlFacadeLocal controlFacade1;

    @EJB
    private ControlFacadeLocal controlFacade;
    @EJB
    private AsignacionConductorCamionFacadeLocal asignacionConductorCamionFacade;
    @EJB    
    private CamionFacadeLocal camionFacade;
    @Inject ControlBeans controlBeans;
    
    private List<Control> controles;
    private String cantidad_basura;
    private Control camion_seleccionado;
    
    
    public ControlLlegadaCamion() {
    }
    
    @PostConstruct
    public void init(){       
        controles = controlFacade.findAll();     
    }
    
    public void modificarControl(){
        
        try {
            System.out.println(camion_seleccionado.getIdCamion().getPatente());
            SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm:ss");
            Date hora_con_formato = formato_hora.parse(controlBeans.getHora_entrada());
            camion_seleccionado.setHoraLlegada(hora_con_formato);
            
            camion_seleccionado.setCantidadBasura(Integer.parseInt(cantidad_basura));

            controlFacade.edit(camion_seleccionado);
            
            camion_seleccionado.getIdCamion().setControl("Estacionado");
            camionFacade.edit(camion_seleccionado.getIdCamion());
        
        } catch (ParseException ex) {
            Logger.getLogger(ControlSalidaCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void onRowSelect(SelectEvent event) {         
       controlBeans.setPatente(camion_seleccionado.getIdCamion().getPatente());
       controlBeans.setHora_salida(camion_seleccionado.getHoraSalida().toString());
       controlBeans.setFecha(camion_seleccionado.getFecha().toString());
    } 
    
    public void confirmacionControlLlegada(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Control de llegada realizado",  "Se ha controlado la llegada de un camion del sistema satisfactoriamente");    
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

    public String getCantidad_basura() {
        return cantidad_basura;
    }

    public void setCantidad_basura(String cantidad_basura) {
        this.cantidad_basura = cantidad_basura;
    }

    public Control getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(Control camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }    

    public ControlFacadeLocal getControlFacade1() {
        return controlFacade1;
    }

    public void setControlFacade1(ControlFacadeLocal controlFacade1) {
        this.controlFacade1 = controlFacade1;
    }

    public List<Control> getControles() {
        return controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
    }  
    
}
