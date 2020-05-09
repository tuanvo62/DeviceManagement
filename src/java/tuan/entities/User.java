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
@Table(name = "UserTB", catalog = "Project", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findRole", query = "SELECT u.role FROM User u WHERE u.userID = :userID and u.password = :userPassword")
    , @NamedQuery(name = "User.findByLikeName", query = "SELECT u FROM User u WHERE u.fullName Like :fullName")
    , @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID")
    , @NamedQuery(name = "User.findByFullName", query = "SELECT u FROM User u WHERE u.fullName = :fullName")
    , @NamedQuery(name = "User.findByYob", query = "SELECT u FROM User u WHERE u.yob = :yob")
    , @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserID", nullable = false, length = 10)
    private String userID;
    @Column(name = "FullName", length = 20)
    private String fullName;
    @Column(name = "YOB")
    @Temporal(TemporalType.DATE)
    private Date yob;
    @Column(name = "Address", length = 50)
    private String address;
    @Column(name = "Email", length = 20)
    private String email;
    @Column(name = "Role", length = 10)
    private String role;
    @Column(name = "Password", length = 20)
    private String password;
    @OneToMany(mappedBy = "requireUserID")
    private List<RepairManagement> repairManagementList;
    @OneToMany(mappedBy = "repairUserID")
    private List<RepairManagement> repairManagementList1;
    @OneToMany(mappedBy = "userID")
    private List<Transmission> transmissionList;
    @JoinColumn(name = "RoomID", referencedColumnName = "RoomID")
    @ManyToOne
    private Room roomID;

    public User() {
    }

    public User(String userID, String fullName, Date yob, String address, String email, String role, Room roomID) {
        this.userID = userID;
        this.fullName = fullName;
        this.yob = yob;
        this.address = address;
        this.email = email;
        this.role = role;
        this.roomID = roomID;
    }

    public User(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getYob() {
        return yob;
    }

    public void setYob(Date yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<RepairManagement> getRepairManagementList() {
        return repairManagementList;
    }

    public void setRepairManagementList(List<RepairManagement> repairManagementList) {
        this.repairManagementList = repairManagementList;
    }

    @XmlTransient
    public List<RepairManagement> getRepairManagementList1() {
        return repairManagementList1;
    }

    public void setRepairManagementList1(List<RepairManagement> repairManagementList1) {
        this.repairManagementList1 = repairManagementList1;
    }

    @XmlTransient
    public List<Transmission> getTransmissionList() {
        return transmissionList;
    }

    public void setTransmissionList(List<Transmission> transmissionList) {
        this.transmissionList = transmissionList;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tuan.entities.User[ userID=" + userID + " ]";
    }
    
}
