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
public class Pensum {
    private String numero;
	private List<MeteriaFiltro> materias;
	
	
	
	public Pensum(String numero, List<MeteriaFiltro> materias) {
		super();
		this.numero = numero;
		this.materias = materias;
	}
	
	public Pensum()
	{
		super();
		this.numero = numero;
		this.materias = materias;
	}
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<MeteriaFiltro> getMaterias() {
		return materias;
	}
	public void setMaterias(List<MeteriaFiltro> materias) {
		this.materias = materias;
	}
	
}
