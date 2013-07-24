/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesClass;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "coordenadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordenadas.findAll", query = "SELECT c FROM Coordenadas c"),
    @NamedQuery(name = "Coordenadas.findByLatitud", query = "SELECT c FROM Coordenadas c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Coordenadas.findByLongitud", query = "SELECT c FROM Coordenadas c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Coordenadas.findByFecha", query = "SELECT c FROM Coordenadas c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Coordenadas.findById", query = "SELECT c FROM Coordenadas c WHERE c.id = :id")})
public class Coordenadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Longitud")
    private String longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "Id_camion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Camion idcamion;

    public Coordenadas() {
    }

    public Coordenadas(Integer id) {
        this.id = id;
    }

    public Coordenadas(Integer id, String latitud, String longitud, Date fecha) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Camion getIdcamion() {
        return idcamion;
    }

    public void setIdcamion(Camion idcamion) {
        this.idcamion = idcamion;
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
        if (!(object instanceof Coordenadas)) {
            return false;
        }
        Coordenadas other = (Coordenadas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.Coordenadas[ id=" + id + " ]";
    }
    
}
