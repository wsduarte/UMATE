/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recomendacion;

import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class MeteriaFiltro {
    
    private String codigo; //llave
    //filtros <Con los que comparo>
    private Integer promedioEstimado;
    private Integer dificultadEstimada;
    private Boolean obligatoria;
    private Integer creditos;
    //materias que desbloquea
    
    private List<String> sucesores;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<String> getSucesores() {
        return sucesores;
    }

    public void setSucesores(List<String> sucesores) {
        this.sucesores = sucesores;
    }

    public Integer getPromedioEstimado() {
        return promedioEstimado;
    }

    public void setPromedioEstimado(Integer promedioEstimado) {
        this.promedioEstimado = promedioEstimado;
    }

    public Integer getDificultadEstimada() {
        return dificultadEstimada;
    }

    public void setDificultadEstimada(Integer dificultadEstimada) {
        this.dificultadEstimada = dificultadEstimada;
    }

    public Boolean getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(Boolean obligatoria) {
        this.obligatoria = obligatoria;
    }
    
    
}
