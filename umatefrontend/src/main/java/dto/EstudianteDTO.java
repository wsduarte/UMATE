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
public class EstudianteDTO {
    
    private String nombre;
    private List<String> carreras;
    private String codigo;
    private Integer semestreActual;
    private PensumDTO pensum;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<String> carreras) {
        this.carreras = carreras;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(Integer semestreActual) {
        this.semestreActual = semestreActual;
    }

    public PensumDTO getPensum() {
        return pensum;
    }

    public void setPensum(PensumDTO pensum) {
        this.pensum = pensum;
    }
    
    
}
