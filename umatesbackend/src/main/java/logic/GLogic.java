/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.BaseEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import persistenes.GPersistence;

/**
 *
 * @author ws.duarte
 */
@Stateless
public abstract class GLogic <Entidad extends BaseEntity> {
    
    protected Class<Entidad> clase;
    protected GPersistence<Entidad> persistence;
    protected final Logger log = Logger.getLogger(this.getClass().getName());

    public GLogic() {}
    
    public GLogic(GPersistence<Entidad> persistence, Class<Entidad> clase) {
        this.persistence = persistence;
        this.clase = clase;
    }
    
    public Entidad create(Entidad entidad) throws Exception {
        logInf("Creando la entidad "+ clase.getSimpleName());
        if(exist(entidad)) logError("La entidad a crear ya existe");
        Entidad ret = persistence.create(entidad);
        logFine("La entidad ha sido creada");
        return ret;
    }
    
    public Entidad find(Long id) throws Exception {
        logInf("Consultado la entidad "+clase.getSimpleName()+" con id: "+id);
        Entidad ret = persistence.find(id);
        if(ret == null) logError("No se ha encontrado "+ clase.getSimpleName()+ " con id: "+id);
        return ret;
    }
    
    public List<Entidad> findAll() {
        logInf("Consultando todas las entidades "+clase.getSimpleName());
        List<Entidad> ret = persistence.findAll();
        logFine("La consulta fue exitosa");
        return ret;
    }
    
    public Entidad update(Entidad entidad, Long id) throws Exception {
        logInf("Actualizando la entidad con id: "+entidad.getId());
        entidad.setId(id);
        if(!exist(entidad)) logError("No se ha encontrado "+ clase.getSimpleName()+ " con id: "+entidad.getId());
        Entidad ret = persistence.update(entidad);
        return ret;
    }
    
    public Entidad delete(Long id) throws Exception{
        logInf("Eliminando la entidad con id");
        Entidad delete = persistence.find(id);
        if(delete == null) logError("No se ha encontrado "+ clase.getSimpleName()+ " con id: "+id);
        return persistence.delete(id);
    }
    
    protected boolean exist(Entidad entidad) {
        return entidad.getId() != null && persistence.find(entidad.getId()) != null;
    }
    
    protected void logInf(String msg) {
        log.log(Level.INFO, msg);
    }
    
    protected void logFine(String msg) {
        log.log(Level.FINE, msg);
    }
    
    protected void logError(String msg) throws Exception {
       log.log(Level.SEVERE, msg);
       throw new Exception(msg);
    }
}
