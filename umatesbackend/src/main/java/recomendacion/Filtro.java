/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recomendacion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import recomendacion.Comparador.Criterio;
import recomendacion.MeteriaFiltro;

/**
 *
 * @author ws.duarte
 */
public class Filtro {
	public static final String RUTA = "./data/IngSistemas.json";
	public static String inicio = "INICIO";
	private LinearProbingHashST<String, MeteriaFiltro> listaMaterias;
	private List<MeteriaFiltro> recado;
	private List<MeteriaFiltro> codigosVistos;
	private Criterio[] criterios;
	private List<MeteriaFiltro> p;
	private Pensum pen;

	public Filtro() throws Exception {
		listaMaterias = cargar(RUTA);
		criterios = Criterio.values();
		recado = new ArrayList<>();
		codigosVistos = new ArrayList<>();
		p = new ArrayList<>();
	}

	public void setCriterios(Criterio... criterios) {
		this.criterios = criterios;
	}


	public List<Pensum> proyección(Integer maxCreditod, Integer creditosMax) {
		List<Pensum> ret = new ArrayList<>();
		int pos = 0;
		ret.add(new Pensum("Semestre 1", recomendar(creditosMax)));
		maxCreditod-=creditosMax;
		while(maxCreditod - creditosMax >= 0) {
			ret.add(new Pensum("Semestre "+(pos+2), recomendarList(creditosMax)));
			pos++;
			maxCreditod-=creditosMax;
			for(MeteriaFiltro m : ret.get(pos).getMaterias()) {
				recado.remove(m);
			}

		}
		return ret;
	}

	public List<MeteriaFiltro> recomendar(Integer maxCreditos) {
		MeteriaFiltro[] recom = sucesoresArray(listaMaterias.get(inicio).getSucesores());
		return darSeleccionadas(recom, maxCreditos);
	}

	public List<MeteriaFiltro> recomendarList(Integer maxCreditos) {
		//recado.clear();

		p = pen.getMaterias();
		for (MeteriaFiltro s : p)
			for(MeteriaFiltro m : sucesoresList(s.getSucesores()))
				if(!codigosVistos.contains((m)) && !recado.contains(m))
					recado.add(m);
		MeteriaFiltro[] recom2 = recado.toArray(new MeteriaFiltro[] {});
		return darSeleccionadas(recom2, maxCreditos);
	}

	private List<MeteriaFiltro> darSeleccionadas(MeteriaFiltro[] array, Integer maxCreditos) {
		List<MeteriaFiltro> ret = new ArrayList<>();
		Arrays.sort(array, Comparador.filtrar(criterios));
		for (int i = 0; i < array.length; i++) {
			if (maxCreditos - array[i].getCreditos() >= 0) {
				ret.add(array[i]);
				maxCreditos -= array[i].getCreditos();
				codigosVistos.add(array[i]);
				
			} 
		}
		return ret;
	}

	private List<MeteriaFiltro> sucesoresList(List<String> codigos) {
		List<MeteriaFiltro> ret = new ArrayList<>();
		for (String s : codigos) {
//			if(!recado.contains(listaMaterias.get(s)))
				ret.add(listaMaterias.get(s));
		}
		return ret;
	}

	private MeteriaFiltro[] sucesoresArray(List<String> codigos) {
		MeteriaFiltro[] ret = new MeteriaFiltro[codigos.size()];
		int i = 0;
		for (String s : codigos)
//			if(!recado.contains(listaMaterias.get(s)))
			ret[i++] = listaMaterias.get(s);//recado.add();
		return ret;
	}

	//Cargar informacion

	private LinearProbingHashST<String, MeteriaFiltro> cargar(String ruta) throws Exception {
		pen = new Pensum();
		List<MeteriaFiltro> mf = new ArrayList<>();
		LinearProbingHashST<String, MeteriaFiltro> ret = new LinearProbingHashST<>();
		Random r = new Random();
		BufferedReader br = new BufferedReader(new FileReader("./data/MateriasSucesor.json"));
		br.readLine();
		for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
			linea = linea.substring(1, linea.length() - 2);
			String[] data = linea.split("/");
			String token = data[1].substring(0, data[1].length() - 1);
			data = data[0].split(",");
			MeteriaFiltro m = new MeteriaFiltro();
			m.setCodigo(re(data[0]));
			m.setPromedioEstimado(r.nextInt(501) / 100);
			m.setCreditos(Integer.parseInt(data[2]));
			m.setDificultadEstimada(m.getPromedioEstimado() / ((int) m.getCreditos()));
			m.setObligatoria(!data[1].equals("t"));
			m.setSucesores(sucesores(token));
			mf.add(m);
			ret.put(m.getCodigo(), m);
		}
		pen.setMaterias(mf);
		br.close();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonEjemplo = gson.toJson(mf);
        System.out.println(jsonEjemplo);
        String ruta1 = "./data/IngSistemas.json";
        PrintWriter pw = new PrintWriter(new FileWriter(ruta1));
        pw.print(jsonEjemplo);
        pw.close();
        
        /**
        for (int j = 0; j < mf.length; j++) {
			mf[j].setDificultadEstimada(mf[j].getCreditos()*mf[j].getPromedioEstimado());
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonEjemplo = gson.toJson(mf);
        System.out.println(jsonEjemplo);
        String ruta1 = "./data/IngSistemas.json";
        PrintWriter pw = new PrintWriter(new FileWriter(ruta1));
        pw.print(jsonEjemplo);
        pw.close();
         */
		return ret;
	}

	private List<String> sucesores(String token) {
		List<String> ret = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(token, ",");
		while (st.hasMoreElements())
			ret.add(re(st.nextToken()));
		return ret;
	}

	private String re(String r) {
		return r.substring(1, r.length() - 1);
	}

}
