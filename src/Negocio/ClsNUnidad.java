/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEUnidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClsNUnidad {

    public boolean MtdResgistrarUnidad(ClsEUnidad objEC) {
        try {
//            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
                String SQL="CALL USP_I_AgregarUnidad(?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEC.getDescripcionUnidad());
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

    public boolean MtdModificarUnidad(ClsEUnidad objEC) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            String SQL="CALL USP_U_ActualizarUnidad(?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setInt(1, objEC.getIdUnidad());
            st.setString(2, objEC.getDescripcionUnidad());
            
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

    public Iterable<ClsEUnidad> MtdListarUnidad() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="CALL USP_S_ListarUnidad()";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEUnidad> lista=new ArrayList<>();
            ClsEUnidad car;
            while (resultado.next())
            {
                car=new ClsEUnidad();
                car.setIdUnidad(resultado.getInt("id_unid"));
                car.setDescripcionUnidad(resultado.getString("descripcion_unid"));
                lista.add(car);
            }
            
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public Iterable<ClsEUnidad> LlenarUnidad() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="SELECT descripcion_unid FROM tb_unidad";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEUnidad> lista=new ArrayList<>();
            ClsEUnidad car;
            while (resultado.next())
            {
                car=new ClsEUnidad();
                car.setDescripcionUnidad(resultado.getString("descripcion_unid"));
                lista.add(car);               
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
}
