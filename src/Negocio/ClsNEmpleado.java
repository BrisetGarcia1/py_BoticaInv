/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEEmpleado;
import Presentación.FrmLogin;
import Presentación.FrmModificar;
import Presentación.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsNEmpleado {

    public boolean MtdResgistrarEmpleado(ClsEEmpleado objEE) {
        try {
//            String SQL="insert into tb_cargo(Codigocargo,Descripcioncargo) values(?,?)";
            String SQL="CALL USP_I_AgregarEmpleado(?,?,?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getDniEmpleado());
            st.setString(2, objEE.getNombreEmpleado());
            st.setString(3, objEE.getApellidosEmpleado());
            st.setString(4, objEE.getSexoEmpleado());
            st.setString(5, objEE.getFnacimientoEmpleado());
            st.setString(6, objEE.getDireccionEmpleado());
            st.setString(7, objEE.getTelefonoEmpleado());
            st.setInt(8, objEE.getTipoEmpleado());
            st.setString(9, objEE.getFingresoEmpleado());
            st.setString(10, objEE.getContraseñaEmpleado());
            st.setInt(11, objEE.getEstadoEmpleado());
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

    public Iterable<ClsEEmpleado> MtdListarEmpleado() {
        try {
//            String SQL="Select * from tb_cargo";
            String SQL="CALL USP_S_ListarEmpleados()";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEEmpleado> lista=new ArrayList<>();
            ClsEEmpleado car;
            while (resultado.next())
            {
                car=new ClsEEmpleado();
                car.setIdEmpleado(resultado.getInt("id_empl"));
                car.setDniEmpleado(resultado.getString("dni_empl"));
                car.setNombreEmpleado(resultado.getString("nombre_empl"));
                car.setApellidosEmpleado(resultado.getString("apellidos_empl"));
                car.setSexoEmpleado(resultado.getString("sexo_empl"));
                car.setFnacimientoEmpleado(resultado.getString("fnacimiento_empl"));
                car.setDireccionEmpleado(resultado.getString("direccion_empl"));
                car.setTelefonoEmpleado(resultado.getString("telefono_empl"));
                car.setTipoEmpleado(resultado.getInt("id_templ"));
                car.setFingresoEmpleado(resultado.getString("fingreso_empl"));
                car.setContraseñaEmpleado(resultado.getString("contraseña_empl"));
                car.setEstadoEmpleado(resultado.getInt("estado_empl"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean MtdModificarEmpleado(ClsEEmpleado objEE) {
         try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            String SQL="CALL USP_U_ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getDniEmpleado());
            st.setInt(2, objEE.getIdEmpleado());
            st.setString(3, objEE.getNombreEmpleado());
            st.setString(4, objEE.getApellidosEmpleado());
            st.setString(5, objEE.getSexoEmpleado());
            st.setString(6, objEE.getFnacimientoEmpleado());
            st.setString(7, objEE.getDireccionEmpleado());
            st.setString(8, objEE.getTelefonoEmpleado());
            st.setInt(9, objEE.getTipoEmpleado());
            st.setString(10, objEE.getFingresoEmpleado());
            st.setString(11, objEE.getContraseñaEmpleado());
            st.setInt(12, objEE.getEstadoEmpleado());
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

    public boolean MtdLoguear(ClsEEmpleado objEE) {
       try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            ResultSet rs=null;
            String SQL="CALL USP_S_Loguear(?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1,objEE.getDniEmpleado());
            rs=st.executeQuery();
            if(rs.next())
            {                    
                if(objEE.getContraseñaEmpleado().equals(rs.getString(5)))
                {
                    if(rs.getInt(4)==1)
                    {
                        JOptionPane.showMessageDialog(null, "Ingreso correcto usuario "+rs.getString(2)+" "+rs.getString(3)+"\n"+
                                "       "+rs.getString(7));
                        FrmLogin.puente=rs.getString(1);      //moviendo DNI
                        FrmLogin.puente2=rs.getString(7);     //Descripcion de tipo de usuario
                        FrmLogin.puente3=rs.getString(2);     //Nombre de empleado
                        FrmLogin.idempleado=rs.getString(8); //id empleado
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
            else
            {
                JOptionPane.showMessageDialog(null, "ESTE USUARIO NO EXISTE");
                return false;
                
            }
        } catch (Exception e) {
            
            return false;
        }
    }

    public boolean MtdResgistroHoraIngreso(ClsEEmpleado objEE) {
        try {
            String SQL="CALL USP_RegistrarHoraIngreso(?,?)";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEE.getDniEmpleado());
            st.setString(2, objEE.getFechaIngreso());      
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
          
        } catch (SQLException e) {
            return false;
        }
    
}

    public boolean MtdResgistroHoraSalida(ClsEEmpleado objEE) {
        try {
            String SQL="CALL USP_RegistrarHoraSalida(?,?)";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEE.getFechaSalida()); 
            st.setString(2, objEE.getDniEmpleado());
                 
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
          
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean MtdBuscarEmpleado(ClsEEmpleado objEE) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            ResultSet rs=null;
            String SQL="CALL USP_B_BuscarEmpleado(?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1,objEE.getDniEmpleado());
            rs=st.executeQuery();
            if(rs.next())
            {                  
                FrmModificar.txtNombre.setText(rs.getString(3));
                FrmModificar.txtApellidos.setText(rs.getString(4));
                if(rs.getString(5).equals("Masculino"))
                {
                    FrmModificar.rbtnMasculino.setSelected(true);
                }
                else
                {
                    FrmModificar.rbtnFemenino.setSelected(true);
                }
                DateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
                String f=rs.getString(6);
                java.util.Date fechaa=null;       
                try {
                    fechaa=formato.parse(f);
                    FrmModificar.jdcFechaNac.setDate(fechaa);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                FrmModificar.txtDireccion.setText(rs.getString(7));
                FrmModificar.txtTelefono.setText(rs.getString(8));
                FrmModificar.txtContraseña.setText(rs.getString(11));
                return true;              
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ESTE USUARIO NO EXISTE");
                return false;
                
            }
        } catch (Exception e) {
            
            return false;
        }
    }

    public boolean MtdModificarEmpleado2(ClsEEmpleado objEE) {
        try {
//            String SQL="Update tb_cargo set descripcioncargo=? where (codigocargo=?);";
            String SQL="CALL USP_U_ActualizarEmpleado2(?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st=con.prepareCall(SQL);
            st.setString(1, objEE.getDniEmpleado());
            st.setString(2, objEE.getNombreEmpleado());
            st.setString(3, objEE.getApellidosEmpleado());
            st.setString(4, objEE.getSexoEmpleado());
            st.setString(5, objEE.getFnacimientoEmpleado());
            st.setString(6, objEE.getDireccionEmpleado());
            st.setString(7, objEE.getTelefonoEmpleado());
            st.setString(8, objEE.getContraseñaEmpleado());           
            if(st.executeUpdate()>0)
            {
                Principal.txtNombre.setText(objEE.getNombreEmpleado());
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