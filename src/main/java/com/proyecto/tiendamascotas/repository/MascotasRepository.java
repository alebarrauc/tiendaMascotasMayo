package com.proyecto.tiendamascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.tiendamascotas.model.Mascotas;


public interface MascotasRepository extends JpaRepository<Mascotas, Long> {

}
