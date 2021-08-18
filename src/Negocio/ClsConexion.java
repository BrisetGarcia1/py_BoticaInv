/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
public class ClsConexion {
     public static Connection Conectar()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //cambio
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/bd_boticainv","root","");
            //return (Connection) DriverManager.getConnection("jdbc:mysql://proyectobotica.mysql.database.azure.com/bd_pybotica","sa@proyectobotica","Proyecto123");

        } catch (ClassNotFoundException e)
        {
          return null;
        }catch (SQLException ex)
        {
         return null;
        }
    }
}
