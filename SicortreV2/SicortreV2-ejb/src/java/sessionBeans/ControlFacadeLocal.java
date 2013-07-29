/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Control;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface ControlFacadeLocal {

    void create(Control control);

    void edit(Control control);

    void remove(Control control);

    Control find(Object id);

    List<Control> findAll();

    List<Control> findRange(int[] range);

    int count();
    
}
