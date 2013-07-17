/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesClass;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ejb__timer__tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EjbTimerTbl.findAll", query = "SELECT e FROM EjbTimerTbl e"),
    @NamedQuery(name = "EjbTimerTbl.findByTimerid", query = "SELECT e FROM EjbTimerTbl e WHERE e.timerid = :timerid"),
    @NamedQuery(name = "EjbTimerTbl.findByApplicationid", query = "SELECT e FROM EjbTimerTbl e WHERE e.applicationid = :applicationid"),
    @NamedQuery(name = "EjbTimerTbl.findByContainerid", query = "SELECT e FROM EjbTimerTbl e WHERE e.containerid = :containerid"),
    @NamedQuery(name = "EjbTimerTbl.findByCreationtimeraw", query = "SELECT e FROM EjbTimerTbl e WHERE e.creationtimeraw = :creationtimeraw"),
    @NamedQuery(name = "EjbTimerTbl.findByInitialexpirationraw", query = "SELECT e FROM EjbTimerTbl e WHERE e.initialexpirationraw = :initialexpirationraw"),
    @NamedQuery(name = "EjbTimerTbl.findByIntervalduration", query = "SELECT e FROM EjbTimerTbl e WHERE e.intervalduration = :intervalduration"),
    @NamedQuery(name = "EjbTimerTbl.findByLastexpirationraw", query = "SELECT e FROM EjbTimerTbl e WHERE e.lastexpirationraw = :lastexpirationraw"),
    @NamedQuery(name = "EjbTimerTbl.findByOwnerid", query = "SELECT e FROM EjbTimerTbl e WHERE e.ownerid = :ownerid"),
    @NamedQuery(name = "EjbTimerTbl.findByPkhashcode", query = "SELECT e FROM EjbTimerTbl e WHERE e.pkhashcode = :pkhashcode"),
    @NamedQuery(name = "EjbTimerTbl.findBySchedule", query = "SELECT e FROM EjbTimerTbl e WHERE e.schedule = :schedule"),
    @NamedQuery(name = "EjbTimerTbl.findByState", query = "SELECT e FROM EjbTimerTbl e WHERE e.state = :state")})
public class EjbTimerTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TIMERID")
    private String timerid;
    @Column(name = "APPLICATIONID")
    private BigInteger applicationid;
    @Lob
    @Column(name = "BLOB")
    private byte[] blob;
    @Column(name = "CONTAINERID")
    private BigInteger containerid;
    @Column(name = "CREATIONTIMERAW")
    private BigInteger creationtimeraw;
    @Column(name = "INITIALEXPIRATIONRAW")
    private BigInteger initialexpirationraw;
    @Column(name = "INTERVALDURATION")
    private BigInteger intervalduration;
    @Column(name = "LASTEXPIRATIONRAW")
    private BigInteger lastexpirationraw;
    @Size(max = 255)
    @Column(name = "OWNERID")
    private String ownerid;
    @Column(name = "PKHASHCODE")
    private Integer pkhashcode;
    @Size(max = 255)
    @Column(name = "SCHEDULE")
    private String schedule;
    @Column(name = "STATE")
    private Integer state;

    public EjbTimerTbl() {
    }

    public EjbTimerTbl(String timerid) {
        this.timerid = timerid;
    }

    public String getTimerid() {
        return timerid;
    }

    public void setTimerid(String timerid) {
        this.timerid = timerid;
    }

    public BigInteger getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(BigInteger applicationid) {
        this.applicationid = applicationid;
    }

    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

    public BigInteger getContainerid() {
        return containerid;
    }

    public void setContainerid(BigInteger containerid) {
        this.containerid = containerid;
    }

    public BigInteger getCreationtimeraw() {
        return creationtimeraw;
    }

    public void setCreationtimeraw(BigInteger creationtimeraw) {
        this.creationtimeraw = creationtimeraw;
    }

    public BigInteger getInitialexpirationraw() {
        return initialexpirationraw;
    }

    public void setInitialexpirationraw(BigInteger initialexpirationraw) {
        this.initialexpirationraw = initialexpirationraw;
    }

    public BigInteger getIntervalduration() {
        return intervalduration;
    }

    public void setIntervalduration(BigInteger intervalduration) {
        this.intervalduration = intervalduration;
    }

    public BigInteger getLastexpirationraw() {
        return lastexpirationraw;
    }

    public void setLastexpirationraw(BigInteger lastexpirationraw) {
        this.lastexpirationraw = lastexpirationraw;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public Integer getPkhashcode() {
        return pkhashcode;
    }

    public void setPkhashcode(Integer pkhashcode) {
        this.pkhashcode = pkhashcode;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timerid != null ? timerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EjbTimerTbl)) {
            return false;
        }
        EjbTimerTbl other = (EjbTimerTbl) object;
        if ((this.timerid == null && other.timerid != null) || (this.timerid != null && !this.timerid.equals(other.timerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesClass.EjbTimerTbl[ timerid=" + timerid + " ]";
    }
    
}
