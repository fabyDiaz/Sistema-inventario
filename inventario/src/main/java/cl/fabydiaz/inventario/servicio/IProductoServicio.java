package cl.fabydiaz.inventario.servicio;

import cl.fabydiaz.inventario.dto.ProductoDTO;
import cl.fabydiaz.inventario.modelo.Producto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IProductoServicio {

    List<Producto> listarProductos();
    List<ProductoDTO> obtenerProductosDelUsuarioAutenticado(Authentication authentication);
    Producto buscarProductoPorId(Integer idProduct);
    Producto guardarProducto(Producto producto);
    ProductoDTO guardarProductoParaUsuarioAutenticado(Producto producto, Authentication authentication);
    void eliminarProductPorId(Integer idProducto);
}
