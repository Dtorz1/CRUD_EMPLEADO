/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado.test;

/**
 *
 * @author miguel
 */
import com.empleado.bo.EmpleadoBO;
import com.empleado.entity.Empleado;


public class Test {
    EmpleadoBO ebo = new EmpleadoBO();
    Empleado emp = new Empleado();
    String mensaje = "";
   
//    public void insertar()  {
//        emp.setNombre("Pedro");
//        emp.setApellido("Macias");
//        emp.setCorreo("asdf@gmail.com");
//        emp.setNumeroCelular(653663);
//        emp.setFechaContratacion("04/4/2015");
//        emp.setJobId("SA_REP");
//        emp.setSalario(1500);
//        emp.setComission_PCT("0,1");
//        emp.setManagerId(149);
//        emp.setDepartmentId(80);
//        mensaje = ebo.agregarEmpleado(emp);
//        System.out.println(mensaje);
//    }
    
        
    
//    public void modificar ()  {
//
//        emp.setNombre("Sergio");
//        emp.setApellido("Paredes");
//        emp.setCorreo("asdf@gmail.com");
//        emp.setNumeroCelular(653663);
//        emp.setFechaContratacion("04/04/2017");
//        emp.setJobId("SA_REP");
//        emp.setSalario(1500);
//        emp.setComission_PCT("0,1");
//        emp.setManagerId(149);
//        emp.setDepartmentId(80);
//        mensaje = ebo.agregarEmpleado(emp);
//        System.out.println(mensaje);
//    }
//    
//   
    public void eliminar() {
        mensaje = ebo.borrarEmpleado(0);
        System.out.println(mensaje);
    }

 
    
    public static void main(String[] args) {
        Test test = new Test();
//        test.eliminar();
       test.eliminar();  
    }
}