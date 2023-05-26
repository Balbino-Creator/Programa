/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iesiliberis.crudcentroeducativo;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.controladorDAO.CursoAcademicoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class CRUDCentroEducativo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection cnlocal=MyDataSource.getConnection();
        System.out.println("Conexion...");
        Test();
    }
    
    
    public static void Test(){
    
        CursoAcademicoDaoImp daoCursoAcademico=CursoAcademicoDaoImp.getInstance();
    
        try {
            CursoAcademico cursoaca=daoCursoAcademico.getById(1);
            System.out.println(cursoaca);
                        
            cursoaca=daoCursoAcademico.getById(1);
            System.out.println(cursoaca);
            
            List<CursoAcademico> lst=daoCursoAcademico.getAll();
            
            System.out.println("Mostrando cursos academicos");
            for(CursoAcademico c : lst){
                System.out.println(c+"\n");
            
            }
            
            // probando inserccion
            //daoCursoAcademico.add(new CursoAcademico(2023,2024,"23-24"));
            
        } catch (Exception ex) {
            System.out.println("Error..."+ex.getMessage());
        }
        
    }
}
