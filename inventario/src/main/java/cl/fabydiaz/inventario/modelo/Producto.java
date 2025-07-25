package cl.fabydiaz.inventario.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdProducto;
    private String descripcion;
    private Double precio;
    private Integer existencias;
    @ManyToOne
    @JoinColumn(name = "usuario_id") // nombre de la columna FK
    private Usuario usuario;
}
