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
import javax.persistence.Id;
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
@Table(name = "conductor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c"),
    @NamedQuery(name = "Conductor.findByRut", query = "SELECT c FROM Conductor c WHERE c.rut = :rut"),
    @NamedQuery(name = "Conductor.findByFechaNacimiento", query = "SELECT c FROM Conductor c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Conductor.findByDireccion", query = "SELECT c FROM Conductor c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Conductor.findByCorreo", query = "SELECT c FROM Conductor c WHERE c.correo = :correo"),
    @NamedQuery(name = "Conductor.findByTelefono", query = "SELECT c FROM Conductor c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Conductor.findByNombres", query = "SELECT c FROM Conductor c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Conductor.findByPrimerApellido", query = "SELECT c FROM Conductor c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Conductor.findBySegundoApellido", query = "SELECT c FROM Conductor c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Conductor.findByEstado", query = "SELECT c FROM Conductor c WHERE c.estado = :estado")})
public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rut")
    private Integer rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductor")
    private Collection<AsignacionConductorCamion> asignacionConductorCamionCollection;

    public Conductor() {
    }

    public Conductor(Integer rut) {
        this.rut = rut;
    }

    public Conductor(Integer rut, String fechaNacimiento, String direccion, String correo, String telefono, String nombres, String primerApellido, String segundoApellido, String estado) {
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.estado = estado;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AsignacionConductorCamion> getAsignacionConductorCamionCollection() {
        return asignacionConductorCamionCollection;
    }

    public void setAsignacionConductorCamionCollection(Collection<AsignacionConductorCamion> asignacionConductorCamionCollection) {
        this.asignacionConductorCamionCollection = asignacionConductorCamionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.Conductor[ rut=" + rut + " ]";
    }
    
}
