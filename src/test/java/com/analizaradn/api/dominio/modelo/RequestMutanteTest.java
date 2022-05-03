package com.analizaradn.api.dominio.modelo;

import com.analizaradn.api.BasePrueba;
import com.analizaradn.api.dominio.ValidadorArgumentosExcepcion;
import com.analizaradn.api.dominio.testdatabuilder.RequestMutanteTestDataBuilder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestMutanteTest {
    @Test
    public void validarRequestMutante(){
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        RequestMutante requestMutante = RequestMutante.builder().dna(adn).build();
        assertEquals(adn,requestMutante.getDna());
    }
    @Test
    public void validarTamañoDelArreglo(){
        String[] adn = {"ATGCGA"};
        RequestMutanteTestDataBuilder requestMutanteTestDataBuilder = RequestMutanteTestDataBuilder.builder().dna(adn).build();
        BasePrueba.assertThrows(requestMutanteTestDataBuilder::build, ValidadorArgumentosExcepcion.class, "El tamaño del ADN es invalido. Debe ser de NxN");
    }
    @Test
    public void validarFormatoDelArreglo(){
        String[] adn = {"ITGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        RequestMutanteTestDataBuilder requestMutanteTestDataBuilder = RequestMutanteTestDataBuilder.builder().dna(adn).build();
        BasePrueba.assertThrows(requestMutanteTestDataBuilder::build, ValidadorArgumentosExcepcion.class, "El formato no es valido");
    }
}
