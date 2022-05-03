package com.analizaradn.api.dominio.testdatabuilder;

import com.analizaradn.api.aplicacion.comando.ComandoRequestMutante;
import lombok.Builder;

@Builder(builderClassName = "ComandoRequestMutanteBuilder")
public class ComandoRequestMutanteTestDataBuilder {
    String[] dna;
    public static class ComandoRequestMutanteBuilder {
        String[] dna =  {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};;
    }
    public ComandoRequestMutante build(){
        return new ComandoRequestMutante(dna);
    }
}
