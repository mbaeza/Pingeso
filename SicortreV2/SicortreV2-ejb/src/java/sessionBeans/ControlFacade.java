/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Control;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco
 */
@Stateless
public class ControlFacade extends AbstractFacade<Control> implements ControlFacadeLocal {
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlFacade() {
        super(Control.class);
    }
    
}
