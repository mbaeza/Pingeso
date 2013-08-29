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
    private Camion camionSeleccionado;  
    private Camion camionSeleccionadoCamEst; 
    private String modeloSeleccionado;
        
    
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
     
        camionSeleccionado.setFechaDeCompra(camionBeans.getFechaCompra());
        camionSeleccionado.setKilometraje(Double.parseDouble(camionBeans.getKilometraje()));
        camionSeleccionado.setMaxCarga(Integer.parseInt(camionBeans.getCargaMax()));
        camionSeleccionado.setMotor(camionBeans.getMotor());
        //camionSeleccionado.setPatente(camionBeans.getPatente());
        camionSeleccionado.setEstado("Activo");
        camionSeleccionado.setUsuarioGLatitude(camionBeans.getCodGpsGoogle());
        for(int i = 0;i<modelos.size();i++){
            if(modelos.get(i).getNombreModelo().equals(modeloSeleccionado))
                id = modelos.get(i).getIdModelo();
        }
        //modelo.setNombreModelo(modelo_seleccionado);
        Modelo modelo = new Modelo(id);
        camionSeleccionado.setControl(camionSeleccionado.getControl());
        camionSeleccionado.setIdModelo(modelo);
        camionSeleccionado.setObservacion(camionBeans.getObservaciones());
        camionFacade.edit(camionSeleccionado);
    }
    
    //funcion utilizada en el modificar camiones, para que aparezcan los datos seleccionados en el formulario
    public void onRowSelect(SelectEvent event) {  
       
        this.setModeloSeleccionado(modeloFacade.BuscarPorID(camionSeleccionado.getIdModelo().getIdModelo()).getNombreModelo());
        camionBeans.setPatente(camionSeleccionado.getPatente());
        camionBeans.setFechaCompra(camionSeleccionado.getFechaDeCompra());
        camionBeans.setKilometraje(String.valueOf(camionSeleccionado.getKilometraje()));
        camionBeans.setMotor(camionSeleccionado.getMotor());
        camionBeans.setCargaMax(String.valueOf(camionSeleccionado.getMaxCarga()));
        camionBeans.setCodGpsGoogle(camionSeleccionado.getUsuarioGLatitude());
        camionBeans.setObservaciones(camionSeleccionado.getObservacion());
        
    }  
    
    //Mensaje confirmación Modificar camion
    public void confirmacionModificar(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación realizada",  "Se ha modificado un camion del sistema satisfactoriamente");    
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }

    public String getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    public void setModeloSeleccionado(String modeloSeleccionado) {
        this.modeloSeleccionado = modeloSeleccionado;
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
        return camionSeleccionado;
    }

    public void setCamion_seleccionado(Camion camion_seleccionado) {
        this.camionSeleccionado = camion_seleccionado;
    }

    public Camion getCamionSeleccionadoCamEst() {
        return camionSeleccionadoCamEst;
    }

    public void setCamionSeleccionadoCamEst(Camion camionSeleccionadoCamEst) {
        this.camionSeleccionadoCamEst = camionSeleccionadoCamEst;
    }
    
    
}
