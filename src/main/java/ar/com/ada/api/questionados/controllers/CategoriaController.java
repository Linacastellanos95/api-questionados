package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.services.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    //GET/categorias
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias() {
        return ResponseEntity.ok(service.traerCategorias());
    }
    
    
    
}
