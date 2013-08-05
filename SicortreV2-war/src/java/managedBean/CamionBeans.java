/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Modelo;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
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
    private String fecha_compra;
    private String kilometraje;
    private String motor;
    private String carga_max;
    private String cod_gps_google;
    private String observaciones;  
    private Modelo modelo;
    private String modelo_seleccionado;

    public CamionBeans(){
    }
    
     public void validaPatente(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Patente"));
        }
    }
    
    public void validaFechaCompra(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);

        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Fecha de compra"));
        }
    }
    
    public void validaKilometraje(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de Kilometraje incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Kilometraje"));
        }
    }
    
    public void validaMotor(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de Motor incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Motor"));
        }
    }
    
    public void validaCargaMaxima(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de Carga maxima incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Carga maxima"));
        }
    }
    
    public void validaCodigoGPS(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Formato de Codigo GPS incorrecto"));
        }
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage("Falta ingresar Codigo GPS"));
        }
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public String getModelo_seleccionado() {
        return modelo_seleccionado;
    }

    public void setModelo_seleccionado(String modelo_seleccionado) {
        this.modelo_seleccionado = modelo_seleccionado;
    }
        
    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
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

    public String getCarga_max() {
        return carga_max;
    }

    public void setCarga_max(String carga_max) {
        this.carga_max = carga_max;
    }

    public String getCod_gps_google() {
        return cod_gps_google;
    }

    public void setCod_gps_google(String cod_gps_google) {
        this.cod_gps_google = cod_gps_google;
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

