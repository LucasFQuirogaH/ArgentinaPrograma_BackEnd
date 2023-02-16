package com.porfolio.lqfBackEnd.Controller;

import com.porfolio.lqfBackEnd.Dto.dtoAcerca;
import com.porfolio.lqfBackEnd.Entity.Acerca;
import com.porfolio.lqfBackEnd.Security.Controller.Mensaje;
import com.porfolio.lqfBackEnd.Service.SAcerca;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acercade")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcerca {

    // ------------------------  Metodos ----------------------------
    @Autowired
    SAcerca sAcerca;

    @GetMapping("/lista")
    public ResponseEntity<List<Acerca>> list() {
        List<Acerca> list = sAcerca.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Acerca> getById(@PathVariable("id") int id) {
        if (!sAcerca.existsById(id))
        {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Acerca acerca = sAcerca.getOne(id).get();
        return new ResponseEntity(acerca, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sAcerca.existsById(id))
        {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sAcerca.delete(id);
        return new ResponseEntity(new Mensaje("Desripcion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcerca dtoacerca) {
        if (StringUtils.isBlank(dtoacerca.getDescripcion()))
        {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sAcerca.existsByDescripcion(dtoacerca.getDescripcion()))
        {
            return new ResponseEntity(new Mensaje("Esa acerca ya existe"), HttpStatus.BAD_REQUEST);
        }

        Acerca acerca = new Acerca(dtoacerca.getDescripcion());
        sAcerca.save(acerca);
        return new ResponseEntity(new Mensaje("Acerca agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcerca dtoacerca) {
        //Validas si existe o no el ID
        if (!sAcerca.existsById(id))
        {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Compara nombre de las acercas
        //if (sAcerca.existsByDescripcion(dtoacerca.getDescripcion()) && sAcerca.getByDescripcion(dtoacerca.getDescripcion()).get().getId() != id)
        //{
        //    return new ResponseEntity(new Mensaje("Esa acerca ya existe"), HttpStatus.BAD_REQUEST);
        //}

        //el campo no puede estar vacio
        if (StringUtils.isBlank(dtoacerca.getDescripcion()))
        {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //Luego de pasar todas estas validaciones recien vamos a actualizar el objeto
        Acerca acerca = sAcerca.getOne(id).get();
        acerca.setDescripcion(dtoacerca.getDescripcion());

        sAcerca.save(acerca);
        return new ResponseEntity(new Mensaje("Acerca actualizada"), HttpStatus.OK);
    }
    // ------------------------  Metodos ----------------------------
}
