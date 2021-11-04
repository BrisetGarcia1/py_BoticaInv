/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.Bitacorasesion;
import Negocio.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class BitacorasesionJpaController implements Serializable {

    public BitacorasesionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bitacorasesion bitacorasesion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bitacorasesion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bitacorasesion bitacorasesion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bitacorasesion = em.merge(bitacorasesion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bitacorasesion.getIdbitacora();
                if (findBitacorasesion(id) == null) {
                    throw new NonexistentEntityException("The bitacorasesion with id " + id + " no longer exists.");
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
            Bitacorasesion bitacorasesion;
            try {
                bitacorasesion = em.getReference(Bitacorasesion.class, id);
                bitacorasesion.getIdbitacora();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bitacorasesion with id " + id + " no longer exists.", enfe);
            }
            em.remove(bitacorasesion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bitacorasesion> findBitacorasesionEntities() {
        return findBitacorasesionEntities(true, -1, -1);
    }

    public List<Bitacorasesion> findBitacorasesionEntities(int maxResults, int firstResult) {
        return findBitacorasesionEntities(false, maxResults, firstResult);
    }

    private List<Bitacorasesion> findBitacorasesionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bitacorasesion.class));
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

    public Bitacorasesion findBitacorasesion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bitacorasesion.class, id);
        } finally {
            em.close();
        }
    }

    public int getBitacorasesionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bitacorasesion> rt = cq.from(Bitacorasesion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
