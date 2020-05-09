/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.blos;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tuan.entities.Device;
import tuan.entities.Room;
import tuan.utils.ValidateInputObj;

/**
 *
 * @author macbookpro
 */
public class DeviceBLO implements Serializable{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("VoHoangTuan_SE130463_ProjectPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public boolean insert(Device dto){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        if(em.find(Device.class, dto.getDeviceID())==null){
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();
            check =  true;
        }
        return check;
    }
    public List<Device> findByLikeName(String name){
        List<Device> result = null;
        EntityManager em = emf.createEntityManager();
        result = em.createNamedQuery("Device.findByLikeName").setParameter("deviceName", "%"+name+"%").getResultList();
        return result;
    }
    public boolean delete(String id){
        boolean  check = false;
        EntityManager em = emf.createEntityManager();
        Device dto = em.find(Device.class, id);
        if(dto != null){
            em.getTransaction().begin();
            em.remove(dto);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
    public boolean update(Device dto){
        boolean  check = false;
        EntityManager em = emf.createEntityManager();
        Device device = em.find(Device.class, dto.getDeviceID());
        if(device!=null){
            em.getTransaction().begin();
            em.merge(dto);
            em.getTransaction().commit();
            check = true;
        }
        
        return check;
    }
    public boolean addToRoom(String deviceID, String roomID){
        EntityManager em = emf.createEntityManager();
        boolean check = false;
        Device device = em.find(Device.class, deviceID);
        Room room = em.find(Room.class, roomID);
        if(device!= null && room!= null){
            device.setRoomID(room);
            em.getTransaction().begin();
            em.merge(device);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
    public Device findByPrimaryKey(String id){
        EntityManager em = emf.createEntityManager();
        Device dto  = em.find(Device.class, id);
        return dto;
    }
    public static void main(String[] args) {
        DeviceBLO blo = new DeviceBLO();
        tuan.utils.ValidateInputObj v= new ValidateInputObj();
        List<Device> result = blo.findByLikeName("a");
        for (Device device : result) {
            System.out.println(device.getImage());
        }
       // System.out.println(blo.insert(new Device("DV008", "Ghe ngoi", "ghe ngoi", "ghe", "image/", v.parseDate("8-3-2020"), 1, "good", new Room("P005"))));
        System.out.println(blo.delete("DV008"));
    }
    
}
