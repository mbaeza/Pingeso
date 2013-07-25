/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.AsignacionConductorCamion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
