/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class DataProcess {

    final private Connection conn;

    public DataProcess() {
        this.conn = DBConnection.getConnection();
    }

    public boolean AddEditDelete(String sql) {
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Check(String sql) {
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Object[]> getListObject(String sql) {
        ArrayList<Object[]> listObj = new ArrayList<>();
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                int count = rs.getMetaData().getColumnCount();
                Object[] arrayObj = new Object[count];
                for (int i = 0; i < count; i++) {
                    arrayObj[i] = rs.getObject(i+1);
                }
                listObj.add(arrayObj);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObj;
    }

    public Object[] getObject(String sql) {
        Object[] obj = null;
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                int count = rs.getMetaData().getColumnCount();
                obj = new Object[count];
                for (int i = 0; i < count; i++) {
                    obj[i] = rs.getObject(i+1);
                }
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM tblUser";
        DataProcess dp = new DataProcess();
        for (Object[] obj : dp.getListObject(sql)) {
            for (Object o : obj) {
                System.out.print(" " + o);
            }
            System.out.println("");
        }
    }
}
