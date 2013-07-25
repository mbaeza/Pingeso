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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "asignacion_conductor_camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionConductorCamion.findAll", query = "SELECT a FROM AsignacionConductorCamion a"),
    @NamedQuery(name = "AsignacionConductorCamion.findByFecha", query = "SELECT a FROM AsignacionConductorCamion a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AsignacionConductorCamion.findByIdAsignar", query = "SELECT a FROM AsignacionConductorCamion a WHERE a.idAsignar = :idAsignar")})
public class AsignacionConductorCamion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignar")
    private Integer idAsignar;
    @JoinColumn(name = "id_conductor", referencedColumnName = "Rut")
    @ManyToOne(optional = false)
    private Conductor idConductor;
    @JoinColumn(name = "id_camion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Camion idCamion;

    public AsignacionConductorCamion() {
    }

    public AsignacionConductorCamion(Integer idAsignar) {
        this.idAsignar = idAsignar;
    }

    public AsignacionConductorCamion(Integer idAsignar, Date fecha) {
        this.idAsignar = idAsignar;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdAsignar() {
        return idAsignar;
    }

    public void setIdAsignar(Integer idAsignar) {
        this.idAsignar = idAsignar;
    }

    public Conductor getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Conductor idConductor) {
        this.idConductor = idConductor;
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
        hash += (idAsignar != null ? idAsignar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionConductorCamion)) {
            return false;
        }
        AsignacionConductorCamion other = (AsignacionConductorCamion) object;
        if ((this.idAsignar == null && other.idAsignar != null) || (this.idAsignar != null && !this.idAsignar.equals(other.idAsignar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.AsignacionConductorCamion[ idAsignar=" + idAsignar + " ]";
    }
    
}
