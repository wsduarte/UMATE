/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Semestre;
import entities.Materia;
import javax.ejb.Stateless;
import javax.inject.Inject;
import persistenes.SemestrePersistence;
import java.util.ArrayList;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class SemestreLogic extends GLogic<Semestre> {
    
    public SemestreLogic() {
    }
    
    @Inject
    public SemestreLogic(SemestrePersistence persistence) {
        super(persistence, Semestre.class);
    }
    
    public Semestre findByNumber(String carrera, Integer number) {
        return getPersistence().findByNumber(carrera, number);
    }
    
    public Semestre addMateria(String carrera, Integer numero, Materia materia ){
        Semestre temp = findByNumber(carrera, numero);
        if(temp.getMaterias() == null) temp.setMaterias(new ArrayList<Materia>());
        temp.getMaterias().add(materia);
        materia.setSemestre(temp);
        return temp;
    }
    
    private SemestrePersistence getPersistence() {
        return (SemestrePersistence) persistence;
    }
}
