/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.TbEmpleado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.TbTempleado;
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
public class TbEmpleadoJpaController implements Serializable {

    public TbEmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbEmpleado tbEmpleado) {
        if (tbEmpleado.getTbKardexList() == null) {
            tbEmpleado.setTbKardexList(new ArrayList<TbKardex>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbTempleado idTempl = tbEmpleado.getIdTempl();
            if (idTempl != null) {
                idTempl = em.getReference(idTempl.getClass(), idTempl.getIdTempl());
                tbEmpleado.setIdTempl(idTempl);
            }
            List<TbKardex> attachedTbKardexList = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListTbKardexToAttach : tbEmpleado.getTbKardexList()) {
                tbKardexListTbKardexToAttach = em.getReference(tbKardexListTbKardexToAttach.getClass(), tbKardexListTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexList.add(tbKardexListTbKardexToAttach);
            }
            tbEmpleado.setTbKardexList(attachedTbKardexList);
            em.persist(tbEmpleado);
            if (idTempl != null) {
                idTempl.getTbEmpleadoList().add(tbEmpleado);
                idTempl = em.merge(idTempl);
            }
            for (TbKardex tbKardexListTbKardex : tbEmpleado.getTbKardexList()) {
                TbEmpleado oldIdEmplOfTbKardexListTbKardex = tbKardexListTbKardex.getIdEmpl();
                tbKardexListTbKardex.setIdEmpl(tbEmpleado);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
                if (oldIdEmplOfTbKardexListTbKardex != null) {
                    oldIdEmplOfTbKardexListTbKardex.getTbKardexList().remove(tbKardexListTbKardex);
                    oldIdEmplOfTbKardexListTbKardex = em.merge(oldIdEmplOfTbKardexListTbKardex);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbEmpleado tbEmpleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbEmpleado persistentTbEmpleado = em.find(TbEmpleado.class, tbEmpleado.getIdEmpl());
            TbTempleado idTemplOld = persistentTbEmpleado.getIdTempl();
            TbTempleado idTemplNew = tbEmpleado.getIdTempl();
            List<TbKardex> tbKardexListOld = persistentTbEmpleado.getTbKardexList();
            List<TbKardex> tbKardexListNew = tbEmpleado.getTbKardexList();
            if (idTemplNew != null) {
                idTemplNew = em.getReference(idTemplNew.getClass(), idTemplNew.getIdTempl());
                tbEmpleado.setIdTempl(idTemplNew);
            }
            List<TbKardex> attachedTbKardexListNew = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListNewTbKardexToAttach : tbKardexListNew) {
                tbKardexListNewTbKardexToAttach = em.getReference(tbKardexListNewTbKardexToAttach.getClass(), tbKardexListNewTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexListNew.add(tbKardexListNewTbKardexToAttach);
            }
            tbKardexListNew = attachedTbKardexListNew;
            tbEmpleado.setTbKardexList(tbKardexListNew);
            tbEmpleado = em.merge(tbEmpleado);
            if (idTemplOld != null && !idTemplOld.equals(idTemplNew)) {
                idTemplOld.getTbEmpleadoList().remove(tbEmpleado);
                idTemplOld = em.merge(idTemplOld);
            }
            if (idTemplNew != null && !idTemplNew.equals(idTemplOld)) {
                idTemplNew.getTbEmpleadoList().add(tbEmpleado);
                idTemplNew = em.merge(idTemplNew);
            }
            for (TbKardex tbKardexListOldTbKardex : tbKardexListOld) {
                if (!tbKardexListNew.contains(tbKardexListOldTbKardex)) {
                    tbKardexListOldTbKardex.setIdEmpl(null);
                    tbKardexListOldTbKardex = em.merge(tbKardexListOldTbKardex);
                }
            }
            for (TbKardex tbKardexListNewTbKardex : tbKardexListNew) {
                if (!tbKardexListOld.contains(tbKardexListNewTbKardex)) {
                    TbEmpleado oldIdEmplOfTbKardexListNewTbKardex = tbKardexListNewTbKardex.getIdEmpl();
                    tbKardexListNewTbKardex.setIdEmpl(tbEmpleado);
                    tbKardexListNewTbKardex = em.merge(tbKardexListNewTbKardex);
                    if (oldIdEmplOfTbKardexListNewTbKardex != null && !oldIdEmplOfTbKardexListNewTbKardex.equals(tbEmpleado)) {
                        oldIdEmplOfTbKardexListNewTbKardex.getTbKardexList().remove(tbKardexListNewTbKardex);
                        oldIdEmplOfTbKardexListNewTbKardex = em.merge(oldIdEmplOfTbKardexListNewTbKardex);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbEmpleado.getIdEmpl();
                if (findTbEmpleado(id) == null) {
                    throw new NonexistentEntityException("The tbEmpleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void editFechaI(TbEmpleado tbEmpleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbEmpleado persistentTbEmpleado = findTbEmpleadodni(tbEmpleado.getDniEmpl());
            TbTempleado idTemplOld = persistentTbEmpleado.getIdTempl();
            TbTempleado idTemplNew = tbEmpleado.getIdTempl();
            List<TbKardex> tbKardexListOld = persistentTbEmpleado.getTbKardexList();
            List<TbKardex> tbKardexListNew = tbEmpleado.getTbKardexList();
            if (idTemplNew != null) {
                idTemplNew = em.getReference(idTemplNew.getClass(), idTemplNew.getIdTempl());
                tbEmpleado.setIdTempl(idTemplNew);
            }
            List<TbKardex> attachedTbKardexListNew = new ArrayList<TbKardex>();
            for (TbKardex tbKardexListNewTbKardexToAttach : tbKardexListNew) {
                tbKardexListNewTbKardexToAttach = em.getReference(tbKardexListNewTbKardexToAttach.getClass(), tbKardexListNewTbKardexToAttach.getNtransaccionKar());
                attachedTbKardexListNew.add(tbKardexListNewTbKardexToAttach);
            }
            tbKardexListNew = attachedTbKardexListNew;
            tbEmpleado.setTbKardexList(tbKardexListNew);
            tbEmpleado = em.merge(tbEmpleado);
            if (idTemplOld != null && !idTemplOld.equals(idTemplNew)) {
                idTemplOld.getTbEmpleadoList().remove(tbEmpleado);
                idTemplOld = em.merge(idTemplOld);
            }
            if (idTemplNew != null && !idTemplNew.equals(idTemplOld)) {
                idTemplNew.getTbEmpleadoList().add(tbEmpleado);
                idTemplNew = em.merge(idTemplNew);
            }
            for (TbKardex tbKardexListOldTbKardex : tbKardexListOld) {
                if (!tbKardexListNew.contains(tbKardexListOldTbKardex)) {
                    tbKardexListOldTbKardex.setIdEmpl(null);
                    tbKardexListOldTbKardex = em.merge(tbKardexListOldTbKardex);
                }
            }
            for (TbKardex tbKardexListNewTbKardex : tbKardexListNew) {
                if (!tbKardexListOld.contains(tbKardexListNewTbKardex)) {
                    TbEmpleado oldIdEmplOfTbKardexListNewTbKardex = tbKardexListNewTbKardex.getIdEmpl();
                    tbKardexListNewTbKardex.setIdEmpl(tbEmpleado);
                    tbKardexListNewTbKardex = em.merge(tbKardexListNewTbKardex);
                    if (oldIdEmplOfTbKardexListNewTbKardex != null && !oldIdEmplOfTbKardexListNewTbKardex.equals(tbEmpleado)) {
                        oldIdEmplOfTbKardexListNewTbKardex.getTbKardexList().remove(tbKardexListNewTbKardex);
                        oldIdEmplOfTbKardexListNewTbKardex = em.merge(oldIdEmplOfTbKardexListNewTbKardex);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbEmpleado.getIdEmpl();
                if (findTbEmpleado(id) == null) {
                    throw new NonexistentEntityException("The tbEmpleado with id " + id + " no longer exists.");
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
            TbEmpleado tbEmpleado;
            try {
                tbEmpleado = em.getReference(TbEmpleado.class, id);
                tbEmpleado.getIdEmpl();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbEmpleado with id " + id + " no longer exists.", enfe);
            }
            TbTempleado idTempl = tbEmpleado.getIdTempl();
            if (idTempl != null) {
                idTempl.getTbEmpleadoList().remove(tbEmpleado);
                idTempl = em.merge(idTempl);
            }
            List<TbKardex> tbKardexList = tbEmpleado.getTbKardexList();
            for (TbKardex tbKardexListTbKardex : tbKardexList) {
                tbKardexListTbKardex.setIdEmpl(null);
                tbKardexListTbKardex = em.merge(tbKardexListTbKardex);
            }
            em.remove(tbEmpleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbEmpleado> findTbEmpleadoEntities() {
        return findTbEmpleadoEntities(true, -1, -1);
    }

    public List<TbEmpleado> findTbEmpleadoEntities(int maxResults, int firstResult) {
        return findTbEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<TbEmpleado> findTbEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbEmpleado.class));
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

    public TbEmpleado findTbEmpleado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbEmpleado.class, id);
        } finally {
            em.close();
        }
    }
    
    public TbEmpleado findTbEmpleadodni(String dni) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbEmpleado.class, dni);
        } finally {
            em.close();
        }
    }

    public int getTbEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbEmpleado> rt = cq.from(TbEmpleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
