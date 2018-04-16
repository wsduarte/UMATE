/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenes;

import entities.Estudiante;
import javax.ejb.Stateless;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class EstudiantePersistence extends GPersistence<Estudiante>{

    public EstudiantePersistence() {
        this.clase = Estudiante.class;
    }
    
    public Estudiante findByName(String name) {
        return find("nombre",name).get(0);
    }
    
    public Estudiante findByCode(String code) {
        return find("codigo",code).get(0);
    }
}
