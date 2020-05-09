/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.errorObjs;

import java.io.Serializable;

/**
 *
 * @author macbookpro
 */
public class RoomErrorObj implements Serializable{
    private String roomIDError, roomNameError;

    public String getRoomIDError() {
        return roomIDError;
    }

    public void setRoomIDError(String roomIDError) {
        this.roomIDError = roomIDError;
    }

    public String getRoomNameError() {
        return roomNameError;
    }

    public void setRoomNameError(String roomNameError) {
        this.roomNameError = roomNameError;
    }
    
}
