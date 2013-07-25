/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.EjbTimerTbl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco
 */
@Stateless
public class EjbTimerTblFacade extends AbstractFacade<EjbTimerTbl> implements EjbTimerTblFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EjbTimerTblFacade() {
        super(EjbTimerTbl.class);
    }
    
}
