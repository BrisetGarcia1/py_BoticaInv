/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClsNDocumento {

    public Iterable<ClsEDocumento> LlenarDocumento() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="SELECT Descripcion_doc FROM tb_documento";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEDocumento> lista=new ArrayList<>();
            ClsEDocumento car;
            while (resultado.next())
            {
                car=new ClsEDocumento();
                car.setDescripcion(resultado.getString("Descripcion_doc"));
                lista.add(car);               
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
}
