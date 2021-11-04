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
@Table(name = "tb_documento", catalog = "bd_boticainv", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbDocumento.findAll", query = "SELECT t FROM TbDocumento t"),
    @NamedQuery(name = "TbDocumento.findByIdDocumento", query = "SELECT t FROM TbDocumento t WHERE t.idDocumento = :idDocumento"),
    @NamedQuery(name = "TbDocumento.findByDescripciondoc", query = "SELECT t FROM TbDocumento t WHERE t.descripciondoc = :descripciondoc")})
public class TbDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento", nullable = false)
    private Integer idDocumento;
    @Column(name = "Descripcion_doc", length = 100)
    private String descripciondoc;
    @OneToMany(mappedBy = "idDocumento")
    private List<TbKardex> tbKardexList;

    public TbDocumento() {
    }

    public TbDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripciondoc() {
        return descripciondoc;
    }

    public void setDescripciondoc(String descripciondoc) {
        this.descripciondoc = descripciondoc;
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
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDocumento)) {
            return false;
        }
        TbDocumento other = (TbDocumento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbDocumento[ idDocumento=" + idDocumento + " ]";
    }
    
}
