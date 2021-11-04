/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEDocumento;
import Entidad.TbDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class ClsNDocumento {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionPU");//conexion con Unidad de persistencia
    TbDocumentoJpaController controlador = new TbDocumentoJpaController(emf);//conexion para el controlador
    EntityManager manager = emf.createEntityManager();


//    public Iterable<ClsEDocumento> LlenarDocumento() {
//        try {
////            String SQL="Select * from tb_cargo";
//            String SQL="SELECT Descripcion_doc FROM tb_documento";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            ResultSet resultado=st.executeQuery();
//            ArrayList<ClsEDocumento> lista=new ArrayList<>();
//            ClsEDocumento car;
//            while (resultado.next())
//            {
//                car=new ClsEDocumento();
//                car.setDescripcion(resultado.getString("Descripcion_doc"));
//                lista.add(car);               
//            }
//            return lista;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//    
    public List<TbDocumento> LlenarDocumento() {
        
        List<TbDocumento> resultList = manager.createQuery(
         "Select a From TbDocumento a", TbDocumento.class).getResultList();
        return resultList;
    }
    
}

