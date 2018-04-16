/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenes;

import entities.BaseEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author ws.duarte
 * @param <Entidad>
 */
@Stateless
public abstract class GPersistence <Entidad extends BaseEntity>
{
    protected Class<Entidad> clase;
    protected final Logger log = Logger.getLogger(this.getClass().getName());
    
    @PersistenceContext(unitName = "umatePU")
    protected EntityManager em;

    public GPersistence() {
    }
    
    public Entidad create(Entidad entidad) {
        logInf("Creado un nuevo "+clase.getSimpleName());
        if(entidad.getId() == null) entidad.setId(generatedID());
        em.persist(entidad);
        logFine("La entidad fue creada");
        return entidad;
    }
    
    public Entidad find(Long id) {
        logInf("Consultando "+clase.getSimpleName()+" por id"+id);
        return em.find(clase, id);
    }
    
    public List<Entidad> findAll() {
        logInf("Consultando todos los "+clase.getSimpleName());
        return em.createQuery("select u from " + clase.getSimpleName() + " u", clase).getResultList();
    }
    
    public Entidad update(Entidad entidad) {
        logInf("Alcualizando un "+clase.getSimpleName());
        Entidad ret = em.merge(entidad);
        logFine("La entidad "+clase.getSimpleName()+" fue actualizada correctamente");
        return ret;
    }
    
    public Entidad delete(Long id) {
        logInf("Eliminando un "+clase.getSimpleName());
        Entidad ret = find(id);
        em.remove(ret);
        logFine("Se elimino "+clase.getSimpleName()+" correctamente");
        return ret;
    }
    
    protected List<Entidad> find(String criterio, Object valor) {
        logInf("Inciando consulta de "+clase.getSimpleName()+" por cliterio "+criterio+" valor "+ valor);
        String query = "Select c FROM " + clase.getSimpleName() + " c where c."+criterio+" = :val";
        return em.createQuery(query, clase).setParameter("val", valor).getResultList();
    }
    
    protected List<Entidad> find(String[] criterios, Object[] valores) {
        logInf("Comenzando consulta multicriterio "+clase.getSimpleName());
        if(criterios.length != valores.length) throw new IllegalArgumentException("No se ingresaron adecuadamente los criterios y valores. \n Por cada criterio debe aver un valor");
        String queryS = "Select c FROM " + clase.getSimpleName() + " c where c."+criterios[0]+" = :val0";
        for(int i = 1; i < criterios.length; i++) queryS+= "and c."+criterios[i]+" = :val"+i;
        TypedQuery<Entidad> query = em.createQuery(queryS, clase);
        for(int i = 0; i < valores.length; i++) query.setParameter("val"+i, valores[i]);
        return query.getResultList();
    }
    
    private Long generatedID() {
        log.log(Level.INFO, "Generando el id automatico");
        return em.createQuery("select max(u.id)+1 from " + clase.getSimpleName() + " u", Long.class).getSingleResult();
    }
    
    protected void logInf(String msg) {
        log.log(Level.INFO, msg);
    }
    
    protected void logFine(String msg) {
        log.log(Level.FINE, msg);
    }
    
    protected void logError(String msg) {
       log.log(Level.SEVERE, msg);
    }
    
}