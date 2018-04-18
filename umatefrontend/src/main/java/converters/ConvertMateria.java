/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dto.MateriaDTO;
import entities.Materia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class ConvertMateria {
    
    public static Materia toEntity(MateriaDTO e) {
        Materia ret = new Materia();
        ret.setCodigo(e.getCodigo());
        ret.setCorequisitos(e.getCorequisitos());
        ret.setCreditos(e.getCreditos());
        ret.setNivel(e.getNivel());
        ret.setNombre(e.getNombre());
        ret.setPrerequisitos(e.getPrerequisitos());
        
        return ret;
    }
    
    public static MateriaDTO toDTO(Materia e) {
        MateriaDTO ret = new MateriaDTO();
        ret.setCodigo(e.getCodigo());
        ret.setCorequisitos(e.getCorequisitos());
        ret.setCreditos(e.getCreditos());
        ret.setNivel(e.getNivel());
        ret.setNombre(e.getNombre());
        ret.setPrerequisitos(e.getPrerequisitos());
        return ret;
    }
    
    public static List<Materia> toListEntity(List<MateriaDTO> list) {
        List<Materia> ret = new ArrayList<>();
        for (MateriaDTO estudiante : list) {
            ret.add(toEntity(estudiante));
        }
        return ret;
    }
    
    public static List<MateriaDTO> toListDTO(List<Materia> list) {
        List<MateriaDTO> ret = new ArrayList<>();
        for (Materia estudiante : list) {
            ret.add(toDTO(estudiante));
        }
        return ret;
    }
    
}
