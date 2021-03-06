/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.AsignacionConductorCamion;
import entitiesClass.Camion;
import entitiesClass.Conductor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface AsignacionConductorCamionFacadeLocal {

    void create(AsignacionConductorCamion asignacionConductorCamion);

    void edit(AsignacionConductorCamion asignacionConductorCamion);

    void remove(AsignacionConductorCamion asignacionConductorCamion);

    AsignacionConductorCamion find(Object id);

    List<AsignacionConductorCamion> findAll();

    List<AsignacionConductorCamion> findRange(int[] range);

    int count();
    
    List<AsignacionConductorCamion> BuscarPorCamion();

    void cambiarEstado(Conductor conductor, Camion camion);

    List<AsignacionConductorCamion> asignacionesActivas();
    
}
