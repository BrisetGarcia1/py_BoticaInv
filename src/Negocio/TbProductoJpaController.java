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
import Entidad.TbUnidad;
import Entidad.TbKardex;
import Entidad.TbProducto;
import Negocio.exceptions.IllegalOrphanException;
import Negocio.exceptions.NonexistentEntityException;
import Negocio.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class TbProductoJpaController implements Serializable {

    public TbProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbProducto tbProducto) throws PreexistingEntityException, Exception {
        if (tbProducto.getTbKardexList() == null) {
            tbProducto.setTbKardexList(new ArrayList<TbKardex>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbUnidad idUnid = tbProducto.getIdUnid();
            if (idUnid != null) {
                idUnid = em.getReference(idUnid.getClass(), idUnid.getIdUnid());
                tbProducto.setIdUnid(idUnid);
            }
            List<TbKardex> attachedTbKardexList = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListTbKardexToAttach : tbProducto.getTbKardexList()) {
                tbKardexListTbKardexToAttach = em.getReference(tbKardexListTbKardexToAttach.getClass(), tbKardexListTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexList.add(tbKardexListTbKardexToAttach);
            }
            tbProducto.setTbKardexList(attachedTbKardexList);
            em.persist(tbProducto);
            if (idUnid != null) {
                idUnid.getTbProductoList().add(tbProducto);
                idUnid = em.merge(idUnid);
            }
            for (TbKardex tbKardexListTbKardex : tbProducto.getTbKardexList()) {
                TbProducto oldCbarrasProdOfTbKardexListTbKardex = tbKardexListTbKardex.getCbarrasProd();
                tbKardexListTbKardex.setCbarrasProd(tbProducto);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
                if (oldCbarrasProdOfTbKardexListTbKardex != null) {
                    oldCbarrasProdOfTbKardexListTbKardex.getTbKardexList().remove(tbKardexListTbKardex);
                    oldCbarrasProdOfTbKardexListTbKardex = em.merge(oldCbarrasProdOfTbKardexListTbKardex);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbProducto(tbProducto.getCbarrasProd()) != null) {
                throw new PreexistingEntityException("TbProducto " + tbProducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbProducto tbProducto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbProducto persistentTbProducto = em.find(TbProducto.class, tbProducto.getCbarrasProd());
            TbUnidad idUnidOld = persistentTbProducto.getIdUnid();
            TbUnidad idUnidNew = tbProducto.getIdUnid();
            List<TbKardex> tbKardexListOld = persistentTbProducto.getTbKardexList();
            List<TbKardex> tbKardexListNew = tbProducto.getTbKardexList();
            List<String> illegalOrphanMessages = null;
            for (TbKardex tbKardexListOldTbKardex : tbKardexListOld) {
                if (!tbKardexListNew.contains(tbKardexListOldTbKardex)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TbKardex " + tbKardexListOldTbKardex + " since its cbarrasProd field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idUnidNew != null) {
                idUnidNew = em.getReference(idUnidNew.getClass(), idUnidNew.getIdUnid());
                tbProducto.setIdUnid(idUnidNew);
            }
            List<TbKardex> attachedTbKardexListNew = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListNewTbKardexToAttach : tbKardexListNew) {
                tbKardexListNewTbKardexToAttach = em.getReference(tbKardexListNewTbKardexToAttach.getClass(), tbKardexListNewTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexListNew.add(tbKardexListNewTbKardexToAttach);
            }
            tbKardexListNew = attachedTbKardexListNew;
            tbProducto.setTbKardexList(tbKardexListNew);
            tbProducto = em.merge(tbProducto);
            if (idUnidOld != null && !idUnidOld.equals(idUnidNew)) {
                idUnidOld.getTbProductoList().remove(tbProducto);
                idUnidOld = em.merge(idUnidOld);
            }
            if (idUnidNew != null && !idUnidNew.equals(idUnidOld)) {
                idUnidNew.getTbProductoList().add(tbProducto);
                idUnidNew = em.merge(idUnidNew);
            }
            for (TbKardex tbKardexListNewTbKardex : tbKardexListNew) {
                if (!tbKardexListOld.contains(tbKardexListNewTbKardex)) {
                    TbProducto oldCbarrasProdOfTbKardexListNewTbKardex = tbKardexListNewTbKardex.getCbarrasProd();
                    tbKardexListNewTbKardex.setCbarrasProd(tbProducto);
                    tbKardexListNewTbKardex = em.merge(tbKardexListNewTbKardex);
                    if (oldCbarrasProdOfTbKardexListNewTbKardex != null && !oldCbarrasProdOfTbKardexListNewTbKardex.equals(tbProducto)) {
                        oldCbarrasProdOfTbKardexListNewTbKardex.getTbKardexList().remove(tbKardexListNewTbKardex);
                        oldCbarrasProdOfTbKardexListNewTbKardex = em.merge(oldCbarrasProdOfTbKardexListNewTbKardex);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbProducto.getCbarrasProd();
                if (findTbProducto(id) == null) {
                    throw new NonexistentEntityException("The tbProducto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbProducto tbProducto;
            try {
                tbProducto = em.getReference(TbProducto.class, id);
                tbProducto.getCbarrasProd();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbProducto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TbKardex> tbKardexListOrphanCheck = tbProducto.getTbKardexList();
            for (TbKardex tbKardexListOrphanCheckTbKardex : tbKardexListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TbProducto (" + tbProducto + ") cannot be destroyed since the TbKardex " + tbKardexListOrphanCheckTbKardex + " in its tbKardexList field has a non-nullable cbarrasProd field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TbUnidad idUnid = tbProducto.getIdUnid();
            if (idUnid != null) {
                idUnid.getTbProductoList().remove(tbProducto);
                idUnid = em.merge(idUnid);
            }
            em.remove(tbProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbProducto> findTbProductoEntities() {
        return findTbProductoEntities(true, -1, -1);
    }

    public List<TbProducto> findTbProductoEntities(int maxResults, int firstResult) {
        return findTbProductoEntities(false, maxResults, firstResult);
    }

    private List<TbProducto> findTbProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbProducto.class));
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

    public TbProducto findTbProducto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbProducto> rt = cq.from(TbProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
