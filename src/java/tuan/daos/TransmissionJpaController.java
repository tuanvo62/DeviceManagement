/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.daos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tuan.daos.exceptions.NonexistentEntityException;
import tuan.daos.exceptions.PreexistingEntityException;
import tuan.entities.Device;
import tuan.entities.Room;
import tuan.entities.Transmission;
import tuan.entities.User;

/**
 *
 * @author macbookpro
 */
public class TransmissionJpaController implements Serializable {

    public TransmissionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transmission transmission) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Device deviceID = transmission.getDeviceID();
            if (deviceID != null) {
                deviceID = em.getReference(deviceID.getClass(), deviceID.getDeviceID());
                transmission.setDeviceID(deviceID);
            }
            Room fromRoom = transmission.getFromRoom();
            if (fromRoom != null) {
                fromRoom = em.getReference(fromRoom.getClass(), fromRoom.getRoomID());
                transmission.setFromRoom(fromRoom);
            }
            Room toRoom = transmission.getToRoom();
            if (toRoom != null) {
                toRoom = em.getReference(toRoom.getClass(), toRoom.getRoomID());
                transmission.setToRoom(toRoom);
            }
            User userID = transmission.getUserID();
            if (userID != null) {
                userID = em.getReference(userID.getClass(), userID.getUserID());
                transmission.setUserID(userID);
            }
            em.persist(transmission);
            if (deviceID != null) {
                deviceID.getTransmissionList().add(transmission);
                deviceID = em.merge(deviceID);
            }
            if (fromRoom != null) {
                fromRoom.getTransmissionList().add(transmission);
                fromRoom = em.merge(fromRoom);
            }
            if (toRoom != null) {
                toRoom.getTransmissionList().add(transmission);
                toRoom = em.merge(toRoom);
            }
            if (userID != null) {
                userID.getTransmissionList().add(transmission);
                userID = em.merge(userID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTransmission(transmission.getTranID()) != null) {
                throw new PreexistingEntityException("Transmission " + transmission + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transmission transmission) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transmission persistentTransmission = em.find(Transmission.class, transmission.getTranID());
            Device deviceIDOld = persistentTransmission.getDeviceID();
            Device deviceIDNew = transmission.getDeviceID();
            Room fromRoomOld = persistentTransmission.getFromRoom();
            Room fromRoomNew = transmission.getFromRoom();
            Room toRoomOld = persistentTransmission.getToRoom();
            Room toRoomNew = transmission.getToRoom();
            User userIDOld = persistentTransmission.getUserID();
            User userIDNew = transmission.getUserID();
            if (deviceIDNew != null) {
                deviceIDNew = em.getReference(deviceIDNew.getClass(), deviceIDNew.getDeviceID());
                transmission.setDeviceID(deviceIDNew);
            }
            if (fromRoomNew != null) {
                fromRoomNew = em.getReference(fromRoomNew.getClass(), fromRoomNew.getRoomID());
                transmission.setFromRoom(fromRoomNew);
            }
            if (toRoomNew != null) {
                toRoomNew = em.getReference(toRoomNew.getClass(), toRoomNew.getRoomID());
                transmission.setToRoom(toRoomNew);
            }
            if (userIDNew != null) {
                userIDNew = em.getReference(userIDNew.getClass(), userIDNew.getUserID());
                transmission.setUserID(userIDNew);
            }
            transmission = em.merge(transmission);
            if (deviceIDOld != null && !deviceIDOld.equals(deviceIDNew)) {
                deviceIDOld.getTransmissionList().remove(transmission);
                deviceIDOld = em.merge(deviceIDOld);
            }
            if (deviceIDNew != null && !deviceIDNew.equals(deviceIDOld)) {
                deviceIDNew.getTransmissionList().add(transmission);
                deviceIDNew = em.merge(deviceIDNew);
            }
            if (fromRoomOld != null && !fromRoomOld.equals(fromRoomNew)) {
                fromRoomOld.getTransmissionList().remove(transmission);
                fromRoomOld = em.merge(fromRoomOld);
            }
            if (fromRoomNew != null && !fromRoomNew.equals(fromRoomOld)) {
                fromRoomNew.getTransmissionList().add(transmission);
                fromRoomNew = em.merge(fromRoomNew);
            }
            if (toRoomOld != null && !toRoomOld.equals(toRoomNew)) {
                toRoomOld.getTransmissionList().remove(transmission);
                toRoomOld = em.merge(toRoomOld);
            }
            if (toRoomNew != null && !toRoomNew.equals(toRoomOld)) {
                toRoomNew.getTransmissionList().add(transmission);
                toRoomNew = em.merge(toRoomNew);
            }
            if (userIDOld != null && !userIDOld.equals(userIDNew)) {
                userIDOld.getTransmissionList().remove(transmission);
                userIDOld = em.merge(userIDOld);
            }
            if (userIDNew != null && !userIDNew.equals(userIDOld)) {
                userIDNew.getTransmissionList().add(transmission);
                userIDNew = em.merge(userIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transmission.getTranID();
                if (findTransmission(id) == null) {
                    throw new NonexistentEntityException("The transmission with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transmission transmission;
            try {
                transmission = em.getReference(Transmission.class, id);
                transmission.getTranID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transmission with id " + id + " no longer exists.", enfe);
            }
            Device deviceID = transmission.getDeviceID();
            if (deviceID != null) {
                deviceID.getTransmissionList().remove(transmission);
                deviceID = em.merge(deviceID);
            }
            Room fromRoom = transmission.getFromRoom();
            if (fromRoom != null) {
                fromRoom.getTransmissionList().remove(transmission);
                fromRoom = em.merge(fromRoom);
            }
            Room toRoom = transmission.getToRoom();
            if (toRoom != null) {
                toRoom.getTransmissionList().remove(transmission);
                toRoom = em.merge(toRoom);
            }
            User userID = transmission.getUserID();
            if (userID != null) {
                userID.getTransmissionList().remove(transmission);
                userID = em.merge(userID);
            }
            em.remove(transmission);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transmission> findTransmissionEntities() {
        return findTransmissionEntities(true, -1, -1);
    }

    public List<Transmission> findTransmissionEntities(int maxResults, int firstResult) {
        return findTransmissionEntities(false, maxResults, firstResult);
    }

    private List<Transmission> findTransmissionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transmission.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Transmission findTransmission(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transmission.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransmissionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transmission> rt = cq.from(Transmission.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
