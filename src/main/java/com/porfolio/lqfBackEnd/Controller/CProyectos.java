package com.porfolio.lqfBackEnd.Controller;

import com.porfolio.lqfBackEnd.Dto.dtoProyectos;
import com.porfolio.lqfBackEnd.Entity.Proyectos;
import com.porfolio.lqfBackEnd.Service.SProyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.porfolio.lqfBackEnd.Security.Controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/proyectos")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://lqf-backend.onrender.com")
public class CProyectos {

    @Autowired
    SProyectos sProyectos;

// -----------------------------------------    Trae la lista ---------------------------------------------------
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
// -----------------------------------------  Fin de Trae la lista ----------------------------------------------
    
// -----------------------------------------------   Detail -----------------------------------------------------
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Proyectos persona = sProyectos.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
// ------------------------------------------------- Fin Detail -----------------------------------------------
   
// ------------------------------------------------- Borrado -----------------------------------------
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<?> delete(@PathVariable("id") int id) {
         if (!sProyectos.existsById(id)) {
             return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
         }
         sProyectos.delete(id);
         return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
     }
// ------------------------------------------- Fin del borrado ----------------------------------------------------

// --------------------------- Esta es la creacion de una educacion nueva -----------------------------------------
    @PostMapping("/create") 
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        
        
        // Probamos solo con el nombre en blanco y las validaciones correspondientes al nombre nomas
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (sProyectos.existsByNombre(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        // Probamos solo con el nombre en blanco y las validaciones correspondientes al nombre nomas

        Proyectos proyectos = new Proyectos(dtoproyectos.getNombre(), dtoproyectos.getFotoDescripcion(), dtoproyectos.getLink());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
//
    

// ------------------------------------------- Actualizar una educacion ---------------------------------------
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {

//    --------------------------------------------------------    Nombre   ----------------------------------------------------------------------
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        if (sProyectos.existsByNombre(dtoproyectos.getNombre()) && sProyectos.getByNombre(dtoproyectos.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        
//    --------------------------------------------------------    Foto Descripcion  -------------------------------------------------------------------

        if (sProyectos.existsByFotoDescripcion(dtoproyectos.getFotoDescripcion()) && sProyectos.getByFotoDescripcion(dtoproyectos.getFotoDescripcion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa ubicacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoproyectos.getFotoDescripcion())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
    
//    --------------------------------------------------------    link  -------------------------------------------------------------------

        if (sProyectos.existsByLink(dtoproyectos.getLink()) && sProyectos.getByLink(dtoproyectos.getLink()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa ubicacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoproyectos.getLink())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        
        // Aqui guardamos luego de haber pasado por todas las validaciones  ---------------------------------------------------------------------
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        // Guarda los atributos luego de completarlos o cargarlos -------------
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setFotoDescripcion(dtoproyectos.getFotoDescripcion());
        proyectos.setLink(dtoproyectos.getLink());

        // Guarda la persona --------------------------------------------------
        sProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);
    }
}
