/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "RepairManagement", catalog = "Project", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepairManagement.findAll", query = "SELECT r FROM RepairManagement r")
    , @NamedQuery(name = "RepairManagement.findByRepairID", query = "SELECT r FROM RepairManagement r WHERE r.repairID = :repairID")
    , @NamedQuery(name = "RepairManagement.findByRequiredContent", query = "SELECT r FROM RepairManagement r WHERE r.requiredContent = :requiredContent")
    , @NamedQuery(name = "RepairManagement.findByRepairContent", query = "SELECT r FROM RepairManagement r WHERE r.repairContent = :repairContent")
    , @NamedQuery(name = "RepairManagement.findByRequiredDate", query = "SELECT r FROM RepairManagement r WHERE r.requiredDate = :requiredDate")
    , @NamedQuery(name = "RepairManagement.findByStartDate", query = "SELECT r FROM RepairManagement r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "RepairManagement.findByEndDate", query = "SELECT r FROM RepairManagement r WHERE r.endDate = :endDate")})
public class RepairManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RepairID", nullable = false)
    private Integer repairID;
    @Column(name = "RequiredContent", length = 50)
    private String requiredContent;
    @Column(name = "RepairContent", length = 50)
    private String repairContent;
    @Column(name = "RequiredDate")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "DeviceID", referencedColumnName = "DeviceID")
    @ManyToOne
    private Device deviceID;
    @JoinColumn(name = "RequireUserID", referencedColumnName = "UserID")
    @ManyToOne
    private User requireUserID;
    @JoinColumn(name = "RepairUserID", referencedColumnName = "UserID")
    @ManyToOne
    private User repairUserID;

    public RepairManagement() {
    }

    public RepairManagement(Integer repairID) {
        this.repairID = repairID;
    }

    public Integer getRepairID() {
        return repairID;
    }

    public void setRepairID(Integer repairID) {
        this.repairID = repairID;
    }

    public String getRequiredContent() {
        return requiredContent;
    }

    public void setRequiredContent(String requiredContent) {
        this.requiredContent = requiredContent;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Device getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Device deviceID) {
        this.deviceID = deviceID;
    }

    public User getRequireUserID() {
        return requireUserID;
    }

    public void setRequireUserID(User requireUserID) {
        this.requireUserID = requireUserID;
    }

    public User getRepairUserID() {
        return repairUserID;
    }

    public void setRepairUserID(User repairUserID) {
        this.repairUserID = repairUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repairID != null ? repairID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepairManagement)) {
            return false;
        }
        RepairManagement other = (RepairManagement) object;
        if ((this.repairID == null && other.repairID != null) || (this.repairID != null && !this.repairID.equals(other.repairID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tuan.entities.RepairManagement[ repairID=" + repairID + " ]";
    }
    
}
