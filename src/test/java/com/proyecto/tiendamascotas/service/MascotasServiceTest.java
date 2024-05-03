package com.proyecto.tiendamascotas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.proyecto.tiendamascotas.model.Mascotas;
import com.proyecto.tiendamascotas.repository.MascotasRepository;


@ExtendWith(MockitoExtension.class)
public class MascotasServiceTest {
    @InjectMocks
    private MascotasServiceImpl mascotaService;

    @Mock
    private MascotasRepository mascotasRepositoryMock;

    @Test
    public void guardarMascotaTest() {

        Mascotas mascotas = new Mascotas();
        mascotas.setDescripcion("Productos de perro");

        when(mascotasRepositoryMock.save(any())).thenReturn(mascotas);

        Mascotas resultado = mascotaService.createMascotas(mascotas);

        assertEquals("Productos de perro", resultado.getDescripcion());
    }
}
