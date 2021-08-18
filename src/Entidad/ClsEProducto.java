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
public class ClsEProducto {
    int idProducto;
    String CBarras;
    String Nombre;
    int uCajas;
    int idUnidad;
    int sMinimo;
    int sMaximo;
    int stock;
    int Estado;
    String descripcionUnidad;
    
    public String getDescripcionUnidad() {
        return descripcionUnidad;
    }

    public void setDescripcionUnidad(String descripcionUnidad) {
        this.descripcionUnidad = descripcionUnidad;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getsMaximo() {
        return sMaximo;
    }

    public void setsMaximo(int sMaximo) {
        this.sMaximo = sMaximo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCBarras() {
        return CBarras;
    }

    public void setCBarras(String CBarras) {
        this.CBarras = CBarras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getuCajas() {
        return uCajas;
    }

    public void setuCajas(int uCajas) {
        this.uCajas = uCajas;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getsMinimo() {
        return sMinimo;
    }

    public void setsMinimo(int sMinimo) {
        this.sMinimo = sMinimo;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
}
