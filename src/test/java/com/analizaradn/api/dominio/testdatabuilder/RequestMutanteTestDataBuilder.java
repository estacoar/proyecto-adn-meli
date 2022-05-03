package com.analizaradn.api.dominio.testdatabuilder;

import com.analizaradn.api.dominio.modelo.RequestMutante;
import lombok.Builder;

@Builder(builderClassName = "RequestMutanteBuilder")
public class RequestMutanteTestDataBuilder {
    String[] dna;
    public static class RequestMutanteBuilder {
        String[] dna =  {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};;
    }
    public RequestMutante build(){
        return new RequestMutante(dna);
    }
}
