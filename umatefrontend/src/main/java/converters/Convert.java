/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

/**
 *
 * @author ws.duarte
 */
public class Convert {
    
    public static final Convert CONVERT = new Convert();
    private static final ConvertEstudiante estudiante = new ConvertEstudiante();
    private static final ConvertMateria materia = new ConvertMateria();
    private static final ConvertPensum pensum = new ConvertPensum();
    private static final ConvertSemestre semestre = new ConvertSemestre();

    public Convert() {
        
    }

    public static ConvertEstudiante getEstudiante() {
        return estudiante;
    }

    public static ConvertMateria getMateria() {
        return materia;
    }

    public static ConvertPensum getPensum() {
        return pensum;
    }

    public static ConvertSemestre getSemestre() {
        return semestre;
    }

    public static Convert getConvert() {
        return CONVERT;
    }
}
