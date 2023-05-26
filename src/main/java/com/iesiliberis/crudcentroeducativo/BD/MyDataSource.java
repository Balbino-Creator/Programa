/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sergio
 */
public class MyDataSource {    
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/centroeducativo";
    private static final String user="usercentroeducativo";
    private static final String pass="1234";
    private static Connection cn;
    
    
    public static Connection getConnection(){        
        try{
            if (cn==null || cn.isClosed()){
            
            //Class.forName(driver);
                cn=DriverManager.getConnection(url,user,pass);
            }
        
        }catch(Exception e){
                System.out.println("Error al conectar BD:"+e.getMessage());
        }

        return cn;
    }
    
}
