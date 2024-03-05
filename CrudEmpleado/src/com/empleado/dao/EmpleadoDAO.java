/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado.dao;

/**
 *
 * @author migue
 */

    


import com.empleado.entity.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aleja
 */
public class EmpleadoDAO {
   
        private String mensaje = "";
   
    public String agregarEmpleado(Connection con, Empleado emp) { // Llamo la clase department de entity
        PreparedStatement pst=null; //Prepared pst es el nombre
        String sql= "INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) " 
                  + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql); //Verificar lo que vamos a poner en la conexion
            pst.setInt(1, emp.getEmpleadoId());
            pst.setString(2, emp.getNombre());
            pst.setString(3, emp.getApellido());
            pst.setString(4, emp.getCorreo());
            pst.setString(5 , emp.getNumeroCelular());
            pst.setString(6, emp.getFechaContratacion());
            pst.setString(7 , emp.getJobId());
            pst.setInt(8 , emp.getSalario());
            pst.setString(9 , emp.getComission_PCT());
            pst.setInt(10 , emp.getManagerId());
            pst.setInt(11 , emp.getDepartmentId());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e){
            mensaje ="No se puede guardar \n" + e.getMessage() + " " + sql;
       
        }
        return mensaje;
    }
    public String borrarEmpleado(Connection con, int id){
          PreparedStatement pst=null;
          String sql="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            mensaje="Eliminado Correctamente" + " " + sql;
            pst.execute();
            pst.close();
           
        } catch (SQLException e) {
           
             mensaje="No se pudo eliminar \n "+ e.getMessage() + " " + sql;
        }
        return mensaje;
    }
   
   
    public String modificarEmpleado(Connection con, Empleado emp){
          PreparedStatement pst=null;
        String sql="update EMPLOYEES set FIRST_NAME = ?,LAST_NAME = ?,EMAIL = ?,PHONE_NUMBER = ?,HIRE_DATE = ?,JOB_ID = ?,SALARY = ?,COMMISSION_PCT = ?,MANAGER_ID = ?,DEPARTMENT_ID = ?"
                  +"where EMPLOYEE_ID = ?";
        try {
            pst = con.prepareStatement(sql); //Verificar lo que vamos a poner en la conexion
            
            pst.setString(1, emp.getNombre());
            pst.setString(2, emp.getApellido());
            pst.setString(3, emp.getCorreo());
            pst.setString(4 , emp.getNumeroCelular());
            pst.setString(5, emp.getFechaContratacion());
            pst.setString(6 , emp.getJobId());
            pst.setInt(7 , emp.getSalario());
            pst.setString(8 , emp.getComission_PCT());
            pst.setInt(9 , emp.getManagerId());
            pst.setInt(10, emp.getDepartmentId());
            pst.setInt(11, emp.getEmpleadoId());
            mensaje="Modificado Correctamente";
            pst.execute();
            pst.close();
           
        } catch (SQLException e) {
           
             mensaje="No se pudo modificar \n "+ e.getMessage();
        }
        return mensaje;
    }
    public void  mostrarEmpleado(Connection con, JTable table)
    {                                                          // Recibir conexiones el nombre de la table
        DefaultTableModel model; //Llamar el objeto de nuestra tabla
        String [] col = {"EmpleadoId", "Nombre", "Apellido","Correo","NumeroCelular","FechaContratacion","jobId","Salario","comission_PCT","managerId","DepartmentId"}; // Agregamos los parametros a nuestra columna
        model = new DefaultTableModel(null, col); // Se lo agregamos a nuestra tabla
       
        String sql = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID"; //Orden numerico, Creamos select que sera consulta
        String [] filas = new String[11]; // # De datos que ingreso Nuestras filas
        Statement st = null; // Ejecutar nuestro Query  
        ResultSet rs = null;
       
       
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); // Tener resultados de ese sql, que va a hacer a nuestro statement
            while (rs.next()) {                
                for (int i = 0; i < 11; i++) {
                    filas[i] = rs.getString(i +1);
                }
                model.addRow(filas); // Guardar directamente las filas
            }
            table.setModel(model); // Guardar datos en el modelo de la tabla que estoy recibiendo
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error para listar la tabla");
        }
    }
    
    public int getMaxID(Connection con){
        int id=0;
        PreparedStatement pst = null;
        ResultSet rs= null;
        String sql = "SELECT MAX(EMPLOYEE_ID)+1 as id FROM  EMPLOYEES";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                id= rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar id"+ e.getMessage());
        }
        return id;
        
    }
}


    

