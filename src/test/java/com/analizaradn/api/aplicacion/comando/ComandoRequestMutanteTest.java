package com.analizaradn.api.aplicacion.comando;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComandoRequestMutanteTest {
    @Test
    public void validarComandoRequestMutante(){
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        ComandoRequestMutante comandoRequestMutante = new ComandoRequestMutante();
        comandoRequestMutante.setDna(adn);
        assertEquals(adn, comandoRequestMutante.getDna());
    }
}
