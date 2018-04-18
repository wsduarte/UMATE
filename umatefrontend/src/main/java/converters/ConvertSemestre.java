/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import convert.GConvert;
import dto.SemestreDTO;
import entities.Semestre;

/**
 *
 * @author ws.duarte
 */
public class ConvertSemestre extends GConvert<SemestreDTO, Semestre>{

    public ConvertSemestre() {
        super(SemestreDTO.class,Semestre.class);
    }
    
    
    
}
