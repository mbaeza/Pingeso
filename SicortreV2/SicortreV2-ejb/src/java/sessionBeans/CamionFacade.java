/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Camion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marco
 */
@Stateless
public class CamionFacade extends AbstractFacade<Camion> implements CamionFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamionFacade() {
        super(Camion.class);
    }
    
    @Override
    public Camion BuscarPorID(int ID) {
        Query query;
        query = em.createNamedQuery("Camion.findAll");
        List<Camion> camiones =  query.getResultList();
        
        for(Camion camionEleg : camiones){
            if(camionEleg.getId() == ID ){
                return camionEleg;
            }            
        }
        return (Camion)query.getResultList().get(0);
    }
    
    @Override
    public boolean CamionExiste(String patente) {
        Query query;
        query = em.createNamedQuery("Camion.findAll");
        List<Camion> camiones =  query.getResultList();
        
        for(Camion camionEleg : camiones){
            if(camionEleg.getPatente().equals(patente) ){
                return true;
            }            
        }
        return false;
    }
    
}
