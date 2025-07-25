package cl.fabydiaz.inventario.repositorio;

import cl.fabydiaz.inventario.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.usuario = :username")
    Optional<Usuario> findByNombreUsuario(@Param("username") String username);

   Optional<Usuario> findById(Integer idUsuario);


}
