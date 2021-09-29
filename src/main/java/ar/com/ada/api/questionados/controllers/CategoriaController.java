package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.response.*;
import ar.com.ada.api.questionados.services.CategoriaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    // GET/categorias
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias() {
        return ResponseEntity.ok(service.traerCategorias());
    }

    // GET /categorias/{id}
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> traerCategoriaPorId(@RequestBody Integer id) {
        return ResponseEntity.ok(service.traerCategoriaPorId(id));
    }

    // POST /categorias
    @PostMapping(value = "/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {

        GenericResponse r = new GenericResponse();
        if (service.crearCategoria(categoria)) {
            r.id = categoria.getCategoriaId();
            r.isOk = true;
            r.message = "Categoria creada con exito";
            return ResponseEntity.ok(r);
        } else {
            r.isOk = false;
            r.message = "Esta categoria ya esta creada";
            return ResponseEntity.badRequest().body(r);
        }

    }
}
