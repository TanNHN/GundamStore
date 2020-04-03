/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBUtil;
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
public class ProductDAO {

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

    public List<ProductDTO> getAllProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM Product";
                ps = cnn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String pName = rs.getString("ProductName");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getFloat("Price");
                    String photo = rs.getString("Photo");
                    list.add(new ProductDTO(id, pName, price, photo, quantity));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }

    public ProductDTO getProductDetail(int ProductID) throws SQLException {
        ProductDTO product = null;
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String SQL = "SELECT * FROM Product WHERE ProductID = ?";
                ps = cnn.prepareStatement(SQL);
                ps.setInt(1, ProductID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String pName = rs.getString("ProductName");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getFloat("Price");
                    String photo = rs.getString("Photo");
                    product = new ProductDTO(id, pName, price, photo, quantity);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return product;
    }

    public void insertProduct(int pID, String pName, int quantity, float price, String photo) throws SQLException {
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "INSERT INTO Product values (? ,? ,? ,? ,?)";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, pID);
                ps.setString(2, pName);
                ps.setInt(3, quantity);
                ps.setFloat(4, price);
                ps.setString(5, photo);
                rs = ps.executeQuery();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public boolean updateProduct(int pID, String pName, int quantity, float price, String photo) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                String SQL = "UPDATE Product SET ProductName = ?, Quantity = ?, Price = ?, Photo = ? WHERE ProductID = ?";
                ps = cnn.prepareStatement(SQL);
                ps.setString(1, pName);
                ps.setInt(2, quantity);
                ps.setFloat(3, price);
                ps.setString(4, photo);
                ps.setInt(5, pID);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteProduct(int proID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                String sql = "DELETE FROM Product WHERE ProductID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, proID);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean DeliverProduct(int orderID) throws ClassNotFoundException, SQLException {
        cnn = DBUtil.getConnection();
        boolean check = false;
        try {
            if (cnn != null) {
                String sql = "delete from [dbo].[OrderDetail] where [OrderID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, orderID);
                check = ps.executeUpdate() > 0;
                if (check) {
                    String sql2 = "delete from [dbo].[Order] where [OrderID] = ?";
                    ps = cnn.prepareStatement(sql2);
                    ps.setInt(1, orderID);
                    check = ps.executeUpdate() > 0;
                }

            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public ArrayList searhProduct(String proName) throws ClassNotFoundException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM Product where [ProductName] LIKE ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, "%"+proName+"%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("ProductName");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getFloat("Price");
                    String photo = rs.getString("Photo");
                    list.add(new ProductDTO(id, name, price, photo, quantity));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
