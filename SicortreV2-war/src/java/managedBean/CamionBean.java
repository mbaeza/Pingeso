/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entitiesClass.Camion;  
import sessionBeans.CamionFacadeLocal;
import entitiesClass.Marca;
import sessionBeans.MarcaFacadeLocal;
import entitiesClass.Modelo;
import java.awt.event.ActionEvent;
import sessionBeans.ModeloFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Marco
 */
@Named(value = "camionBean")
@RequestScoped
public class CamionBean implements Serializable {
    //Inyección de dependencia desde los EJB
    @EJB
    private MarcaFacadeLocal marcaFacade;
    @EJB
    private ModeloFacadeLocal modeloFacade;
    @EJB
    private CamionFacadeLocal camionFacade;
    
    //variables a utilizar
    private List<SelectItem> modelosYMarcas;
    private List<Modelo> modelos;
    private List<Marca> marcas;
    private List<Camion> camiones;
    private List<Modelo> modelosSeleccionadosPorMarca;
    private Marca marcaSeleccionada;
    private String modeloSeleccionado;
    private String patente;
    private String fechaCompra;
    private String kilometraje;
    private String motor;
    private String cargaMax;
    private String codGpsGoogle;
    private String observaciones;
    private Camion camionSeleccionado;    
    private Modelo modelo;
    private Camion camionSeleccionadoCamEst;
  
    public CamionBean(){    
    }
   
   @PostConstruct
    public void init(){
        marcas = marcaFacade.findAll();      
        camiones = camionFacade.findAll();
        modelos = modeloFacade.findAll();  
   }
   
    //Setters y Getters
    public Camion getCamionSeleccionadoCamEst() {
        return camionSeleccionadoCamEst;
    }

    public void setCamionSeleccionadoCamEst(Camion camionSeleccionadoCamEst) {
        this.camionSeleccionadoCamEst = camionSeleccionadoCamEst;
    }
    
    public Camion getCamionSeleccionado() {
        return camionSeleccionado;
    }

    public void setCamionSeleccionado(Camion camionSeleccionado) {
        this.camionSeleccionado = camionSeleccionado;
    }
    
     public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<SelectItem> getModelosYMarcas() {
        return modelosYMarcas;
    }

    public void setModelosYMarcas(List<SelectItem> modelosYMarcas) {
        this.modelosYMarcas = modelosYMarcas;
    }
    
    public List<Modelo> getModelosSeleccionadosPorMarca() {
        return modelosSeleccionadosPorMarca;
    }

    public void setModelosSeleccionadosPorMarca(List<Modelo> modelosSeleccionadosPorMarca) {
        this.modelosSeleccionadosPorMarca = modelosSeleccionadosPorMarca;
    }

    
    public MarcaFacadeLocal getMarcaFacade() {
        return marcaFacade;
    }

    public void setMarcaFacade(MarcaFacadeLocal marcaFacade) {
        this.marcaFacade = marcaFacade;
    }

    public ModeloFacadeLocal getModeloFacade() {
        return modeloFacade;
    }

    public void setModeloFacade(ModeloFacadeLocal modeloFacade) {
        this.modeloFacade = modeloFacade;
    }

    public CamionFacadeLocal getCamionFacade() {
        return camionFacade;
    }

    public void setCamionFacade(CamionFacadeLocal camionFacade) {
        this.camionFacade = camionFacade;
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

    public Marca getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Marca marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    public String getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    public void setModeloSeleccionado(String modeloSeleccionado) {
        this.modeloSeleccionado = modeloSeleccionado;
    }

    //Funcion para insertarun camion
    public void insertarCamion(){
        int id = 0;
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Camion camion = new Camion();
        camion.setEstado("Activo");
        camion.setFechaDeCompra(fechaCompra);
        camion.setKilometraje(Double.parseDouble(kilometraje));
        camion.setMaxCarga(Integer.parseInt(cargaMax));
        camion.setMotor(motor);
        camion.setPatente(patente);
        camion.setControl("Estacionado");
        camion.setUsuarioGLatitude(codGpsGoogle);
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modeloSeleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modeloSeleccionado);
        modelo = new Modelo(id);
        camion.setIdModelo(modelo);
        camion.setObservacion(observaciones);
        camionFacade.create(camion);
        
        modeloSeleccionado = "";
        patente = null;
        fechaCompra = null;;
        kilometraje = null;
        motor = null;
        cargaMax =null;
        codGpsGoogle = null;
        observaciones = null;
        
    }
    
    //funcion para modificar los datos de un camion
    public void modificarCamion(){
        int id = 0;
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Camion camion = new Camion();
        camion.setId(camionSeleccionado.getId());
        camion.setFechaDeCompra(fechaCompra);
        camion.setKilometraje(Double.parseDouble(kilometraje));
        camion.setMaxCarga(Integer.parseInt(cargaMax));
        camion.setMotor(motor);
        camion.setPatente(patente);
        camion.setUsuarioGLatitude(codGpsGoogle);
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modeloSeleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modeloSeleccionado);
        modelo = new Modelo(id);
        camion.setEstado("Activo");
        camion.setIdModelo(modelo);
        camion.setObservacion(observaciones);
        camionFacade.edit(camion);
    }
    
    //funcion para cambiar el estado de un camion
    public void cambiarEstadoCamion(){
        
        camionSeleccionadoCamEst.setEstado("Inactivo");
        camionFacade.edit(camionSeleccionadoCamEst);
        
    }
    
    //funcion utilizada en el modificar camiones, para que aparezcan los datos seleccionados en el formulario
    public void onRowSelect(SelectEvent event) {  
       
        modeloSeleccionado = modeloFacade.BuscarPorID(camionSeleccionado.getIdModelo().getIdModelo()).getNombreModelo();
        patente = camionSeleccionado.getPatente();
        fechaCompra = camionSeleccionado.getFechaDeCompra();
        kilometraje = String.valueOf(camionSeleccionado.getKilometraje());
        motor = camionSeleccionado.getMotor() ;
        cargaMax = String.valueOf(camionSeleccionado.getMaxCarga());
        codGpsGoogle = camionSeleccionado.getUsuarioGLatitude();
        observaciones = camionSeleccionado.getObservacion();
        
    }  
    
    //Mensaje confirmación Modificar camion
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }  
    
    //Mensaje confirmación Agregar camion
    public void confirmacionAgregar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregación realizada",  "Se ha agregado un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 
    
    //Mensaje confirmación Cambiar de estado camion
    public void confirmacionCambiarEstado(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio de estado realizado",  "Se ha cambiado el estado un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    } 
}
