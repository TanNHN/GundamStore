/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBUtil;
import dto.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tan
 */
public class OrderDAO {
    
    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void closeConnection() throws SQLException {
        if (cnn != null) {
            cnn.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
    
    public int createOrder(int userID, String Date) throws SQLException {
        try {
            Connection cnn = DBUtil.getConnection();
            if (cnn != null) {
                String sql = "INSERT INTO [dbo].[Order]([OrderDate],[UserID]) values(?, ?)";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, Date);
                ps.setInt(2, userID);
                int result = ps.executeUpdate();
                if (result > 0) {
                    String sql2 = "SELECT TOP 1 OrderID from [dbo].[Order] order by OrderID desc";
                    ps = cnn.prepareStatement(sql2);
                    rs = ps.executeQuery();
                    if (rs != null && rs.next()) {
                        return rs.getInt("OrderID");
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return -1;
    }
    
    public List<OrderDTO> getUserOrder(int userID) {
        List<OrderDTO> list = null;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                list = new ArrayList<>();
                String sql = "SELECT * FROM [dbo].[Order] WHERE UserID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, userID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    String date = rs.getString("OrderDate");
                    list.add(new OrderDTO(orderID, date, userID));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<OrderDTO> viewAllCusOrder() {
        List<OrderDTO> list = new ArrayList<>();
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM [dbo].[Order]";
                ps = cnn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    String date = rs.getString("OrderDate");
                    int userID = rs.getInt("UserID");
                    list.add(new OrderDTO(orderID, date, userID));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
