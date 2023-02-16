package com.porfolio.lqfBackEnd.Security.Service;

import com.porfolio.lqfBackEnd.Security.Entity.Rol;
import com.porfolio.lqfBackEnd.Security.Enums.RolNombre;
import com.porfolio.lqfBackEnd.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional // Si una opracion falla hace un rolback y que se mantenga en un estado anterior
public class RolService {

    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
