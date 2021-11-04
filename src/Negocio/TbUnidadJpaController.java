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
import Entidad.TbProducto;
import Entidad.TbUnidad;
import Negocio.exceptions.IllegalOrphanException;
import Negocio.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class TbUnidadJpaController implements Serializable {

    public TbUnidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbUnidad tbUnidad) {
        if (tbUnidad.getTbProductoList() == null) {
            tbUnidad.setTbProductoList(new ArrayList<TbProducto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbProducto> attachedTbProductoList = new ArrayList<TbProducto>();
            for (TbProducto tbProductoListTbProductoToAttach : tbUnidad.getTbProductoList()) {
                tbProductoListTbProductoToAttach = em.getReference(tbProductoListTbProductoToAttach.getClass(), tbProductoListTbProductoToAttach.getCbarrasProd());
                attachedTbProductoList.add(tbProductoListTbProductoToAttach);
            }
            tbUnidad.setTbProductoList(attachedTbProductoList);
            em.persist(tbUnidad);
            for (TbProducto tbProductoListTbProducto : tbUnidad.getTbProductoList()) {
                TbUnidad oldIdUnidOfTbProductoListTbProducto = tbProductoListTbProducto.getIdUnid();
                tbProductoListTbProducto.setIdUnid(tbUnidad);
                tbProductoListTbProducto = em.merge(tbProductoListTbProducto);
                if (oldIdUnidOfTbProductoListTbProducto != null) {
                    oldIdUnidOfTbProductoListTbProducto.getTbProductoList().remove(tbProductoListTbProducto);
                    oldIdUnidOfTbProductoListTbProducto = em.merge(oldIdUnidOfTbProductoListTbProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbUnidad tbUnidad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbUnidad persistentTbUnidad = em.find(TbUnidad.class, tbUnidad.getIdUnid());
            List<TbProducto> tbProductoListOld = persistentTbUnidad.getTbProductoList();
            List<TbProducto> tbProductoListNew = tbUnidad.getTbProductoList();
            List<String> illegalOrphanMessages = null;
            for (TbProducto tbProductoListOldTbProducto : tbProductoListOld) {
                if (!tbProductoListNew.contains(tbProductoListOldTbProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TbProducto " + tbProductoListOldTbProducto + " since its idUnid field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TbProducto> attachedTbProductoListNew = new ArrayList<TbProducto>();
            for (TbProducto tbProductoListNewTbProductoToAttach : tbProductoListNew) {
                tbProductoListNewTbProductoToAttach = em.getReference(tbProductoListNewTbProductoToAttach.getClass(), tbProductoListNewTbProductoToAttach.getCbarrasProd());
                attachedTbProductoListNew.add(tbProductoListNewTbProductoToAttach);
            }
            tbProductoListNew = attachedTbProductoListNew;
            tbUnidad.setTbProductoList(tbProductoListNew);
            tbUnidad = em.merge(tbUnidad);
            for (TbProducto tbProductoListNewTbProducto : tbProductoListNew) {
                if (!tbProductoListOld.contains(tbProductoListNewTbProducto)) {
                    TbUnidad oldIdUnidOfTbProductoListNewTbProducto = tbProductoListNewTbProducto.getIdUnid();
                    tbProductoListNewTbProducto.setIdUnid(tbUnidad);
                    tbProductoListNewTbProducto = em.merge(tbProductoListNewTbProducto);
                    if (oldIdUnidOfTbProductoListNewTbProducto != null && !oldIdUnidOfTbProductoListNewTbProducto.equals(tbUnidad)) {
                        oldIdUnidOfTbProductoListNewTbProducto.getTbProductoList().remove(tbProductoListNewTbProducto);
                        oldIdUnidOfTbProductoListNewTbProducto = em.merge(oldIdUnidOfTbProductoListNewTbProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbUnidad.getIdUnid();
                if (findTbUnidad(id) == null) {
                    throw new NonexistentEntityException("The tbUnidad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbUnidad tbUnidad;
            try {
                tbUnidad = em.getReference(TbUnidad.class, id);
                tbUnidad.getIdUnid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbUnidad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TbProducto> tbProductoListOrphanCheck = tbUnidad.getTbProductoList();
            for (TbProducto tbProductoListOrphanCheckTbProducto : tbProductoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TbUnidad (" + tbUnidad + ") cannot be destroyed since the TbProducto " + tbProductoListOrphanCheckTbProducto + " in its tbProductoList field has a non-nullable idUnid field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tbUnidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbUnidad> findTbUnidadEntities() {
        return findTbUnidadEntities(true, -1, -1);
    }

    public List<TbUnidad> findTbUnidadEntities(int maxResults, int firstResult) {
        return findTbUnidadEntities(false, maxResults, firstResult);
    }

    private List<TbUnidad> findTbUnidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbUnidad.class));
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

    public TbUnidad findTbUnidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbUnidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbUnidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbUnidad> rt = cq.from(TbUnidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
