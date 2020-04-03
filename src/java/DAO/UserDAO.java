/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBUtil;
import dto.UserDTO;
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
public class UserDAO {

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

    public UserDTO checkLogin(String AccountName, String Password) throws SQLException {
        UserDTO user = null;
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM Account WHERE AccountName = ? AND Password = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, AccountName);
                ps.setString(2, Password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("UserName");
                    String role = rs.getString("Role");
                    user = new UserDTO(id, AccountName, name, Password, role);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return user;
    }

    public List<UserDTO> getUserList(String AccountName) throws SQLException {
        List<UserDTO> list = new ArrayList();
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM Account WHERE AccountName LIKE ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, "%" + AccountName + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int UserID = rs.getInt("UserID");
                    String UserName = rs.getString("UserName");
                    String Accountname = rs.getString("AccountName");
                    String Password = rs.getString("Password");
                    String Role = rs.getString("Role");
                    list.add(new dto.UserDTO(UserID, Accountname, UserName, Password, Role));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }

    public void deleteUser(int ID) throws SQLException {
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "DELETE FROM Account WHERE UserID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, ID);
                rs = ps.executeQuery();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public void updateUser(int UserID, String name, String password, String Role) throws SQLException {
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String sql = "Update Account SET UserName = ?, Password = ?, Role = ? WHERE UserID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setString(3, Role);
                ps.setInt(4, UserID);
                rs = ps.executeQuery();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public void inserUser(String AccountName, String UserName, String Password, String Role) throws SQLException {
        try {
            cnn = DB.DBUtil.getConnection();
            if (cnn != null) {
                String SQL = "INSERT INTO Account(AccountName, UserName, Password, Role) values(?,?,?,?)";
                ps = cnn.prepareStatement(SQL);
                ps.setString(1, AccountName);
                ps.setString(2, UserName);
                ps.setString(3, Password);
                ps.setString(4, Role);
                rs = ps.executeQuery();
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }

    public UserDTO getUserInfo(String accountName, String pass) throws SQLException {
        UserDTO dto = null;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM Account WHERE AccountName = ? And Password = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, accountName);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int UserID = rs.getInt("UserID");
                    String UserName = rs.getString("UserName");
                    String Accountname = rs.getString("AccountName");
                    String Password = rs.getString("Password");
                    String Role = rs.getString("Role");
                    dto = new UserDTO(UserID, Accountname, UserName, Password, Role);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return dto;
    }

    public UserDTO getUserInfo(int userID) throws SQLException {
        UserDTO user = null;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                String sql = "SELECT * From  Account WHERE userID = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, userID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int UserID = rs.getInt("UserID");
                    String UserName = rs.getString("UserName");
                    String Accountname = rs.getString("AccountName");
                    String Password = rs.getString("Password");
                    String Role = rs.getString("Role");
                    user = new UserDTO(UserID, Accountname, UserName, Password, Role);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return user;
    }

}
