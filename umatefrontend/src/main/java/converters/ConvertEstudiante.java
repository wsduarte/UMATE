/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import convert.GConvert;
import dto.EstudianteDTO;
import entities.Estudiante;

/**
 *
 * @author ws.duarte
 */
public class ConvertEstudiante extends GConvert<EstudianteDTO, Estudiante>{

    public ConvertEstudiante() {
        super(EstudianteDTO.class, Estudiante.class);
    }
    
  
}
