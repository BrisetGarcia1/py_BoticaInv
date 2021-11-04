/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEKardex;
import Entidad.TbKardex;
//import com.itextpdf.text.Document;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsNKardex {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionPU");//conexion con Unidad de persistencia
    TbKardexJpaController controlador = new TbKardexJpaController(emf);//conexion para el controlador
    EntityManager manager = emf.createEntityManager();

//    public boolean MtdResgistrarKardex(ClsEKardex objEE) {
//        try {
////            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
//            String SQL="CALL USP_I_AgregarKardex(?,?,?,?,?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, objEE.getOperacion());
//            st.setInt(2, objEE.getCantidad());
//            st.setString(3, objEE.getFecha());
//            st.setInt(4, objEE.getIdEmpleado());
//            st.setInt(5, objEE.getIdDocumento());
//            st.setInt(6, objEE.getIdProveedor());
//            st.setString(7, objEE.getcBarras());
//            st.setInt(8, objEE.getStock());
//            if(st.executeUpdate()>0)
//            {
//                return true;
//            }
//            else
//            {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }
    
  
    
    public boolean MtdResgistrarKardex(ClsEKardex objK, TbKardex objEP) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           controlador.create(objEP);//usando controlador
           tx.commit();
           MtdRegistrarKardexMongo(objK, objEP);
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    
    
        
//    public Iterable<ClsEKardex> MtdListarKardex() {
//        try {
////            String SQL="Select * from tb_cargo";
//            String SQL="CALL USP_S_ListarKardex()";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            ResultSet resultado=st.executeQuery();
//            ArrayList<ClsEKardex> lista=new ArrayList<>();
//            ClsEKardex car;
//            while (resultado.next())
//            {               
//                car=new ClsEKardex();
//                car.setNtransaccion(resultado.getInt("ntransaccion_kar"));
//                car.setOperacion(resultado.getString("operacion_kar"));
//                car.setCantidad(resultado.getInt("cantidad_kar"));
//                car.setFecha(resultado.getString("fecha_kar"));
//                car.setIdEmpleado(resultado.getInt("id_empl"));
//                car.setIdDocumento(resultado.getInt("id_documento"));
//                car.setIdProveedor(resultado.getInt("id_prov"));
//                car.setcBarras(resultado.getString("cbarras_prod"));
//                car.setStock(resultado.getInt("stock"));
//                lista.add(car);
//            }
//            return lista;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    
    public List<TbKardex> MtdListarKardex(){
        List<TbKardex> resultList = manager.createQuery(
         "Select a From TbKardex a", TbKardex.class).getResultList();
        return resultList;
    }

    
    

//    public boolean MtdModificarKardex(ClsEKardex objEE) {
//        try {
////            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
//            String SQL="CALL USP_U_ActualizarKardex(?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setInt(1, objEE.getNtransaccion());
//            st.setString(2, objEE.getFecha());
//            st.setInt(3, objEE.getIdDocumento());
//            st.setInt(4, objEE.getIdProveedor());
//
//            if(st.executeUpdate()>0)
//            {
//                return true;
//            }
//            else
//            {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }
    
        public boolean MtdModificarKardex(TbKardex objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();   
        
        try {
           TypedQuery<TbKardex> query = manager.createQuery("SELECT t FROM TbKardex t WHERE t.ntransaccionKar = :ntransaccionKar",TbKardex.class).setParameter("ntransaccionKar",objEE.getNtransaccionKar());
            List<TbKardex> kard= query.getResultList();
            kard.get(0).setFechaKar(objEE.getFechaKar());
            kard.get(1).setIdDocumento(objEE.getIdDocumento());
            kard.get(2).setIdProv(objEE.getIdProv());
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, e);
           tx.rollback();
        }
        return false;
    }
    
    //FALTAA

//    public Iterable<ClsEKardex> MtdListarKardex2(String codigo) {
//       try {
////            String SQL="Select * from tb_cargo";
//            String SQL="CALL USP_S_ListarKardexPorCodigo(?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, codigo);
//            ResultSet resultado=st.executeQuery();
//            ArrayList<ClsEKardex> lista=new ArrayList<>();
//            ClsEKardex car;
//            while (resultado.next())
//            {              
//                car=new ClsEKardex();
//                car.setNtransaccion(resultado.getInt("ntransaccion_kar"));
//                car.setOperacion(resultado.getString("operacion_kar"));
//                car.setCantidad(resultado.getInt("cantidad_kar"));
//                car.setFecha(resultado.getString("fecha_kar"));
//                car.setIdEmpleado(resultado.getInt("id_empl"));
//                car.setNombreProv(resultado.getString("nombre_prov"));             
//                car.setDescripcionDoc(resultado.getString("Descripcion_doc"));              
//                car.setStock(resultado.getInt("stock"));
//                
//                lista.add(car);
//            }
//            return lista;
//        } catch (Exception e) {
//            return null;
//        }
//    }
        
    public List<TbKardex> MtdListarKardex2(TbKardex objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            TypedQuery<TbKardex> query = manager.createQuery("Select k From TbKardex WHERE k.cbarrasProd = :cbarrasProd", TbKardex.class).setParameter("cbarrasProd",objEE.getCbarrasProd());
            List<TbKardex> kard= query.getResultList();
            tx.commit();
           return kard;
        } catch (Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, e);
           tx.rollback();
        }
        
        return null;
    }

    private void MtdRegistrarKardexMongo(ClsEKardex objK, TbKardex objEP) {
        ClsConexionMongoDB mongo = new ClsConexionMongoDB();
        MongoDatabase mongodb = mongo.conexion();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechayhora = dtf.format(LocalDateTime.now());
        Document kardex = new Document();
        kardex.append("codproducto", objK.getcBarras());
        kardex.append("cantidad", objEP.getCantidadKar());
        kardex.append("idempleado", objK.getIdEmpleado());
        kardex.append("Transaccion", objEP.getOperacionKar());       
        kardex.append("FechaHora", objEP.getFechaKar());
        kardex.append("idprov", objK.getIdProveedor());

        mongodb.getCollection("kardex").insertOne(kardex);
        
    }
        
        
        
        
}   

        
        

    

    

