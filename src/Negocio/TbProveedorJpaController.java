/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.TbKardex;
import Entidad.TbProveedor;
import Negocio.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class TbProveedorJpaController implements Serializable {

    public TbProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbProveedor tbProveedor) {
        if (tbProveedor.getTbKardexList() == null) {
            tbProveedor.setTbKardexList(new ArrayList<TbKardex>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbKardex> attachedTbKardexList = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListTbKardexToAttach : tbProveedor.getTbKardexList()) {
                tbKardexListTbKardexToAttach = em.getReference(tbKardexListTbKardexToAttach.getClass(), tbKardexListTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexList.add(tbKardexListTbKardexToAttach);
            }
            tbProveedor.setTbKardexList(attachedTbKardexList);
            em.persist(tbProveedor);
            for (TbKardex tbKardexListTbKardex : tbProveedor.getTbKardexList()) {
                TbProveedor oldIdProvOfTbKardexListTbKardex = tbKardexListTbKardex.getIdProv();
                tbKardexListTbKardex.setIdProv(tbProveedor);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
                if (oldIdProvOfTbKardexListTbKardex != null) {
                    oldIdProvOfTbKardexListTbKardex.getTbKardexList().remove(tbKardexListTbKardex);
                    oldIdProvOfTbKardexListTbKardex = em.merge(oldIdProvOfTbKardexListTbKardex);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbProveedor tbProveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbProveedor persistentTbProveedor = em.find(TbProveedor.class, tbProveedor.getIdProv());
            List<TbKardex> tbKardexListOld = persistentTbProveedor.getTbKardexList();
            List<TbKardex> tbKardexListNew = tbProveedor.getTbKardexList();
            List<TbKardex> attachedTbKardexListNew = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListNewTbKardexToAttach : tbKardexListNew) {
                tbKardexListNewTbKardexToAttach = em.getReference(tbKardexListNewTbKardexToAttach.getClass(), tbKardexListNewTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexListNew.add(tbKardexListNewTbKardexToAttach);
            }
            tbKardexListNew = attachedTbKardexListNew;
            tbProveedor.setTbKardexList(tbKardexListNew);
            tbProveedor = em.merge(tbProveedor);
            for (TbKardex tbKardexListOldTbKardex : tbKardexListOld) {
                if (!tbKardexListNew.contains(tbKardexListOldTbKardex)) {
                    tbKardexListOldTbKardex.setIdProv(null);
                    tbKardexListOldTbKardex = em.merge(tbKardexListOldTbKardex);
                }
            }
            for (TbKardex tbKardexListNewTbKardex : tbKardexListNew) {
                if (!tbKardexListOld.contains(tbKardexListNewTbKardex)) {
                    TbProveedor oldIdProvOfTbKardexListNewTbKardex = tbKardexListNewTbKardex.getIdProv();
                    tbKardexListNewTbKardex.setIdProv(tbProveedor);
                    tbKardexListNewTbKardex = em.merge(tbKardexListNewTbKardex);
                    if (oldIdProvOfTbKardexListNewTbKardex != null && !oldIdProvOfTbKardexListNewTbKardex.equals(tbProveedor)) {
                        oldIdProvOfTbKardexListNewTbKardex.getTbKardexList().remove(tbKardexListNewTbKardex);
                        oldIdProvOfTbKardexListNewTbKardex = em.merge(oldIdProvOfTbKardexListNewTbKardex);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbProveedor.getIdProv();
                if (findTbProveedor(id) == null) {
                    throw new NonexistentEntityException("The tbProveedor with id " + id + " no longer exists.");
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
            TbProveedor tbProveedor;
            try {
                tbProveedor = em.getReference(TbProveedor.class, id);
                tbProveedor.getIdProv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbProveedor with id " + id + " no longer exists.", enfe);
            }
            List<TbKardex> tbKardexList = tbProveedor.getTbKardexList();
            for (TbKardex tbKardexListTbKardex : tbKardexList) {
                tbKardexListTbKardex.setIdProv(null);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
            }
            em.remove(tbProveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbProveedor> findTbProveedorEntities() {
        return findTbProveedorEntities(true, -1, -1);
    }

    public List<TbProveedor> findTbProveedorEntities(int maxResults, int firstResult) {
        return findTbProveedorEntities(false, maxResults, firstResult);
    }

    private List<TbProveedor> findTbProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbProveedor.class));
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

    public TbProveedor findTbProveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbProveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbProveedor> rt = cq.from(TbProveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
