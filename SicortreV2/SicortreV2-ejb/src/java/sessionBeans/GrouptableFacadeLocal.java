/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Grouptable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GrouptableFacadeLocal {

    void create(Grouptable grouptable);

    void edit(Grouptable grouptable);

    void remove(Grouptable grouptable);

    Grouptable find(Object id);

    List<Grouptable> findAll();

    List<Grouptable> findRange(int[] range);

    int count();
    
}
