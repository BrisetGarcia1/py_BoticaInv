/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tb_proveedor", catalog = "bd_boticainv", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbProveedor.findAll", query = "SELECT t FROM TbProveedor t"),
    @NamedQuery(name = "TbProveedor.findByIdProv", query = "SELECT t FROM TbProveedor t WHERE t.idProv = :idProv"),
    @NamedQuery(name = "TbProveedor.findByNombreProv", query = "SELECT t FROM TbProveedor t WHERE t.nombreProv = :nombreProv"),
    @NamedQuery(name = "TbProveedor.findByRucProv", query = "SELECT t FROM TbProveedor t WHERE t.rucProv = :rucProv"),
    @NamedQuery(name = "TbProveedor.findByDniProv", query = "SELECT t FROM TbProveedor t WHERE t.dniProv = :dniProv"),
    @NamedQuery(name = "TbProveedor.findByDireccionProv", query = "SELECT t FROM TbProveedor t WHERE t.direccionProv = :direccionProv"),
    @NamedQuery(name = "TbProveedor.findByCelularProv", query = "SELECT t FROM TbProveedor t WHERE t.celularProv = :celularProv"),
    @NamedQuery(name = "TbProveedor.findByEmailProv", query = "SELECT t FROM TbProveedor t WHERE t.emailProv = :emailProv"),
    @NamedQuery(name = "TbProveedor.findByNcuentaProv", query = "SELECT t FROM TbProveedor t WHERE t.ncuentaProv = :ncuentaProv"),
    @NamedQuery(name = "TbProveedor.findByEstadoProv", query = "SELECT t FROM TbProveedor t WHERE t.estadoProv = :estadoProv")})
public class TbProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prov", nullable = false)
    private Integer idProv;
    @Basic(optional = false)
    @Column(name = "nombre_prov", nullable = false, length = 100)
    private String nombreProv;
    @Basic(optional = false)
    @Column(name = "ruc_prov", nullable = false, length = 11)
    private String rucProv;
    @Basic(optional = false)
    @Column(name = "dni_prov", nullable = false, length = 8)
    private String dniProv;
    @Column(name = "direccion_prov", length = 50)
    private String direccionProv;
    @Basic(optional = false)
    @Column(name = "celular_prov", nullable = false, length = 9)
    private String celularProv;
    @Column(name = "email_prov", length = 50)
    private String emailProv;
    @Basic(optional = false)
    @Column(name = "ncuenta_prov", nullable = false, length = 16)
    private String ncuentaProv;
    @Basic(optional = false)
    @Column(name = "estado_prov", nullable = false)
    private int estadoProv;
    @OneToMany(mappedBy = "idProv")
    private List<TbKardex> tbKardexList;

    public TbProveedor() {
    }

    public TbProveedor(Integer idProv) {
        this.idProv = idProv;
    }

    public TbProveedor(Integer idProv, String nombreProv, String rucProv, String dniProv, String celularProv, String ncuentaProv, int estadoProv) {
        this.idProv = idProv;
        this.nombreProv = nombreProv;
        this.rucProv = rucProv;
        this.dniProv = dniProv;
        this.celularProv = celularProv;
        this.ncuentaProv = ncuentaProv;
        this.estadoProv = estadoProv;
    }

    public Integer getIdProv() {
        return idProv;
    }

    public void setIdProv(Integer idProv) {
        this.idProv = idProv;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getRucProv() {
        return rucProv;
    }

    public void setRucProv(String rucProv) {
        this.rucProv = rucProv;
    }

    public String getDniProv() {
        return dniProv;
    }

    public void setDniProv(String dniProv) {
        this.dniProv = dniProv;
    }

    public String getDireccionProv() {
        return direccionProv;
    }

    public void setDireccionProv(String direccionProv) {
        this.direccionProv = direccionProv;
    }

    public String getCelularProv() {
        return celularProv;
    }

    public void setCelularProv(String celularProv) {
        this.celularProv = celularProv;
    }

    public String getEmailProv() {
        return emailProv;
    }

    public void setEmailProv(String emailProv) {
        this.emailProv = emailProv;
    }

    public String getNcuentaProv() {
        return ncuentaProv;
    }

    public void setNcuentaProv(String ncuentaProv) {
        this.ncuentaProv = ncuentaProv;
    }

    public int getEstadoProv() {
        return estadoProv;
    }

    public void setEstadoProv(int estadoProv) {
        this.estadoProv = estadoProv;
    }

    public List<TbKardex> getTbKardexList() {
        return tbKardexList;
    }

    public void setTbKardexList(List<TbKardex> tbKardexList) {
        this.tbKardexList = tbKardexList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProv != null ? idProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProveedor)) {
            return false;
        }
        TbProveedor other = (TbProveedor) object;
        if ((this.idProv == null && other.idProv != null) || (this.idProv != null && !this.idProv.equals(other.idProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbProveedor[ idProv=" + idProv + " ]";
    }
    
}
