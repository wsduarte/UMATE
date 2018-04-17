/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Estudiante;
import entities.Pensum;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import persistenes.EstudiantePersistence;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class EstudianteLogic extends GLogic<Estudiante>{

    public EstudianteLogic() {
    }
    
    @Inject
    public EstudianteLogic(EstudiantePersistence persistence) {
        super(persistence, Estudiante.class);
    }
    
    public List<Estudiante> findByName(String name) {
        return getPersistence().findByName(name);
    }
    
    public Estudiante findByCode(String code) {
        return getPersistence().findByCode(code);
    }
    
    public Estudiante addPensum(String codigo, Pensum pensum) {
        Estudiante ret = findByCode(codigo);
        ret.setPensum(pensum);
        pensum.setEstudiante(ret);
        return ret;
    }
//    
    private EstudiantePersistence getPersistence() {
        return (EstudiantePersistence) persistence;
    }
    
}
