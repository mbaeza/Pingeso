/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesClass;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByPatente", query = "SELECT c FROM Camion c WHERE c.patente = :patente"),
    @NamedQuery(name = "Camion.findById", query = "SELECT c FROM Camion c WHERE c.id = :id"),
    @NamedQuery(name = "Camion.findByUsuarioGLatitude", query = "SELECT c FROM Camion c WHERE c.usuarioGLatitude = :usuarioGLatitude"),
    @NamedQuery(name = "Camion.findByFechaDeCompra", query = "SELECT c FROM Camion c WHERE c.fechaDeCompra = :fechaDeCompra"),
    @NamedQuery(name = "Camion.findByObservacion", query = "SELECT c FROM Camion c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Camion.findByMaxCarga", query = "SELECT c FROM Camion c WHERE c.maxCarga = :maxCarga"),
    @NamedQuery(name = "Camion.findByMotor", query = "SELECT c FROM Camion c WHERE c.motor = :motor"),
    @NamedQuery(name = "Camion.findByKilometraje", query = "SELECT c FROM Camion c WHERE c.kilometraje = :kilometraje"),
    @NamedQuery(name = "Camion.findByEstado", query = "SELECT c FROM Camion c WHERE c.estado = :estado"),
    @NamedQuery(name = "Camion.findByControl", query = "SELECT c FROM Camion c WHERE c.control = :control")})
public class Camion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Patente")
    private String patente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "UsuarioGLatitude")
    private String usuarioGLatitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "fecha_de_compra")
    private String fechaDeCompra;
    @Size(max = 400)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_carga")
    private int maxCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "motor")
    private String motor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kilometraje")
    private double kilometraje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "Control")
    private String control;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne(optional = false)
    private Modelo idModelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamion")
    private Collection<AsignacionConductorCamion> asignacionConductorCamionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamion")
    private Collection<Control> controlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamion")
    private Collection<Coordenada> coordenadaCollection;

    public Camion() {
    }

    public Camion(Integer id) {
        this.id = id;
    }

    public Camion(Integer id, String patente, String usuarioGLatitude, String fechaDeCompra, int maxCarga, String motor, double kilometraje, String estado, String control) {
        this.id = id;
        this.patente = patente;
        this.usuarioGLatitude = usuarioGLatitude;
        this.fechaDeCompra = fechaDeCompra;
        this.maxCarga = maxCarga;
        this.motor = motor;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.control = control;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuarioGLatitude() {
        return usuarioGLatitude;
    }

    public void setUsuarioGLatitude(String usuarioGLatitude) {
        this.usuarioGLatitude = usuarioGLatitude;
    }

    public String getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(String fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getMaxCarga() {
        return maxCarga;
    }

    public void setMaxCarga(int maxCarga) {
        this.maxCarga = maxCarga;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AsignacionConductorCamion> getAsignacionConductorCamionCollection() {
        return asignacionConductorCamionCollection;
    }

    public void setAsignacionConductorCamionCollection(Collection<AsignacionConductorCamion> asignacionConductorCamionCollection) {
        this.asignacionConductorCamionCollection = asignacionConductorCamionCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Control> getControlCollection() {
        return controlCollection;
    }

    public void setControlCollection(Collection<Control> controlCollection) {
        this.controlCollection = controlCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Coordenada> getCoordenadaCollection() {
        return coordenadaCollection;
    }

    public void setCoordenadaCollection(Collection<Coordenada> coordenadaCollection) {
        this.coordenadaCollection = coordenadaCollection;
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
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.Camion[ id=" + id + " ]";
    }
    
}
