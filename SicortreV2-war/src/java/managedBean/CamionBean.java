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
    @EJB
    private MarcaFacadeLocal marcaFacade;
    @EJB
    private ModeloFacadeLocal modeloFacade;
    @EJB
    private CamionFacadeLocal camionFacade;
    
    private List<SelectItem> modelos_y_marcas;
    private List<Modelo> modelos;
    private List<Marca> marcas;
    private List<Camion> camiones;
    private List<Modelo> modelosSeleccionadosPorMarca;
    private Marca marca_seleccionada;
    private String modelo_seleccionado;
    private String patente;
    private String fecha_compra;
    private String kilometraje;
    private String motor;
    private String carga_max;
    private String cod_gps_google;
    private String observaciones;
    private Camion camion_seleccionado;    
    private Modelo modelo;

  
   public CamionBean(){    
   }
   
   @PostConstruct
    public void init(){
        marcas = marcaFacade.findAll();      
        camiones = camionFacade.findAll();
        modelos = modeloFacade.findAll();  
        //modelos_y_marcas = camionFacade.MarcasModelos();
       // modelos_y_marcas = new CamionBean().MarcasModelos(modelos, marcas);
       /* for(int i = 0;i < modelos.size();i++){
           SelectItemGroup Mo1 = new SelectItemGroup(modelos.get(i).getNombreModelo());
           SelectItem items[] = null;
           for(int u = 0;u < marcas.size();u++){
               SelectItem item = new SelectItem(marcas.get(u).getNombreMarca(),marcas.get(u).getNombreMarca());
               items[u] = item;
        }
           Mo1.setSelectItems(items);
           modelos_y_marcas.add(Mo1);
        }*/
       // modelos = modeloFacade.find(marca_seleccionada.getIdMarca());
        /*for(int i = 0;i < modelos.size();i++){
            if(marca_seleccionada.getIdMarca() == modelos.get(i).getIdMarca().getIdMarca()){
                modelosSeleccionadosPorMarca.add(modeloFacade.findAll().get(i));
            }
        }*/
    }
    
    public Camion getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(Camion camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }
    
     public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<SelectItem> getModelos_y_marcas() {
        return modelos_y_marcas;
    }

    public void setModelos_y_marcas(List<SelectItem> modelos_y_marcas) {
        this.modelos_y_marcas = modelos_y_marcas;
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

    public Marca getMarca_seleccionada() {
        return marca_seleccionada;
    }

    public void setMarca_seleccionada(Marca marca_seleccionada) {
        this.marca_seleccionada = marca_seleccionada;
    }

    public String getModelo_seleccionado() {
        return modelo_seleccionado;
    }

    public void setModelo_seleccionado(String modelo_seleccionado) {
        this.modelo_seleccionado = modelo_seleccionado;
    }

    public void insertarCamion(){
        int id = 0;
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Camion camion = new Camion();
        camion.setFechaDeCompra(fecha_compra);
        camion.setKilometraje(Double.parseDouble(kilometraje));
        camion.setMaxCarga(Integer.parseInt(carga_max));
        camion.setMotor(motor);
        camion.setPatente(patente);
        camion.setUsuarioGLatitude(cod_gps_google);
        camion.setIdConductor(null);
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modelo_seleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modelo_seleccionado);
        modelo = new Modelo(id);
        camion.setIdModelo(modelo);
        camion.setObservacion(observaciones);
        camionFacade.create(camion);
    }
    
    public void modificarCamion(){
        int id = 0;
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/
        Camion camion = new Camion();
        camion.setId(camion_seleccionado.getId());
        camion.setFechaDeCompra(fecha_compra);
        camion.setKilometraje(Double.parseDouble(kilometraje));
        camion.setMaxCarga(Integer.parseInt(carga_max));
        camion.setMotor(motor);
        camion.setPatente(patente);
        camion.setUsuarioGLatitude(cod_gps_google);
        camion.setIdConductor(null);
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modelo_seleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modelo_seleccionado);
        modelo = new Modelo(id);
        camion.setIdModelo(modelo);
        camion.setObservacion(observaciones);
        camionFacade.edit(camion);
    }
    
    
    
    public void onRowSelect(SelectEvent event) {  
       /* FacesMessage msg = new FacesMessage("Car Selected", ((Camion) event.getObject()).getPatente());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
      //  Modelo miModelo = modeloFacade.BuscarPorID(String.valueOf(camion_seleccionado.getId()));
        modelo_seleccionado = modeloFacade.BuscarPorID(camion_seleccionado.getIdModelo().getIdModelo()).getNombreModelo();
        patente = camion_seleccionado.getPatente();
        fecha_compra = camion_seleccionado.getFechaDeCompra();
        kilometraje = String.valueOf(camion_seleccionado.getKilometraje());
        motor = camion_seleccionado.getMotor() ;
        carga_max = String.valueOf(camion_seleccionado.getMaxCarga());
        cod_gps_google = camion_seleccionado.getUsuarioGLatitude();
        observaciones = camion_seleccionado.getObservacion();
        
    }   
}
