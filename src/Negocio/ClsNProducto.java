/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEProducto;
import Entidad.TbProducto;
import Presentación.FrmKardex;
import Presentación.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class ClsNProducto {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionPU");//conexion con Unidad de persistencia
    TbProductoJpaController controlador = new TbProductoJpaController(emf);//conexion para el controlador
    EntityManager manager = emf.createEntityManager();

//    public boolean MtdResgistrarProducto(ClsEProducto objEE) {
//        try {
////            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
//            String SQL="CALL USP_I_AgregarProducto(?,?,?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, objEE.getCBarras());
//            st.setString(2, objEE.getNombre());
//            st.setInt(3, objEE.getuCajas());
//            st.setInt(4, objEE.getIdUnidad());
//            st.setInt(5, objEE.getStock());
//            st.setInt(6, objEE.getEstado());
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
    
    public boolean MtdResgistrarProducto(TbProducto objEP) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           controlador.create(objEP);//usando controlador
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    
    
//    public boolean MtdModificarProducto(ClsEProducto objEE) {
//        try {
////            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
//            String SQL="CALL USP_U_ActualizarProducto(?,?,?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, objEE.getCBarras());
//            st.setString(2, objEE.getNombre());
//            st.setInt(3, objEE.getuCajas());
//            st.setInt(4, objEE.getIdUnidad());
//            st.setInt(5, objEE.getStock());
//            st.setInt(6, objEE.getEstado());
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
    
    public boolean MtdModificarProducto(TbProducto objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           TbProducto Objproducto = manager.find(TbProducto.class, objEE.getCbarrasProd());
           Objproducto.setNombreProd(objEE.getNombreProd());
           Objproducto.setUcajasProd(objEE.getUcajasProd());
           Objproducto.setIdUnid(objEE.getIdUnid());
           Objproducto.setStock(objEE.getStock());
           Objproducto.setEstadoProd(objEE.getEstadoProd());
          
           manager.persist(Objproducto);
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    

//    public Iterable<ClsEProducto> MtdListarProducto() {
//        try {
////            String SQL="Select * from tb_cargo";
//            String SQL="CALL USP_S_ListarProducto()";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            ResultSet resultado=st.executeQuery();
//            ArrayList<ClsEProducto> lista=new ArrayList<>();
//            ClsEProducto car;
//            while (resultado.next())
//            {
//                car=new ClsEProducto();
//                car.setCBarras(resultado.getString("cbarras_prod"));
//                car.setNombre(resultado.getString("nombre_prod"));
//                car.setuCajas(resultado.getInt("ucajas_prod"));
//                car.setIdUnidad(resultado.getInt("id_unid"));
//                car.setsMinimo(resultado.getInt("sminimo_prod"));
//                car.setsMaximo(resultado.getInt("smaximo_prod"));
//                car.setStock(resultado.getInt("Stock"));
//                car.setEstado(resultado.getInt("estado_prod"));
//                lista.add(car);
//            }
//            return lista;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    
    
    public List<TbProducto> MtdListarProducto(){
        
        List<TbProducto> resultList = manager.createQuery(
         "Select a From TbProducto a", TbProducto.class).getResultList();
        return resultList;
        
    } 

    
//    public boolean MtdBuscarProducto(ClsEProducto objEE) {
//        try {
////            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
//            ResultSet rs=null;
//            String SQL="CALL USP_B_BuscarProductoPorBarras(?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1,objEE.getCBarras());
//            rs=st.executeQuery();
//            if(rs.next())
//            {
//                if(Principal.ayuda==0) //si se buscó en kardex
//                {
//                    if(rs.getString("estado_prod").equals("1"))
//                    {
//                        FrmKardex.txtNomProkar.setText(rs.getString("nombre_prod"));
//                        FrmKardex.txtUnidad.setText(rs.getString("descripcion_unid"));
//                        FrmKardex.txtstockmin.setText(rs.getString("sminimo_prod"));
//                        FrmKardex.txtstockmax.setText(rs.getString("smaximo_prod"));
//                        FrmKardex.txtStock.setText(rs.getString("Stock"));
//                        
//                    }
//                    else
//                    {
//                        return false;
//                    }
//                }                            
//                if(Principal.ayuda==1)  //Si se buscó producto en imprimir
//                {
//                    if(rs.getString("estado_prod").equals("1"))
//                    {
//                        objEE.setNombre(rs.getString("nombre_prod"));
//                        objEE.setDescripcionUnidad(rs.getString("descripcion_unid"));
//                        objEE.setuCajas(rs.getInt("ucajas_prod"));
//                        objEE.setsMinimo(rs.getInt("sminimo_prod"));
//                        objEE.setsMaximo(rs.getInt("smaximo_prod"));
//                        
//                    }
//                    else
//                    {
//                        return false;
//                    }
//                } 
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
    
    
    public boolean MtdBuscarProducto(TbProducto objEE) {
       try {

            TypedQuery<TbProducto> query = manager.createQuery("SELECT t FROM TbProducto t WHERE t.cbarrasProd = :cbarrasProd",TbProducto.class).setParameter("cbarrasProd",objEE.getCbarrasProd());
            
            List<TbProducto> resultList = query.getResultList();
            
            for (TbProducto objprod : resultList) {

                if(Principal.ayuda==0) //si se buscó en kardex
                {
                    if(objprod.getEstadoProd()==1)
                    {
                        FrmKardex.txtNomProkar.setText(objprod.getNombreProd());
                        FrmKardex.txtUnidad.setText(objprod.getIdUnid().getDescripcionUnid());
                        FrmKardex.txtstockmin.setText(objprod.getSminimoProd().toString());
                        FrmKardex.txtstockmax.setText(objprod.getSmaximoProd().toString());
                        FrmKardex.txtStock.setText(objprod.getStock().toString());
                        
                    }
                    else
                    {
                        return false;
                    }
                }                            
                if(Principal.ayuda==1)  //Si se buscó producto en imprimir
                {
                    if(objprod.getEstadoProd()==1)
                    {
                        objEE.setNombreProd(objprod.getNombreProd());
                        objEE.setIdUnid(objprod.getIdUnid());
                        objEE.setUcajasProd(objprod.getUcajasProd());
                        objEE.setSminimoProd(objprod.getSminimoProd());
                        objEE.setSmaximoProd(objprod.getSmaximoProd());
                        
                    }
                    else
                    {
                        return false;
                    }
                } 
                return true;
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }

        return true;
    }
    
    
    

//    public boolean MtdModificarProducto2(ClsEProducto objEEE) {
//        try {
////            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
//            String SQL="CALL USP_U_ActualizarStockMinMax(?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setInt(1, objEEE.getsMinimo());
//            st.setInt(2, objEEE.getsMaximo());
//            st.setString(3, objEEE.getCBarras());
//            st.setInt(4, objEEE.getStock());
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
    
    
    public boolean MtdModificarProducto2(TbProducto objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           TbProducto Objproducto = manager.find(TbProducto.class, objEE.getCbarrasProd());
           Objproducto.setSminimoProd(objEE.getSminimoProd());
           Objproducto.setSmaximoProd(objEE.getSmaximoProd());
           Objproducto.setStock(objEE.getStock());         
           manager.persist(Objproducto);
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    
    
    
    
    
    
    
    
}
