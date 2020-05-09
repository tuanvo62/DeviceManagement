/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.daos;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tuan.entities.Device;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tuan.daos.exceptions.NonexistentEntityException;
import tuan.daos.exceptions.PreexistingEntityException;
import tuan.entities.Room;
import tuan.entities.Transmission;
import tuan.entities.User;

/**
 *
 * @author macbookpro
 */
public class RoomJpaController implements Serializable {

    public RoomJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Room room) throws PreexistingEntityException, Exception {
        if (room.getDeviceList() == null) {
            room.setDeviceList(new ArrayList<Device>());
        }
        if (room.getTransmissionList() == null) {
            room.setTransmissionList(new ArrayList<Transmission>());
        }
        if (room.getTransmissionList1() == null) {
            room.setTransmissionList1(new ArrayList<Transmission>());
        }
        if (room.getUserList() == null) {
            room.setUserList(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Device> attachedDeviceList = new ArrayList<Device>();
            for (Device deviceListDeviceToAttach : room.getDeviceList()) {
                deviceListDeviceToAttach = em.getReference(deviceListDeviceToAttach.getClass(), deviceListDeviceToAttach.getDeviceID());
                attachedDeviceList.add(deviceListDeviceToAttach);
            }
            room.setDeviceList(attachedDeviceList);
            List<Transmission> attachedTransmissionList = new ArrayList<Transmission>();
            for (Transmission transmissionListTransmissionToAttach : room.getTransmissionList()) {
                transmissionListTransmissionToAttach = em.getReference(transmissionListTransmissionToAttach.getClass(), transmissionListTransmissionToAttach.getTranID());
                attachedTransmissionList.add(transmissionListTransmissionToAttach);
            }
            room.setTransmissionList(attachedTransmissionList);
            List<Transmission> attachedTransmissionList1 = new ArrayList<Transmission>();
            for (Transmission transmissionList1TransmissionToAttach : room.getTransmissionList1()) {
                transmissionList1TransmissionToAttach = em.getReference(transmissionList1TransmissionToAttach.getClass(), transmissionList1TransmissionToAttach.getTranID());
                attachedTransmissionList1.add(transmissionList1TransmissionToAttach);
            }
            room.setTransmissionList1(attachedTransmissionList1);
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : room.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getUserID());
                attachedUserList.add(userListUserToAttach);
            }
            room.setUserList(attachedUserList);
            em.persist(room);
            for (Device deviceListDevice : room.getDeviceList()) {
                Room oldRoomIDOfDeviceListDevice = deviceListDevice.getRoomID();
                deviceListDevice.setRoomID(room);
                deviceListDevice = em.merge(deviceListDevice);
                if (oldRoomIDOfDeviceListDevice != null) {
                    oldRoomIDOfDeviceListDevice.getDeviceList().remove(deviceListDevice);
                    oldRoomIDOfDeviceListDevice = em.merge(oldRoomIDOfDeviceListDevice);
                }
            }
            for (Transmission transmissionListTransmission : room.getTransmissionList()) {
                Room oldFromRoomOfTransmissionListTransmission = transmissionListTransmission.getFromRoom();
                transmissionListTransmission.setFromRoom(room);
                transmissionListTransmission = em.merge(transmissionListTransmission);
                if (oldFromRoomOfTransmissionListTransmission != null) {
                    oldFromRoomOfTransmissionListTransmission.getTransmissionList().remove(transmissionListTransmission);
                    oldFromRoomOfTransmissionListTransmission = em.merge(oldFromRoomOfTransmissionListTransmission);
                }
            }
            for (Transmission transmissionList1Transmission : room.getTransmissionList1()) {
                Room oldToRoomOfTransmissionList1Transmission = transmissionList1Transmission.getToRoom();
                transmissionList1Transmission.setToRoom(room);
                transmissionList1Transmission = em.merge(transmissionList1Transmission);
                if (oldToRoomOfTransmissionList1Transmission != null) {
                    oldToRoomOfTransmissionList1Transmission.getTransmissionList1().remove(transmissionList1Transmission);
                    oldToRoomOfTransmissionList1Transmission = em.merge(oldToRoomOfTransmissionList1Transmission);
                }
            }
            for (User userListUser : room.getUserList()) {
                Room oldRoomIDOfUserListUser = userListUser.getRoomID();
                userListUser.setRoomID(room);
                userListUser = em.merge(userListUser);
                if (oldRoomIDOfUserListUser != null) {
                    oldRoomIDOfUserListUser.getUserList().remove(userListUser);
                    oldRoomIDOfUserListUser = em.merge(oldRoomIDOfUserListUser);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRoom(room.getRoomID()) != null) {
                throw new PreexistingEntityException("Room " + room + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Room room) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Room persistentRoom = em.find(Room.class, room.getRoomID());
            List<Device> deviceListOld = persistentRoom.getDeviceList();
            List<Device> deviceListNew = room.getDeviceList();
            List<Transmission> transmissionListOld = persistentRoom.getTransmissionList();
            List<Transmission> transmissionListNew = room.getTransmissionList();
            List<Transmission> transmissionList1Old = persistentRoom.getTransmissionList1();
            List<Transmission> transmissionList1New = room.getTransmissionList1();
            List<User> userListOld = persistentRoom.getUserList();
            List<User> userListNew = room.getUserList();
            List<Device> attachedDeviceListNew = new ArrayList<Device>();
            for (Device deviceListNewDeviceToAttach : deviceListNew) {
                deviceListNewDeviceToAttach = em.getReference(deviceListNewDeviceToAttach.getClass(), deviceListNewDeviceToAttach.getDeviceID());
                attachedDeviceListNew.add(deviceListNewDeviceToAttach);
            }
            deviceListNew = attachedDeviceListNew;
            room.setDeviceList(deviceListNew);
            List<Transmission> attachedTransmissionListNew = new ArrayList<Transmission>();
            for (Transmission transmissionListNewTransmissionToAttach : transmissionListNew) {
                transmissionListNewTransmissionToAttach = em.getReference(transmissionListNewTransmissionToAttach.getClass(), transmissionListNewTransmissionToAttach.getTranID());
                attachedTransmissionListNew.add(transmissionListNewTransmissionToAttach);
            }
            transmissionListNew = attachedTransmissionListNew;
            room.setTransmissionList(transmissionListNew);
            List<Transmission> attachedTransmissionList1New = new ArrayList<Transmission>();
            for (Transmission transmissionList1NewTransmissionToAttach : transmissionList1New) {
                transmissionList1NewTransmissionToAttach = em.getReference(transmissionList1NewTransmissionToAttach.getClass(), transmissionList1NewTransmissionToAttach.getTranID());
                attachedTransmissionList1New.add(transmissionList1NewTransmissionToAttach);
            }
            transmissionList1New = attachedTransmissionList1New;
            room.setTransmissionList1(transmissionList1New);
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getUserID());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            room.setUserList(userListNew);
            room = em.merge(room);
            for (Device deviceListOldDevice : deviceListOld) {
                if (!deviceListNew.contains(deviceListOldDevice)) {
                    deviceListOldDevice.setRoomID(null);
                    deviceListOldDevice = em.merge(deviceListOldDevice);
                }
            }
            for (Device deviceListNewDevice : deviceListNew) {
                if (!deviceListOld.contains(deviceListNewDevice)) {
                    Room oldRoomIDOfDeviceListNewDevice = deviceListNewDevice.getRoomID();
                    deviceListNewDevice.setRoomID(room);
                    deviceListNewDevice = em.merge(deviceListNewDevice);
                    if (oldRoomIDOfDeviceListNewDevice != null && !oldRoomIDOfDeviceListNewDevice.equals(room)) {
                        oldRoomIDOfDeviceListNewDevice.getDeviceList().remove(deviceListNewDevice);
                        oldRoomIDOfDeviceListNewDevice = em.merge(oldRoomIDOfDeviceListNewDevice);
                    }
                }
            }
            for (Transmission transmissionListOldTransmission : transmissionListOld) {
                if (!transmissionListNew.contains(transmissionListOldTransmission)) {
                    transmissionListOldTransmission.setFromRoom(null);
                    transmissionListOldTransmission = em.merge(transmissionListOldTransmission);
                }
            }
            for (Transmission transmissionListNewTransmission : transmissionListNew) {
                if (!transmissionListOld.contains(transmissionListNewTransmission)) {
                    Room oldFromRoomOfTransmissionListNewTransmission = transmissionListNewTransmission.getFromRoom();
                    transmissionListNewTransmission.setFromRoom(room);
                    transmissionListNewTransmission = em.merge(transmissionListNewTransmission);
                    if (oldFromRoomOfTransmissionListNewTransmission != null && !oldFromRoomOfTransmissionListNewTransmission.equals(room)) {
                        oldFromRoomOfTransmissionListNewTransmission.getTransmissionList().remove(transmissionListNewTransmission);
                        oldFromRoomOfTransmissionListNewTransmission = em.merge(oldFromRoomOfTransmissionListNewTransmission);
                    }
                }
            }
            for (Transmission transmissionList1OldTransmission : transmissionList1Old) {
                if (!transmissionList1New.contains(transmissionList1OldTransmission)) {
                    transmissionList1OldTransmission.setToRoom(null);
                    transmissionList1OldTransmission = em.merge(transmissionList1OldTransmission);
                }
            }
            for (Transmission transmissionList1NewTransmission : transmissionList1New) {
                if (!transmissionList1Old.contains(transmissionList1NewTransmission)) {
                    Room oldToRoomOfTransmissionList1NewTransmission = transmissionList1NewTransmission.getToRoom();
                    transmissionList1NewTransmission.setToRoom(room);
                    transmissionList1NewTransmission = em.merge(transmissionList1NewTransmission);
                    if (oldToRoomOfTransmissionList1NewTransmission != null && !oldToRoomOfTransmissionList1NewTransmission.equals(room)) {
                        oldToRoomOfTransmissionList1NewTransmission.getTransmissionList1().remove(transmissionList1NewTransmission);
                        oldToRoomOfTransmissionList1NewTransmission = em.merge(oldToRoomOfTransmissionList1NewTransmission);
                    }
                }
            }
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    userListOldUser.setRoomID(null);
                    userListOldUser = em.merge(userListOldUser);
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    Room oldRoomIDOfUserListNewUser = userListNewUser.getRoomID();
                    userListNewUser.setRoomID(room);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldRoomIDOfUserListNewUser != null && !oldRoomIDOfUserListNewUser.equals(room)) {
                        oldRoomIDOfUserListNewUser.getUserList().remove(userListNewUser);
                        oldRoomIDOfUserListNewUser = em.merge(oldRoomIDOfUserListNewUser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = room.getRoomID();
                if (findRoom(id) == null) {
                    throw new NonexistentEntityException("The room with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Room room;
            try {
                room = em.getReference(Room.class, id);
                room.getRoomID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The room with id " + id + " no longer exists.", enfe);
            }
            List<Device> deviceList = room.getDeviceList();
            for (Device deviceListDevice : deviceList) {
                deviceListDevice.setRoomID(null);
                deviceListDevice = em.merge(deviceListDevice);
            }
            List<Transmission> transmissionList = room.getTransmissionList();
            for (Transmission transmissionListTransmission : transmissionList) {
                transmissionListTransmission.setFromRoom(null);
                transmissionListTransmission = em.merge(transmissionListTransmission);
            }
            List<Transmission> transmissionList1 = room.getTransmissionList1();
            for (Transmission transmissionList1Transmission : transmissionList1) {
                transmissionList1Transmission.setToRoom(null);
                transmissionList1Transmission = em.merge(transmissionList1Transmission);
            }
            List<User> userList = room.getUserList();
            for (User userListUser : userList) {
                userListUser.setRoomID(null);
                userListUser = em.merge(userListUser);
            }
            em.remove(room);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Room> findRoomEntities() {
        return findRoomEntities(true, -1, -1);
    }

    public List<Room> findRoomEntities(int maxResults, int firstResult) {
        return findRoomEntities(false, maxResults, firstResult);
    }

    private List<Room> findRoomEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Room.class));
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

    public Room findRoom(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Room.class, id);
        } finally {
            em.close();
        }
    }

    public int getRoomCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Room> rt = cq.from(Room.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
