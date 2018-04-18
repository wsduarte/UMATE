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
    private Integer promedioEstimado;
    private Integer dificultadEstimada;
    private Boolean obligatoria;
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
    
    
}
