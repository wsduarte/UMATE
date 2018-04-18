/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class PensumDTO {
    
    private String carrera;
    private List<SemestreDTO> semestre;
    private EstudianteDTO estudiante;

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<SemestreDTO> getSemestre() {
        return semestre;
    }

    public void setSemestre(List<SemestreDTO> semestre) {
        this.semestre = semestre;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }
    
    
    
    
}
