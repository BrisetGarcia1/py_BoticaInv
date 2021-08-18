/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClsNProveedor {

    public boolean MtdResgistrarProveedor(ClsEProveedor objEE) {
        try {
//            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
            String SQL="CALL USP_I_AgregarProveedor(?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getNombre());
            st.setString(2, objEE.getRuc());
            st.setString(3, objEE.getDni());
            st.setString(4, objEE.getDireccion());
            st.setString(5, objEE.getCelular());
            st.setString(6, objEE.getEmail());
            st.setString(7, objEE.getNCuenta());
            st.setInt(8, objEE.getEstado());

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

    public Iterable<ClsEProveedor> MtdListarProveedor() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="CALL USP_S_ListarProveedores()";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProveedor> lista=new ArrayList<>();
            ClsEProveedor car;
            while (resultado.next())
            {
                car=new ClsEProveedor();
                car.setIdProveedor(resultado.getInt("id_prov"));
                car.setDni(resultado.getString("dni_prov"));
                car.setNombre(resultado.getString("nombre_prov"));
                car.setRuc(resultado.getString("ruc_prov"));
                car.setDireccion(resultado.getString("direccion_prov"));
                car.setCelular(resultado.getString("celular_prov"));
                car.setEmail(resultado.getString("email_prov"));
                car.setNCuenta(resultado.getString("ncuenta_prov"));
                car.setEstado(resultado.getInt("estado_prov"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean MtdModificarProveedor(ClsEProveedor objEE) {
        try {
//            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
            String SQL="CALL USP_U_ActualizarProveedor(?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getNombre());
            st.setInt(2, objEE.getIdProveedor());
            st.setString(3, objEE.getRuc());
            st.setString(4, objEE.getDni());
            st.setString(5, objEE.getDireccion());
            st.setString(6, objEE.getCelular());
            st.setString(7, objEE.getEmail());
            st.setString(8, objEE.getNCuenta());
            st.setInt(9, objEE.getEstado());

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

    public Iterable<ClsEProveedor> LlenarProveedor() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="SELECT nombre_prov,estado_prov FROM tb_proveedor";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProveedor> lista=new ArrayList<>();
            ClsEProveedor car;
            while (resultado.next())
            {
                car=new ClsEProveedor();
                car.setEstado(resultado.getInt("estado_prov"));
                car.setNombre(resultado.getString("nombre_prov"));
                lista.add(car);               
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
}
