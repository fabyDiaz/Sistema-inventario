package cl.fabydiaz.inventario.repositorio;

import cl.fabydiaz.inventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRespositorio extends JpaRepository<Producto, Integer> {

    @Override
    Optional<Producto> findById(Integer integer);
}
