/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

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
