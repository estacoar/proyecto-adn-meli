package com.analizaradn.api.dominio.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdnalizadoTest {
    @Test
    public void validarAdnAnalizado(){
        Adnalizado adnalizado = Adnalizado.builder()
                .id(1).adn("{'ATGCGA', 'CAGTGC', 'TTATGT', 'AGAAGG', 'CCCCTA', 'TCACTG'}")
                .ind("M").build();

        assertEquals(1,adnalizado.getId());
        assertEquals("{'ATGCGA', 'CAGTGC', 'TTATGT', 'AGAAGG', 'CCCCTA', 'TCACTG'}", adnalizado.getAdn());
        assertEquals("M" , adnalizado.getInd());
    }
}
