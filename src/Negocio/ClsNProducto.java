/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEProducto;
import Presentación.FrmKardex;
import Presentación.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClsNProducto {

    public boolean MtdResgistrarProducto(ClsEProducto objEE) {
        try {
//            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
            String SQL="CALL USP_I_AgregarProducto(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getCBarras());
            st.setString(2, objEE.getNombre());
            st.setInt(3, objEE.getuCajas());
            st.setInt(4, objEE.getIdUnidad());
            st.setInt(5, objEE.getStock());
            st.setInt(6, objEE.getEstado());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean MtdModificarProducto(ClsEProducto objEE) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            String SQL="CALL USP_U_ActualizarProducto(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getCBarras());
            st.setString(2, objEE.getNombre());
            st.setInt(3, objEE.getuCajas());
            st.setInt(4, objEE.getIdUnidad());
            st.setInt(5, objEE.getStock());
            st.setInt(6, objEE.getEstado());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<ClsEProducto> MtdListarProducto() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="CALL USP_S_ListarProducto()";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProducto> lista=new ArrayList<>();
            ClsEProducto car;
            while (resultado.next())
            {
                car=new ClsEProducto();
                car.setCBarras(resultado.getString("cbarras_prod"));
                car.setNombre(resultado.getString("nombre_prod"));
                car.setuCajas(resultado.getInt("ucajas_prod"));
                car.setIdUnidad(resultado.getInt("id_unid"));
                car.setsMinimo(resultado.getInt("sminimo_prod"));
                car.setsMaximo(resultado.getInt("smaximo_prod"));
                car.setStock(resultado.getInt("Stock"));
                car.setEstado(resultado.getInt("estado_prod"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean MtdBuscarProducto(ClsEProducto objEE) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            ResultSet rs=null;
            String SQL="CALL USP_B_BuscarProductoPorBarras(?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1,objEE.getCBarras());
            rs=st.executeQuery();
            if(rs.next())
            {
                if(Principal.ayuda==0) //si se buscó en kardex
                {
                    if(rs.getString("estado_prod").equals("1"))
                    {
                        FrmKardex.txtNomProkar.setText(rs.getString("nombre_prod"));
                        FrmKardex.txtUnidad.setText(rs.getString("descripcion_unid"));
                        FrmKardex.txtstockmin.setText(rs.getString("sminimo_prod"));
                        FrmKardex.txtstockmax.setText(rs.getString("smaximo_prod"));
                        FrmKardex.txtStock.setText(rs.getString("Stock"));
                        
                    }
                    else
                    {
                        return false;
                    }
                }                            
                if(Principal.ayuda==1)  //Si se buscó producto en imprimir
                {
                    if(rs.getString("estado_prod").equals("1"))
                    {
                        objEE.setNombre(rs.getString("nombre_prod"));
                        objEE.setDescripcionUnidad(rs.getString("descripcion_unid"));
                        objEE.setuCajas(rs.getInt("ucajas_prod"));
                        objEE.setsMinimo(rs.getInt("sminimo_prod"));
                        objEE.setsMaximo(rs.getInt("smaximo_prod"));
                        
                    }
                    else
                    {
                        return false;
                    }
                } 
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean MtdModificarProducto2(ClsEProducto objEEE) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            String SQL="CALL USP_U_ActualizarStockMinMax(?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setInt(1, objEEE.getsMinimo());
            st.setInt(2, objEEE.getsMaximo());
            st.setString(3, objEEE.getCBarras());
            st.setInt(4, objEEE.getStock());
 
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
}
