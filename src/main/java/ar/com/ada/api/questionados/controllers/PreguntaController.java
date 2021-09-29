package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {

    @Autowired
    private PreguntaService service;
    
    //GET/preguntas
    @GetMapping("/preguntas")
    public ResponseEntity<List<Pregunta>> traerPreguntas() {
        return ResponseEntity.ok(service.traerPreguntas());
    }
    
    //GET /preguntas/{id} 
    @GetMapping("/preguntas/{id}")
    public ResponseEntity<Pregunta> traerPreguntaPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.traerPreguntaPorId(id));

    }

    //POST /preguntas
    @PostMapping("/preguntas")
    public ResponseEntity<?> crearPregunta(@RequestBody InfoPreguntaNueva preguntaInfo){
  
        GenericResponse respuesta = new GenericResponse();
        Pregunta pregunta = service.crearPregunta(preguntaInfo.enunciado, preguntaInfo.categoriaId, preguntaInfo.opciones);
        respuesta.isOk = true;
        respuesta.id = pregunta.getPreguntaId();
        respuesta.message = "La pregunta fue creada con exito";

        return ResponseEntity.ok(preguntaInfo);

    }


}
