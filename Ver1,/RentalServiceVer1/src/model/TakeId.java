/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class TakeId {

    private final Connection conn;

    public TakeId() {
        this.conn = DBConnection.getConnection();
    }

    public ArrayList<String> getListId(String column, String table) {
        ArrayList<String> listId = new ArrayList<>();
        String sql = "SELECT " + column + " FROM " + table + "";
        try {
            try (ResultSet rs = conn.createStatement().executeQuery(sql)) {
                while (rs.next()) {
                    String id = rs.getString(column);
                    listId.add(id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TakeId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listId;
    }

    public String takeNewId(String type, String column, String table) {
        ArrayList<String> listId = getListId(column, table);
        boolean loop = true;
        String id = null;
        while (loop) {
            String uuid = type + UUID.randomUUID().toString().substring(0, 8);
            if (listId.isEmpty()) {
                id = uuid;
                return id;
            } else {
                for (String str : listId) {
                    if (!listId.contains(uuid)) {
                        id = uuid;
                        loop = false;
                        break;
                    }
                }
            }
        }
        return id;
    }
}
