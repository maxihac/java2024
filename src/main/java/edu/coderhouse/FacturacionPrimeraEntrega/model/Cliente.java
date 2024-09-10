package edu.coderhouse.FacturacionPrimeraEntrega.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import  jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name="CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id unico de cliente",example = "1",accessMode = Schema.AccessMode.READ_ONLY)
    private Long idcliente;
    @Schema(description = "Nombre de cliente",example = "Maxi",requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "NOMBRE")     // se hace para mappear el nombre de la columna con la variable en Java
    private String nombre;
    @Schema(description = "Apellido de cliente",example = "Sterling",requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "APELLIDO")
    private String apellido;
    @Schema(description = "DNI de cliente",example = "26600777",requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "DNI")
    private long dni;
    @Schema(description = "Email de cliente",example = "maxsterling@gmail.com",requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "EMAIL")
    private String email;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de ventas del cliente",accessMode = Schema.AccessMode.READ_ONLY)
    @JsonBackReference
     private List<Venta> ventas;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni, String email, List<Venta> ventas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.ventas = ventas;
    }

    public Long getIdcliente() {
        return idcliente;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idcliente == cliente.idcliente && dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(email, cliente.email) && Objects.equals(ventas, cliente.ventas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente, nombre, apellido, dni, email, ventas);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idcliente=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", ventas=" + ventas +
                '}';
    }
}
