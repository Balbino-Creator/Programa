/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizado;
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
public class AutorizadoDaoImp implements AutorizadoDao{

    @Override
    public int add(Autorizado a) throws SQLException {
        String sql="""
                  insert into Autorizado(dni,nombre,apellido1,apellido2,parentesco)
                  values (?,?,?,?,?)
                  """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3,a.getApellido1());
            pstm.setString(4,a.getApellido2());
            //falta enumerado
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public int update(Autorizado a) throws SQLException {
        String sql="""
                  update autorizado
                  set dni=?,nombre=?, apellido1=?, apellido2=?, parentesco=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3,a.getApellido1());
            pstm.setString(4,a.getApellido2());
            //falta enumerado
            pstm.setInt(5,a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Autorizado getById(int idalumno) throws SQLException {
        Autorizado autorizado=null;
        String sql="select * from autorizado where idalumno=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, idalumno);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                Autorizado autori= new Autorizado();
                autori.setId(rs.getInt("id"));
                autori.setDni(rs.getString("dni"));
                autori.setNombre(rs.getString("nombre"));
                autori.setApellido1(rs.getString("apellido1"));
                autori.setApellido2(rs.getString("apellido2"));
                //falta parentesco
            }
            
        }
        
        return autorizaciones;
    }

    @Override
    public List<Autorizado> getAll() throws SQLException {
        Autorizado a=null;
        String sql="select * from autorizado";
        
        List<Autorizado> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                a=new Autorizado();
                
                a.setId(rs.getInt("id"));
                a.setDni(rs.getString("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido1(rs.getString("apellido1"));
                a.setApellido2(rs.getString("apellido2"));
                //falta parentesco
                
                
                result.add(a);
            }
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from autorizado where id = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
            
            pstm.executeUpdate();
        }
    }
    
}
