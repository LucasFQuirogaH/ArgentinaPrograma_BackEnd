package com.porfolio.lqfBackEnd.Security.Service;

import com.porfolio.lqfBackEnd.Security.Entity.Usuario;
import com.porfolio.lqfBackEnd.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    //Esta va a chequear si el nombre de usuario existe
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    //Esta chequea si el email existe
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }

}
