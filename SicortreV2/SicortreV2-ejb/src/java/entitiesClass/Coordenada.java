/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "coordenada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordenada.findAll", query = "SELECT c FROM Coordenada c"),
    @NamedQuery(name = "Coordenada.findById", query = "SELECT c FROM Coordenada c WHERE c.id = :id"),
    @NamedQuery(name = "Coordenada.findByLatitud", query = "SELECT c FROM Coordenada c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Coordenada.findByLongitud", query = "SELECT c FROM Coordenada c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Coordenada.findByFecha", query = "SELECT c FROM Coordenada c WHERE c.fecha = :fecha")})
public class Coordenada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "longitud")
    private String longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Fecha")
    private String fecha;
    @JoinColumn(name = "id_camion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Camion idCamion;

    public Coordenada() {
    }

    public Coordenada(Integer id) {
        this.id = id;
    }

    public Coordenada(Integer id, String latitud, String longitud, String fecha) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Camion getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Camion idCamion) {
        this.idCamion = idCamion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordenada)) {
            return false;
        }
        Coordenada other = (Coordenada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.Coordenada[ id=" + id + " ]";
    }
    
}
