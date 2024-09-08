package edu.coderhouse.FacturacionPrimeraEntrega.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id unico de producto",example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private int idProducto;
    @Schema(description = "Nombre de Producto",example = "Manzana",requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;
    @Schema(description = "Stock",example = "200",requiredMode = Schema.RequiredMode.REQUIRED)
    private int stock;
    @Schema(description = "Precio",example = "250.80",requiredMode = Schema.RequiredMode.REQUIRED)
    private Double precio;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonBackReference
    @Schema(description = "Lista de ventas del Producto",accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private List<VentaProducto> ventaProductos;

    public Producto() {
    }

    public Producto(String nombre, int stock, Double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<VentaProducto> getVentaProductos() {
        return ventaProductos;
    }

    public void setVentaProductos(List<VentaProducto> ventaProductos) {
        this.ventaProductos = ventaProductos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto && stock == producto.stock && Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(ventaProductos, producto.ventaProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre, stock, precio, ventaProductos);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", ventaProductos=" + ventaProductos +
                '}';
    }
}
