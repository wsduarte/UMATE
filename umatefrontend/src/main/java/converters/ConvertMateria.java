/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import convert.GConvert;
import dto.MateriaDTO;
import entities.Materia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class ConvertMateria extends GConvert<MateriaDTO, Materia>{

    public ConvertMateria() {
        super(MateriaDTO.class, Materia.class);
    }
    
    
}
