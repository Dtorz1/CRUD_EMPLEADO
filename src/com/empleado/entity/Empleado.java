/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado.entity;

/**
 *
 * @author migue
 */
public class Empleado {
    
    private int EmpleadoId;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String NumeroCelular;
    private String FechaContratacion;
    private String jobId;
    private int Salario;
    private String comission_PCT;
    private int managerId;
    private int DepartmentId;
    
 
    public Empleado() {}

    public Empleado(int EmpleadoId, String Nombre, String Apellido, String Correo, String NumeroCelular, String FechaContratacion, String jobId, int Salario, String comission_PCT, int managerId, int DepartmentId) {
        this.EmpleadoId = EmpleadoId;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.NumeroCelular = NumeroCelular;
        this.FechaContratacion = FechaContratacion;
        this.jobId = jobId;
        this.Salario = Salario;
        this.comission_PCT = comission_PCT;
        this.managerId = managerId;
        this.DepartmentId = DepartmentId;
    }

    public int getEmpleadoId() {
        return EmpleadoId;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getNumeroCelular() {
        return NumeroCelular;
    }

    public String getFechaContratacion() {
        return FechaContratacion;
    }

    public String getJobId() {
        return jobId;
    }

    public int getSalario() {
        return Salario;
    }

    public String getComission_PCT() {
        return comission_PCT;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    
    
    public void setEmpleadoId(int EmpleadoId) {
        this.EmpleadoId = EmpleadoId;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setNumeroCelular(String NumeroCelular) {
        this.NumeroCelular = NumeroCelular;
    }

    public void setFechaContratacion(String FechaContratacion) {
        this.FechaContratacion = FechaContratacion;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    public void setComission_PCT(String comission_PCT) {
        this.comission_PCT = comission_PCT;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    
    @Override
    public String toString() {
        return "Empleado{" + "EmpleadoId=" + EmpleadoId + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo + ", NumeroCelular=" + NumeroCelular + ", FechaContratacion=" + FechaContratacion + ", jobId=" + jobId + ", Salario=" + Salario + ", comission_PCT=" + comission_PCT + ", managerId=" + managerId + ", DepartmentId=" + DepartmentId + '}';
    } 

}


