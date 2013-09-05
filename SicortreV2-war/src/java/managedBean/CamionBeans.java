/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Modelo;
import java.io.Serializable;
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
@Named(value = "camionBeans")
@RequestScoped
public class CamionBeans implements Serializable{
    

    private String patente;
    private String fechaCompra;
    private String kilometraje;
    private String motor;
    private String cargaMax;
    private String codGpsGoogle;
    private String observaciones;  
    private Modelo modelo;    

    public CamionBeans(){
    }
    
     public void validaPatente(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en patente ingresada","Falta ingresar Patente"));
        }
    }
    
    public void validaFechaCompra(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);

        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en fecha de compra ingresada","Falta ingresar Fecha de compra"));
        }
        String[] split=strValue.split("/");
        if(Integer.parseInt(split[2])>2013 || Integer.parseInt(split[2])<1910 || Integer.parseInt(split[1])>12 || Integer.parseInt(split[0])>31){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en fecha ingresada","Fecha ingresada no valida"));
        }
    }
    
    public void validaKilometraje(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en kilometraje ingresado","Formato de Kilometraje incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en kilometraje ingresado","Falta ingresar Kilometraje"));
        }
    }
    
    public void validaMotor(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en motor ingresado","Formato de Motor incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en motor ingresado","Falta ingresar Motor"));
        }
    }
    
    public void validaCargaMaxima(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en carga maxima ingresada","Formato de Carga maxima incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en carga maxima ingresada","Falta ingresar Carga maxima"));
        }
    }
    
    public void validaCodigoGPS(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en codigo GPS ingresado","Formato de Codigo GPS incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en codigo GPS ingresado","Falta ingresar Codigo GPS"));
        }
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }
   
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(String cargaMax) {
        this.cargaMax = cargaMax;
    }

    public String getCodGpsGoogle() {
        return codGpsGoogle;
    }

    public void setCodGpsGoogle(String codGpsGoogle) {
        this.codGpsGoogle = codGpsGoogle;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    
}

