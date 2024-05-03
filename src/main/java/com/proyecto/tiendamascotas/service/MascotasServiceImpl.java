package com.proyecto.tiendamascotas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tiendamascotas.model.Mascotas;
import com.proyecto.tiendamascotas.repository.MascotasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MascotasServiceImpl implements MascotasService{
    @Autowired
    private MascotasRepository MascotasRepository;

    @Override
    public List<Mascotas> getAllMascotas() {
        return MascotasRepository.findAll();
    }

    @Override
    public Optional<Mascotas> getMascotasById(Long id) {
        return MascotasRepository.findById(id);
    }
    
    @Override
    public Mascotas createMascotas(Mascotas mascota){
        return MascotasRepository.save(mascota);
    }

    @Override
    public Mascotas updateMascotas(Long id, Mascotas mascota){
        if(MascotasRepository.existsById(id)){
            mascota.setId(id);
            return MascotasRepository.save(mascota);
        }else{
                return null;
            }
        }
 
    @Override
    public void deleteMascotas(Long id){
        MascotasRepository.deleteById(id);;
    }
    
    }

