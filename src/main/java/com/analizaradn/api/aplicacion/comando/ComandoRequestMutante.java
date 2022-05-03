package com.analizaradn.api.aplicacion.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComandoRequestMutante {
    String[] dna;
}
