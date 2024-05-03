package com.proyecto.tiendamascotas.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.proyecto.tiendamascotas.model.Mascotas;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MascotasRepositoryTest {
    @Autowired
    private MascotasRepository mascotasRepository;
    @Test
    public void guardarMascotaTest() {
        Mascotas mascotas = new Mascotas();
        mascotas.setDescripcion("repelente pulgas");

        Mascotas resultado = mascotasRepository.save(mascotas);

        assertNotNull(resultado.getId());
        assertEquals("repelente pulgas", resultado.getDescripcion());
    }    
}

