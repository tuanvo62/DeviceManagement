/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macbookpro
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGOUT = "LogoutController";
    private static final String LOGIN = "LoginController";
    private static final String INSERTUSER = "InsertUserController";
    private static final String UPDATEUSER = "UpdateUserController";
    private static final String DELETEUSER = "DeleteUserController";
    private static final String EDITUSER = "EditUserController";
    private static final String SEARCHUSER = "SearchUserController";
    
    private static final String INSERTROOM = "InsertRoomController";
    private static final String UPDATEROOM = "UpdateRoomController";
    private static final String DELETEROOM = "DeleteRoomController";
    private static final String EDITROOM = "EditRoomController";
    private static final String SEARCHROOM = "SearchRoomController";
    
    private static final String INSERTDEVICE = "InsertDeviceController";
    private static final String UPDATEDEVICE = "UpdateDeviceController";
    private static final String DELETEDEVICE = "DeleteDeviceController";
    private static final String EDITDEVICE= "EditDeviceController";
    private static final String SEARCHDEVICE = "SearchDeviceController";

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
        String action = request.getParameter("action");
        String url = ERROR;
        try {
            switch (action) {
                case "Logout":
                    url = LOGOUT;
                    break;
                case "Login":
                    url = LOGIN;
                    break;
                case "InsertUser":
                    url = INSERTUSER;
                    break;
                case "UpdateUser":
                    url = UPDATEUSER;
                    break;
                case "DeleteUser":
                    url = DELETEUSER;
                    break;
                case "EditUser":
                    url = EDITUSER;
                    break;
                case "SearchUser":
                    url = SEARCHUSER;
                    break;
                case "InsertRoom":
                    url = INSERTROOM;
                    break;
                case "UpdateRoom":
                    url = UPDATEROOM;
                    break;
                case "DeleteRoom":
                    url = DELETEROOM;
                    break;
                case "EditRoom":
                    url = EDITROOM;
                    break;
                case "SearchRoom":
                    url = SEARCHROOM;
                    break;
                case "InsertDevice":
                    url = INSERTDEVICE;
                    break;
                case "UpdateDevice":
                    url = UPDATEDEVICE;
                    break;
                case "DeleteDevice":
                    url = DELETEDEVICE;
                    break;
                case "EditDevice":
                    url = EDITDEVICE;
                    break;
                case "SearchDevice":
                    url = SEARCHDEVICE;
                    break;
                default:
                    request.setAttribute("ERROR", url);
                    break;
            }
        } catch (Exception e) {
            log("ERROR at MainController: "+e.getMessage());
        }
        finally{
            request.getRequestDispatcher(url).forward(request, response);
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
