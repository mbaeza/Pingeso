/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Camion;
import entitiesClass.Conductor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ConductorFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "verConductor")
@RequestScoped
public class VerConductor {

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
    private Camion camion_seleccionado;
    
    public VerConductor() {
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

    public Camion getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(Camion camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }
    
}
