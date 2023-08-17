package org.bgonzalez.appmockito.ejemplos.services;

import org.bgonzalez.appmockito.ejemplos.models.Examen;
import org.bgonzalez.appmockito.ejemplos.repositories.ExamenRepository;
import org.bgonzalez.appmockito.ejemplos.repositories.PreguntasReposiory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamenServiceImplTest {
    ExamenRepository repository;
    ExamenService service;

    PreguntasReposiory preguntasReposiory;


    @BeforeEach
    void setUp(){
        preguntasReposiory = mock(PreguntasReposiory.class);
        repository = mock(ExamenRepository.class);
        service = new ExamenServiceImpl(repository, preguntasReposiory);
    }

    @Test
    void findExamenPorNombre() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matemáticas", examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");
        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasReposiory.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("integrales"));
    }
}