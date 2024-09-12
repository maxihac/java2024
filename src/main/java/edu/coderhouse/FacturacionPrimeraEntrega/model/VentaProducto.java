package edu.coderhouse.FacturacionPrimeraEntrega.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "VENTA_PRODUCTO")
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id unico de Venta_producto",example = "1",accessMode = Schema.AccessMode.READ_ONLY)

    private int idVentaProducto;
   @Schema(description = "Cantidad vendida",example = "5",requiredMode = Schema.RequiredMode.REQUIRED)

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    @Schema(hidden = true) // Ocultar en la documentación de Swagger
    @JsonBackReference
    private Venta venta;

    @ManyToOne
  //  @Schema(description = "Id producto asociado a la venta",example = "1",requiredMode = Schema.RequiredMode.REQUIRED)

    @JoinColumn(name = "id_producto")
    private Producto producto;

    public VentaProducto() {
    }

    public VentaProducto(Integer cantidad, Venta venta, Producto producto) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.producto = producto;
    }

    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaProducto that = (VentaProducto) o;
        return idVentaProducto == that.idVentaProducto && Objects.equals(cantidad, that.cantidad) && Objects.equals(venta, that.venta) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVentaProducto, cantidad, venta, producto);
    }

    @Override
    public String toString() {
        return "VentaProducto{" +
                "idVentaProducto=" + idVentaProducto +
                ", cantidad=" + cantidad +
                ", venta=" + venta +
                ", producto=" + producto +
                '}';
    }
}