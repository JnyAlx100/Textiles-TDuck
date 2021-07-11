/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    private Connection conexion;
    private String driver = "com.mysql.jdbc.Driver";
    private String base = "textilests";//<- Esto cambiarlo sin duda
    private String host = "localhost:3306";//<- Cambiar esto
    private String puerto = "3306";//<- Posiblemente eso
    private String url = "jdbc:mysql://" + host + "/" + base;
    private String user = "root";
    private String password = "1234";
    private static ConexionDB instancia;
    private ArrayList<String> atributos = new ArrayList<String>();

    private ConexionDB() {
    }
    
    public static ConexionDB InstanciaSingleton(){
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }
    
    public Connection conectarMySQL(){
        conexion = null;
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println(url);
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
        }
        return conexion;
    }

    public void Desconectar(){
        try {
            this.conexion.close();
        } catch (Exception e) {
        }
    }
}