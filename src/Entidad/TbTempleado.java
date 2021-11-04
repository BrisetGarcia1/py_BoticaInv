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
@Table(name = "tb_templeado", catalog = "bd_boticainv", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbTempleado.findAll", query = "SELECT t FROM TbTempleado t"),
    @NamedQuery(name = "TbTempleado.findByIdTempl", query = "SELECT t FROM TbTempleado t WHERE t.idTempl = :idTempl"),
    @NamedQuery(name = "TbTempleado.findByDescripcionTempl", query = "SELECT t FROM TbTempleado t WHERE t.descripcionTempl = :descripcionTempl")})
public class TbTempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_templ", nullable = false)
    private Integer idTempl;
    @Basic(optional = false)
    @Column(name = "descripcion_templ", nullable = false, length = 50)
    private String descripcionTempl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTempl")
    private List<TbEmpleado> tbEmpleadoList;

    public TbTempleado() {
    }

    public TbTempleado(Integer idTempl) {
        this.idTempl = idTempl;
    }

    public TbTempleado(Integer idTempl, String descripcionTempl) {
        this.idTempl = idTempl;
        this.descripcionTempl = descripcionTempl;
    }

    public Integer getIdTempl() {
        return idTempl;
    }

    public void setIdTempl(Integer idTempl) {
        this.idTempl = idTempl;
    }

    public String getDescripcionTempl() {
        return descripcionTempl;
    }

    public void setDescripcionTempl(String descripcionTempl) {
        this.descripcionTempl = descripcionTempl;
    }

    public List<TbEmpleado> getTbEmpleadoList() {
        return tbEmpleadoList;
    }

    public void setTbEmpleadoList(List<TbEmpleado> tbEmpleadoList) {
        this.tbEmpleadoList = tbEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTempl != null ? idTempl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTempleado)) {
            return false;
        }
        TbTempleado other = (TbTempleado) object;
        if ((this.idTempl == null && other.idTempl != null) || (this.idTempl != null && !this.idTempl.equals(other.idTempl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbTempleado[ idTempl=" + idTempl + " ]";
    }
    
}
