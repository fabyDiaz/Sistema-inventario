package cl.fabydiaz.inventario.servicio;

import cl.fabydiaz.inventario.dto.UsuarioDTO;
import cl.fabydiaz.inventario.modelo.Usuario;

public interface IUsuarioServicio {

    UsuarioDTO guardarUsuario(Usuario usuario);
}
