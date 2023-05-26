/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.Parentesco;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author balbi
 */
public interface ParentescoDao {
    int add(Parentesco p) throws SQLException;
    
    Parentesco getById(int id) throws SQLException;
        
    List<Parentesco> getAll()  throws SQLException;
    
    int update(Parentesco p)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
