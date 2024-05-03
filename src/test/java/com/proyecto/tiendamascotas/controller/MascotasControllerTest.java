package com.proyecto.tiendamascotas.controller;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.proyecto.tiendamascotas.model.Mascotas;
import com.proyecto.tiendamascotas.service.MascotasServiceImpl;

@WebMvcTest(MascotasController.class)
public class MascotasControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotasServiceImpl ventaServicioMock;

    private List<Mascotas> mascotas;

    @BeforeEach
    public void setUp() {
        Mascotas mascota1 = new Mascotas();
        mascota1.setDescripcion("Comida");
        mascota1.setId(1L);
      
        mascotas = Arrays.asList(mascota1);
    }

    @AfterEach
    public void tearDown() {
        mascotas = null;
    }

    @Test
    public void obtenerTodosTest() throws Exception {
        when(ventaServicioMock.getAllMascotas()).thenReturn(mascotas);
    
        mockMvc.perform(MockMvcRequestBuilders.get("/mascotas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.mascotasList", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.mascotasList[0].descripcion", Matchers.is("Comida")));
    }
    

}
