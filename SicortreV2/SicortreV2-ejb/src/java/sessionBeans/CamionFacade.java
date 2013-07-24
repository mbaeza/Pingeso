/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import com.sun.xml.ws.api.transport.tcp.SelectOptimalTransport;
import entitiesClass.Camion;
import entitiesClass.Marca;
import entitiesClass.Modelo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marco
 */
@Stateless
public class CamionFacade extends AbstractFacade<Camion> implements CamionFacadeLocal {
    @EJB
    private ModeloFacadeLocal modeloFacade;
    @EJB
    private MarcaFacadeLocal marcaFacade;
    
    @PersistenceContext(unitName = "SicortreV2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamionFacade() {
        super(Camion.class);
    }

    @Override
    public Camion BuscarPorID(int ID) {
        Query query;
        query = em.createNamedQuery("Camion.findAll");
        List<Camion> camiones =  query.getResultList();
        
        for(Camion camionEleg : camiones){
            if(camionEleg.getId() == ID ){
                return camionEleg;
            }            
        }
        return (Camion)query.getResultList().get(0);
    }
    /*@Override
    public List<SelectItem> MarcasModelos(){
        List<SelectItem> modelos_y_marcas = null;
        List<Modelo> modelos = modeloFacade.findAll();
        List<Marca> marcas = marcaFacade.findAll();

        for(int i = 0;i < modelos.size();i++){
            SelectItemGroup Mo1 = new SelectItemGroup(modelos.get(i).getNombreModelo());
            SelectItem items[] = null;
            for(int u = 0;u < marcas.size();u++){
                SelectItem item = new SelectItem(marcas.get(u).getNombreMarca(),marcas.get(u).getNombreMarca());
                items[u] = item;
            }
            Mo1.setSelectItems(items);
            modelos_y_marcas.add(Mo1);
        }
        return modelos_y_marcas;
    }*/
    
    
    
}
