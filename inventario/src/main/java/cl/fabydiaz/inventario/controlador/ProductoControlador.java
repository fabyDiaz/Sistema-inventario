package cl.fabydiaz.inventario.controlador;

import cl.fabydiaz.inventario.modelo.Producto;
import cl.fabydiaz.inventario.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventario-app") //http://localhost:8080/inventario-app)
@CrossOrigin(value="http://localhost:4200") //puerto por defalut de angular
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProducto(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenido: ");
        productos.forEach(producto->logger.info(producto.toString()));
        return productos;
    }


}
