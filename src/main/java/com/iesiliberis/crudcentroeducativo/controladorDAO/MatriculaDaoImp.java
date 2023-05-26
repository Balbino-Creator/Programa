/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author balbi
 */
public class MatriculaDaoImp implements MatriculaDao{

    private static MatriculaDaoImp instance;
    
    static{
        instance=new MatriculaDaoImp();
    }
    
    private MatriculaDaoImp(){ }
    
    public static MatriculaDaoImp getInstance(){
        return instance;
    }
    
    @Override
    public int add(Matricula m) throws SQLException {
        String sql="""
                  insert into matricula(idalumno,idunidad,descripcion,fMatricula,fBaja)
                  values (?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, m.getIdalumno());
            pstm.setInt(2, m.getIdunidad());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());
            pstm.setDate(5, m.getfBaja());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Matricula getById(int id) throws SQLException {
        Matricula matricula=null;
        String sql="select * from matricula where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                matricula = new Matricula();
                matricula.setIdmatricula(rs.getInt("idmatricula"));
                matricula.setIdalumno(rs.getInt("idalumno"));
                matricula.setIdunidad(rs.getInt("idunidad"));
                matricula.setfMatricula(rs.getDate("fMatricula"));
                matricula.setfBaja(rs.getDate("fBaja"));
            }
            
        }
        
        return matricula;
    }

    @Override
    public List<Matricula> getAll() throws SQLException {
        Matricula matricula=null;
        String sql="select * from matricula";
        
        List<Matricula> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                matricula = new Matricula();
                matricula.setIdmatricula(rs.getInt("idmatricula"));
                matricula.setIdalumno(rs.getInt("idalumno"));
                matricula.setIdunidad(rs.getInt("idunidad"));
                matricula.setfMatricula(rs.getDate("fMatricula"));
                matricula.setfBaja(rs.getDate("fBaja"));
                result.add(matricula);
            }
            
        }
        
        return result;
    }

    @Override
    public List<Matricula> getAllByUnidad(int idUnidad) throws SQLException {
        ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
        Matricula matricula;
        String sql="""
                  select * from matricula where idunidad = ?
                   """;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,idUnidad);
            
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                matricula = new Matricula();
                matricula.setIdmatricula(rs.getInt("idmatricula"));
                matricula.setIdalumno(rs.getInt("idalumno"));
                matricula.setIdunidad(rs.getInt("idunidad"));
                matricula.setfMatricula(rs.getDate("fMatricula"));
                matricula.setfBaja(rs.getDate("fBaja"));
                matriculas.add(matricula);
            }
            
        }
        return matriculas;
    }

    @Override
    public int update(Matricula m) throws SQLException {
        String sql="""
                  update matricula
                  set idalumno=?,idunidad=?,descripcion=?,fMatricula=?,fBaja=?
                   where idmatricula=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, m.getIdalumno());
            pstm.setInt(2, m.getIdunidad());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());
            pstm.setDate(5, m.getfBaja());
            pstm.setInt(6, m.getIdmatricula());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from matricula where idmatricula = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
            
            pstm.executeUpdate();
        }
    }
    
}
