/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Camion;
import entitiesClass.Conductor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionBeans.AsignacionConductorCamionFacadeLocal;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.ConductorFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "asignarConductorCamion")
@RequestScoped
public class AsignarConductorCamion {

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
    private Conductor conductorSeleccionado;
    private Conductor conductorSeleccionadoCamEst;
    private Camion camionSeleccionado;
    
    public AsignarConductorCamion() {
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
    
    public void asignarCamion(){
        asignacionConductorCamionFacade.cambiarEstado();
        AsignacionConductorCamion asignacion =  new AsignacionConductorCamion();
        asignacion.setFecha(new Date());
        asignacion.setIdCamion(camionFacade.BuscarPorID(Integer.parseInt(camion)));
        asignacion.setIdConductor(conductorSeleccionadoCamEst);
        asignacion.setEstado("Activo");
        asignacionConductorCamionFacade.create(asignacion);
    }
    
}
