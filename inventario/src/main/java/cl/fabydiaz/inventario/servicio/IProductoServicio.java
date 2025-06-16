package cl.fabydiaz.inventario.servicio;

import cl.fabydiaz.inventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    List<Producto> listarProductos();
    Producto buscarProductoPorId(Integer idProduct);
    Producto guardarProdducto(Producto producto);
    void eliminarProductPorId(Integer idProducto);
}
