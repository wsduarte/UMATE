/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenes;

import entities.Estudiante;
import java.util.List;
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
    
    public List<Estudiante> findByName(String name) {
        return find("nombre",name);
    }
    
    public Estudiante findByCode(String code) {
        return find("codigo",code).get(0);
    }
}
