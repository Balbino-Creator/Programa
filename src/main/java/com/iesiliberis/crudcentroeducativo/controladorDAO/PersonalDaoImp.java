/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Personal;
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
public class PersonalDaoImp implements PersonalDao{
    private static PersonalDaoImp instance;
    
    static {
        instance = new PersonalDaoImp();
    }
    
    private PersonalDaoImp(){
        
    }
    
    public static PersonalDaoImp getInstance(){
        return instance;
    }
    
    @Override
    public int add(Personal p) throws SQLException {
        String sql = """
                     insert into personal(dni,nombre,apellido1,apellido2,direccion,cp,poblacion,provincia,telefono,email,tipo) 
                     values (?,?,?,?,?,?,?,?,?,?,?)
                     """;
        int result = 0;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, p.getDni());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido1());
            pstm.setString(4, p.getApellido2());
            pstm.setString(5, p.getDireccion());
            pstm.setString(6, p.getCp());
            pstm.setString(7, p.getPoblacion());
            pstm.setString(8,p.getProvincia());
            pstm.setString(9, p.getTelefono());
            pstm.setString(10, p.getEmail());
            pstm.setInt(11,p.getTipo());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Personal getById(int id) throws SQLException {
        Personal p=null;
        String sql="select * from personal where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                p=new Personal();
                
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido1(rs.getString("apellido1"));
                p.setApellido2(rs.getString("apellido2"));
                p.setDireccion(rs.getString("direccion"));
                p.setCp(rs.getString("direccion"));
                p.setPoblacion(rs.getString("poblacion"));
                p.setProvincia(rs.getString("provincia"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                p.setTipo(rs.getInt("tipo"));
            }
            
        }
        
        return p;
    }

    @Override
    public List<Personal> getAll() throws SQLException {
        Personal p=null;
        String sql="select * from personal";
        
        List<Personal> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                p=new Personal();
                p.setId(rs.getInt("id"));
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido1(rs.getString("apellido1"));
                p.setApellido2(rs.getString("apellido2"));
                p.setDireccion(rs.getString("direccion"));
                p.setCp(rs.getString("cp"));
                p.setPoblacion(rs.getString("poblacion"));
                p.setProvincia(rs.getString("provincia"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                p.setTipo(rs.getInt("tipo"));
                result.add(p);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Personal p) throws SQLException {
        String sql = """
                     update personal set dni=?,nombre=?,apellido1=?,apellido2=?,direccion=?,cp=?,poblacion=?,provincia=?,telefono=?,email=?,tipo=?
                     where id = ?
                     """;
        int result = 0;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, p.getDni());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido1());
            pstm.setString(4, p.getApellido2());
            pstm.setString(5, p.getDireccion());
            pstm.setString(6, p.getCp());
            pstm.setString(7, p.getPoblacion());
            pstm.setString(8,p.getProvincia());
            pstm.setString(9, p.getTelefono());
            pstm.setString(10, p.getEmail());
            pstm.setInt(11,p.getTipo());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from personal where id = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
            
            pstm.executeUpdate();
        }
    }

    @Override
    public int getIdByDni(String dni) throws SQLException {
        int id=0;
        String sql="select id from personal where dni=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, dni);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
                id = rs.getInt("id");
            
        }
        
        return id;
    }
    
}
