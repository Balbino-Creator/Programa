/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
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
public class AlumnoDaoImp implements AlumnoDao {

     private static AlumnoDaoImp instance;
    
    static{
        instance=new AlumnoDaoImp();
    }
    
    private AlumnoDaoImp(){ }
    
    public static AlumnoDaoImp getInstance(){
        return instance;
    }
    
    
    
    @Override
    public int add(Alumno a) throws SQLException {
        String sql="""
                  insert into alumno(nombre,apellido1,apellido2,fNacimiento, telefono, email, dni, direccion, cp, poblacion, provincia)
                  values (?,?,?,?,?,?,?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getApellido1());
            pstm.setString(3, a.getApellido2());
            pstm.setDate(4, a.getFnacimiento());
            pstm.setString(5, a.getTelefono());
            pstm.setString(6, a.getEmail());
            pstm.setString(7, a.getDni());
            pstm.setString(8, a.getDireccion());
            pstm.setString(9, a.getCp());
            pstm.setString(10, a.getPoblacion());
            pstm.setString(11, a.getProvincia());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Alumno getById(int id) throws SQLException {
        Alumno alumno=null;
        String sql="select * from alumno where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido1(rs.getString("apellido1"));
                alumno.setApellido2(rs.getString("apellido2"));
                alumno.setFnacimiento(rs.getDate("fNacimiento"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setEmail(rs.getString("email"));
                alumno.setDni(rs.getString("dni "));
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setCp(rs.getString("direccion"));
                alumno.setPoblacion(rs.getString("poblacion"));
                alumno.setProvincia(rs.getString("provincia"));
            }
            
        }
        
        return alumno;
    }

    @Override
    public List<Alumno> getAll() throws SQLException {
        Alumno alum=null;
        String sql="select * from alumno";
        
        List<Alumno> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                alum=new Alumno();
                
                alum.setId(rs.getInt("id"));
                alum.setNombre(rs.getString("nombre"));
                alum.setApellido1(rs.getString("apellido1"));
                alum.setApellido2(rs.getString("apellido2"));
                alum.setFnacimiento(rs.getDate("fNacimiento"));
                alum.setTelefono(rs.getString("telefono"));
                alum.setEmail(rs.getString("email"));
                alum.setDni(rs.getString("dni"));
                alum.setDireccion(rs.getString("direccion"));
                alum.setCp("cp");
                alum.setPoblacion("poblacion");
                alum.setProvincia("provincia");
                
                
                result.add(alum);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Alumno a) throws SQLException {
        String sql="""
                  update alumno
                  set nombre=?,apellido1=?,apellido2=?,fNacimiento=?, telefono=?, email=?, dni=?, direccion=?, cp=?, poblacion=?, provincia=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getApellido1());
            pstm.setString(3, a.getApellido2());
            pstm.setDate(4, a.getFnacimiento());
            pstm.setString(5, a.getTelefono());
            pstm.setString(6, a.getEmail());
            pstm.setString(7, a.getDni());
            pstm.setString(8, a.getDireccion());
            pstm.setString(9,a.getCp());
            pstm.setString(10, a.getPoblacion());
            pstm.setString(11, a.getProvincia());
            pstm.setInt(12,a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                     delete from alumno where id = ?
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,id);
        }
    }

    @Override
    public int getIdByDni(String dni) throws SQLException {
        int id=0;
        String sql="select id from alumno where dni=?";

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
