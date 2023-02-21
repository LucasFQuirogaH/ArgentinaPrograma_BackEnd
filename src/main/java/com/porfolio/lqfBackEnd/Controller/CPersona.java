package com.porfolio.lqfBackEnd.Controller;

import com.porfolio.lqfBackEnd.Dto.dtoPersona;
import com.porfolio.lqfBackEnd.Entity.Persona;
import com.porfolio.lqfBackEnd.Security.Controller.Mensaje;
import com.porfolio.lqfBackEnd.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://lqf-backend.onrender.com")
public class CPersona {
    @Autowired
    private SPersona sPersona;

// -----------------------------------------    Trae la lista ---------------------------------------------------
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
// -----------------------------------------  Fin de Trae la lista ----------------------------------------------
    
// -----------------------------------------------   Detail -----------------------------------------------------
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
// ------------------------------------------------- Fin Detail -----------------------------------------------
   
// ------------------------------------------- Actualizar una educacion ---------------------------------------
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {

//    --------------------------------------------------------    Nombre completo  -------------------------------------------------------------------
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        if (sPersona.existsByNombreCompleto(dtopersona.getNombreCompleto()) && sPersona.getByNombreCompleto(dtopersona.getNombreCompleto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getNombreCompleto())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
//    --------------------------------------------------------    Profesion  -------------------------------------------------------------------

        if (sPersona.existsByProfesion(dtopersona.getProfesion()) && sPersona.getByProfesion(dtopersona.getProfesion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getProfesion())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
//    --------------------------------------------------------    Ubicacion  -------------------------------------------------------------------

        if (sPersona.existsByUbicacion(dtopersona.getUbicacion()) && sPersona.getByUbicacion(dtopersona.getUbicacion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa ubicacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getProfesion())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
//    --------------------------------------------------------    Foto Perfil  -------------------------------------------------------------------

        if (sPersona.existsByFotoPerfil(dtopersona.getFotoPerfil()) && sPersona.getByFotoPerfil(dtopersona.getFotoPerfil()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa ubicacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getFotoPerfil())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
    
//    --------------------------------------------------------   Foto Portada  -------------------------------------------------------------------

        if (sPersona.existsByFotoPortada(dtopersona.getFotoPortada()) && sPersona.getByFotoPortada(dtopersona.getFotoPortada()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa ubicacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getFotoPortada())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = sPersona.getOne(id).get();
        // Guarda los atributos luego de completarlos o cargarlos -------------
        persona.setNombreCompleto(dtopersona.getNombreCompleto());
        persona.setProfesion(dtopersona.getProfesion());
        persona.setUbicacion(dtopersona.getUbicacion());
        persona.setFotoPerfil(dtopersona.getFotoPerfil());
        persona.setFotoPortada(dtopersona.getFotoPortada());

        // Guarda la persona --------------------------------------------------
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
