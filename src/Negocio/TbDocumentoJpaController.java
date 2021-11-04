/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.TbDocumento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.TbKardex;
import Negocio.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class TbDocumentoJpaController implements Serializable {

    public TbDocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbDocumento tbDocumento) {
        if (tbDocumento.getTbKardexList() == null) {
            tbDocumento.setTbKardexList(new ArrayList<TbKardex>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbKardex> attachedTbKardexList = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListTbKardexToAttach : tbDocumento.getTbKardexList()) {
                tbKardexListTbKardexToAttach = em.getReference(tbKardexListTbKardexToAttach.getClass(), tbKardexListTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexList.add(tbKardexListTbKardexToAttach);
            }
            tbDocumento.setTbKardexList(attachedTbKardexList);
            em.persist(tbDocumento);
            for (TbKardex tbKardexListTbKardex : tbDocumento.getTbKardexList()) {
                TbDocumento oldIdDocumentoOfTbKardexListTbKardex = tbKardexListTbKardex.getIdDocumento();
                tbKardexListTbKardex.setIdDocumento(tbDocumento);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
                if (oldIdDocumentoOfTbKardexListTbKardex != null) {
                    oldIdDocumentoOfTbKardexListTbKardex.getTbKardexList().remove(tbKardexListTbKardex);
                    oldIdDocumentoOfTbKardexListTbKardex = em.merge(oldIdDocumentoOfTbKardexListTbKardex);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbDocumento tbDocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbDocumento persistentTbDocumento = em.find(TbDocumento.class, tbDocumento.getIdDocumento());
            List<TbKardex> tbKardexListOld = persistentTbDocumento.getTbKardexList();
            List<TbKardex> tbKardexListNew = tbDocumento.getTbKardexList();
            List<TbKardex> attachedTbKardexListNew = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListNewTbKardexToAttach : tbKardexListNew) {
                tbKardexListNewTbKardexToAttach = em.getReference(tbKardexListNewTbKardexToAttach.getClass(), tbKardexListNewTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexListNew.add(tbKardexListNewTbKardexToAttach);
            }
            tbKardexListNew = attachedTbKardexListNew;
            tbDocumento.setTbKardexList(tbKardexListNew);
            tbDocumento = em.merge(tbDocumento);
            for (TbKardex tbKardexListOldTbKardex : tbKardexListOld) {
                if (!tbKardexListNew.contains(tbKardexListOldTbKardex)) {
                    tbKardexListOldTbKardex.setIdDocumento(null);
                    tbKardexListOldTbKardex = em.merge(tbKardexListOldTbKardex);
                }
            }
            for (TbKardex tbKardexListNewTbKardex : tbKardexListNew) {
                if (!tbKardexListOld.contains(tbKardexListNewTbKardex)) {
                    TbDocumento oldIdDocumentoOfTbKardexListNewTbKardex = tbKardexListNewTbKardex.getIdDocumento();
                    tbKardexListNewTbKardex.setIdDocumento(tbDocumento);
                    tbKardexListNewTbKardex = em.merge(tbKardexListNewTbKardex);
                    if (oldIdDocumentoOfTbKardexListNewTbKardex != null && !oldIdDocumentoOfTbKardexListNewTbKardex.equals(tbDocumento)) {
                        oldIdDocumentoOfTbKardexListNewTbKardex.getTbKardexList().remove(tbKardexListNewTbKardex);
                        oldIdDocumentoOfTbKardexListNewTbKardex = em.merge(oldIdDocumentoOfTbKardexListNewTbKardex);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbDocumento.getIdDocumento();
                if (findTbDocumento(id) == null) {
                    throw new NonexistentEntityException("The tbDocumento with id " + id + " no longer exists.");
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
            TbDocumento tbDocumento;
            try {
                tbDocumento = em.getReference(TbDocumento.class, id);
                tbDocumento.getIdDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbDocumento with id " + id + " no longer exists.", enfe);
            }
            List<TbKardex> tbKardexList = tbDocumento.getTbKardexList();
            for (TbKardex tbKardexListTbKardex : tbKardexList) {
                tbKardexListTbKardex.setIdDocumento(null);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
            }
            em.remove(tbDocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbDocumento> findTbDocumentoEntities() {
        return findTbDocumentoEntities(true, -1, -1);
    }

    public List<TbDocumento> findTbDocumentoEntities(int maxResults, int firstResult) {
        return findTbDocumentoEntities(false, maxResults, firstResult);
    }

    private List<TbDocumento> findTbDocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbDocumento.class));
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

    public TbDocumento findTbDocumento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbDocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbDocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbDocumento> rt = cq.from(TbDocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
