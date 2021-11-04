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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tb_producto", catalog = "bd_boticainv", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cbarras_prod"})})
@NamedQueries({
    @NamedQuery(name = "TbProducto.findAll", query = "SELECT t FROM TbProducto t"),
    @NamedQuery(name = "TbProducto.findByCbarrasProd", query = "SELECT t FROM TbProducto t WHERE t.cbarrasProd = :cbarrasProd"),
    @NamedQuery(name = "TbProducto.findByNombreProd", query = "SELECT t FROM TbProducto t WHERE t.nombreProd = :nombreProd"),
    @NamedQuery(name = "TbProducto.findByUcajasProd", query = "SELECT t FROM TbProducto t WHERE t.ucajasProd = :ucajasProd"),
    @NamedQuery(name = "TbProducto.findBySminimoProd", query = "SELECT t FROM TbProducto t WHERE t.sminimoProd = :sminimoProd"),
    @NamedQuery(name = "TbProducto.findBySmaximoProd", query = "SELECT t FROM TbProducto t WHERE t.smaximoProd = :smaximoProd"),
    @NamedQuery(name = "TbProducto.findByStock", query = "SELECT t FROM TbProducto t WHERE t.stock = :stock"),
    @NamedQuery(name = "TbProducto.findByEstadoProd", query = "SELECT t FROM TbProducto t WHERE t.estadoProd = :estadoProd")})
public class TbProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cbarras_prod", nullable = false, length = 12)
    private String cbarrasProd;
    @Basic(optional = false)
    @Column(name = "nombre_prod", nullable = false, length = 25)
    private String nombreProd;
    @Basic(optional = false)
    @Column(name = "ucajas_prod", nullable = false)
    private int ucajasProd;
    @Column(name = "sminimo_prod")
    private Integer sminimoProd;
    @Column(name = "smaximo_prod")
    private Integer smaximoProd;
    @Column(name = "Stock")
    private Integer stock;
    @Basic(optional = false)
    @Column(name = "estado_prod", nullable = false)
    private int estadoProd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cbarrasProd")
    private List<TbKardex> tbKardexList;
    @JoinColumn(name = "id_unid", referencedColumnName = "id_unid", nullable = false)
    @ManyToOne(optional = false)
    private TbUnidad idUnid;

    public TbProducto() {
    }

    public TbProducto(String cbarrasProd) {
        this.cbarrasProd = cbarrasProd;
    }
    

    public TbProducto(String cbarrasProd, String nombreProd, int ucajasProd, int estadoProd) {
        this.cbarrasProd = cbarrasProd;
        this.nombreProd = nombreProd;
        this.ucajasProd = ucajasProd;
        this.estadoProd = estadoProd;
    }

    public String getCbarrasProd() {
        return cbarrasProd;
    }

    public void setCbarrasProd(String cbarrasProd) {
        this.cbarrasProd = cbarrasProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getUcajasProd() {
        return ucajasProd;
    }

    public void setUcajasProd(int ucajasProd) {
        this.ucajasProd = ucajasProd;
    }

    public Integer getSminimoProd() {
        return sminimoProd;
    }

    public void setSminimoProd(Integer sminimoProd) {
        this.sminimoProd = sminimoProd;
    }

    public Integer getSmaximoProd() {
        return smaximoProd;
    }

    public void setSmaximoProd(Integer smaximoProd) {
        this.smaximoProd = smaximoProd;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getEstadoProd() {
        return estadoProd;
    }

    public void setEstadoProd(int estadoProd) {
        this.estadoProd = estadoProd;
    }

    public List<TbKardex> getTbKardexList() {
        return tbKardexList;
    }

    public void setTbKardexList(List<TbKardex> tbKardexList) {
        this.tbKardexList = tbKardexList;
    }

    public TbUnidad getIdUnid() {
        return idUnid;
    }

    public void setIdUnid(TbUnidad idUnid) {
        this.idUnid = idUnid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cbarrasProd != null ? cbarrasProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProducto)) {
            return false;
        }
        TbProducto other = (TbProducto) object;
        if ((this.cbarrasProd == null && other.cbarrasProd != null) || (this.cbarrasProd != null && !this.cbarrasProd.equals(other.cbarrasProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbProducto[ cbarrasProd=" + cbarrasProd + " ]";
    }
    
}
