/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Camion;
import entitiesClass.Marca;
import entitiesClass.Modelo;
import java.util.List;
import javax.ejb.Local;
import javax.faces.model.SelectItem;

/**
 *
 * @author Marco
 */
@Local
public interface CamionFacadeLocal {

    void create(Camion camion);

    void edit(Camion camion);

    void remove(Camion camion);

    Camion find(Object id);

    List<Camion> findAll();

    List<Camion> findRange(int[] range);

    int count();

   /* List<SelectItem> MarcasModelos();*/
    
}
