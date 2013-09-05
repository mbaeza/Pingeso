/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Marco
 */
@Named(value = "controlBeans")
@RequestScoped
public class ControlBeans {

    private String conductorNombres;
    private String conductorApellidos;    
    private String patente;
    private String fecha;
    private String horaSalida;
    private String horaEntrada;
    
    public ControlBeans() {
    }

    public void validaFecha(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);

        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en fecha de control ingresada","Falta ingresar Fecha de control"));
        }
        String[] split=strValue.split("/");
        if(Integer.parseInt(split[2])<2013 || Integer.parseInt(split[2])>2020 || Integer.parseInt(split[1])>12 || Integer.parseInt(split[0])>31){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en fecha ingresada","Fecha ingresada no valida"));
        }
    }
    
    public void validaHora(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);

        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en hora de salida ingresada","Falta ingresar hora de salida"));
        }
        String[] split=strValue.split(":");
        if(Integer.parseInt(split[2])>59 || Integer.parseInt(split[1])>59 || Integer.parseInt(split[0])>23){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en hora de salida ingresada","Hora de salida ingresada no valida"));
        }
    }
    
    public void validaPatente(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);

        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en patente seleccionada","No se ha seleccionado un camion"));
        }
    }
    
    public String getConductorNombres() {
        return conductorNombres;
    }

    public void setConductorNombres(String conductorNombres) {
        this.conductorNombres = conductorNombres;
    }

    public String getConductorApellidos() {
        return conductorApellidos;
    }

    public void setConductorApellidos(String conductorApellidos) {
        this.conductorApellidos = conductorApellidos;
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

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    
    
}
