package com.proyecto.tiendamascotas.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class MascotasTest {

    @Test
    public void testGettersAndSetters() {
        Mascotas mascota = new Mascotas();
        mascota.setId(1L);
        mascota.setDescripcion("Gato");


        assertEquals(1L, mascota.getId());
        assertEquals("Gato", mascota.getDescripcion());
   }
}


