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
public class Unidad {
    private int id; 
    private String codigo; 
    private String nombre; 
    private String observaciones;  
    private int idcurso; 
    private int idtutor; 
    private int idaula;

    public Unidad(int id, String codigo, String nombre, String observaciones, Curso curso, Autorizado tutor, Aula aula) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.idcurso = curso.getId();
        this.idtutor = tutor.getId();
        this.idaula = aula.getId();
    }

    public Unidad() {
        
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

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(int idtutor) {
        this.idtutor = idtutor;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + this.idcurso;
        hash = 79 * hash + this.idtutor;
        hash = 79 * hash + this.idaula;
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
        final Unidad other = (Unidad) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idcurso != other.idcurso) {
            return false;
        }
        if (this.idtutor != other.idtutor) {
            return false;
        }
        if (this.idaula != other.idaula) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }
    
    
}
