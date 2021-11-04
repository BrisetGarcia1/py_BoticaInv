/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEEmpleado;
import Entidad.TbEmpleado;
import Presentación.FrmLogin;
import Presentación.FrmModificar;
import Presentación.Principal;
import com.itextpdf.text.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ClsNEmpleado {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoGestionPU");//conexion con Unidad de persistencia
    TbEmpleadoJpaController controlador = new TbEmpleadoJpaController(emf);//conexion para el controlador
    EntityManager manager = emf.createEntityManager();

//    public boolean MtdResgistrarEmpleado(ClsEEmpleado objEE) {
//        try {
////            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
//            String SQL="CALL USP_I_AgregarEmpleado(?,?,?,?,?,?,?,?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, objEE.getDniEmpleado());
//            st.setString(2, objEE.getNombreEmpleado());
//            st.setString(3, objEE.getApellidosEmpleado());
//            st.setString(4, objEE.getSexoEmpleado());
//            st.setString(5, objEE.getFnacimientoEmpleado());
//            st.setString(6, objEE.getDireccionEmpleado());
//            st.setString(7, objEE.getTelefonoEmpleado());
//            st.setInt(8, objEE.getTipoEmpleado());
//            st.setString(9, objEE.getFingresoEmpleado());
//            st.setString(10, objEE.getContraseñaEmpleado());
//            st.setInt(11, objEE.getEstadoEmpleado());
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
    
    public boolean MtdResgistrarEmpleado(TbEmpleado objEC) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           controlador.create(objEC);//usando controlador
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    
    
    

//    public Iterable<ClsEEmpleado> MtdListarEmpleado() {
//        try {
////            String SQL="Select * from tb_cargo";
//            String SQL="CALL USP_S_ListarEmpleados()";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            ResultSet resultado=st.executeQuery();
//            ArrayList<ClsEEmpleado> lista=new ArrayList<>();
//            ClsEEmpleado car;
//            while (resultado.next())
//            {
//                car=new ClsEEmpleado();
//                car.setIdEmpleado(resultado.getInt("id_empl"));
//                car.setDniEmpleado(resultado.getString("dni_empl"));
//                car.setNombreEmpleado(resultado.getString("nombre_empl"));
//                car.setApellidosEmpleado(resultado.getString("apellidos_empl"));
//                car.setSexoEmpleado(resultado.getString("sexo_empl"));
//                car.setFnacimientoEmpleado(resultado.getString("fnacimiento_empl"));
//                car.setDireccionEmpleado(resultado.getString("direccion_empl"));
//                car.setTelefonoEmpleado(resultado.getString("telefono_empl"));
//                car.setTipoEmpleado(resultado.getInt("id_templ"));
//                car.setFingresoEmpleado(resultado.getString("fingreso_empl"));
//                car.setContraseñaEmpleado(resultado.getString("contraseña_empl"));
//                car.setEstadoEmpleado(resultado.getInt("estado_empl"));
//                lista.add(car);
//            }
//            return lista;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
    public List<TbEmpleado> MtdListarEmpleado(){
        
        List<TbEmpleado> resultList = manager.createQuery(
         "Select a From TbEmpleado a", TbEmpleado.class).getResultList();
        return resultList;


    } 
    
    
    
//    public boolean MtdModificarEmpleado(ClsEEmpleado objEE) {
//         try {
////            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
//            String SQL="CALL USP_U_ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, objEE.getDniEmpleado());
//            st.setInt(2, objEE.getIdEmpleado());
//            st.setString(3, objEE.getNombreEmpleado());
//            st.setString(4, objEE.getApellidosEmpleado());
//            st.setString(5, objEE.getSexoEmpleado());
//            st.setString(6, objEE.getFnacimientoEmpleado());
//            st.setString(7, objEE.getDireccionEmpleado());
//            st.setString(8, objEE.getTelefonoEmpleado());
//            st.setInt(9, objEE.getTipoEmpleado());
//            st.setString(10, objEE.getFingresoEmpleado());
//            st.setString(11, objEE.getContraseñaEmpleado());
//            st.setInt(12, objEE.getEstadoEmpleado());
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
    
    public boolean MtdModificarEmpleado(TbEmpleado objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           TbEmpleado Objempleado = manager.find(TbEmpleado.class, objEE.getIdEmpl());
           Objempleado.setDniEmpl(objEE.getDniEmpl());
           Objempleado.setNombreEmpl(objEE.getNombreEmpl());
           Objempleado.setApellidosEmpl(objEE.getApellidosEmpl());
           Objempleado.setSexoEmpl(objEE.getSexoEmpl());
           Objempleado.setFnacimientoEmpl(objEE.getFnacimientoEmpl());
           Objempleado.setDireccionEmpl(objEE.getDireccionEmpl());
           Objempleado.setTelefonoEmpl(objEE.getTelefonoEmpl());
           Objempleado.setIdTempl(objEE.getIdTempl());
           Objempleado.setFingresoEmpl(objEE.getFingresoEmpl());
           Objempleado.setContraseñaEmpl(objEE.getContraseñaEmpl());
           Objempleado.setEstadoEmpl(objEE.getEstadoEmpl());
          
           manager.persist(Objempleado);
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    


    public boolean MtdLoguear(TbEmpleado objEE) {
       try {

            TypedQuery<TbEmpleado> query = manager.createQuery("SELECT e FROM TbEmpleado e INNER JOIN TbTempleado t ON e.idTempl=t WHERE e.dniEmpl = :dniEmpl",TbEmpleado.class).setParameter("dniEmpl",objEE.getDniEmpl());
            
            List<TbEmpleado> resultList = query.getResultList();
            
            for (TbEmpleado objEEmpl : resultList) {

                if(objEE.getContraseñaEmpl().equals(objEEmpl.getContraseñaEmpl()))
                {
                    if(objEEmpl.getEstadoEmpl()==1)
                    {
                        JOptionPane.showMessageDialog(null, "Ingreso correcto usuario "+objEEmpl.getNombreEmpl()+" "+objEEmpl.getApellidosEmpl()+"\n"+
                                "       "+objEEmpl.getIdTempl().getDescripcionTempl());
                        FrmLogin.puente=objEEmpl.getDniEmpl();      //moviendo DNI
                        FrmLogin.puente2=objEEmpl.getIdTempl().getDescripcionTempl();     //Descripcion de tipo de usuario
                        FrmLogin.puente3=objEEmpl.getNombreEmpl();     //Nombre de empleado
                        FrmLogin.idempleado=objEEmpl.getIdEmpl().toString(); //id empleado
                        return true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "USUARIO INACTIVO");
                        return false;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "CLAVE INCORRECTA");
                    return false;
                }
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }

        return true;
    }

        public boolean MtdResgistroHoraIngreso(TbEmpleado objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();   
        
        try {
           TypedQuery<TbEmpleado> query = manager.createQuery("Select e FROM TbEmpleado e Where e.dniEmpl = :dni",TbEmpleado.class).setParameter("dni",objEE.getDniEmpl());
            List<TbEmpleado> empl= query.getResultList();
            empl.get(0).setFechaI(objEE.getFechaI());
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    
}
        public void MtdResgistroHoraIngresoMongo(TbEmpleado objEE)
        {
            ClsConexionMongoDB mongo = new ClsConexionMongoDB();
            MongoDatabase mongodb = mongo.conexion();
        
            org.bson.Document bitacora = new org.bson.Document();
            bitacora.append("DniEmpleado", objEE.getDniEmpl());
            bitacora.append("FechaIngreso", objEE.getFechaI());
            mongodb.getCollection("bitacora").insertOne(bitacora);
            
        }
        
        
        

    public boolean MtdResgistroHoraSalida(TbEmpleado objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();   
        
        try {
           TypedQuery<TbEmpleado> query = manager.createQuery("Select e FROM TbEmpleado e Where e.dniEmpl = :dni",TbEmpleado.class).setParameter("dni",objEE.getDniEmpl());
            List<TbEmpleado> empl= query.getResultList();
            empl.get(0).setFechaS(objEE.getFechaS());
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    
    
    public void MtdResgistroHoraSalidaMongo(TbEmpleado objEE)
    {
        ClsConexionMongoDB mongo = new ClsConexionMongoDB();
        MongoDatabase mongodb = mongo.conexion();

        org.bson.Document bitacora = new org.bson.Document();
        bitacora.append("DniEmpleado", objEE.getDniEmpl());
        bitacora.append("FechaSalida", objEE.getFechaS());
        mongodb.getCollection("bitacora").insertOne(bitacora);

    }

//    public boolean MtdBuscarEmpleado(ClsEEmpleado objEE) {
//        try {          
//            ResultSet rs=null;
//            String SQL="CALL USP_B_BuscarEmpleado(?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1,objEE.getDniEmpleado());
//            rs=st.executeQuery();
//            if(rs.next())
//            {                  
//                FrmModificar.txtNombre.setText(rs.getString(3));
//                FrmModificar.txtApellidos.setText(rs.getString(4));
//                if(rs.getString(5).equals("Masculino"))
//                {
//                    FrmModificar.rbtnMasculino.setSelected(true);
//                }
//                else
//                {
//                    FrmModificar.rbtnFemenino.setSelected(true);
//                }
//                DateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
//                String f=rs.getString(6);
//                java.util.Date fechaa=null;       
//                try {
//                    fechaa=formato.parse(f);
//                    FrmModificar.jdcFechaNac.setDate(fechaa);
//                } catch (ParseException ex) {
//                    ex.printStackTrace();
//                }
//                FrmModificar.txtDireccion.setText(rs.getString(7));
//                FrmModificar.txtTelefono.setText(rs.getString(8));
//                FrmModificar.txtContraseña.setText(rs.getString(11));
//                return true;              
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "ESTE USUARIO NO EXISTE");
//                return false;
//                
//            }
//        } catch (Exception e) {
//            
//            return false;
//        }
//    }
    
    public boolean MtdBuscarEmpleado(TbEmpleado objEE) {
       try {

            TypedQuery<TbEmpleado> query = manager.createQuery("SELECT t FROM TbEmpleado t WHERE t.dniEmpl = :dniEmpl",TbEmpleado.class).setParameter("dniEmpl",objEE.getDniEmpl());
            
            List<TbEmpleado> resultList = query.getResultList();
            
            for (TbEmpleado objempl : resultList) {

                FrmModificar.txtNombre.setText(objempl.getNombreEmpl());
                FrmModificar.txtApellidos.setText(objempl.getApellidosEmpl());
                if(objempl.getSexoEmpl().equals("Masculino"))
                {
                    FrmModificar.rbtnMasculino.setSelected(true);
                }
                else
                {
                    FrmModificar.rbtnFemenino.setSelected(true);
                }
                DateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
                String f=objempl.getFnacimientoEmpl().toString();
                java.util.Date fechaa=null;       
                try {
                    fechaa=formato.parse(f);
                    FrmModificar.jdcFechaNac.setDate(fechaa);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                FrmModificar.txtDireccion.setText(objempl.getDireccionEmpl());
                FrmModificar.txtTelefono.setText(objempl.getTelefonoEmpl());
                FrmModificar.txtContraseña.setText(objempl.getContraseñaEmpl());
                return true;
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }

        return true;
    }
   
    
    

//    public boolean MtdModificarEmpleado2(ClsEEmpleado objEE) {
//        try {
////            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
//            String SQL="CALL USP_U_ActualizarEmpleado2(?,?,?,?,?,?,?,?)";
//            Connection con = ClsConexion.Conectar();
//            PreparedStatement st=con.prepareCall(SQL);
//            st.setString(1, objEE.getDniEmpleado());
//            st.setString(2, objEE.getNombreEmpleado());
//            st.setString(3, objEE.getApellidosEmpleado());
//            st.setString(4, objEE.getSexoEmpleado());
//            st.setString(5, objEE.getFnacimientoEmpleado());
//            st.setString(6, objEE.getDireccionEmpleado());
//            st.setString(7, objEE.getTelefonoEmpleado());
//            st.setString(8, objEE.getContraseñaEmpleado());           
//            if(st.executeUpdate()>0)
//            {
//                Principal.txtNombre.setText(objEE.getNombreEmpleado());
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
    
    public boolean MtdModificarEmpleado2(TbEmpleado objEE) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
           TbEmpleado Objempl = manager.find(TbEmpleado.class, objEE.getDniEmpl());
           Objempl.setNombreEmpl(objEE.getNombreEmpl());
           Objempl.setApellidosEmpl(objEE.getApellidosEmpl());
           Objempl.setSexoEmpl(objEE.getSexoEmpl());
           Objempl.setFnacimientoEmpl(objEE.getFnacimientoEmpl());
           Objempl.setDireccionEmpl(objEE.getDireccionEmpl());
           Objempl.setTelefonoEmpl(objEE.getTelefonoEmpl());
           Objempl.setContraseñaEmpl(objEE.getContraseñaEmpl());
           
           manager.persist(Objempl);
           tx.commit();
           return true;
        } catch (Exception e) {
           e.printStackTrace();
           tx.rollback();
        }
        return false;
    }
    
    
    
    
}