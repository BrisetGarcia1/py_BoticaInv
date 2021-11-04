/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tb_empleado", catalog = "bd_boticainv", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dni_empl"})})
@NamedQueries({
    @NamedQuery(name = "TbEmpleado.findAll", query = "SELECT t FROM TbEmpleado t"),
    @NamedQuery(name = "TbEmpleado.findByIdEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.idEmpl = :idEmpl"),
    @NamedQuery(name = "TbEmpleado.findByDniEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.dniEmpl = :dniEmpl"),
    @NamedQuery(name = "TbEmpleado.findByNombreEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.nombreEmpl = :nombreEmpl"),
    @NamedQuery(name = "TbEmpleado.findByApellidosEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.apellidosEmpl = :apellidosEmpl"),
    @NamedQuery(name = "TbEmpleado.findBySexoEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.sexoEmpl = :sexoEmpl"),
    @NamedQuery(name = "TbEmpleado.findByFnacimientoEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.fnacimientoEmpl = :fnacimientoEmpl"),
    @NamedQuery(name = "TbEmpleado.findByDireccionEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.direccionEmpl = :direccionEmpl"),
    @NamedQuery(name = "TbEmpleado.findByTelefonoEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.telefonoEmpl = :telefonoEmpl"),
    @NamedQuery(name = "TbEmpleado.findByFingresoEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.fingresoEmpl = :fingresoEmpl"),
    @NamedQuery(name = "TbEmpleado.findByContrase\u00f1aEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.contrase\u00f1aEmpl = :contrase\u00f1aEmpl"),
    @NamedQuery(name = "TbEmpleado.findByEstadoEmpl", query = "SELECT t FROM TbEmpleado t WHERE t.estadoEmpl = :estadoEmpl"),
    @NamedQuery(name = "TbEmpleado.findByFechaI", query = "SELECT t FROM TbEmpleado t WHERE t.fechaI = :fechaI"),
    @NamedQuery(name = "TbEmpleado.findByFechaS", query = "SELECT t FROM TbEmpleado t WHERE t.fechaS = :fechaS")})
public class TbEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;

    public static TbTempleado ValueOf(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empl", nullable = false)
    private Integer idEmpl;
    @Basic(optional = false)
    @Column(name = "dni_empl", nullable = false, length = 8)
    private String dniEmpl;
    @Basic(optional = false)
    @Column(name = "nombre_empl", nullable = false, length = 50)
    private String nombreEmpl;
    @Basic(optional = false)
    @Column(name = "apellidos_empl", nullable = false, length = 50)
    private String apellidosEmpl;
    @Basic(optional = false)
    @Column(name = "sexo_empl", nullable = false, length = 9)
    private String sexoEmpl;
    @Basic(optional = false)
    @Column(name = "fnacimiento_empl", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fnacimientoEmpl;
    @Basic(optional = false)
    @Column(name = "direccion_empl", nullable = false, length = 50)
    private String direccionEmpl;
    @Basic(optional = false)
    @Column(name = "telefono_empl", nullable = false, length = 9)
    private String telefonoEmpl;
    @Basic(optional = false)
    @Column(name = "fingreso_empl", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fingresoEmpl;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a_empl", nullable = false, length = 12)
    private String contraseñaEmpl;
    @Basic(optional = false)
    @Column(name = "estado_empl", nullable = false)
    private int estadoEmpl;
    @Column(name = "fechaI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaI;
    @Column(name = "fechaS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaS;
    @OneToMany(mappedBy = "idEmpl")
    private List<TbKardex> tbKardexList;
    @JoinColumn(name = "id_templ", referencedColumnName = "id_templ", nullable = false)
    @ManyToOne(optional = false)
    private TbTempleado idTempl;

    public TbEmpleado() {
    }

    public TbEmpleado(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public TbEmpleado(Integer idEmpl, String dniEmpl, String nombreEmpl, String apellidosEmpl, String sexoEmpl, Date fnacimientoEmpl, String direccionEmpl, String telefonoEmpl, Date fingresoEmpl, String contraseñaEmpl, int estadoEmpl) {
        this.idEmpl = idEmpl;
        this.dniEmpl = dniEmpl;
        this.nombreEmpl = nombreEmpl;
        this.apellidosEmpl = apellidosEmpl;
        this.sexoEmpl = sexoEmpl;
        this.fnacimientoEmpl = fnacimientoEmpl;
        this.direccionEmpl = direccionEmpl;
        this.telefonoEmpl = telefonoEmpl;
        this.fingresoEmpl = fingresoEmpl;
        this.contraseñaEmpl = contraseñaEmpl;
        this.estadoEmpl = estadoEmpl;
    }

    public Integer getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public String getDniEmpl() {
        return dniEmpl;
    }

    public void setDniEmpl(String dniEmpl) {
        this.dniEmpl = dniEmpl;
    }

    public String getNombreEmpl() {
        return nombreEmpl;
    }

    public void setNombreEmpl(String nombreEmpl) {
        this.nombreEmpl = nombreEmpl;
    }

    public String getApellidosEmpl() {
        return apellidosEmpl;
    }

    public void setApellidosEmpl(String apellidosEmpl) {
        this.apellidosEmpl = apellidosEmpl;
    }

    public String getSexoEmpl() {
        return sexoEmpl;
    }

    public void setSexoEmpl(String sexoEmpl) {
        this.sexoEmpl = sexoEmpl;
    }

    public Date getFnacimientoEmpl() {
        return fnacimientoEmpl;
    }

    public void setFnacimientoEmpl(Date fnacimientoEmpl) {
        this.fnacimientoEmpl = fnacimientoEmpl;
    }

    public String getDireccionEmpl() {
        return direccionEmpl;
    }

    public void setDireccionEmpl(String direccionEmpl) {
        this.direccionEmpl = direccionEmpl;
    }

    public String getTelefonoEmpl() {
        return telefonoEmpl;
    }

    public void setTelefonoEmpl(String telefonoEmpl) {
        this.telefonoEmpl = telefonoEmpl;
    }

    public Date getFingresoEmpl() {
        return fingresoEmpl;
    }

    public void setFingresoEmpl(Date fingresoEmpl) {
        this.fingresoEmpl = fingresoEmpl;
    }

    public String getContraseñaEmpl() {
        return contraseñaEmpl;
    }

    public void setContraseñaEmpl(String contraseñaEmpl) {
        this.contraseñaEmpl = contraseñaEmpl;
    }

    public int getEstadoEmpl() {
        return estadoEmpl;
    }

    public void setEstadoEmpl(int estadoEmpl) {
        this.estadoEmpl = estadoEmpl;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaS() {
        return fechaS;
    }

    public void setFechaS(Date fechaS) {
        this.fechaS = fechaS;
    }

    public List<TbKardex> getTbKardexList() {
        return tbKardexList;
    }

    public void setTbKardexList(List<TbKardex> tbKardexList) {
        this.tbKardexList = tbKardexList;
    }

    public TbTempleado getIdTempl() {
        return idTempl;
    }

    public void setIdTempl(TbTempleado idTempl) {
        this.idTempl = idTempl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpl != null ? idEmpl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmpleado)) {
            return false;
        }
        TbEmpleado other = (TbEmpleado) object;
        if ((this.idEmpl == null && other.idEmpl != null) || (this.idEmpl != null && !this.idEmpl.equals(other.idEmpl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.TbEmpleado[ idEmpl=" + idEmpl + " ]";
    }
//
//    public void setIdTempl(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
