package edu.coderhouse.FacturacionPrimeraEntrega.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "VENTA")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idventa;
    @Column(name = "TIPOFACTURA")
    private char tipofactura;
    @Column(name = "FACTURA")
    private int factura;
    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "TOTAL")
    private int total;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
       private List<VentaProducto> ventaProductos;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(char tipofactura, int factura, Date fecha, int total, List<VentaProducto> ventaProductos, Cliente cliente) {
        this.tipofactura = tipofactura;
        this.factura = factura;
        this.fecha = fecha;
        this.total = total;
        this.ventaProductos = ventaProductos;
        this.cliente = cliente;
    }

    public Long getIdventa() {
        return idventa;
    }

     public char getTipofactura() {
        return tipofactura;
    }

    public void setTipofactura(char tipofactura) {
        this.tipofactura = tipofactura;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<VentaProducto> getVentaProductos() {
        return ventaProductos;
    }

    public void setVentaProductos(List<VentaProducto> ventaProductos) {
        this.ventaProductos = ventaProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return idventa == venta.idventa && tipofactura == venta.tipofactura && factura == venta.factura && total == venta.total && Objects.equals(fecha, venta.fecha) && Objects.equals(ventaProductos, venta.ventaProductos) && Objects.equals(cliente, venta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idventa, tipofactura, factura, fecha, total, ventaProductos, cliente);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idventa=" + idventa +
                ", tipofactura=" + tipofactura +
                ", factura=" + factura +
                ", fecha=" + fecha +
                ", total=" + total +
                ", ventaProductos=" + ventaProductos +
                ", cliente=" + cliente +
                '}';
    }
}
// RESTO DE LOS MÉTODOS}
