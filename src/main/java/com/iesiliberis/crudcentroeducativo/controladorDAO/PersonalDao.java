/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.Personal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author balbi
 */
public interface PersonalDao {
    int add(Personal p) throws SQLException;
    
    Personal getById(int id) throws SQLException;
    
    int getIdByDni(String dni) throws SQLException;
        
    List<Personal> getAll()  throws SQLException;
    
    int update(Personal p)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
