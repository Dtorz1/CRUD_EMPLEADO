/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado.bo;

/**
 *
 * @author migue
 */
import com.empleado.dao.EmpleadoDAO;
import com.empleado.db.Conexion;
import com.empleado.entity.Empleado;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Miguel
 */
public class EmpleadoBO {
   
  private String mensaje="";
    private EmpleadoDAO edao= new EmpleadoDAO();
   
    public String agregarEmpleado(Empleado emp ){
        Connection conn= Conexion.getConnection();
        try {
            mensaje = edao.agregarEmpleado(conn, emp);
            conn.commit();
            } catch (Exception e) {
           mensaje = mensaje +" " + e.getMessage();
           
        }finally {
            try {
                if (conn != null){
                    conn.close();
            }
            } catch (Exception e) {
                mensaje = mensaje +" " + e.getMessage();
               
            }
        }
        return mensaje;
    }
   
    public String borrarEmpleado( int id){
        Connection conn= Conexion.getConnection();
        try {
            mensaje = edao.borrarEmpleado(conn, id);
           //Ignora los cambios hechos desdde el principio
        } catch (Exception e) {
           mensaje = mensaje +" " + e.getMessage();
        }finally {
            try {
                if (conn != null){
                    conn.close();
            }
            } catch (Exception e) {
                mensaje = mensaje +" " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String modificarEmpleado(Empleado emp){
        Connection conn= Conexion.getConnection(); //Me dice si la conexion esta activa
        try {
            mensaje = edao.modificarEmpleado(conn, emp);
            conn.commit(); //Almacena los cambios en el disco duro
        } catch (Exception e) {
           mensaje = mensaje +" " + e.getMessage();
        }finally {
            try {
                if (conn != null){
                    conn.close();
            }
            } catch (Exception e) {
                mensaje = mensaje +" " + e.getMessage();
            }
        }
        return mensaje;
    }
    public void  mostrarEmpleado(JTable table){
        Connection conn = Conexion.getConnection();
        edao.mostrarEmpleado(conn, table);
      try {
          conn.close();
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
   public int getMaxID(){
             Connection conn = Conexion.getConnection();
        int id = edao.getMaxID(conn);
      try {
          conn.close();
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
      return id;
   }
}
