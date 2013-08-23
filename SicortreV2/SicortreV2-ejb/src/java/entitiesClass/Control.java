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
@Table(name = "control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c"),
    @NamedQuery(name = "Control.findByIdControl", query = "SELECT c FROM Control c WHERE c.idControl = :idControl"),
    @NamedQuery(name = "Control.findByHoraSalida", query = "SELECT c FROM Control c WHERE c.horaSalida = :horaSalida"),
    @NamedQuery(name = "Control.findByHoraLlegada", query = "SELECT c FROM Control c WHERE c.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "Control.findByCantidadBasura", query = "SELECT c FROM Control c WHERE c.cantidadBasura = :cantidadBasura"),
    @NamedQuery(name = "Control.findByFecha", query = "SELECT c FROM Control c WHERE c.fecha = :fecha")})
public class Control implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control")
    private Integer idControl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "hora_llegada")
    @Temporal(TemporalType.TIME)
    private Date horaLlegada;
    @Column(name = "cantidad_basura")
    private Integer cantidadBasura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_camion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Camion idCamion;

    public Control() {
    }

    public Control(Integer idControl) {
        this.idControl = idControl;
    }

    public Control(Integer idControl, Date horaSalida, Date fecha) {
        this.idControl = idControl;
        this.horaSalida = horaSalida;
        this.fecha = fecha;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Integer getCantidadBasura() {
        return cantidadBasura;
    }

    public void setCantidadBasura(Integer cantidadBasura) {
        this.cantidadBasura = cantidadBasura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
        hash += (idControl != null ? idControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Control)) {
            return false;
        }
        Control other = (Control) object;
        if ((this.idControl == null && other.idControl != null) || (this.idControl != null && !this.idControl.equals(other.idControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.Control[ idControl=" + idControl + " ]";
    }
    
}
