/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEKardex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsNKardex {

    public boolean MtdResgistrarKardex(ClsEKardex objEE) {
        try {
//            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
            String SQL="CALL USP_I_AgregarKardex(?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getOperacion());
            st.setInt(2, objEE.getCantidad());
            st.setString(3, objEE.getFecha());
            st.setInt(4, objEE.getIdEmpleado());
            st.setInt(5, objEE.getIdDocumento());
            st.setInt(6, objEE.getIdProveedor());
            st.setString(7, objEE.getcBarras());
            st.setInt(8, objEE.getStock());
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

    public Iterable<ClsEKardex> MtdListarKardex() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="CALL USP_S_ListarKardex()";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEKardex> lista=new ArrayList<>();
            ClsEKardex car;
            while (resultado.next())
            {               
                car=new ClsEKardex();
                car.setNtransaccion(resultado.getInt("ntransaccion_kar"));
                car.setOperacion(resultado.getString("operacion_kar"));
                car.setCantidad(resultado.getInt("cantidad_kar"));
                car.setFecha(resultado.getString("fecha_kar"));
                car.setIdEmpleado(resultado.getInt("id_empl"));
                car.setIdDocumento(resultado.getInt("id_documento"));
                car.setIdProveedor(resultado.getInt("id_prov"));
                car.setcBarras(resultado.getString("cbarras_prod"));
                car.setStock(resultado.getInt("stock"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean MtdModificarKardex(ClsEKardex objEE) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            String SQL="CALL USP_U_ActualizarKardex(?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setInt(1, objEE.getNtransaccion());
            st.setString(2, objEE.getFecha());
            st.setInt(3, objEE.getIdDocumento());
            st.setInt(4, objEE.getIdProveedor());

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

    public Iterable<ClsEKardex> MtdListarKardex2(String codigo) {
       try {
//            String SQL="Select * from tb_cargo";
            String SQL="CALL USP_S_ListarKardexPorCodigo(?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, codigo);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEKardex> lista=new ArrayList<>();
            ClsEKardex car;
            while (resultado.next())
            {              
                car=new ClsEKardex();
                car.setNtransaccion(resultado.getInt("ntransaccion_kar"));
                car.setOperacion(resultado.getString("operacion_kar"));
                car.setCantidad(resultado.getInt("cantidad_kar"));
                car.setFecha(resultado.getString("fecha_kar"));
                car.setIdEmpleado(resultado.getInt("id_empl"));
                car.setNombreProv(resultado.getString("nombre_prov"));             
                car.setDescripcionDoc(resultado.getString("Descripcion_doc"));              
                car.setStock(resultado.getInt("stock"));
                
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }


    
}
