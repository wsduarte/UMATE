/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recomendacion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class Comparador {
    
    public static enum Criterio {
        PROMEDIO("promedioEstimado","PROMEDIO"), 
        DIFICULTAD("dificultadEstimada","DIFICULTAD"), 
        CREDITOS("creditos","CREDITOS");
        
        private final String atributo;
        private final String nombre;
        Criterio(String atributo, String nombre) {
            this.atributo = atributo;
            this.nombre = nombre;
        }

        public String getAtributo() {
            return atributo;
        }

        public String getNombre() {
            return nombre;
        }

        public static Criterio buscar(String nombre) {
            for(Criterio c : Criterio.values()){
                if(c.getNombre().equalsIgnoreCase(nombre))
                    return c;
            }
            return null;
        }
    }

    public static Comparator<MeteriaFiltro> filtrar(Criterio... criterios) {
        return (MeteriaFiltro o1, MeteriaFiltro o2) -> {
            try {
                int ret = 0;
                Field crit = null;
                for (Criterio string : criterios) {
                    crit = MeteriaFiltro.class.getField(string.getAtributo());
                    ret = (int) crit.getType().getMethod("compareTo", crit.getType()).invoke(crit.get(o1), crit.get(o2));
                    if (ret != 0) {
                        break;
                    }
                }
                return ret;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw new IllegalArgumentException("No se especifico adecuadamente el atributo de filtro");
            }
        };
    }
    
    

}
