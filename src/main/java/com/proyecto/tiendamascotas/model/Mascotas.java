package com.proyecto.tiendamascotas.model;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name ="mascotas")
public class Mascotas extends RepresentationModel<Mascotas> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mascota")
    private Long id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="valor")
    private double valor;
    @Column(name="fecha")
    private LocalDate fecha;

    // Getters y Setters
    // Método getter para 'id'
    public Long getId() {
        return id;
    }

    // Método getter para 'descripcion'
    public String getDescripcion() {
        return descripcion;
    }

    // Método getter para 'cantidad'
    public int getCantidad() {
        return cantidad;
    }

    // Método getter para 'valor'
    public double getValor() {
        return valor;
    }

    // Método getter para 'fecha'
    public LocalDate getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
