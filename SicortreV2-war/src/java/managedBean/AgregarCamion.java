/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Camion;
import entitiesClass.Marca;
import entitiesClass.Modelo;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.MarcaFacadeLocal;
import sessionBeans.ModeloFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "agregarCamion")
@RequestScoped
public class AgregarCamion {
    @EJB
    private ModeloFacadeLocal modeloFacade;
    @EJB
    private MarcaFacadeLocal marcaFacade;
    @EJB
    private CamionFacadeLocal camionFacade;

    private List<Modelo> modelos;
    private List<Marca> marcas;
    private List<Camion> camiones;
    private String modelo_seleccionado;
    private String patente;
    private String fecha_compra;
    private String kilometraje;
    private String motor;
    private String carga_max;
    private String cod_gps_google;
    private String observaciones;  
    private Modelo modelo;
    
    public AgregarCamion() {
    }
    
    @PostConstruct
    public void init(){
        marcas = marcaFacade.findAll();      
        camiones = camionFacade.findAll();
        modelos = modeloFacade.findAll();  
   }
    
    public void insertarCamion(){
        int id = 0;

        Camion camion = new Camion();
        
        camion.setEstado("Activo");
        camion.setFechaDeCompra(fecha_compra);
        camion.setKilometraje(Double.parseDouble(kilometraje));
        camion.setMaxCarga(Integer.parseInt(carga_max));
        camion.setMotor(motor);
        camion.setPatente(patente);
        camion.setControl("Estacionado");
        camion.setUsuarioGLatitude(cod_gps_google);
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modelo_seleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modelo_seleccionado);
        modelo = new Modelo(id);
        camion.setIdModelo(modelo);
        camion.setObservacion(observaciones);
        camionFacade.create(camion);
        
        modelo_seleccionado = "";
        patente = null;
        fecha_compra = null;;
        kilometraje = null;
        motor = null;
        carga_max =null;
        cod_gps_google = null;
        observaciones = null;
        
    }
    
    //Mensaje confirmación Agregar camion
    public void confirmacionAgregar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregación realizada",  "Se ha agregado un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 

    public ModeloFacadeLocal getModeloFacade() {
        return modeloFacade;
    }

    public void setModeloFacade(ModeloFacadeLocal modeloFacade) {
        this.modeloFacade = modeloFacade;
    }

    public MarcaFacadeLocal getMarcaFacade() {
        return marcaFacade;
    }

    public void setMarcaFacade(MarcaFacadeLocal marcaFacade) {
        this.marcaFacade = marcaFacade;
    }

    public CamionFacadeLocal getCamionFacade() {
        return camionFacade;
    }

    public void setCamionFacade(CamionFacadeLocal camionFacade) {
        this.camionFacade = camionFacade;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(List<Camion> camiones) {
        this.camiones = camiones;
    }

    public String getModelo_seleccionado() {
        return modelo_seleccionado;
    }

    public void setModelo_seleccionado(String modelo_seleccionado) {
        this.modelo_seleccionado = modelo_seleccionado;
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
