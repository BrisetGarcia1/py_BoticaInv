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
import Entidad.TbDocumento;
import Entidad.TbEmpleado;
import Entidad.TbKardex;
import Entidad.TbProveedor;
import Negocio.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class TbKardexJpaController implements Serializable {

    public TbKardexJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbKardex tbKardex) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbProducto cbarrasProd = tbKardex.getCbarrasProd();
            if (cbarrasProd != null) {
                cbarrasProd = em.getReference(cbarrasProd.getClass(), cbarrasProd.getCbarrasProd());
                tbKardex.setCbarrasProd(cbarrasProd);
            }
            TbDocumento idDocumento = tbKardex.getIdDocumento();
            if (idDocumento != null) {
                idDocumento = em.getReference(idDocumento.getClass(), idDocumento.getIdDocumento());
                tbKardex.setIdDocumento(idDocumento);
            }
            TbEmpleado idEmpl = tbKardex.getIdEmpl();
            if (idEmpl != null) {
                idEmpl = em.getReference(idEmpl.getClass(), idEmpl.getIdEmpl());
                tbKardex.setIdEmpl(idEmpl);
            }
            TbProveedor idProv = tbKardex.getIdProv();
            if (idProv != null) {
                idProv = em.getReference(idProv.getClass(), idProv.getIdProv());
                tbKardex.setIdProv(idProv);
            }
            em.persist(tbKardex);
            if (cbarrasProd != null) {
                cbarrasProd.getTbKardexList().add(tbKardex);
                cbarrasProd = em.merge(cbarrasProd);
            }
            if (idDocumento != null) {
                idDocumento.getTbKardexList().add(tbKardex);
                idDocumento = em.merge(idDocumento);
            }
            if (idEmpl != null) {
                idEmpl.getTbKardexList().add(tbKardex);
                idEmpl = em.merge(idEmpl);
            }
            if (idProv != null) {
                idProv.getTbKardexList().add(tbKardex);
                idProv = em.merge(idProv);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbKardex tbKardex) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbKardex persistentTbKardex = em.find(TbKardex.class, tbKardex.getNtransaccionKar());
            TbProducto cbarrasProdOld = persistentTbKardex.getCbarrasProd();
            TbProducto cbarrasProdNew = tbKardex.getCbarrasProd();
            TbDocumento idDocumentoOld = persistentTbKardex.getIdDocumento();
            TbDocumento idDocumentoNew = tbKardex.getIdDocumento();
            TbEmpleado idEmplOld = persistentTbKardex.getIdEmpl();
            TbEmpleado idEmplNew = tbKardex.getIdEmpl();
            TbProveedor idProvOld = persistentTbKardex.getIdProv();
            TbProveedor idProvNew = tbKardex.getIdProv();
            if (cbarrasProdNew != null) {
                cbarrasProdNew = em.getReference(cbarrasProdNew.getClass(), cbarrasProdNew.getCbarrasProd());
                tbKardex.setCbarrasProd(cbarrasProdNew);
            }
            if (idDocumentoNew != null) {
                idDocumentoNew = em.getReference(idDocumentoNew.getClass(), idDocumentoNew.getIdDocumento());
                tbKardex.setIdDocumento(idDocumentoNew);
            }
            if (idEmplNew != null) {
                idEmplNew = em.getReference(idEmplNew.getClass(), idEmplNew.getIdEmpl());
                tbKardex.setIdEmpl(idEmplNew);
            }
            if (idProvNew != null) {
                idProvNew = em.getReference(idProvNew.getClass(), idProvNew.getIdProv());
                tbKardex.setIdProv(idProvNew);
            }
            tbKardex = em.merge(tbKardex);
            if (cbarrasProdOld != null && !cbarrasProdOld.equals(cbarrasProdNew)) {
                cbarrasProdOld.getTbKardexList().remove(tbKardex);
                cbarrasProdOld = em.merge(cbarrasProdOld);
            }
            if (cbarrasProdNew != null && !cbarrasProdNew.equals(cbarrasProdOld)) {
                cbarrasProdNew.getTbKardexList().add(tbKardex);
                cbarrasProdNew = em.merge(cbarrasProdNew);
            }
            if (idDocumentoOld != null && !idDocumentoOld.equals(idDocumentoNew)) {
                idDocumentoOld.getTbKardexList().remove(tbKardex);
                idDocumentoOld = em.merge(idDocumentoOld);
            }
            if (idDocumentoNew != null && !idDocumentoNew.equals(idDocumentoOld)) {
                idDocumentoNew.getTbKardexList().add(tbKardex);
                idDocumentoNew = em.merge(idDocumentoNew);
            }
            if (idEmplOld != null && !idEmplOld.equals(idEmplNew)) {
                idEmplOld.getTbKardexList().remove(tbKardex);
                idEmplOld = em.merge(idEmplOld);
            }
            if (idEmplNew != null && !idEmplNew.equals(idEmplOld)) {
                idEmplNew.getTbKardexList().add(tbKardex);
                idEmplNew = em.merge(idEmplNew);
            }
            if (idProvOld != null && !idProvOld.equals(idProvNew)) {
                idProvOld.getTbKardexList().remove(tbKardex);
                idProvOld = em.merge(idProvOld);
            }
            if (idProvNew != null && !idProvNew.equals(idProvOld)) {
                idProvNew.getTbKardexList().add(tbKardex);
                idProvNew = em.merge(idProvNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbKardex.getNtransaccionKar();
                if (findTbKardex(id) == null) {
                    throw new NonexistentEntityException("The tbKardex with id " + id + " no longer exists.");
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
            TbKardex tbKardex;
            try {
                tbKardex = em.getReference(TbKardex.class, id);
                tbKardex.getNtransaccionKar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbKardex with id " + id + " no longer exists.", enfe);
            }
            TbProducto cbarrasProd = tbKardex.getCbarrasProd();
            if (cbarrasProd != null) {
                cbarrasProd.getTbKardexList().remove(tbKardex);
                cbarrasProd = em.merge(cbarrasProd);
            }
            TbDocumento idDocumento = tbKardex.getIdDocumento();
            if (idDocumento != null) {
                idDocumento.getTbKardexList().remove(tbKardex);
                idDocumento = em.merge(idDocumento);
            }
            TbEmpleado idEmpl = tbKardex.getIdEmpl();
            if (idEmpl != null) {
                idEmpl.getTbKardexList().remove(tbKardex);
                idEmpl = em.merge(idEmpl);
            }
            TbProveedor idProv = tbKardex.getIdProv();
            if (idProv != null) {
                idProv.getTbKardexList().remove(tbKardex);
                idProv = em.merge(idProv);
            }
            em.remove(tbKardex);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbKardex> findTbKardexEntities() {
        return findTbKardexEntities(true, -1, -1);
    }

    public List<TbKardex> findTbKardexEntities(int maxResults, int firstResult) {
        return findTbKardexEntities(false, maxResults, firstResult);
    }

    private List<TbKardex> findTbKardexEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbKardex.class));
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

    public TbKardex findTbKardex(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbKardex.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbKardexCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbKardex> rt = cq.from(TbKardex.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
