package cl.fabydiaz.inventario.servicio;

import cl.fabydiaz.inventario.dto.UsuarioDTO;
import cl.fabydiaz.inventario.modelo.Usuario;
import cl.fabydiaz.inventario.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements IUsuarioServicio{
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UsuarioDTO guardarUsuario(Usuario usuario) {
        String contrasenaEncriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(contrasenaEncriptada);
        Usuario usuarioGuardado =  usuarioRepositorio.save(usuario);

        return UsuarioDTO.builder()
                .idUsuario(usuarioGuardado.getIdUsuario())
                .usuario(usuarioGuardado.getUsuario())
                .email(usuarioGuardado.getEmail())
                .build();
    }
}
