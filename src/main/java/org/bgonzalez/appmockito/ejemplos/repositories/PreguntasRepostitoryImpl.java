package org.bgonzalez.appmockito.ejemplos.repositories;

import org.bgonzalez.appmockito.ejemplos.Datos;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PreguntasRepostitoryImpl implements PreguntasRepository {
    @Override
    public void guardarVarias(List<String> preguntas) {
        System.out.println("PreguntasRepostitoryImpl.guardarVarias");
    }

    @Override
    public List<String> findPreguntasPorExamenId(Long id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("PreguntasRepostitoryImpl.findPreguntasPorExamenId");
        return Datos.PREGUNTAS;
    }
}
