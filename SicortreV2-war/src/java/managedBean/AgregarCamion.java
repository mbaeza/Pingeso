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
import javax.inject.Inject;
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
    @Inject CamionBeans camionBeans;    

    private List<Modelo> modelos;
    private List<Marca> marcas;
    private List<Camion> camiones;
    private String modeloSeleccionado;
    
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
        camion.setFechaDeCompra(camionBeans.getFechaCompra());
        camion.setKilometraje(Double.parseDouble(camionBeans.getKilometraje()));
        camion.setMaxCarga(Integer.parseInt(camionBeans.getCargaMax()));
        camion.setMotor(camionBeans.getMotor());
        camion.setPatente(camionBeans.getPatente());
        camion.setControl("Estacionado");
        camion.setUsuarioGLatitude(camionBeans.getCodGpsGoogle());
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modeloSeleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modelo_seleccionado);
        Modelo modelo = new Modelo(id);
        camion.setIdModelo(modelo);
        camion.setObservacion(camionBeans.getObservaciones());
        camionFacade.create(camion);
        
        this.setModeloSeleccionado("");
        camionBeans.setPatente(null);
        camionBeans.setFechaCompra(null);
        camionBeans.setKilometraje(null);
        camionBeans.setMotor(null);
        camionBeans.setCargaMax(null);
        camionBeans.setCodGpsGoogle(null);
        camionBeans.setObservaciones(null);
        
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

    public CamionBeans getCamionBeans() {
        return camionBeans;
    }

    public void setCamionBeans(CamionBeans camionBeans) {
        this.camionBeans = camionBeans;
    }

    public String getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    public void setModeloSeleccionado(String modeloSeleccionado) {
        this.modeloSeleccionado = modeloSeleccionado;
    }
    
}
