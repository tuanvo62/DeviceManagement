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
import javax.persistence.Query;
import tuan.entities.Room;
import tuan.entities.User;
import tuan.utils.ValidateInputObj;

/**
 *
 * @author macbookpro
 */
public class UserBLO implements Serializable{

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
    public String checkLogin(String userID, String password){
        String role  = "failed";
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query q = em.createNamedQuery("User.findRole");
            q.setParameter("userID", userID);
            q.setParameter("userPassword", password);
            role =(String) q.getSingleResult();
        } catch(Exception e) {
            return role;
        }
        return role;
    }
    public boolean insert(User dto){
        EntityManager em = emf.createEntityManager();
        boolean check = false;
        User user = em.find(User.class, dto.getUserID());
        if(user == null){
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }

    public List<User> findByLikeName(String name) {
        List<User> result = null;
        EntityManager em = emf.createEntityManager();
        result = em.createNamedQuery("User.findByLikeName").setParameter("fullName", "%"+name+"%").getResultList();
        return result;
    }
    public User findByPrimaryKey(String id){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        return user;
    }
    public boolean delete(String id){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        if(user!=null){
            try{
                em.getTransaction().begin();
                em.remove(user);
                em.getTransaction().commit();
            }
            catch(Exception e){
                return check;
            }
            check = true;
        }
        return check;
        
    }
    public boolean update(User dto){
        boolean  check = false;
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, dto.getUserID());
        if(user !=null ){
            user.setFullName(dto.getFullName());
            user.setAddress(dto.getAddress());
            user.setEmail(dto.getEmail());
            user.setRoomID(em.find(Room.class, dto.getRoomID().getRoomID()));
            user.setRole(dto.getRole());
            user.setYob(dto.getYob());
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            check = true;
        }
        
        return check;
    }
    public boolean addUserToRoom(String userID, String roomID){
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        Room r = em.find(Room.class, roomID);
        User u = em.find(User.class, userID);
        if(r != null && u != null){
            u.setRoomID(r);
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            check = true;
        }
        return check;
    }
    public static void main(String[] args) {
        UserBLO u = new UserBLO();
        tuan.utils.ValidateInputObj v = new ValidateInputObj();
        EntityManager em = u.emf.createEntityManager();
        List<User> r = u.findByLikeName("n");
        User us = new User("I006", "Vo Hoang Tuan", v.parseDate("01-06-1999"), "Long An", "Debronees2@gmail.com", "user", new Room("P007"));
        System.out.println(r.size());
        
    }
}
