package org.bgonzalez.appmockito.ejemplos.repositories;

import java.util.List;

public interface PreguntasReposiory {
    List<String> findPreguntasPorExamenId(Long id);
}
