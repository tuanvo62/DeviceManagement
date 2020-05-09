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
import tuan.blos.UserBLO;
import static tuan.controllers.UpdateUserController.ERROR;
import static tuan.controllers.UpdateUserController.INVALID;
import static tuan.controllers.UpdateUserController.SUCCESS;
import tuan.entities.Room;
import tuan.entities.User;
import tuan.errorObjs.UserErrorObj;
import tuan.utils.ValidateInputObj;

/**
 *
 * @author macbookpro
 */
public class InsertUserController extends HttpServlet {
    public static final String ERROR = "error.jsp";
    public static final String SUCCESS = "admin.jsp";
    public static final String INVALID = "insert.jsp";

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
            String userID = request.getParameter("txtUserID");
            String userName = request.getParameter("txtFullName");
            String yob = request.getParameter("txtYob");
            String address = request.getParameter("txtAddress");
            String email = request.getParameter("txtEmail");
            String roomID = request.getParameter("txtRoom");
            String role = request.getParameter("txtRole");
            ValidateInputObj validObj = new ValidateInputObj();
            UserErrorObj erroObj = new UserErrorObj();
            User dto = new User();
            UserBLO blo = new UserBLO();
            boolean valid = true;
            if(userID.length()==0){
                valid = false;
                erroObj.setUserIdError("ID cant be blank");
            }
            else if(blo.findByPrimaryKey(userID)!=null){
                valid = false;
                erroObj.setUserIdError("ID is existed");
            }
            else
                dto.setUserID(userID);
            if(userName.length()==0){
                valid = false;
                erroObj.setUserNameError("Name cant be blank");
            }
            else 
                dto.setFullName(userName);
            if(yob.length() == 0){
                valid = false;
                erroObj.setYobError("Year of birth cant be blank");
            }
            else if(!validObj.checkDate(yob)){
                valid = false;
                erroObj.setYobError("Wrong input Year of Birth");
            } else 
                dto.setYob(validObj.parseDate(yob));
            if(address.length()==0){
                valid = false;
                erroObj.setAddressError("Address cant be blank");
            } else 
                dto.setAddress(address);
            if(email.length()==0){
                valid = false;
                erroObj.setEmailError("Email cant be blank");
            }
            else if(!validObj.checkEmail(email)){
                valid = false;
                erroObj.setEmailError("Wrong input email");
            }else
                dto.setEmail(email);
            if(roomID.length()==0){
                valid = false;
                erroObj.setRoomError("Room cant be blank");
            }else if(!validObj.checkExistRoom(roomID)){
                valid = false;
                erroObj.setRoomError("Room is not exist");
            }
            else {
                dto.setRoomID(new Room(roomID));
            }
                
            
            if(role.length()==0 ){
                valid = false;
                erroObj.setRoleError("Role cant be blank");
            } else if((role.compareToIgnoreCase("admin")!=0) && (role.compareToIgnoreCase("user")!=0) && (role.compareToIgnoreCase("repairer")!=0)){
                valid = false;
                erroObj.setRoleError("Invalid role input");
            }
            else dto.setRole(role.toLowerCase());
            if(valid){
                if(blo.insert(dto)){
                    url = SUCCESS;
                }
                else{
                    request.setAttribute("ERROR", "Insert failed");
                }
            }
            else{
                url = INVALID;
                request.setAttribute("INVALID", erroObj);
                request.setAttribute("DTO", dto);
                
            }
        } catch (Exception e) {
            log("ERROR at InsertUserController: "+e.getMessage());
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
