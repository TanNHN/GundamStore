/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.CartDTO;
import dto.ProductDTO;
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
public class CartDAO {

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

    public ProductDTO getProductInfo(int ProductID) throws SQLException {
        ProductDTO product = null;
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
//                for (int i = 0; i <= list.size(); i++) {
//                    if (ProductID == list.get(i).getId()) {
//                        list.get(i).setQuantity(list.get(i).getQuantity() + 1);
//                    } else {
                String sql = "SELECT * FROM Product WHERE ProductID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, ProductID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("ProductName");
                    float price = rs.getFloat("Price");
                    String photo = rs.getString("Photo");
                    int quantity = rs.getInt("Quantity");
                    product = new ProductDTO(id, name, price, photo, quantity);
//                        }
//                    }
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return product;
    }

    public int checkExist(int id, List<CartDTO> product) {
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
