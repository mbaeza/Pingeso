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

    private String conductor_nombres;
    private String conductor_apellidos;    
    private String patente;
    private String fecha;
    private String hora_salida;
    private String hora_entrada;
    
    public ControlBeans() {
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
