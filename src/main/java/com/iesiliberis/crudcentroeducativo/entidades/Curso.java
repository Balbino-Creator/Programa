/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;

import java.util.Objects;

/**
 *
 * @author balbi
 */
public class Curso {
    private int id;
    private String codigo;
    private String nombre;
    private String observaciones;
    private int idcursoacademico;

    public Curso() {
    }
    
    public Curso(int id, String codigo, String nombre, String observaciones, CursoAcademico cursoacademico) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.idcursoacademico = cursoacademico.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdcursoacademico() {
        return idcursoacademico;
    }

    public void setIdcursoacademico(int idcursoacademico) {
        this.idcursoacademico = idcursoacademico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + this.idcursoacademico;
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
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idcursoacademico != other.idcursoacademico) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo) && Objects.equals(this.idcursoacademico, other.idcursoacademico);
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", observaciones=" + observaciones + ", idcursoacademico=" + idcursoacademico + '}';
    }
}
