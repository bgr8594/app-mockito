package org.bgonzalez.appmockito.ejemplos.repositories;

import java.util.List;

public interface PreguntasRepository {
    void guardarVarias(List<String> preguntas);
    List<String> findPreguntasPorExamenId(Long id);
}
