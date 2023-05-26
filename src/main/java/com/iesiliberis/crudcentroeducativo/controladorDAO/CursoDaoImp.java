/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
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
public class CursoDaoImp implements CursoDao{

    private static CursoDaoImp instance;
    
    static{
        instance=new CursoDaoImp();
    }
    
    private CursoDaoImp(){ }
    
    public static CursoDaoImp getInstance(){
        return instance;
    }
    
    @Override
    public int add(Curso c) throws SQLException {
        String sql="""
                  insert into curso(codigo,nombre,Observaciones,idcursoacademico)
                  values (?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcursoacademico());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Curso getById(int id) throws SQLException {
        Curso cu=null;
        String sql="select * from curso where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                cu=new Curso();
                
                cu.setId(rs.getInt("id"));
                
                cu.setCodigo(rs.getString("codigo"));
                cu.setNombre(rs.getString("nombre"));
                cu.setObservaciones(rs.getString("Observaciones"));
            }
            
        }
        
        return cu;
    }

    @Override
    public List<Curso> getAll() throws SQLException {
        Curso c=null;
        String sql="select * from curso";
        
        List<Curso> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                c=new Curso();
                
                c.setId(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setObservaciones(rs.getString("Observaciones"));
                c.setIdcursoacademico(rs.getInt("idcursoacademico"));
                
                
                result.add(c);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Curso c) throws SQLException {
        String sql="""
                  update curso
                  set codigo=?,nombre=?, Observaciones=?, idcursoacademico=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1,c.getCodigo());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4,c.getIdcursoacademico());
            pstm.setInt(5, c.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from curso where id = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
            
            pstm.executeUpdate();
        }
    }

    /*
    @Override
    public CursoAcademico getCursoAcademico(Curso c) throws SQLException {
        CursoAcademicoDaoImp ca = CursoAcademicoDaoImp.getInstance();
        return ca.getById(c.getIdcursoacademico());
    }*/

    @Override
    public List<Curso> getAllByCursoAcademico(int idcursoacademico) throws SQLException {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        Curso c;
        String sql="""
                  select * from curso where idcursoacademico = ?
                   """;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,idcursoacademico);
            
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                c = new Curso();
                c.setId(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setObservaciones(rs.getString("Observaciones"));
                c.setIdcursoacademico(rs.getInt(idcursoacademico));
                cursos.add(c);
            }
            
        }
        return cursos;
    }
    
}
