/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.UserDAO;
import dto.CartDTO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tan
 */
public class OrderServlet extends HttpServlet {

    public static final String Success = "UserOrder.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = Success;
        try {

            HttpSession session = request.getSession();
            UserDAO udao = new UserDAO();
            int id = Integer.parseInt(session.getAttribute("USERID").toString());
            UserDTO userdto = (UserDTO) udao.getUserInfo(id);
            OrderDAO order = new OrderDAO();
            Date date = new Date(System.currentTimeMillis());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss ");
            OrderDetailDAO orderDetail = new OrderDetailDAO();
            int userID = userdto.getUserID();
            List<CartDTO> cart = (List<CartDTO>) session.getAttribute("CART");
            int orderID = order.createOrder(userID, format.format(date));
            if (orderID != -1) {
                for (CartDTO item : cart) {
                    orderDetail.CreateOrderDetail(orderID, item.getProduct().getId(), item.getQuantity());
                }
            }

        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(URL).forward(request, response);
        }

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
