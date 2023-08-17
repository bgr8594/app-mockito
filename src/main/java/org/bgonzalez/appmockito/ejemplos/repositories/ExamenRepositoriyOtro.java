package org.bgonzalez.appmockito.ejemplos.repositories;

import org.bgonzalez.appmockito.ejemplos.models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepositoriyOtro implements ExamenRepository{
    @Override
    public List<Examen> findAll() {
        try {
            System.out.println("ExamenRepositoriyOtro");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
