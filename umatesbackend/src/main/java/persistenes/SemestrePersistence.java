/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenes;

import entities.Semestre;
import javax.ejb.Stateless;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class SemestrePersistence extends GPersistence<Semestre>{

    public SemestrePersistence() {
        this.clase = Semestre.class;
    }
    
    public Semestre findByNumber(String carrera, Integer numero) {
        return find(new String[]{"pensum.carrera", "numero"},new Object[]{carrera, numero}).get(0);
    }
    
}
