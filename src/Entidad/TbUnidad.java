/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tb_unidad", catalog = "bd_boticainv", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbUnidad.findAll", query = "SELECT t FROM TbUnidad t"),
    @NamedQuery(name = "TbUnidad.findByIdUnid", query = "SELECT t FROM TbUnidad t WHERE t.idUnid = :idUnid"),
    @NamedQuery(name = "TbUnidad.findByDescripcionUnid", query = "SELECT t FROM TbUnidad t WHERE t.descripcionUnid = :descripcionUnid")})
public class TbUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unid", nullable = false)
    private Integer idUnid;
    @Basic(optional = false)
    @Column(name = "descripcion_unid", nullable = false, length = 50)
    private String descripcionUnid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnid")
    private List<TbProducto> tbProductoList;

    public TbUnidad() {
    }

    public TbUnidad(Integer idUnid) {
        this.idUnid = idUnid;
    }

    public TbUnidad(Integer idUnid, String descripcionUnid) {
        this.idUnid = idUnid;
        this.descripcionUnid = descripcionUnid;
    }

    public Integer getIdUnid() {
        return idUnid;
    }

    public void setIdUnid(Integer idUnid) {
        this.idUnid = idUnid;
    }

    public String getDescripcionUnid() {
        return descripcionUnid;
    }

    public void setDescripcionUnid(String descripcionUnid) {
        this.descripcionUnid = descripcionUnid;
    }

    public List<TbProducto> getTbProductoList() {
        return tbProductoList;
    }

    public void setTbProductoList(List<TbProducto> tbProductoList) {
        this.tbProductoList = tbProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnid != null ? idUnid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUnidad)) {
            return false;
        }
        TbUnidad other = (TbUnidad) object;
        if ((this.idUnid == null && other.idUnid != null) || (this.idUnid != null && !this.idUnid.equals(other.idUnid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbUnidad[ idUnid=" + idUnid + " ]";
    }
    
}
