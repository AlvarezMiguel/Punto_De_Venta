/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_venta.ventaDAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author OscarTeran
 */
public class conexion {
    String strConexionDB = "jdbc:sqlite:C:/Users/OscarTeran/Documents/GitSites/Punto_De_Venta/DataBase_Ventas.s3db";
    Connection conn = null;
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            System.out.println("Error de conexión"+e);
        }
    }
}
