package org.bgonzalez.appmockito.ejemplos.services;

import org.bgonzalez.appmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenService {
    Examen guardar(Examen examen);
    Optional<Examen> findExamenPorNombre(String nombre);
    Examen findExamenPorNombreConPreguntas(String nombre);
}
