package com.proyecto.tiendamascotas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import com.proyecto.tiendamascotas.model.Mascotas;
import com.proyecto.tiendamascotas.service.MascotasService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/mascotas")
public class MascotasController {

    private static final Logger log = LoggerFactory.getLogger(MascotasController.class);
    @Autowired
    private MascotasService mascotasService;


    @GetMapping
    public CollectionModel<EntityModel<Mascotas>> getAllMascotas() {
         List<Mascotas> mascotas = mascotasService.getAllMascotas();
        log.info("GET /mascotas");
        log.info("Retornando todos los productos");
        List<EntityModel<Mascotas>> mascotasResources = mascotas.stream()
            .map( mascota -> EntityModel.of(mascota,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotasById(mascota.getId())).withSelfRel()
            ))
            .collect(Collectors.toList());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas());
        CollectionModel<EntityModel<Mascotas>> resources = CollectionModel.of(mascotasResources, linkTo.withRel("mascotas"));
        return resources;
    }
         
    @GetMapping("/{id}")
    public EntityModel<Mascotas> getMascotasById(@PathVariable Long id){
        Optional<Mascotas> mascotas = mascotasService.getMascotasById(id);

        if (mascotas.isPresent()) {
            return EntityModel.of(mascotas.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotasById(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas()).withRel("pmascotas"));    
        }   else {
            throw new MascotasNotFoundException("Idmas cotas no encontrado: "+id);
        }
    } 

    @PostMapping
    public EntityModel<Mascotas> createMascotas (@RequestBody Mascotas Mascotas) {
    Mascotas createdMascotas = mascotasService.createMascotas (Mascotas); return EntityModel.of (createdMascotas,
    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotasById(createdMascotas.getId())).withSelfRel(),
    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas()).withRel("mascotas"));
    }

    @PutMapping("/{id}")
    public EntityModel<Mascotas> updateMascota (@PathVariable Long id, @RequestBody Mascotas Mascotas) {
    Mascotas updatedMascota = mascotasService.updateMascotas(id, Mascotas);
    return EntityModel.of (updatedMascota,
    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMascotasById(id)).withSelfRel(),
    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMascotas()).withRel("pelicula"));
    }


    @DeleteMapping("/{id}")
    public void deleteMascota (@PathVariable Long id) {
    mascotasService.deleteMascotas(id);
    }





}
