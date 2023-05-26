/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizaciones;
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
public class AutorizacionesDaoImp implements AutorizacionesDao{
    private static AutorizacionesDaoImp instance;
    
    static{
        instance=new AutorizacionesDaoImp();
    }
    
    private AutorizacionesDaoImp(){ }
    
    public static AutorizacionesDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(Autorizaciones a) throws SQLException {
        String sql="""
                  insert into autorizaciones(idalumno, idautorizado)
                  values (?,?)
                  """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, a.getIdalumno());
            pstm.setInt(2, a.getIdautorizado());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Autorizaciones getById(int idalumno) throws SQLException {
        Autorizaciones autorizaciones=null;
        String sql="select * from autorizaciones where idalumno=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, idalumno);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                Autorizaciones autori= new Autorizaciones();
                autori.setIdalumno(rs.getInt("idalumno"));
                autori.setIdautorizado(rs.getInt("idautorizado"));
            }
            
        }
        
        return autorizaciones;
    }

    @Override
    public List<Autorizaciones> getAll() throws SQLException {
        Autorizaciones autorizaciones=null;
        String sql="select * from autorizaciones";
        
        List<Autorizaciones> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                Autorizaciones autori = new Autorizaciones();
                autori.setIdalumno(rs.getInt("idalumno"));
                autori.setIdautorizado(rs.getInt("idautorizado"));
                result.add(autori);
            }
            
        }
        
        return result; 
    }

    @Override
    public void delete(int idalumno, int idautorizado) throws SQLException {
        String sql = """
                     delete from autorizaciones where idalumno=? and idautorizado=?;
                     """;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1,idalumno);
            pstm.setInt(2, idautorizado);
        }
    }
}
