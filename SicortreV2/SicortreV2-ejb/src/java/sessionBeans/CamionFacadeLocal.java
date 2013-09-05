/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Camion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface CamionFacadeLocal {

    boolean CamionExiste(String patente);
    
    void create(Camion camion);

    void edit(Camion camion);

    void remove(Camion camion);

    Camion find(Object id);

    List<Camion> findAll();

    List<Camion> findRange(int[] range);
    
    Camion BuscarPorID(int ID);

    int count();
    
}
