package com.porfolio.lqfBackEnd.Controller;

import com.porfolio.lqfBackEnd.Dto.dtoEducacion;
import com.porfolio.lqfBackEnd.Entity.Educacion;
import com.porfolio.lqfBackEnd.Security.Controller.Mensaje;
import com.porfolio.lqfBackEnd.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://lqf-backend.onrender.com")
public class CEducacion {

    @Autowired
    SEducacion sEducacion;

// -----------------------------------------    Trae la lista -----------------------------------------
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
// -----------------------------------------  Fin de Trae la lista -------------------------------------
    
// -----------------------------------------------   Detail ---------------------------------------------
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
// ------------------------------------------------- Fin Detail -----------------------------------------


// ------------------------------------------------- Borrado -----------------------------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }
// ------------------------------------------- Fin del borrado ----------------------------------------------------

    
// --------------------------- Esta es la creacion de una educacion nueva -----------------------------------------
    @PostMapping("/create") 
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {

        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        // --------------------------------------------------------------------------Esto agregue
        // --------------------------------------------------------------------------Esto agregue
        //if (StringUtils.isBlank(dtoeducacion.getDescripcionE())) {
        //    return new ResponseEntity(new Mensaje("La descripcion tambien es obligatoria"), HttpStatus.BAD_REQUEST);
        //}
        // ------------------------------------------------------------------------- Fin de lo que agregue
        // ------------------------------------------------------------------------- Fin de lo que agregue

        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
// ------------------------------ fin de la creacion de una educacion nueva ---------------------------------------

    
    
// ------------------------------------------- Actualizar una educacion ---------------------------------------

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        if (sEducacion.existsByNombreE(dtoeducacion.getNombreE()) && sEducacion.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        
        // --------------------------------------------------------------------------Esto agregue
        // --------------------------------------------------------------------------Esto agregue
        //if (sEducacion.existsByNombreE(dtoeducacion.getDescripcionE()) && sEducacion.getByNombreE(dtoeducacion.getDescripcionE()).get().getId() != id) {
        //    return new ResponseEntity(new Mensaje("Esta descripcion ya existe"), HttpStatus.BAD_REQUEST);
        //} 
        // ------------------------------------------------------------------------- Fin de lo que agregue
        // ------------------------------------------------------------------------- Fin de lo que agregue
        
        
        
        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
