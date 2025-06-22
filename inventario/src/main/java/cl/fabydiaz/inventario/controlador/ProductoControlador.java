package cl.fabydiaz.inventario.controlador;

import cl.fabydiaz.inventario.dto.ProductoDTO;
import cl.fabydiaz.inventario.modelo.Producto;
import cl.fabydiaz.inventario.servicio.ProductoServicio;
import cl.fabydiaz.inventario.excepcion.RecursoNoEncontradoExcepcion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventario-app") //http://localhost:8080/inventario-app)
//@CrossOrigin(value="http://localhost:4200") //puerto por defalut de angular
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private ProductoServicio productoServicio;

   /* @GetMapping("/productos")
    public List<Producto> obtenerProducto(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenido: ");
        productos.forEach(producto->logger.info(producto.toString()));
        return productos;
    }*/

    @GetMapping("/mis-productos")
    public ResponseEntity<List<ProductoDTO>> obtenerMisProductos(Authentication authentication) {
        List<ProductoDTO> productos = productoServicio.obtenerProductosDelUsuarioAutenticado(authentication);
        return ResponseEntity.ok(productos);
    }

    /*@PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto, ){
        logger.info("Porducto a agregar: "+ producto);
        return this.productoServicio.guardarProducto(producto);
    }*/

    @PostMapping("/agregar-producto")
    public ResponseEntity<ProductoDTO> agregarProducto(@RequestBody Producto producto, Authentication authentication) {
        ProductoDTO guardado = productoServicio.guardarProductoParaUsuarioAutenticado(producto, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> obtenerProuctoPorId(@PathVariable Integer id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto != null){
            return ResponseEntity.ok(producto);
        }else{
            throw  new RecursoNoEncontradoExcepcion("No se encontró el producto");
        }
    }





}
