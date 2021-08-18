/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsEKardex {

    int ntransaccion;
    String operacion;
    int cantidad;
    String fecha;
    int idEmpleado;
    int idDocumento;
    int idProveedor;
    String cBarras;
    int Stock;
    String nombreProv;
    String descripcionDoc;
    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getDescripcionDoc() {
        return descripcionDoc;
    }

    public void setDescripcionDoc(String descripcionDoc) {
        this.descripcionDoc = descripcionDoc;
    }
    
    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
   
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
   
    public int getNtransaccion() {
        return ntransaccion;
    }

    public void setNtransaccion(int ntransaccion) {
        this.ntransaccion = ntransaccion;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getcBarras() {
        return cBarras;
    }

    public void setcBarras(String cBarras) {
        this.cBarras = cBarras;
    }
    
}
