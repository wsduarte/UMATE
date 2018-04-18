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
    
    public String codigo; //llave
    //filtros <Con los que comparo>
    public Integer promedioEstimado;
    public Integer dificultadEstimada;
    public Boolean obligatoria;
    public Integer creditos;
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
