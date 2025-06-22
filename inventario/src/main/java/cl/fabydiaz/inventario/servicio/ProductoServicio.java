package cl.fabydiaz.inventario.servicio;

import cl.fabydiaz.inventario.dto.ProductoDTO;
import cl.fabydiaz.inventario.dto.UsuarioDTO;
import cl.fabydiaz.inventario.modelo.Producto;
import cl.fabydiaz.inventario.modelo.Usuario;
import cl.fabydiaz.inventario.repositorio.ProductoRespositorio;
import cl.fabydiaz.inventario.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    ProductoRespositorio productoRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepositorio.findAll();

    }

    public List<ProductoDTO> obtenerProductosDelUsuarioAutenticado(Authentication authentication) {
        String nombreUsuario = authentication.getName(); // nombre desde el token
        Usuario usuario = usuarioRepositorio.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        List<Producto> productos = productoRepositorio.findByUsuarioIdUsuario(usuario.getIdUsuario());

        return productos.stream().map(producto -> ProductoDTO.builder()
                .IdProducto(producto.getIdProducto())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .existencias(producto.getExistencias())
                .usuarioId(producto.getUsuario().getIdUsuario())
                .build()).collect(Collectors.toList());
    }



    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepositorio.save(producto);
    }
    @Override
    public ProductoDTO guardarProductoParaUsuarioAutenticado(Producto producto, Authentication authentication) {
        // 1. Obtener nombre de usuario desde el token
        String nombreUsuario = authentication.getName();

        // 2. Buscar el usuario en la base de datos
        Usuario usuario = usuarioRepositorio.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // 3. Asociar el producto con el usuario
        producto.setUsuario(usuario);

        // 4. Guardar producto
        Producto productoGuardado =  productoRepositorio.save(producto);

        return ProductoDTO.builder()
                .IdProducto(productoGuardado.getIdProducto())
                .descripcion(productoGuardado.getDescripcion())
                .precio(productoGuardado.getPrecio())
                .existencias(productoGuardado.getExistencias())
                .usuarioId(productoGuardado.getUsuario().getIdUsuario())
                .build();
    }


    @Override
    public void eliminarProductPorId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }
}
