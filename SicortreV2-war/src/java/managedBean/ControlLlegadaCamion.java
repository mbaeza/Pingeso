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
    private String cantidadBasura;
    private Control camionSeleccionado;
    
    
    public ControlLlegadaCamion() {
    }
    
    @PostConstruct
    public void init(){       
        controles = controlFacade.findAll();     
    }
    
    public void modificarControl(){
        
        try {
            
            SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm:ss");
            Date hora_con_formato = formato_hora.parse(controlBeans.getHoraEntrada());
            camionSeleccionado.setHoraLlegada(hora_con_formato);
            
            camionSeleccionado.setCantidadBasura(Integer.parseInt(cantidadBasura));

            controlFacade.edit(camionSeleccionado);
            
            camionSeleccionado.getIdCamion().setControl("Estacionado");
            camionFacade.edit(camionSeleccionado.getIdCamion());
        
        } catch (ParseException ex) {
            Logger.getLogger(ControlSalidaCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void onRowSelect(SelectEvent event) {   

       SimpleDateFormat formateador1 = new SimpleDateFormat("dd/MM/yyyy");
       String aux1= formateador1.format(camionSeleccionado.getFecha());
       
       SimpleDateFormat formateador2 = new SimpleDateFormat("h:mm a");
       String aux2= formateador2.format(camionSeleccionado.getHoraSalida());
       
       controlBeans.setPatente(camionSeleccionado.getIdCamion().getPatente());
       controlBeans.setHoraSalida(aux2);
       controlBeans.setFecha(aux1);
    
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

    public String getCantidadBasura() {
        return cantidadBasura;
    }

    public void setCantidadBasura(String cantidadBasura) {
        this.cantidadBasura = cantidadBasura;
    }

    public Control getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(Control camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
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
