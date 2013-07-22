/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Modelo;
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
public class ModeloFacade extends AbstractFacade<Modelo> implements ModeloFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }   

    @Override
    public Modelo BuscarPorID(int ID) {
        Query query;
        query = em.createNamedQuery("Modelo.findAll");
        List<Modelo> modelos =  query.getResultList();
        
        for(Modelo modeloEleg : modelos){
            if(modeloEleg.getIdModelo() == ID ){
                return modeloEleg;
            }            
        }
        return (Modelo)query.getResultList().get(0);
    }
    
    
}