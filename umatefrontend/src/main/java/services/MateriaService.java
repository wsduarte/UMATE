/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dto.MateriaDTO;
import logic.MateriaLogic;
import converters.Convert;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author ws.duarte
 */
@Path("matria")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MateriaService {
    
    
    private MateriaLogic logic;

    public MateriaService() {
        super();
    }
    
    @Inject
    public MateriaService(MateriaLogic logic) {
        this.logic = logic;
    }
    
    @POST
    public MateriaDTO add(MateriaDTO e) throws Exception {
        return Convert.getMateria().toDTO(logic.create(Convert.getMateria().toEntidad(e)));
    }
    
    @GET
    public List<MateriaDTO> findAll() throws Exception{
        return Convert.getMateria().toListDTO(logic.findAll());
    }
    
    @GET
    @Path("{code: [a-z][a-z]*}")
    public MateriaDTO findCode(@PathParam("code") String code) throws Exception{
        return Convert.getMateria().toDTO(logic.findByCode(code));
    }
    
    @GET
    @Path("{name: [a-z][a-z]*}")
    public List<MateriaDTO> findName(@PathParam("name") String name ) throws Exception{
        return Convert.getMateria().toListDTO(logic.findByName(name));
    }
    
    @PUT
    @Path("{code: [a-z][a-z]*}")
    public MateriaDTO update(MateriaDTO e, @PathParam("code") String code) throws Exception {
        return Convert.getMateria().toDTO(logic.update(Convert.getMateria().toEntidad(e),logic.findByCode(code).getId()));
    }
    
    @DELETE
    @Path("{code: [a-z][a-z]*}")
    public MateriaDTO delete(@PathParam("code") String code) throws Exception {
        return Convert.getMateria().toDTO(logic.delete(logic.findByCode(code).getId()));
    }
    
    
    
}
