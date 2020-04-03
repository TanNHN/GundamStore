/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBUtil;
import dto.OrderDTO;
import dto.OrderDetailDTO;
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
public class OrderDetailDAO {

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

    public void CreateOrderDetail(int orderID, int ProductID, int quantity) throws SQLException {
        try {
            Connection cnn = DBUtil.getConnection();
            if (cnn != null) {
                String SQL = "INSERT INTO OrderDetail values(?, ?, ?)";
                ps = cnn.prepareStatement(SQL);
                ps.setInt(1, orderID);
                ps.setInt(2, ProductID);
                ps.setInt(3, quantity);
                int result = ps.executeUpdate();
                if (result > 0) {
                    String sql2 = "Update Product set Quantity = Quantity-? where ProductID = ?";
                    ps = cnn.prepareStatement(sql2);
                    ps.setInt(1, quantity);
                    ps.setInt(2, ProductID);
                    result = ps.executeUpdate();
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public List<OrderDetailDTO> getOrderDetail(int OrderID) throws SQLException {
        List<OrderDetailDTO> list = new ArrayList<>();
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM OrderDetail WHERE OrderID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, OrderID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int proID = rs.getInt("ProductID");
                    int quantity = rs.getInt("quantity");
                    list.add(new OrderDetailDTO(OrderID, proID, quantity));
                }
            }

        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }
}
