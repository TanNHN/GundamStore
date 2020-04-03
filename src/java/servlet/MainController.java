/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tan
 */
public class MainController extends HttpServlet {

    public static final String login = "LoginServlet";
    public static final String error = "error.jsp";
    public static final String search = "SearchServlet";
    public static final String register = "register.jsp";
    public static final String afterRegister = "RegisterServlet";
    public static final String UserInfo = "UserInfoServlet";
    public static final String LogOut = "LogOutServlet";
    public static final String BackToPage = "GoToMainPage";
    public static final String UpdateUser = "UpdateUserServlet";
    public static final String DeleteUser = "DeleteUserServlet";
    public static final String AddToCart = "CartServlet";
    public static final String Order = "OrderServlet";
    public static final String ViewOrder = "ViewUserOrderServlet";
    public static final String Edit = "ProductEditServlet";
    public static final String AddNewProduct = "AddNewProduct.jsp";
    public static final String AddProduct = "AddProductServlet";
    public static final String DeleteProduct = "DeleteProductServlet";
    public static final String Deliver = "DeliverServlet";
    public static final String SearchItem = "SearchItemServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = login;
        try {

            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                URL = login;
            } else if (action.equals("Search")) {
                URL = search;
            } else if (action.equals("Register")) {
                URL = register;
            } else if (action.equals("Sign up")) {
                URL = afterRegister;
            } else if (action.equals("UserProfile")) {
                URL = UserInfo;
            } else if (action.equals("LogOut")) {
                URL = LogOut;
            } else if (action.equals("BackToPage")) {
                URL = BackToPage;
            } else if (action.equals("Update")) {
                URL = UpdateUser;
            } else if (action.equals("Delete")) {
                URL = DeleteUser;
            } else if (action.equals("AddToCart")) {
                URL = AddToCart;
            } else if (action.equals("Order")) {
                URL = Order;
            } else if (action.equals("ViewOrder")) {
                URL = ViewOrder;
            } else if (action.equals("Edit")) {
                URL = Edit;
            } else if (action.equals("AddProduct")) {
                URL = AddProduct;
            } else if (action.equals("AddNewProduct")) {
                URL = AddNewProduct;
            } else if (action.equals("DeleteProduct")) {
                URL = DeleteProduct;
            } else if (action.equals("Deliver")) {
                URL = Deliver;
            }
             else if (action.equals("SearchItem")) {
                URL = SearchItem;
            }else {
                URL = error;
            }
        } catch (Exception e) {
        }
        request.getRequestDispatcher(URL).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
