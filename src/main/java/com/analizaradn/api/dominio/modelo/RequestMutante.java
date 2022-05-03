package com.analizaradn.api.dominio.modelo;


import com.analizaradn.api.dominio.ValidadorArgumentosExcepcion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RequestMutante {
	 String[] dna;
	public RequestMutante(String[] dna) throws ValidadorArgumentosExcepcion  {
		this.dna = dna;
		 if (this.dna == null || this.dna.length == 0 || this.dna.length != this.dna[0].length())
			 throw new ValidadorArgumentosExcepcion("El tamaño del ADN es invalido. Debe ser de NxN");
		 
		 if (dna[0].matches(".*[^ATCG].*"))
			 throw new ValidadorArgumentosExcepcion("El formato no es valido");
	}
}
