/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

/**
 *
 * @author balbi
 */
public class Autorizaciones {
    private int idalumno;
    private int idautorizado;
    
    public Autorizaciones(Alumno alumno, Autorizado autorizado){
        this.idalumno = alumno.getId();
        this.idautorizado = alumno.getId();
    }

    public Autorizaciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdautorizado() {
        return idautorizado;
    }

    public void setIdautorizado(int idautorizado) {
        this.idautorizado = idautorizado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idalumno;
        hash = 41 * hash + this.idautorizado;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autorizaciones other = (Autorizaciones) obj;
        if (this.idalumno != other.idalumno) {
            return false;
        }
        return this.idautorizado == other.idautorizado;
    }
    
    
}
