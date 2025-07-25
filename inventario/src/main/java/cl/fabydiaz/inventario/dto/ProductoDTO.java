package cl.fabydiaz.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Integer IdProducto;
    private String descripcion;
    private Double precio;
    private Integer existencias;
    private Integer usuarioId;
}
