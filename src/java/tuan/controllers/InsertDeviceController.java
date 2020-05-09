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
import tuan.blos.DeviceBLO;
import tuan.entities.Device;
import tuan.entities.Room;
import tuan.errorObjs.DeviceErrorObj;
import tuan.utils.ValidateInputObj;

/**
 *
 * @author macbookpro
 */
public class InsertDeviceController extends HttpServlet {
    public static final String ERROR = "error.jsp";
    public static final String SUCCESS = "adminDevice.jsp";
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
            String deviceID = request.getParameter("txtDeviceID");
            String deviceName = request.getParameter("txtDeviceName");
            String description = request.getParameter("txtDescription");
            String type = request.getParameter("txtType");
            String boughtDate = request.getParameter("txtBoughtDate");
            String roomID = request.getParameter("txtRoomID");
            String status = request.getParameter("txtStatus");
            String pog = request.getParameter("txtPOG");
            String image = request.getParameter("txtImage");
            ValidateInputObj validObj = new ValidateInputObj();
            DeviceErrorObj erroObj = new DeviceErrorObj();
            Device dto = new Device();
            DeviceBLO blo = new DeviceBLO();
            boolean valid = true;
            if(deviceID.length()==0){
                valid = false;
                erroObj.setDeviceIDError("ID cant be blank");
            }else if(blo.findByPrimaryKey(deviceID) != null){
                valid = false;
                erroObj.setDeviceIDError("ID is exist");
            }else
                dto.setDeviceID(deviceID);
            
            if(image.length()==0){
                valid = false;
                erroObj.setImageError("Image cant be blank");
            }else
                dto.setImage(image);
            if(deviceName.length()==0){
                valid = false;
                erroObj.setDeviceNameError("Name cant be blank");
            }
            else 
                dto.setDeviceName(deviceName);
            ///
            if(boughtDate.length() == 0){
                valid = false;
                erroObj.setBoughtDateError("Bought Date cant be blank");
            }
            else if(!validObj.checkFormatDate(boughtDate)){
                valid = false;
                erroObj.setBoughtDateError("Wrong input Bought Date");
            } else 
                dto.setBoughtDate(validObj.parseDate(boughtDate));
            
            ///
            if(status.length()==0){
                valid = false;
                erroObj.setStatusError("Status cant be blank");
            } else 
                dto.setStatus(status);
            ///
            if(type.length()==0){
                valid = false;
                erroObj.setTypeError("Type cant be blank");
            }else
                dto.setType(type);
            ///
            if(pog.length()==0){
                valid = false;
                erroObj.setPeriodOfGuaranteeError("PeriodOfGuarantee cant be blank");
            }else if(!validObj.checkNumber(pog)){
                valid = false;
                erroObj.setPeriodOfGuaranteeError("PeriodOfGuaranteeError is wrong");
            }
            else {
                dto.setPeriodOfGuarantee(Integer.parseInt(pog));
            }
            //
            if(roomID.length()==0){
                valid = false;
                erroObj.setRoomIDError("RoomID cant be bank");
            }
            else if(!validObj.checkExistRoom(roomID)){
                valid = false;
                erroObj.setRoomIDError(roomID+" is not exist");
            }
            else{
                dto.setRoomID(new Room(roomID));
            }
            if(description.length()==0){
                valid = false;
                erroObj.setDescriptionError("Description cant be blank");
            }else dto.setDescription(description);
           
            if(valid){
                if(blo.insert(dto)){
                    url = SUCCESS;
                }
                else{
                    request.setAttribute("ERROR", "Update failed");
                }
            }
            else{
                url = INVALID;
                request.setAttribute("INVALID", erroObj);
                request.setAttribute("DTO", dto);
            }
        } catch (Exception e) {
            log("ERROR at UpdateUserController: "+e.getMessage());
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
