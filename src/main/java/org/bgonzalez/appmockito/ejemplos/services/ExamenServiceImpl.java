package org.bgonzalez.appmockito.ejemplos.services;

import org.bgonzalez.appmockito.ejemplos.models.Examen;
import org.bgonzalez.appmockito.ejemplos.repositories.ExamenRepository;
import org.bgonzalez.appmockito.ejemplos.repositories.PreguntasReposiory;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
    private ExamenRepository examenRepository;
    private PreguntasReposiory preguntasReposiory;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntasReposiory preguntasReposiory) {
        this.examenRepository = examenRepository;
        this.preguntasReposiory = preguntasReposiory;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return this.examenRepository.findAll()
                .stream()
                .filter(e->e.getNombre().contains(nombre)).findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if(examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntasReposiory.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }
}
