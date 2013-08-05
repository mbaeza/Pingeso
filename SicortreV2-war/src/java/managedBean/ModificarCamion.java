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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import sessionBeans.CamionFacadeLocal;
import sessionBeans.MarcaFacadeLocal;
import sessionBeans.ModeloFacadeLocal;

/**
 *
 * @author Marco
 */
@Named(value = "modificarCamion")
@RequestScoped
public class ModificarCamion {
    
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
    private Camion camion_seleccionado;  
    private Camion camion_seleccionado_CamEst;    
        
    
    public ModificarCamion() {
    }
    
    @PostConstruct
    public void init(){
        marcas = marcaFacade.findAll();      
        camiones = camionFacade.findAll();
        modelos = modeloFacade.findAll();  
    }
    
    public void modificarCamion(){
        int id = 0;
      /*  if(camionFacade.findAll().size() != 0){
            id = camionFacade.findAll().get(camionFacade.findAll().size()-1).getId()+1;
        }*/       
        camion_seleccionado.setFechaDeCompra(camionBeans.getFecha_compra());
        camion_seleccionado.setKilometraje(Double.parseDouble(camionBeans.getKilometraje()));
        camion_seleccionado.setMaxCarga(Integer.parseInt(camionBeans.getCarga_max()));
        camion_seleccionado.setMotor(camionBeans.getMotor());
        camion_seleccionado.setPatente(camionBeans.getPatente());
        camion_seleccionado.setUsuarioGLatitude(camionBeans.getCod_gps_google());
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(camionBeans.getModelo_seleccionado()))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modelo_seleccionado);
        Modelo modelo = new Modelo(id);
        camion_seleccionado.setControl(camion_seleccionado.getControl());
        camion_seleccionado.setIdModelo(modelo);
        camion_seleccionado.setObservacion(camionBeans.getObservaciones());
        camionFacade.edit(camion_seleccionado);
    }
    
    //funcion utilizada en el modificar camiones, para que aparezcan los datos seleccionados en el formulario
    public void onRowSelect(SelectEvent event) {  
       
        camionBeans.setModelo_seleccionado(modeloFacade.BuscarPorID(camion_seleccionado.getIdModelo().getIdModelo()).getNombreModelo());
        camionBeans.setPatente(camion_seleccionado.getPatente());
        camionBeans.setFecha_compra(camion_seleccionado.getFechaDeCompra());
        camionBeans.setKilometraje(String.valueOf(camion_seleccionado.getKilometraje()));
        camionBeans.setMotor(camion_seleccionado.getMotor());
        camionBeans.setCarga_max(String.valueOf(camion_seleccionado.getMaxCarga()));
        camionBeans.setCod_gps_google(camion_seleccionado.getUsuarioGLatitude());
        camionBeans.setObservaciones(camion_seleccionado.getObservacion());
        
    }  
    
    //Mensaje confirmación Modificar camion
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un camion del sistema satisfactoriamente");    
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

    public Camion getCamion_seleccionado() {
        return camion_seleccionado;
    }

    public void setCamion_seleccionado(Camion camion_seleccionado) {
        this.camion_seleccionado = camion_seleccionado;
    }

    public Camion getCamion_seleccionado_CamEst() {
        return camion_seleccionado_CamEst;
    }

    public void setCamion_seleccionado_CamEst(Camion camion_seleccionado_CamEst) {
        this.camion_seleccionado_CamEst = camion_seleccionado_CamEst;
    }
    
    
}
