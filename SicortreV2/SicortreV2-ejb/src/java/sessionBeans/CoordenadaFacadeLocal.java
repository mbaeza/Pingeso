/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entitiesClass.Coordenada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface CoordenadaFacadeLocal {

    void create(Coordenada coordenada);

    void edit(Coordenada coordenada);

    void remove(Coordenada coordenada);

    Coordenada find(Object id);

    List<Coordenada> findAll();

    List<Coordenada> findRange(int[] range);

    int count();
    
    String obtenerLatitud(String nombreUsuarioGLatitude);
    
    String obtenerLongitud(String nombreUsuarioGLongitud);

    void guardarCoordenadas();
    
}
