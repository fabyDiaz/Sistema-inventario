package cl.fabydiaz.inventario.servicio;

import cl.fabydiaz.inventario.modelo.Producto;
import cl.fabydiaz.inventario.repositorio.ProductoRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    ProductoRespositorio productoRespositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRespositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = this.productoRespositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRespositorio.save(producto);

    }

    @Override
    public void eliminarProductPorId(Integer idProducto) {
        this.productoRespositorio.deleteById(idProducto);
    }
}
