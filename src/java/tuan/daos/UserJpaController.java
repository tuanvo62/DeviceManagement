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
import tuan.entities.Room;
import tuan.entities.RepairManagement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tuan.daos.exceptions.NonexistentEntityException;
import tuan.daos.exceptions.PreexistingEntityException;
import tuan.entities.Transmission;
import tuan.entities.User;

/**
 *
 * @author macbookpro
 */
public class UserJpaController implements Serializable {

    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(User user) throws PreexistingEntityException, Exception {
        if (user.getRepairManagementList() == null) {
            user.setRepairManagementList(new ArrayList<RepairManagement>());
        }
        if (user.getRepairManagementList1() == null) {
            user.setRepairManagementList1(new ArrayList<RepairManagement>());
        }
        if (user.getTransmissionList() == null) {
            user.setTransmissionList(new ArrayList<Transmission>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Room roomID = user.getRoomID();
            if (roomID != null) {
                roomID = em.getReference(roomID.getClass(), roomID.getRoomID());
                user.setRoomID(roomID);
            }
            List<RepairManagement> attachedRepairManagementList = new ArrayList<RepairManagement>();
            for (RepairManagement repairManagementListRepairManagementToAttach : user.getRepairManagementList()) {
                repairManagementListRepairManagementToAttach = em.getReference(repairManagementListRepairManagementToAttach.getClass(), repairManagementListRepairManagementToAttach.getRepairID());
                attachedRepairManagementList.add(repairManagementListRepairManagementToAttach);
            }
            user.setRepairManagementList(attachedRepairManagementList);
            List<RepairManagement> attachedRepairManagementList1 = new ArrayList<RepairManagement>();
            for (RepairManagement repairManagementList1RepairManagementToAttach : user.getRepairManagementList1()) {
                repairManagementList1RepairManagementToAttach = em.getReference(repairManagementList1RepairManagementToAttach.getClass(), repairManagementList1RepairManagementToAttach.getRepairID());
                attachedRepairManagementList1.add(repairManagementList1RepairManagementToAttach);
            }
            user.setRepairManagementList1(attachedRepairManagementList1);
            List<Transmission> attachedTransmissionList = new ArrayList<Transmission>();
            for (Transmission transmissionListTransmissionToAttach : user.getTransmissionList()) {
                transmissionListTransmissionToAttach = em.getReference(transmissionListTransmissionToAttach.getClass(), transmissionListTransmissionToAttach.getTranID());
                attachedTransmissionList.add(transmissionListTransmissionToAttach);
            }
            user.setTransmissionList(attachedTransmissionList);
            em.persist(user);
            if (roomID != null) {
                roomID.getUserList().add(user);
                roomID = em.merge(roomID);
            }
            for (RepairManagement repairManagementListRepairManagement : user.getRepairManagementList()) {
                User oldRequireUserIDOfRepairManagementListRepairManagement = repairManagementListRepairManagement.getRequireUserID();
                repairManagementListRepairManagement.setRequireUserID(user);
                repairManagementListRepairManagement = em.merge(repairManagementListRepairManagement);
                if (oldRequireUserIDOfRepairManagementListRepairManagement != null) {
                    oldRequireUserIDOfRepairManagementListRepairManagement.getRepairManagementList().remove(repairManagementListRepairManagement);
                    oldRequireUserIDOfRepairManagementListRepairManagement = em.merge(oldRequireUserIDOfRepairManagementListRepairManagement);
                }
            }
            for (RepairManagement repairManagementList1RepairManagement : user.getRepairManagementList1()) {
                User oldRepairUserIDOfRepairManagementList1RepairManagement = repairManagementList1RepairManagement.getRepairUserID();
                repairManagementList1RepairManagement.setRepairUserID(user);
                repairManagementList1RepairManagement = em.merge(repairManagementList1RepairManagement);
                if (oldRepairUserIDOfRepairManagementList1RepairManagement != null) {
                    oldRepairUserIDOfRepairManagementList1RepairManagement.getRepairManagementList1().remove(repairManagementList1RepairManagement);
                    oldRepairUserIDOfRepairManagementList1RepairManagement = em.merge(oldRepairUserIDOfRepairManagementList1RepairManagement);
                }
            }
            for (Transmission transmissionListTransmission : user.getTransmissionList()) {
                User oldUserIDOfTransmissionListTransmission = transmissionListTransmission.getUserID();
                transmissionListTransmission.setUserID(user);
                transmissionListTransmission = em.merge(transmissionListTransmission);
                if (oldUserIDOfTransmissionListTransmission != null) {
                    oldUserIDOfTransmissionListTransmission.getTransmissionList().remove(transmissionListTransmission);
                    oldUserIDOfTransmissionListTransmission = em.merge(oldUserIDOfTransmissionListTransmission);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUser(user.getUserID()) != null) {
                throw new PreexistingEntityException("User " + user + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(User user) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User persistentUser = em.find(User.class, user.getUserID());
            Room roomIDOld = persistentUser.getRoomID();
            Room roomIDNew = user.getRoomID();
            List<RepairManagement> repairManagementListOld = persistentUser.getRepairManagementList();
            List<RepairManagement> repairManagementListNew = user.getRepairManagementList();
            List<RepairManagement> repairManagementList1Old = persistentUser.getRepairManagementList1();
            List<RepairManagement> repairManagementList1New = user.getRepairManagementList1();
            List<Transmission> transmissionListOld = persistentUser.getTransmissionList();
            List<Transmission> transmissionListNew = user.getTransmissionList();
            if (roomIDNew != null) {
                roomIDNew = em.getReference(roomIDNew.getClass(), roomIDNew.getRoomID());
                user.setRoomID(roomIDNew);
            }
            List<RepairManagement> attachedRepairManagementListNew = new ArrayList<RepairManagement>();
            for (RepairManagement repairManagementListNewRepairManagementToAttach : repairManagementListNew) {
                repairManagementListNewRepairManagementToAttach = em.getReference(repairManagementListNewRepairManagementToAttach.getClass(), repairManagementListNewRepairManagementToAttach.getRepairID());
                attachedRepairManagementListNew.add(repairManagementListNewRepairManagementToAttach);
            }
            repairManagementListNew = attachedRepairManagementListNew;
            user.setRepairManagementList(repairManagementListNew);
            List<RepairManagement> attachedRepairManagementList1New = new ArrayList<RepairManagement>();
            for (RepairManagement repairManagementList1NewRepairManagementToAttach : repairManagementList1New) {
                repairManagementList1NewRepairManagementToAttach = em.getReference(repairManagementList1NewRepairManagementToAttach.getClass(), repairManagementList1NewRepairManagementToAttach.getRepairID());
                attachedRepairManagementList1New.add(repairManagementList1NewRepairManagementToAttach);
            }
            repairManagementList1New = attachedRepairManagementList1New;
            user.setRepairManagementList1(repairManagementList1New);
            List<Transmission> attachedTransmissionListNew = new ArrayList<Transmission>();
            for (Transmission transmissionListNewTransmissionToAttach : transmissionListNew) {
                transmissionListNewTransmissionToAttach = em.getReference(transmissionListNewTransmissionToAttach.getClass(), transmissionListNewTransmissionToAttach.getTranID());
                attachedTransmissionListNew.add(transmissionListNewTransmissionToAttach);
            }
            transmissionListNew = attachedTransmissionListNew;
            user.setTransmissionList(transmissionListNew);
            user = em.merge(user);
            if (roomIDOld != null && !roomIDOld.equals(roomIDNew)) {
                roomIDOld.getUserList().remove(user);
                roomIDOld = em.merge(roomIDOld);
            }
            if (roomIDNew != null && !roomIDNew.equals(roomIDOld)) {
                roomIDNew.getUserList().add(user);
                roomIDNew = em.merge(roomIDNew);
            }
            for (RepairManagement repairManagementListOldRepairManagement : repairManagementListOld) {
                if (!repairManagementListNew.contains(repairManagementListOldRepairManagement)) {
                    repairManagementListOldRepairManagement.setRequireUserID(null);
                    repairManagementListOldRepairManagement = em.merge(repairManagementListOldRepairManagement);
                }
            }
            for (RepairManagement repairManagementListNewRepairManagement : repairManagementListNew) {
                if (!repairManagementListOld.contains(repairManagementListNewRepairManagement)) {
                    User oldRequireUserIDOfRepairManagementListNewRepairManagement = repairManagementListNewRepairManagement.getRequireUserID();
                    repairManagementListNewRepairManagement.setRequireUserID(user);
                    repairManagementListNewRepairManagement = em.merge(repairManagementListNewRepairManagement);
                    if (oldRequireUserIDOfRepairManagementListNewRepairManagement != null && !oldRequireUserIDOfRepairManagementListNewRepairManagement.equals(user)) {
                        oldRequireUserIDOfRepairManagementListNewRepairManagement.getRepairManagementList().remove(repairManagementListNewRepairManagement);
                        oldRequireUserIDOfRepairManagementListNewRepairManagement = em.merge(oldRequireUserIDOfRepairManagementListNewRepairManagement);
                    }
                }
            }
            for (RepairManagement repairManagementList1OldRepairManagement : repairManagementList1Old) {
                if (!repairManagementList1New.contains(repairManagementList1OldRepairManagement)) {
                    repairManagementList1OldRepairManagement.setRepairUserID(null);
                    repairManagementList1OldRepairManagement = em.merge(repairManagementList1OldRepairManagement);
                }
            }
            for (RepairManagement repairManagementList1NewRepairManagement : repairManagementList1New) {
                if (!repairManagementList1Old.contains(repairManagementList1NewRepairManagement)) {
                    User oldRepairUserIDOfRepairManagementList1NewRepairManagement = repairManagementList1NewRepairManagement.getRepairUserID();
                    repairManagementList1NewRepairManagement.setRepairUserID(user);
                    repairManagementList1NewRepairManagement = em.merge(repairManagementList1NewRepairManagement);
                    if (oldRepairUserIDOfRepairManagementList1NewRepairManagement != null && !oldRepairUserIDOfRepairManagementList1NewRepairManagement.equals(user)) {
                        oldRepairUserIDOfRepairManagementList1NewRepairManagement.getRepairManagementList1().remove(repairManagementList1NewRepairManagement);
                        oldRepairUserIDOfRepairManagementList1NewRepairManagement = em.merge(oldRepairUserIDOfRepairManagementList1NewRepairManagement);
                    }
                }
            }
            for (Transmission transmissionListOldTransmission : transmissionListOld) {
                if (!transmissionListNew.contains(transmissionListOldTransmission)) {
                    transmissionListOldTransmission.setUserID(null);
                    transmissionListOldTransmission = em.merge(transmissionListOldTransmission);
                }
            }
            for (Transmission transmissionListNewTransmission : transmissionListNew) {
                if (!transmissionListOld.contains(transmissionListNewTransmission)) {
                    User oldUserIDOfTransmissionListNewTransmission = transmissionListNewTransmission.getUserID();
                    transmissionListNewTransmission.setUserID(user);
                    transmissionListNewTransmission = em.merge(transmissionListNewTransmission);
                    if (oldUserIDOfTransmissionListNewTransmission != null && !oldUserIDOfTransmissionListNewTransmission.equals(user)) {
                        oldUserIDOfTransmissionListNewTransmission.getTransmissionList().remove(transmissionListNewTransmission);
                        oldUserIDOfTransmissionListNewTransmission = em.merge(oldUserIDOfTransmissionListNewTransmission);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = user.getUserID();
                if (findUser(id) == null) {
                    throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
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
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getUserID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            Room roomID = user.getRoomID();
            if (roomID != null) {
                roomID.getUserList().remove(user);
                roomID = em.merge(roomID);
            }
            List<RepairManagement> repairManagementList = user.getRepairManagementList();
            for (RepairManagement repairManagementListRepairManagement : repairManagementList) {
                repairManagementListRepairManagement.setRequireUserID(null);
                repairManagementListRepairManagement = em.merge(repairManagementListRepairManagement);
            }
            List<RepairManagement> repairManagementList1 = user.getRepairManagementList1();
            for (RepairManagement repairManagementList1RepairManagement : repairManagementList1) {
                repairManagementList1RepairManagement.setRepairUserID(null);
                repairManagementList1RepairManagement = em.merge(repairManagementList1RepairManagement);
            }
            List<Transmission> transmissionList = user.getTransmissionList();
            for (Transmission transmissionListTransmission : transmissionList) {
                transmissionListTransmission.setUserID(null);
                transmissionListTransmission = em.merge(transmissionListTransmission);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<User> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<User> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(User.class));
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

    public User findUser(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
