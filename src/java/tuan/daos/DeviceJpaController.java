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
import tuan.entities.Device;
import tuan.entities.Transmission;

/**
 *
 * @author macbookpro
 */
public class DeviceJpaController implements Serializable {

    public DeviceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Device device) throws PreexistingEntityException, Exception {
        if (device.getRepairManagementList() == null) {
            device.setRepairManagementList(new ArrayList<RepairManagement>());
        }
        if (device.getTransmissionList() == null) {
            device.setTransmissionList(new ArrayList<Transmission>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Room roomID = device.getRoomID();
            if (roomID != null) {
                roomID = em.getReference(roomID.getClass(), roomID.getRoomID());
                device.setRoomID(roomID);
            }
            List<RepairManagement> attachedRepairManagementList = new ArrayList<RepairManagement>();
            for (RepairManagement repairManagementListRepairManagementToAttach : device.getRepairManagementList()) {
                repairManagementListRepairManagementToAttach = em.getReference(repairManagementListRepairManagementToAttach.getClass(), repairManagementListRepairManagementToAttach.getRepairID());
                attachedRepairManagementList.add(repairManagementListRepairManagementToAttach);
            }
            device.setRepairManagementList(attachedRepairManagementList);
            List<Transmission> attachedTransmissionList = new ArrayList<Transmission>();
            for (Transmission transmissionListTransmissionToAttach : device.getTransmissionList()) {
                transmissionListTransmissionToAttach = em.getReference(transmissionListTransmissionToAttach.getClass(), transmissionListTransmissionToAttach.getTranID());
                attachedTransmissionList.add(transmissionListTransmissionToAttach);
            }
            device.setTransmissionList(attachedTransmissionList);
            em.persist(device);
            if (roomID != null) {
                roomID.getDeviceList().add(device);
                roomID = em.merge(roomID);
            }
            for (RepairManagement repairManagementListRepairManagement : device.getRepairManagementList()) {
                Device oldDeviceIDOfRepairManagementListRepairManagement = repairManagementListRepairManagement.getDeviceID();
                repairManagementListRepairManagement.setDeviceID(device);
                repairManagementListRepairManagement = em.merge(repairManagementListRepairManagement);
                if (oldDeviceIDOfRepairManagementListRepairManagement != null) {
                    oldDeviceIDOfRepairManagementListRepairManagement.getRepairManagementList().remove(repairManagementListRepairManagement);
                    oldDeviceIDOfRepairManagementListRepairManagement = em.merge(oldDeviceIDOfRepairManagementListRepairManagement);
                }
            }
            for (Transmission transmissionListTransmission : device.getTransmissionList()) {
                Device oldDeviceIDOfTransmissionListTransmission = transmissionListTransmission.getDeviceID();
                transmissionListTransmission.setDeviceID(device);
                transmissionListTransmission = em.merge(transmissionListTransmission);
                if (oldDeviceIDOfTransmissionListTransmission != null) {
                    oldDeviceIDOfTransmissionListTransmission.getTransmissionList().remove(transmissionListTransmission);
                    oldDeviceIDOfTransmissionListTransmission = em.merge(oldDeviceIDOfTransmissionListTransmission);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDevice(device.getDeviceID()) != null) {
                throw new PreexistingEntityException("Device " + device + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Device device) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Device persistentDevice = em.find(Device.class, device.getDeviceID());
            Room roomIDOld = persistentDevice.getRoomID();
            Room roomIDNew = device.getRoomID();
            List<RepairManagement> repairManagementListOld = persistentDevice.getRepairManagementList();
            List<RepairManagement> repairManagementListNew = device.getRepairManagementList();
            List<Transmission> transmissionListOld = persistentDevice.getTransmissionList();
            List<Transmission> transmissionListNew = device.getTransmissionList();
            if (roomIDNew != null) {
                roomIDNew = em.getReference(roomIDNew.getClass(), roomIDNew.getRoomID());
                device.setRoomID(roomIDNew);
            }
            List<RepairManagement> attachedRepairManagementListNew = new ArrayList<RepairManagement>();
            for (RepairManagement repairManagementListNewRepairManagementToAttach : repairManagementListNew) {
                repairManagementListNewRepairManagementToAttach = em.getReference(repairManagementListNewRepairManagementToAttach.getClass(), repairManagementListNewRepairManagementToAttach.getRepairID());
                attachedRepairManagementListNew.add(repairManagementListNewRepairManagementToAttach);
            }
            repairManagementListNew = attachedRepairManagementListNew;
            device.setRepairManagementList(repairManagementListNew);
            List<Transmission> attachedTransmissionListNew = new ArrayList<Transmission>();
            for (Transmission transmissionListNewTransmissionToAttach : transmissionListNew) {
                transmissionListNewTransmissionToAttach = em.getReference(transmissionListNewTransmissionToAttach.getClass(), transmissionListNewTransmissionToAttach.getTranID());
                attachedTransmissionListNew.add(transmissionListNewTransmissionToAttach);
            }
            transmissionListNew = attachedTransmissionListNew;
            device.setTransmissionList(transmissionListNew);
            device = em.merge(device);
            if (roomIDOld != null && !roomIDOld.equals(roomIDNew)) {
                roomIDOld.getDeviceList().remove(device);
                roomIDOld = em.merge(roomIDOld);
            }
            if (roomIDNew != null && !roomIDNew.equals(roomIDOld)) {
                roomIDNew.getDeviceList().add(device);
                roomIDNew = em.merge(roomIDNew);
            }
            for (RepairManagement repairManagementListOldRepairManagement : repairManagementListOld) {
                if (!repairManagementListNew.contains(repairManagementListOldRepairManagement)) {
                    repairManagementListOldRepairManagement.setDeviceID(null);
                    repairManagementListOldRepairManagement = em.merge(repairManagementListOldRepairManagement);
                }
            }
            for (RepairManagement repairManagementListNewRepairManagement : repairManagementListNew) {
                if (!repairManagementListOld.contains(repairManagementListNewRepairManagement)) {
                    Device oldDeviceIDOfRepairManagementListNewRepairManagement = repairManagementListNewRepairManagement.getDeviceID();
                    repairManagementListNewRepairManagement.setDeviceID(device);
                    repairManagementListNewRepairManagement = em.merge(repairManagementListNewRepairManagement);
                    if (oldDeviceIDOfRepairManagementListNewRepairManagement != null && !oldDeviceIDOfRepairManagementListNewRepairManagement.equals(device)) {
                        oldDeviceIDOfRepairManagementListNewRepairManagement.getRepairManagementList().remove(repairManagementListNewRepairManagement);
                        oldDeviceIDOfRepairManagementListNewRepairManagement = em.merge(oldDeviceIDOfRepairManagementListNewRepairManagement);
                    }
                }
            }
            for (Transmission transmissionListOldTransmission : transmissionListOld) {
                if (!transmissionListNew.contains(transmissionListOldTransmission)) {
                    transmissionListOldTransmission.setDeviceID(null);
                    transmissionListOldTransmission = em.merge(transmissionListOldTransmission);
                }
            }
            for (Transmission transmissionListNewTransmission : transmissionListNew) {
                if (!transmissionListOld.contains(transmissionListNewTransmission)) {
                    Device oldDeviceIDOfTransmissionListNewTransmission = transmissionListNewTransmission.getDeviceID();
                    transmissionListNewTransmission.setDeviceID(device);
                    transmissionListNewTransmission = em.merge(transmissionListNewTransmission);
                    if (oldDeviceIDOfTransmissionListNewTransmission != null && !oldDeviceIDOfTransmissionListNewTransmission.equals(device)) {
                        oldDeviceIDOfTransmissionListNewTransmission.getTransmissionList().remove(transmissionListNewTransmission);
                        oldDeviceIDOfTransmissionListNewTransmission = em.merge(oldDeviceIDOfTransmissionListNewTransmission);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = device.getDeviceID();
                if (findDevice(id) == null) {
                    throw new NonexistentEntityException("The device with id " + id + " no longer exists.");
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
            Device device;
            try {
                device = em.getReference(Device.class, id);
                device.getDeviceID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The device with id " + id + " no longer exists.", enfe);
            }
            Room roomID = device.getRoomID();
            if (roomID != null) {
                roomID.getDeviceList().remove(device);
                roomID = em.merge(roomID);
            }
            List<RepairManagement> repairManagementList = device.getRepairManagementList();
            for (RepairManagement repairManagementListRepairManagement : repairManagementList) {
                repairManagementListRepairManagement.setDeviceID(null);
                repairManagementListRepairManagement = em.merge(repairManagementListRepairManagement);
            }
            List<Transmission> transmissionList = device.getTransmissionList();
            for (Transmission transmissionListTransmission : transmissionList) {
                transmissionListTransmission.setDeviceID(null);
                transmissionListTransmission = em.merge(transmissionListTransmission);
            }
            em.remove(device);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Device> findDeviceEntities() {
        return findDeviceEntities(true, -1, -1);
    }

    public List<Device> findDeviceEntities(int maxResults, int firstResult) {
        return findDeviceEntities(false, maxResults, firstResult);
    }

    private List<Device> findDeviceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Device.class));
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

    public Device findDevice(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Device.class, id);
        } finally {
            em.close();
        }
    }

    public int getDeviceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Device> rt = cq.from(Device.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
