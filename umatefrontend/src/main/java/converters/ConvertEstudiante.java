/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dto.EstudianteDTO;
import entities.Estudiante;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class ConvertEstudiante {
    
    public static Estudiante toEntity(EstudianteDTO e) {
        Estudiante ret = new Estudiante();
        ret.setCarreras(e.getCarreras());
        ret.setCodigo(e.getCodigo());
        ret.setNombre(e.getNombre());
        ret.setSemestreActual(e.getSemestreActual());
        return ret;
    }
    
    public static EstudianteDTO toDTO(Estudiante e) {
        EstudianteDTO ret = new EstudianteDTO();
        ret.setCarreras(e.getCarreras());
        ret.setCodigo(e.getCodigo());
        ret.setNombre(e.getNombre());
        ret.setSemestreActual(e.getSemestreActual());
        return ret;
    }
    
    public static List<Estudiante> toListEntity(List<EstudianteDTO> list) {
        List<Estudiante> ret = new ArrayList<>();
        for (EstudianteDTO estudiante : list) {
            ret.add(toEntity(estudiante));
        }
        return ret;
    }
    
    public static List<EstudianteDTO> toListDTO(List<Estudiante> list) {
        List<EstudianteDTO> ret = new ArrayList<>();
        for (Estudiante estudiante : list) {
            ret.add(toDTO(estudiante));
        }
        return ret;
    }
}
