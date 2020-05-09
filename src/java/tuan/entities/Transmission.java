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
@Table(name = "Transmission", catalog = "Project", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transmission.findAll", query = "SELECT t FROM Transmission t")
    , @NamedQuery(name = "Transmission.findByTranID", query = "SELECT t FROM Transmission t WHERE t.tranID = :tranID")
    , @NamedQuery(name = "Transmission.findByTime", query = "SELECT t FROM Transmission t WHERE t.time = :time")
    , @NamedQuery(name = "Transmission.findByReason", query = "SELECT t FROM Transmission t WHERE t.reason = :reason")})
public class Transmission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TranID", nullable = false)
    private Integer tranID;
    @Column(name = "Time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Column(name = "Reason", length = 100)
    private String reason;
    @JoinColumn(name = "DeviceID", referencedColumnName = "DeviceID")
    @ManyToOne
    private Device deviceID;
    @JoinColumn(name = "FromRoom", referencedColumnName = "RoomID")
    @ManyToOne
    private Room fromRoom;
    @JoinColumn(name = "ToRoom", referencedColumnName = "RoomID")
    @ManyToOne
    private Room toRoom;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;

    public Transmission() {
    }

    public Transmission(Integer tranID) {
        this.tranID = tranID;
    }

    public Integer getTranID() {
        return tranID;
    }

    public void setTranID(Integer tranID) {
        this.tranID = tranID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Device getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Device deviceID) {
        this.deviceID = deviceID;
    }

    public Room getFromRoom() {
        return fromRoom;
    }

    public void setFromRoom(Room fromRoom) {
        this.fromRoom = fromRoom;
    }

    public Room getToRoom() {
        return toRoom;
    }

    public void setToRoom(Room toRoom) {
        this.toRoom = toRoom;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tranID != null ? tranID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transmission)) {
            return false;
        }
        Transmission other = (Transmission) object;
        if ((this.tranID == null && other.tranID != null) || (this.tranID != null && !this.tranID.equals(other.tranID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tuan.entities.Transmission[ tranID=" + tranID + " ]";
    }
    
}
