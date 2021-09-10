/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_venta.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rolando
 */
public class conexion {
        String RutaRolio = "jdbc:sqlite:C:/Users/Rolando/Documents/NetBeansProjects/Punto_De_Venta/DataBase_Ventas.s3db";
        String RutaOsqui = "jdbc:sqlite:C:/Users/OscarTeran/Documents/GitSites/Punto_De_Venta/DataBase_Ventas.s3db";
        String strConexionDB = RutaOsqui; //Ruta a la base de datos .s3db
        Connection conn=null;

    public conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConexionDB);
            
            System.out.println("CONEXIÓN ESTABLECIDA");
        } catch (Exception e) {
            System.out.println("ERROR EN LA CONEXIÓN"+e);
        }
    }
        
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try { 
            PreparedStatement pstm=conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error"+e);
            return 0;
        }
    }
    
//Método para realizar consultas 
    public ResultSet consultarRegistros(String strSentenciaSQL){
    
        try {
            PreparedStatement pstm=conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta=pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println("No fue posible acceder a los registros"+ e);
            return null;
        }
    
    } 
    
    
        
}
