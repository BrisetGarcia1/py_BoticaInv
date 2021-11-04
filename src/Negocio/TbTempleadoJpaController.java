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
import Entidad.TbEmpleado;
import Entidad.TbTempleado;
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
public class TbTempleadoJpaController implements Serializable {

    public TbTempleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbTempleado tbTempleado) {
        if (tbTempleado.getTbEmpleadoList() == null) {
            tbTempleado.setTbEmpleadoList(new ArrayList<TbEmpleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbEmpleado> attachedTbEmpleadoList = new ArrayList<TbEmpleado>();
            for (TbEmpleado tbEmpleadoListTbEmpleadoToAttach : tbTempleado.getTbEmpleadoList()) {
                tbEmpleadoListTbEmpleadoToAttach = em.getReference(tbEmpleadoListTbEmpleadoToAttach.getClass(), tbEmpleadoListTbEmpleadoToAttach.getIdEmpl());
                attachedTbEmpleadoList.add(tbEmpleadoListTbEmpleadoToAttach);
            }
            tbTempleado.setTbEmpleadoList(attachedTbEmpleadoList);
            em.persist(tbTempleado);
            for (TbEmpleado tbEmpleadoListTbEmpleado : tbTempleado.getTbEmpleadoList()) {
                TbTempleado oldIdTemplOfTbEmpleadoListTbEmpleado = tbEmpleadoListTbEmpleado.getIdTempl();
                tbEmpleadoListTbEmpleado.setIdTempl(tbTempleado);
                tbEmpleadoListTbEmpleado = em.merge(tbEmpleadoListTbEmpleado);
                if (oldIdTemplOfTbEmpleadoListTbEmpleado != null) {
                    oldIdTemplOfTbEmpleadoListTbEmpleado.getTbEmpleadoList().remove(tbEmpleadoListTbEmpleado);
                    oldIdTemplOfTbEmpleadoListTbEmpleado = em.merge(oldIdTemplOfTbEmpleadoListTbEmpleado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbTempleado tbTempleado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbTempleado persistentTbTempleado = em.find(TbTempleado.class, tbTempleado.getIdTempl());
            List<TbEmpleado> tbEmpleadoListOld = persistentTbTempleado.getTbEmpleadoList();
            List<TbEmpleado> tbEmpleadoListNew = tbTempleado.getTbEmpleadoList();
            List<String> illegalOrphanMessages = null;
            for (TbEmpleado tbEmpleadoListOldTbEmpleado : tbEmpleadoListOld) {
                if (!tbEmpleadoListNew.contains(tbEmpleadoListOldTbEmpleado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TbEmpleado " + tbEmpleadoListOldTbEmpleado + " since its idTempl field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TbEmpleado> attachedTbEmpleadoListNew = new ArrayList<TbEmpleado>();
            for (TbEmpleado tbEmpleadoListNewTbEmpleadoToAttach : tbEmpleadoListNew) {
                tbEmpleadoListNewTbEmpleadoToAttach = em.getReference(tbEmpleadoListNewTbEmpleadoToAttach.getClass(), tbEmpleadoListNewTbEmpleadoToAttach.getIdEmpl());
                attachedTbEmpleadoListNew.add(tbEmpleadoListNewTbEmpleadoToAttach);
            }
            tbEmpleadoListNew = attachedTbEmpleadoListNew;
            tbTempleado.setTbEmpleadoList(tbEmpleadoListNew);
            tbTempleado = em.merge(tbTempleado);
            for (TbEmpleado tbEmpleadoListNewTbEmpleado : tbEmpleadoListNew) {
                if (!tbEmpleadoListOld.contains(tbEmpleadoListNewTbEmpleado)) {
                    TbTempleado oldIdTemplOfTbEmpleadoListNewTbEmpleado = tbEmpleadoListNewTbEmpleado.getIdTempl();
                    tbEmpleadoListNewTbEmpleado.setIdTempl(tbTempleado);
                    tbEmpleadoListNewTbEmpleado = em.merge(tbEmpleadoListNewTbEmpleado);
                    if (oldIdTemplOfTbEmpleadoListNewTbEmpleado != null && !oldIdTemplOfTbEmpleadoListNewTbEmpleado.equals(tbTempleado)) {
                        oldIdTemplOfTbEmpleadoListNewTbEmpleado.getTbEmpleadoList().remove(tbEmpleadoListNewTbEmpleado);
                        oldIdTemplOfTbEmpleadoListNewTbEmpleado = em.merge(oldIdTemplOfTbEmpleadoListNewTbEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbTempleado.getIdTempl();
                if (findTbTempleado(id) == null) {
                    throw new NonexistentEntityException("The tbTempleado with id " + id + " no longer exists.");
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
            TbTempleado tbTempleado;
            try {
                tbTempleado = em.getReference(TbTempleado.class, id);
                tbTempleado.getIdTempl();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbTempleado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TbEmpleado> tbEmpleadoListOrphanCheck = tbTempleado.getTbEmpleadoList();
            for (TbEmpleado tbEmpleadoListOrphanCheckTbEmpleado : tbEmpleadoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TbTempleado (" + tbTempleado + ") cannot be destroyed since the TbEmpleado " + tbEmpleadoListOrphanCheckTbEmpleado + " in its tbEmpleadoList field has a non-nullable idTempl field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tbTempleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbTempleado> findTbTempleadoEntities() {
        return findTbTempleadoEntities(true, -1, -1);
    }

    public List<TbTempleado> findTbTempleadoEntities(int maxResults, int firstResult) {
        return findTbTempleadoEntities(false, maxResults, firstResult);
    }

    private List<TbTempleado> findTbTempleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbTempleado.class));
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

    public TbTempleado findTbTempleado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbTempleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbTempleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbTempleado> rt = cq.from(TbTempleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
