/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Camion;
import entitiesClass.Conductor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marco
 */
@Stateless
public class AsignacionConductorCamionFacade extends AbstractFacade<AsignacionConductorCamion> implements AsignacionConductorCamionFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionConductorCamionFacade() {
        super(AsignacionConductorCamion.class);
    }
    
    @Override
    public List<AsignacionConductorCamion> BuscarPorCamion() {
        Query query, query2;      
        List<AsignacionConductorCamion> camiones_guardados = new ArrayList<AsignacionConductorCamion>();
        
        query = em.createNamedQuery("AsignacionConductorCamion.findAll");
        List<AsignacionConductorCamion> asignaciones =  query.getResultList();
        
        query2 = em.createNamedQuery("Camion.findAll");
        List<Camion> camiones =  query2.getResultList();
        
        for(Camion camionEleg : camiones){
            int flag = 0;
            AsignacionConductorCamion asignacion = new AsignacionConductorCamion();
            for(int i = 0;i<asignaciones.size();i++){
                
                if(camionEleg.getId() == asignaciones.get(i).getIdCamion().getId()){
                    flag = 1;
                    if(i==0){
                        asignacion = asignaciones.get(i);                       
                        
                    }else if(asignacion.getFecha().before(asignaciones.get(i).getFecha())){
                       asignacion = asignaciones.get(i);  
                    }
                }
            
            }
            if(flag == 1)
                camiones_guardados.add(asignacion);
            
        }        
        return camiones_guardados;
    }

    @Override
    public void cambiarEstado(Conductor conductor, Camion camion) {
        List<AsignacionConductorCamion> asignaciones_Antiguas = findAll();
        
        for(AsignacionConductorCamion AsignacionElegida : asignaciones_Antiguas){
            if(AsignacionElegida.getIdConductor().getRut().equals(conductor.getRut()) || AsignacionElegida.getIdCamion().getId().equals(camion.getId())){
                AsignacionElegida.setEstado("Inactivo");
                edit(AsignacionElegida);
            }
        }          
        
    }

    @Override
    public List<AsignacionConductorCamion> asignacionesActivas() {
        List<AsignacionConductorCamion> asignaciones = findAll();
        List<AsignacionConductorCamion> asignacionesActivas = new ArrayList<AsignacionConductorCamion>();
        for(AsignacionConductorCamion AsignacionElegida : asignaciones){
            if(AsignacionElegida.getEstado().equals("Activo")){
                asignacionesActivas.add(AsignacionElegida);
            }            
        }  
        return asignacionesActivas;
    }
    
    
    
}
