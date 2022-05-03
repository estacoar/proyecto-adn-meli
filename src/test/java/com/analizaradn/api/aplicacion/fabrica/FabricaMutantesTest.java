package com.analizaradn.api.aplicacion.fabrica;

import com.analizaradn.api.aplicacion.fabrica.FabricaMutantes;
import com.analizaradn.api.dominio.modelo.RequestMutante;
import com.analizaradn.api.dominio.testdatabuilder.RequestMutanteTestDataBuilder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaMutantesTest {
    @Test
    public void validarFabricaMutantes(){
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        RequestMutante requestMutante = RequestMutante.builder().dna(adn).build();
        FabricaMutantes fabricaMutantes = new FabricaMutantes();
        fabricaMutantes.crearRequestMutante(requestMutante.getDna());
        assertEquals(RequestMutanteTestDataBuilder.builder().build().build().toString(),
                fabricaMutantes.crearRequestMutante(requestMutante.getDna()).toString());
    }
}
