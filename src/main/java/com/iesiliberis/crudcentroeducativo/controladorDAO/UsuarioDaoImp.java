/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergio
 */
public class UsuarioDaoImp implements UsuarioDao {

    private static UsuarioDaoImp instance;
    
    static{
        instance=new UsuarioDaoImp();
    }
    
    private UsuarioDaoImp(){ }
    
    public static UsuarioDaoImp getInstance(){
        return instance;
    }
    
    @Override
    public Usuario getById(int id) throws SQLException {
        Usuario usu=null;
        String sql="select * from usuario where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                usu=new Usuario();
                
                usu.setId(rs.getInt("id"));
                
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                
            }
            
        }
        
        return usu;
    }

    @Override
    public int add(Usuario u) throws SQLException {
        String sql="""
                  insert into usuario(usuario,password)
                  values (?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, u.getUsuario());
            pstm.setString(2, u.getPassword());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        Usuario usu=null;
        String sql="select * from usuario";
        
        List<Usuario> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                usu=new Usuario();
                
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                
                result.add(usu);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Usuario c) throws SQLException {
        String sql="""
                  update usuario
                  set usuario=?,password=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1,c.getUsuario());
            pstm.setString(2,c.getPassword());
            pstm.setInt(3,c.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from usuario where id = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
            
            pstm.executeUpdate();
        }
    }

    @Override
    public boolean valida(String Usuario, String password) throws SQLException {
        
        String sql="select * from usuario where usuario=? and password=? ";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, Usuario);
            pstm.setString(2, password);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
               return true;
                
            }
            
        }
        
        return false;
    }

   
    
}
