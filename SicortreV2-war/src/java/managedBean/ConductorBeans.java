/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import sessionBeans.ConductorFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "conductorBeans")
@RequestScoped
public class ConductorBeans {
    @EJB
    private ConductorFacadeLocal conductorFacade;

    private String rut;    
    private String fechaNacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String camion;
    
    public ConductorBeans() {
    }
    
    public void validaNombre(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[a-zA-Z[ x0Bf ]]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en nombres ingresado","Formato de nombre incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en nombres ingresados","Falta ingresar Nombres"));
        }
    }
    
    public void validaPrimerApellido(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[a-zA-Z]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en primer apellido ingresado","Formato de primer apellido incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en primer apellido ingresado","Falta ingresar Primer apellido"));
        }
    }
    
    public void validaSegundoApellido(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches("[a-zA-Z]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en segundo apellido ingresado","Formato de segundo apellido incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en segundo apellido ingresado","Falta ingresar Segundo apellido"));
        }
    }
    
    public boolean rutCorrecto(String rut){
        int largo=rut.length();
        char dv=rut.charAt(largo-1);
        int rutsd=Integer.parseInt(rut.substring(0,largo-1));
        int m = 0, s = 1;
        for (; rutsd != 0; rutsd /= 10)
        {
            s = (s + rutsd % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
    
    public void validaRut(FacesContext fc, UIComponent uic, Object o) {
        
        String strValue = String.valueOf(o);
        if (!strValue.matches("[0-9]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en RUT ingresado","Formato de segundo apellido incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en RUT ingresado","Falta ingresar RUT"));
        }
        
        if(!rutCorrecto(strValue)){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en RUT ingresado","RUT ingresado incorrecto"));
        }
        if(conductorFacade.ConductorExiste(Integer.parseInt(strValue))){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en RUT ingresado","Ya existe un conductor con este RUT"));
        }
        
    }
    
    public void validaFechaNacimiento(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en fecha ingresada","Falta ingresar Fecha de nacimiento"));
        }
        String[] split=strValue.split("/");
        if(Integer.parseInt(split[2])>2013 || Integer.parseInt(split[2])<1910 || Integer.parseInt(split[1])>12 || Integer.parseInt(split[0])>31){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en fecha ingresada","Fecha ingresada no valida"));
        }
    }
    
    public void validaDireccion(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en direccion ingresada","Falta ingresar Direccion"));
        }
    }
    
    public void validaMail(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (!strValue.matches(".+@.+\\.[a-z]+") && !strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en correo ingresado","Formato de correo incorrecto"));
        }
        
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en correo ingresado","Falta ingresar Correo"));
        }
    }
    
    public void validaTelefono(FacesContext fc, UIComponent uic, Object o) {
        String strValue = String.valueOf(o);
        if (strValue.matches("")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en telefono ingresado","Falta ingresar Telefono"));
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCamion() {
        return camion;
    }

    public void setCamion(String camion) {
        this.camion = camion;
    }        
    
}
