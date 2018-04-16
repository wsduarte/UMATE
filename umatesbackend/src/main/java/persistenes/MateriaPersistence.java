/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenes;

import entities.Materia;
import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class MateriaPersistence extends GPersistence<Materia>{

    public MateriaPersistence() {
        this.clase = Materia.class;
    }
    
    public Materia findByCode(String code) {
        return find("codigo", code).get(0);
    }
    
    public List<Materia> findByName(String name) {
        return find("nombre", name);
    }
    
}
