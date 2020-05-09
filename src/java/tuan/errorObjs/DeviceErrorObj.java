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
public class DeviceErrorObj implements Serializable{
    private String deviceIDError, deviceNameError, descriptionError,
            typeError,imageError,boughtDateError, periodOfGuaranteeError,statusError, roomIDError;

    public String getDeviceIDError() {
        return deviceIDError;
    }

    public void setDeviceIDError(String deviceIDError) {
        this.deviceIDError = deviceIDError;
    }

    public String getDeviceNameError() {
        return deviceNameError;
    }

    public void setDeviceNameError(String deviceNameError) {
        this.deviceNameError = deviceNameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getTypeError() {
        return typeError;
    }

    public void setTypeError(String typeError) {
        this.typeError = typeError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getBoughtDateError() {
        return boughtDateError;
    }

    public void setBoughtDateError(String boughtDateError) {
        this.boughtDateError = boughtDateError;
    }

    public String getPeriodOfGuaranteeError() {
        return periodOfGuaranteeError;
    }

    public void setPeriodOfGuaranteeError(String periodOfGuaranteeError) {
        this.periodOfGuaranteeError = periodOfGuaranteeError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getRoomIDError() {
        return roomIDError;
    }

    public void setRoomIDError(String roomIDError) {
        this.roomIDError = roomIDError;
    }
    
}
