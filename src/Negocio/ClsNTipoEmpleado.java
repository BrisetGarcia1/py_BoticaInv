/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsETipoEmpleado;
import Entidad.TbTempleado;
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
public class ClsNTipoEmpleado {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionPU");//conexion con Unidad de persistencia
    TbTempleadoJpaController controlador = new TbTempleadoJpaController(emf);//conexion para el controlador
    EntityManager manager = emf.createEntityManager();

//    public Iterable<ClsETipoEmpleado> LlenarTipoEmpleado() {
//        try {
////            String SQL="Select * from tb_cargo";
//            String SQL="SELECT descripcion_templ FROM tb_templeado";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            ResultSet resultado=st.executeQuery();
//            ArrayList<ClsETipoEmpleado> lista=new ArrayList<>();
//            ClsETipoEmpleado car;
//            while (resultado.next())
//            {
//                car=new ClsETipoEmpleado();
//                car.setDescripcionTipo(resultado.getString("descripcion_templ"));
//                lista.add(car);               
//            }
//            return lista;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    
    public List<TbTempleado> LlenarTipoEmpleado() {
        
        List<TbTempleado> resultList = manager.createQuery(
         "Select a From TbTempleado a", TbTempleado.class).getResultList();
        return resultList;
    }
    
    
    
}
