/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Coordenadas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface CoordenadasFacadeLocal {

    void create(Coordenadas coordenadas);

    void edit(Coordenadas coordenadas);

    void remove(Coordenadas coordenadas);

    Coordenadas find(Object id);

    List<Coordenadas> findAll();

    List<Coordenadas> findRange(int[] range);

    int count();
    
    String obtenerLatitud(String nombreUsuarioGLatitude);
    
    String obtenerLongitud(String nombreUsuarioGLongitud);
    
}
