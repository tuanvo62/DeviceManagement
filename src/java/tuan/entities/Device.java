/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "Device", catalog = "Project", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
    , @NamedQuery(name = "Device.findByLikeName", query = "SELECT d FROM Device d WHERE d.deviceName Like :deviceName")
    , @NamedQuery(name = "Device.findByDeviceID", query = "SELECT d FROM Device d WHERE d.deviceID = :deviceID")
    , @NamedQuery(name = "Device.findByDeviceName", query = "SELECT d FROM Device d WHERE d.deviceName = :deviceName")
    , @NamedQuery(name = "Device.findByDescription", query = "SELECT d FROM Device d WHERE d.description = :description")
    , @NamedQuery(name = "Device.findByType", query = "SELECT d FROM Device d WHERE d.type = :type")
    , @NamedQuery(name = "Device.findByImage", query = "SELECT d FROM Device d WHERE d.image = :image")
    , @NamedQuery(name = "Device.findByBoughtDate", query = "SELECT d FROM Device d WHERE d.boughtDate = :boughtDate")
    , @NamedQuery(name = "Device.findByPeriodOfGuarantee", query = "SELECT d FROM Device d WHERE d.periodOfGuarantee = :periodOfGuarantee")
    , @NamedQuery(name = "Device.findByStatus", query = "SELECT d FROM Device d WHERE d.status = :status")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DeviceID", nullable = false, length = 10)
    private String deviceID;
    @Column(name = "DeviceName", length = 50)
    private String deviceName;
    @Column(name = "Description", length = 50)
    private String description;
    @Column(name = "Type", length = 30)
    private String type;
    @Column(name = "Image", length = 50)
    private String image;
    @Column(name = "BoughtDate")
    @Temporal(TemporalType.DATE)
    private Date boughtDate;
    @Column(name = "PeriodOfGuarantee")
    private Integer periodOfGuarantee;
    @Column(name = "Status", length = 50)
    private String status;
    @OneToMany(mappedBy = "deviceID")
    private List<RepairManagement> repairManagementList;
    @JoinColumn(name = "RoomID", referencedColumnName = "RoomID")
    @ManyToOne
    private Room roomID;
    @OneToMany(mappedBy = "deviceID")
    private List<Transmission> transmissionList;

    public Device() {
    }

    public Device(String deviceID, String deviceName, String description, String type, String image, Date boughtDate, Integer periodOfGuarantee, String status, Room roomID) {
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.description = description;
        this.type = type;
        this.image = image;
        this.boughtDate = boughtDate;
        this.periodOfGuarantee = periodOfGuarantee;
        this.status = status;
        this.roomID = roomID;
    }

    public Device(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }

    public Integer getPeriodOfGuarantee() {
        return periodOfGuarantee;
    }

    public void setPeriodOfGuarantee(Integer periodOfGuarantee) {
        this.periodOfGuarantee = periodOfGuarantee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<RepairManagement> getRepairManagementList() {
        return repairManagementList;
    }

    public void setRepairManagementList(List<RepairManagement> repairManagementList) {
        this.repairManagementList = repairManagementList;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    @XmlTransient
    public List<Transmission> getTransmissionList() {
        return transmissionList;
    }

    public void setTransmissionList(List<Transmission> transmissionList) {
        this.transmissionList = transmissionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceID != null ? deviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.deviceID == null && other.deviceID != null) || (this.deviceID != null && !this.deviceID.equals(other.deviceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tuan.entities.Device[ deviceID=" + deviceID + " ]";
    }
    
}
