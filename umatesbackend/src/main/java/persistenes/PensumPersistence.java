/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenes;

import entities.Pensum;
import javax.ejb.Stateless;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class PensumPersistence extends GPersistence<Pensum>{

    public PensumPersistence() {
        this.clase = Pensum.class;
    }
    
    public Pensum findByName(String name) {
        return find("carrera", name).get(0);
    }
    
    public Pensum findByStudent(String nameStudent) {
        return find("estudiante.nombre", nameStudent).get(0);
    }
}
