/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Conductor;
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
public class ConductorFacade extends AbstractFacade<Conductor> implements ConductorFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConductorFacade() {
        super(Conductor.class);
    }
    
    @Override
    public boolean ConductorExiste(int rut) {
        Query query;
        query = em.createNamedQuery("Conductor.findAll");
        List<Conductor> conductores =  query.getResultList();
        
        for(Conductor conductorEleg : conductores){
            if(conductorEleg.getRut()==rut ){
                return true;
            }            
        }
        return false;
    }
    
}
