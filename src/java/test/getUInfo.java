/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.UserDAO;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import dto.UserDTO;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tan
 */
public class getUInfo {

    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
        UserDTO dto = new UserDTO(); 
        dto = (UserDTO)dao.getUserInfo("aaa", "123");
        System.out.println(dto.getAccountName());
        System.out.println(dto.getAccountPassword());
        System.out.println(dto.getUserID());
        System.out.println(dto.getRole());
    }

}
