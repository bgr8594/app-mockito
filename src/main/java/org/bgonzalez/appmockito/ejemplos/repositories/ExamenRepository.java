package org.bgonzalez.appmockito.ejemplos.repositories;

import org.bgonzalez.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
}
