/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import entities.BaseEntity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ws.duarte
 * @param <DTO>
 * @param <Entidad>
 */
public abstract class GConvert<DTO, Entidad> {

    private Class<DTO> claseDTO;
    private Class<Entidad> claseEntidad;
    private Field[] fieldDTO;
    private Field[] fieldEntidad;

    public GConvert() {
    }

    public GConvert(Class<DTO> claseDTO, Class<Entidad> claseEntidad) {
        this.claseDTO = claseDTO;
        this.claseEntidad = claseEntidad;
        List<Field> tempDTO = new ArrayList<>();
        List<Field> tempEntidad = new ArrayList<>();
        fieldDTO = claseDTO.getDeclaredFields();
        fieldEntidad = claseEntidad.getDeclaredFields();
        if (fieldDTO.length > fieldEntidad.length) {
            throw new IllegalArgumentException("EL DTO no corresponde a la entidad");
        }
        for (int i = 0; i < fieldDTO.length; i++) {
            fieldDTO[i].setAccessible(true);
            fieldEntidad[i].setAccessible(true);
        }
        Comparator<Field> comp = (Field o1, Field o2) -> o1.getName().compareTo(o2.getName());
        Arrays.sort(fieldDTO, comp);
        Arrays.sort(fieldEntidad, comp);
        for (int i = 0; i < fieldEntidad.length; i++) {
            if (fieldDTO[i].getName().equals(fieldEntidad[i].getName()) 
                    && fieldDTO[i].getType().getName().equals(fieldEntidad[i].getType().getName()) 
                    && !fieldEntidad[i].getType().getSuperclass().getName().equals(BaseEntity.class.getName())) {
                tempDTO.add(fieldDTO[i]);
                tempEntidad.add(fieldEntidad[i]);
            }
        }
        this.fieldDTO = (Field[]) tempDTO.toArray();
        this.fieldEntidad = (Field[]) tempEntidad.toArray();
        System.out.println("Los atributos aceptados: "+Arrays.toString(fieldDTO));
    }

    public DTO toDTO(Entidad entidad) {
        DTO ret;
        try {
            ret = claseDTO.newInstance();
            for (int i = 0; i < fieldDTO.length; i++) {
                fieldDTO[i].set(ret, fieldEntidad[i].get(entidad));
            }
            return ret;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("No fue posible crear el DTO\n" + e.getMessage());
        }
    }

    public Entidad toEntidad(DTO entidad) {
        Entidad ret;
        try {
            ret = claseEntidad.newInstance();
            for (int i = 0; i < fieldEntidad.length; i++) {
                fieldEntidad[i].set(ret, fieldDTO[i].get(entidad));
            }
            return ret;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("No fue posible crear el DTO\n" + e.getMessage());
        }
    }

    public List<DTO> toListDTO(List<Entidad> listEntidad) {
        List<DTO> ret = new ArrayList<>();
        listEntidad.forEach((e) -> {
            ret.add(toDTO(e));
        });
        return ret;
    }

    public List<Entidad> toListEntidad(List<DTO> listDTO) {
        List<Entidad> ret = new ArrayList<>();
        listDTO.forEach((e) -> {
            ret.add(toEntidad(e));
        });
        return ret;
    }

}
