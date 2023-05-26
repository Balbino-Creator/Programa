/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
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
public class UnidadDaoImp implements UnidadDao{
    private static UnidadDaoImp instance;
    
    static{
        instance=new UnidadDaoImp();
    }
    
    private UnidadDaoImp(){ }
    
    public static UnidadDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(Unidad u) throws SQLException {
        String sql="""
                  insert into unidad(codigo,nombre,Observaciones,idcurso,idtutor,idaula)
                  values (?,?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, u.getCodigo());
            pstm.setString(2, u.getNombre());
            pstm.setString(3, u.getObservaciones());
            pstm.setInt(4, u.getIdcurso());
            pstm.setInt(5, u.getIdtutor());
            pstm.setInt(6, u.getIdaula());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Unidad getById(int id) throws SQLException {
        Unidad u=null;
        String sql="select * from unidad where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                u=new Unidad();
                
                u.setId(rs.getInt("id"));
                
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setObservaciones(rs.getString("Observaciones"));
            }
            
        }
        
        return u;
    }

    @Override
    public List<Unidad> getAll() throws SQLException {
        Unidad u=null;
        String sql="select * from unidad";
        
        List<Unidad> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                u=new Unidad();
                
                u.setId(rs.getInt("id"));
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setObservaciones(rs.getString("observaciones"));
                u.setIdcurso(rs.getInt("idcurso"));
                u.setIdtutor(rs.getInt("idtutor"));
                u.setIdaula(rs.getInt("idaula"));
                
                
                result.add(u);
            }
            
        }
        
        return result;
    }

    @Override
    public List<Unidad> getAllByCurso(int idcurso) throws SQLException {
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        Unidad u;
        String sql="""
                  select * from unidad where idcurso = ?
                   """;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,idcurso);
            
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                u = new Unidad();
                u.setId(rs.getInt("id"));
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setObservaciones(rs.getString("Observaciones"));
                u.setIdcurso(rs.getInt(idcurso));
                u.setIdtutor(rs.getInt("idtutor"));
                u.setIdaula(rs.getInt("idaula"));
                unidades.add(u);
            }
            
        }
        return unidades;
    }

    @Override
    public int update(Unidad u) throws SQLException {
        String sql="""
                  update unidad
                  set codigo=?,nombre=?, Observaciones=?, idcurso=?, idtutor=?, idaula=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1,u.getCodigo());
            pstm.setString(2,u.getNombre());
            pstm.setString(3, u.getObservaciones());
            pstm.setInt(4,u.getIdcurso());
            pstm.setInt(5,u.getIdtutor());
            pstm.setInt(6,u.getIdaula());
            pstm.setInt(7,u.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from unidad where id = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
            
            pstm.executeUpdate();
        }
    }
}
