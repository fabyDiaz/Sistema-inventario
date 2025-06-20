package cl.fabydiaz.inventario.controlador;

import cl.fabydiaz.inventario.modelo.Producto;
import cl.fabydiaz.inventario.modelo.Usuario;
import cl.fabydiaz.inventario.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventario-app")
public class UsuarioController {

    @Autowired
    UsuarioServicio usuarioServicio;

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
        logger.info("Porducto a agregar: "+ usuario);
        Usuario nuevo = usuarioServicio.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevo);
    }


}
