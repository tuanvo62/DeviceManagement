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
import javax.servlet.http.HttpSession;
import tuan.blos.UserBLO;
import tuan.errorObjs.UserErrorObj;

/**
 *
 * @author macbookpro
 */
public class LoginController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String USER = "user.jsp";
    private static final String INVALID = "login.jsp";
    private static final String REPAIRER = "repairer.jsp";

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
        String url = ERROR;
        try {
            String userId = request.getParameter("txtUserId");
            String password = request.getParameter("txtPassword");

            UserErrorObj errorObj = new UserErrorObj();
            boolean valid = true;
            
            if(userId.length() == 0){
                errorObj.setUserIdError("UserId cant be blank");
                valid = false;
            }
            if(password.length()==0){
                errorObj.setPasswordError("Password cant be blank");
                valid = false;
            }
            if(valid){
                UserBLO blo = new UserBLO();
                String role = blo.checkLogin(userId, password);
                if(role.equals("failed")){
                    request.setAttribute("ERROR", "Your Id or Password is invalid");
                }else {
                    HttpSession session = request.getSession();
                    session.setAttribute("USERID", userId);
                    session.setAttribute("USERROLE", role);
                    if(role.equals("admin")){
                        url = ADMIN;
                    }
                    else if(role.equals("user")){
                        url = USER;
                    }
                    else if(role.equals("repairer")){
                        url = REPAIRER;
                    }
                    else{
                        request.setAttribute("ERROR", "Your Role is invalid");
                    }
                }
                
            }
            else{
                request.setAttribute("INVALID", errorObj);
                url = INVALID;
            }
        } catch (Exception e) {
            log("ERROR at LoginController: "+e.getMessage());
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
