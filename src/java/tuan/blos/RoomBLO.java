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
import tuan.entities.Room;

/**
 *
 * @author macbookpro
 */
public class RoomBLO implements Serializable{

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
    public boolean delete(String roomID){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Room room = em.find(Room.class, roomID);
        if(room!=null){
            em.getTransaction().begin();
            em.remove(room);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
    public boolean update(Room room){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Room r = em.find(Room.class, room.getRoomID());
        if(r!=null){
            r.setRoomName(room.getRoomName());
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
    public List<Room> findByLikeName(String name){
        List<Room> result = null;
        EntityManager em = emf.createEntityManager();
        result = em.createNamedQuery("Room.findByLikeName").setParameter("roomName", "%"+name+"%").getResultList();
        return result;
    }
    public Room findByPrimaryKey(String roomID){
        Room result = null;
        EntityManager em = emf.createEntityManager();
        result = em.find(Room.class, roomID);
        return result;
    }
    public boolean insert(Room dto){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Room room = em.find(Room.class, dto.getRoomID());
        if(room==null){
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
    public boolean checkExistRoom(String roomID){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        check = em.find(Room.class, roomID) != null;
        return check;
    }
    public static void main(String[] args) {
        RoomBLO r = new RoomBLO();
        System.out.println(r.checkExistRoom("P007"));
    }
}
