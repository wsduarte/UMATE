/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import convert.GConvert;
import dto.PensumDTO;
import entities.Pensum;

/**
 *
 * @author ws.duarte
 */
public class ConvertPensum extends GConvert<PensumDTO, Pensum>{

    public ConvertPensum() {
        super(PensumDTO.class, Pensum.class);
    }
    
    
    
}
