/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Tan
 */
public class UserDTO {

    private int UserID;
    private String AccountName;
    private String UserName;
    private String AccountPassword;
    private String Role;

    public UserDTO() {
    }

    
    
    public UserDTO(int UserID, String AccountName, String UserName, String AccountPassword, String Role) {
        this.UserID = UserID;
        this.AccountName = AccountName;
        this.UserName = UserName;
        this.AccountPassword = AccountPassword;
        this.Role = Role;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getAccountPassword() {
        return AccountPassword;
    }

    public void setAccountPassword(String AccountPassword) {
        this.AccountPassword = AccountPassword;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
}
