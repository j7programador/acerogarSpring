package com.example.acero.controller;

import com.example.acero.entity.Persona;
import com.example.acero.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="acerogar/personas")
@CrossOrigin("http://localhost:3000/")
public class PersonaController {

    @Autowired
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public Optional<Persona> obtenerPorId(@PathVariable("id") Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping
    public void  guardarActualizar(@RequestBody Persona persona) {
        personaService.guardarActualizar(persona);
    }

    @DeleteMapping("/{id}")
    public void  eliminar(@PathVariable("id") Long id) {
        personaService.eliminarPersona(id);
    }

}
