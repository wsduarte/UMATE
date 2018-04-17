/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Pensum;
import entities.Semestre;
import java.util.ArrayList;
import javax.inject.Inject;
import persistenes.PensumPersistence;

/**
 *
 * @author ws.duarte
 */
public class PensumLogic extends GLogic<Pensum>{

    public PensumLogic() {
    }
    
    @Inject
    public PensumLogic(PensumPersistence persistence) {
        super(persistence,Pensum.class);
    }
    
    public Pensum findByName(String carrera) {
        return getPersistence().findByName(carrera);
    }
    
    public Pensum findByStudent(String nameStudent) {
        return getPersistence().findByStudent(nameStudent);
    }
    
    public Pensum addSemestre(String carrera, Semestre semestre) {
        Pensum ret = findByName(carrera);
        if(ret.getSemestres() == null) ret.setSemestres(new ArrayList<Semestre>());
        ret.getSemestres().add(semestre);
        semestre.setPensum(ret);
        return ret;
    }
    
    private PensumPersistence getPersistence() {
        return (PensumPersistence) persistence;
    }
}
