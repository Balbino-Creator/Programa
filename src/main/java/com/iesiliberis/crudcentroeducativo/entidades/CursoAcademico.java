/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

/**
 *
 * @author sergio
 */
public class CursoAcademico {
    private int id;
    private int yearinicio;
    private int yearfin;
    private String descripcion;

    public CursoAcademico() {
    }

    
    public CursoAcademico(int yearinicio, int yearfin, String descripcion) {
        this.yearinicio = yearinicio;
        this.yearfin = yearfin;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public int getYearinicio() {
        return yearinicio;
    }

    public void setYearinicio(int yearinicio) {
        this.yearinicio = yearinicio;
    }

    public int getYearfin() {
        return yearfin;
    }

    public void setYearfin(int yearfin) {
        this.yearfin = yearfin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CursoAcademico{" + "id=" + id + ", yearinicio=" + yearinicio + ", yearfin=" + yearfin + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + this.yearinicio;
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
        final CursoAcademico other = (CursoAcademico) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.yearinicio == other.yearinicio;
    }
    
    
    
}
