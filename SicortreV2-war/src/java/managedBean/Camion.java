/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Marca;
import entitiesClass.Modelo;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named("camion")
@RequestScoped
public class Camion implements Serializable{
    

    private String patente;
    private String fecha_compra;
    private String kilometraje;
    private String motor;
    private String carga_max;
    private String cod_gps_google;
    private String observaciones;  
    private Modelo modelo;

    public Camion() {
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
