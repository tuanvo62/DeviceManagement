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
import tuan.entities.RepairManagement;
import tuan.entities.User;

/**
 *
 * @author macbookpro
 */
public class RepairManagementJpaController implements Serializable {

    public RepairManagementJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RepairManagement repairManagement) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Device deviceID = repairManagement.getDeviceID();
            if (deviceID != null) {
                deviceID = em.getReference(deviceID.getClass(), deviceID.getDeviceID());
                repairManagement.setDeviceID(deviceID);
            }
            User requireUserID = repairManagement.getRequireUserID();
            if (requireUserID != null) {
                requireUserID = em.getReference(requireUserID.getClass(), requireUserID.getUserID());
                repairManagement.setRequireUserID(requireUserID);
            }
            User repairUserID = repairManagement.getRepairUserID();
            if (repairUserID != null) {
                repairUserID = em.getReference(repairUserID.getClass(), repairUserID.getUserID());
                repairManagement.setRepairUserID(repairUserID);
            }
            em.persist(repairManagement);
            if (deviceID != null) {
                deviceID.getRepairManagementList().add(repairManagement);
                deviceID = em.merge(deviceID);
            }
            if (requireUserID != null) {
                requireUserID.getRepairManagementList().add(repairManagement);
                requireUserID = em.merge(requireUserID);
            }
            if (repairUserID != null) {
                repairUserID.getRepairManagementList().add(repairManagement);
                repairUserID = em.merge(repairUserID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRepairManagement(repairManagement.getRepairID()) != null) {
                throw new PreexistingEntityException("RepairManagement " + repairManagement + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RepairManagement repairManagement) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RepairManagement persistentRepairManagement = em.find(RepairManagement.class, repairManagement.getRepairID());
            Device deviceIDOld = persistentRepairManagement.getDeviceID();
            Device deviceIDNew = repairManagement.getDeviceID();
            User requireUserIDOld = persistentRepairManagement.getRequireUserID();
            User requireUserIDNew = repairManagement.getRequireUserID();
            User repairUserIDOld = persistentRepairManagement.getRepairUserID();
            User repairUserIDNew = repairManagement.getRepairUserID();
            if (deviceIDNew != null) {
                deviceIDNew = em.getReference(deviceIDNew.getClass(), deviceIDNew.getDeviceID());
                repairManagement.setDeviceID(deviceIDNew);
            }
            if (requireUserIDNew != null) {
                requireUserIDNew = em.getReference(requireUserIDNew.getClass(), requireUserIDNew.getUserID());
                repairManagement.setRequireUserID(requireUserIDNew);
            }
            if (repairUserIDNew != null) {
                repairUserIDNew = em.getReference(repairUserIDNew.getClass(), repairUserIDNew.getUserID());
                repairManagement.setRepairUserID(repairUserIDNew);
            }
            repairManagement = em.merge(repairManagement);
            if (deviceIDOld != null && !deviceIDOld.equals(deviceIDNew)) {
                deviceIDOld.getRepairManagementList().remove(repairManagement);
                deviceIDOld = em.merge(deviceIDOld);
            }
            if (deviceIDNew != null && !deviceIDNew.equals(deviceIDOld)) {
                deviceIDNew.getRepairManagementList().add(repairManagement);
                deviceIDNew = em.merge(deviceIDNew);
            }
            if (requireUserIDOld != null && !requireUserIDOld.equals(requireUserIDNew)) {
                requireUserIDOld.getRepairManagementList().remove(repairManagement);
                requireUserIDOld = em.merge(requireUserIDOld);
            }
            if (requireUserIDNew != null && !requireUserIDNew.equals(requireUserIDOld)) {
                requireUserIDNew.getRepairManagementList().add(repairManagement);
                requireUserIDNew = em.merge(requireUserIDNew);
            }
            if (repairUserIDOld != null && !repairUserIDOld.equals(repairUserIDNew)) {
                repairUserIDOld.getRepairManagementList().remove(repairManagement);
                repairUserIDOld = em.merge(repairUserIDOld);
            }
            if (repairUserIDNew != null && !repairUserIDNew.equals(repairUserIDOld)) {
                repairUserIDNew.getRepairManagementList().add(repairManagement);
                repairUserIDNew = em.merge(repairUserIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = repairManagement.getRepairID();
                if (findRepairManagement(id) == null) {
                    throw new NonexistentEntityException("The repairManagement with id " + id + " no longer exists.");
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
            RepairManagement repairManagement;
            try {
                repairManagement = em.getReference(RepairManagement.class, id);
                repairManagement.getRepairID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The repairManagement with id " + id + " no longer exists.", enfe);
            }
            Device deviceID = repairManagement.getDeviceID();
            if (deviceID != null) {
                deviceID.getRepairManagementList().remove(repairManagement);
                deviceID = em.merge(deviceID);
            }
            User requireUserID = repairManagement.getRequireUserID();
            if (requireUserID != null) {
                requireUserID.getRepairManagementList().remove(repairManagement);
                requireUserID = em.merge(requireUserID);
            }
            User repairUserID = repairManagement.getRepairUserID();
            if (repairUserID != null) {
                repairUserID.getRepairManagementList().remove(repairManagement);
                repairUserID = em.merge(repairUserID);
            }
            em.remove(repairManagement);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RepairManagement> findRepairManagementEntities() {
        return findRepairManagementEntities(true, -1, -1);
    }

    public List<RepairManagement> findRepairManagementEntities(int maxResults, int firstResult) {
        return findRepairManagementEntities(false, maxResults, firstResult);
    }

    private List<RepairManagement> findRepairManagementEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RepairManagement.class));
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

    public RepairManagement findRepairManagement(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RepairManagement.class, id);
        } finally {
            em.close();
        }
    }

    public int getRepairManagementCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RepairManagement> rt = cq.from(RepairManagement.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
