/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "bitacorasesion", catalog = "bd_boticainv", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bitacorasesion.findAll", query = "SELECT b FROM Bitacorasesion b"),
    @NamedQuery(name = "Bitacorasesion.findByIdbitacora", query = "SELECT b FROM Bitacorasesion b WHERE b.idbitacora = :idbitacora"),
    @NamedQuery(name = "Bitacorasesion.findByEmpleado", query = "SELECT b FROM Bitacorasesion b WHERE b.empleado = :empleado"),
    @NamedQuery(name = "Bitacorasesion.findByFechai", query = "SELECT b FROM Bitacorasesion b WHERE b.fechai = :fechai"),
    @NamedQuery(name = "Bitacorasesion.findByFechas", query = "SELECT b FROM Bitacorasesion b WHERE b.fechas = :fechas")})
public class Bitacorasesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbitacora", nullable = false)
    private Integer idbitacora;
    @Column(name = "empleado", length = 50)
    private String empleado;
    @Column(name = "fechai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechai;
    @Column(name = "fechas")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechas;

    public Bitacorasesion() {
    }

    public Bitacorasesion(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

    public Integer getIdbitacora() {
        return idbitacora;
    }

    public void setIdbitacora(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Date getFechas() {
        return fechas;
    }

    public void setFechas(Date fechas) {
        this.fechas = fechas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbitacora != null ? idbitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacorasesion)) {
            return false;
        }
        Bitacorasesion other = (Bitacorasesion) object;
        if ((this.idbitacora == null && other.idbitacora != null) || (this.idbitacora != null && !this.idbitacora.equals(other.idbitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Bitacorasesion[ idbitacora=" + idbitacora + " ]";
    }
    
}
