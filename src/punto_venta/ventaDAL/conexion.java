/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_venta.ventaDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OscarTeran
 */
public class conexion {
    String file_path = "DataBase_Ventas.s3db";
    String strConexionDB = file_path;
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
    
    public int ejecutar_sentencia_SQL(String strSentenciaSQL){
        try{
           PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
           pstm.execute();
           return 1;
        } catch (SQLException e){
            System.out.println(e);
            return 0;
    }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
           PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
           ResultSet respuesta = pstm.executeQuery();
           return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
