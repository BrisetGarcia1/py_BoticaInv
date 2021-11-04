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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_kardex", catalog = "bd_boticainv", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbKardex.findAll", query = "SELECT t FROM TbKardex t"),
    @NamedQuery(name = "TbKardex.findByNtransaccionKar", query = "SELECT t FROM TbKardex t WHERE t.ntransaccionKar = :ntransaccionKar"),
    @NamedQuery(name = "TbKardex.findByOperacionKar", query = "SELECT t FROM TbKardex t WHERE t.operacionKar = :operacionKar"),
    @NamedQuery(name = "TbKardex.findByCantidadKar", query = "SELECT t FROM TbKardex t WHERE t.cantidadKar = :cantidadKar"),
    @NamedQuery(name = "TbKardex.findByFechaKar", query = "SELECT t FROM TbKardex t WHERE t.fechaKar = :fechaKar"),
    @NamedQuery(name = "TbKardex.findByStock", query = "SELECT t FROM TbKardex t WHERE t.stock = :stock")})
public class TbKardex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ntransaccion_kar", nullable = false)
    private Integer ntransaccionKar;
    @Column(name = "operacion_kar", length = 50)
    private String operacionKar;
    @Column(name = "cantidad_kar")
    private Integer cantidadKar;
    @Column(name = "fecha_kar")
    @Temporal(TemporalType.DATE)
    private Date fechaKar;
    @Column(name = "stock")
    private Integer stock;
    @JoinColumn(name = "cbarras_prod", referencedColumnName = "cbarras_prod", nullable = false)
    @ManyToOne(optional = false)
    private TbProducto cbarrasProd;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    @ManyToOne
    private TbDocumento idDocumento;
    @JoinColumn(name = "id_empl", referencedColumnName = "id_empl")
    @ManyToOne
    private TbEmpleado idEmpl;
    @JoinColumn(name = "id_prov", referencedColumnName = "id_prov")
    @ManyToOne
    private TbProveedor idProv;

    public TbKardex() {
    }

    public TbKardex(Integer ntransaccionKar) {
        this.ntransaccionKar = ntransaccionKar;
    }

    public Integer getNtransaccionKar() {
        return ntransaccionKar;
    }

    public void setNtransaccionKar(Integer ntransaccionKar) {
        this.ntransaccionKar = ntransaccionKar;
    }

    public String getOperacionKar() {
        return operacionKar;
    }

    public void setOperacionKar(String operacionKar) {
        this.operacionKar = operacionKar;
    }

    public Integer getCantidadKar() {
        return cantidadKar;
    }

    public void setCantidadKar(Integer cantidadKar) {
        this.cantidadKar = cantidadKar;
    }

    public Date getFechaKar() {
        return fechaKar;
    }

    public void setFechaKar(Date fechaKar) {
        this.fechaKar = fechaKar;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public TbProducto getCbarrasProd() {
        return cbarrasProd;
    }

    public void setCbarrasProd(TbProducto cbarrasProd) {
        this.cbarrasProd = cbarrasProd;
    }

    public TbDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(TbDocumento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public TbEmpleado getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(TbEmpleado idEmpl) {
        this.idEmpl = idEmpl;
    }

    public TbProveedor getIdProv() {
        return idProv;
    }

    public void setIdProv(TbProveedor idProv) {
        this.idProv = idProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ntransaccionKar != null ? ntransaccionKar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbKardex)) {
            return false;
        }
        TbKardex other = (TbKardex) object;
        if ((this.ntransaccionKar == null && other.ntransaccionKar != null) || (this.ntransaccionKar != null && !this.ntransaccionKar.equals(other.ntransaccionKar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbKardex[ ntransaccionKar=" + ntransaccionKar + " ]";
    }
    
}
