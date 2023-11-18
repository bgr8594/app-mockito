package org.bgonzalez.appmockito.ejemplos.services;

import org.bgonzalez.appmockito.ejemplos.models.Examen;
import org.bgonzalez.appmockito.ejemplos.repositories.ExamenRepository;
import org.bgonzalez.appmockito.ejemplos.repositories.PreguntasRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository examenRepository;
    private PreguntasRepository preguntasRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntasRepository preguntasRepository) {

        this.examenRepository = examenRepository;
        this.preguntasRepository = preguntasRepository;
    }

    @Override
    public Examen guardar(Examen examen) {
        if(!examen.getPreguntas().isEmpty()){
            preguntasRepository.guardarVarias(examen.getPreguntas());
        }
        return examenRepository.guardar(examen);
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll().stream().filter(
                e->e.getNombre().contains(nombre)
        ).findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if(examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntasRepository.findPreguntasPorExamenId(examenOptional.orElseThrow().getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }
}
