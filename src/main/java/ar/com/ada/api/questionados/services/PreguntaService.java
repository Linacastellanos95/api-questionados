package ar.com.ada.api.questionados.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.questionados.entities.*;
import ar.com.ada.api.questionados.models.request.InfoPreguntaNueva;
import ar.com.ada.api.questionados.repos.PreguntaRepository;

@Service
public class PreguntaService {
    
    @Autowired
    private PreguntaRepository repo;

    @Autowired
    private CategoriaService categoriaService;

    public List<Pregunta> traerPreguntas(){
        return repo.findAll();
    }

    public Pregunta traerPreguntaPorId(Integer preguntaId){
        Optional<Pregunta> resultado = repo.findById(preguntaId);
       

        if(resultado.isPresent())
            return resultado.get();

        return null;
    }

    public Pregunta crearPregunta(String enunciado, Integer categoriaId, List<Respuesta> opciones ) {
        
        Pregunta pregunta = new Pregunta();
        pregunta.setEnunciado(enunciado);

        Categoria categoria = categoriaService.traerCategoriaPorId(categoriaId);

        pregunta.setCategoria(categoria);
      
        for (Respuesta respuesta: opciones) {
            respuesta.setPregunta(pregunta);
        }
        
        repo.save(pregunta);
        return pregunta;
    }
}