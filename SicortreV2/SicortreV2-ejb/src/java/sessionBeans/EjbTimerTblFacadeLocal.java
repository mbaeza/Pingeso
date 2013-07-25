/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.EjbTimerTbl;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface EjbTimerTblFacadeLocal {

    void create(EjbTimerTbl ejbTimerTbl);

    void edit(EjbTimerTbl ejbTimerTbl);

    void remove(EjbTimerTbl ejbTimerTbl);

    EjbTimerTbl find(Object id);

    List<EjbTimerTbl> findAll();

    List<EjbTimerTbl> findRange(int[] range);

    int count();
    
}
