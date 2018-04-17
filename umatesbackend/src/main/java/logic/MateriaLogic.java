/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import persistenes.MateriaPersistence;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class MateriaLogic extends GLogic<Materia>{

    public MateriaLogic() {
    }
    
    @Inject
    public MateriaLogic(MateriaPersistence persistence) {
        super(persistence, Materia.class);
    }
    
    public Materia findByCode(String code) {
        logInf("Consultando materia por código: "+code);
        return getPersistence().findByCode(code);
    }
    
    public List<Materia> findByName(String name) {
        logInf("Consultadon materias por nombre: "+name);
        return getPersistence().findByName(name);
    }
    
    

    private MateriaPersistence getPersistence() {
        return (MateriaPersistence) persistence;
    }    
}
