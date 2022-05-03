package com.analizaradn.api.dominio.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.analizaradn.api.dominio.modelo.RequestMutante;
import com.analizaradn.api.dominio.modelo.Adnalizado;
import com.analizaradn.api.infraestructura.repositorio.RepositorioServicioAdnalizado;


public class ServicioIsMutant {
	private String[] dnaMutantes = { "AAAA", "TTTT", "CCCC", "GGGG" };
	public int totalMutamtes;
	public int difereciaMatrizDna;
	
	private RepositorioServicioAdnalizado repositorioServicioAdnalizado;

	public ServicioIsMutant(
			RepositorioServicioAdnalizado repositorioServicioAdnalizado) {
		this.repositorioServicioAdnalizado = repositorioServicioAdnalizado;
	}

	public boolean isMutant(RequestMutante requestMutante) throws  ClassNotFoundException {
		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList(requestMutante.getDna()));
		this.totalMutamtes = 0;

		for (int i = 0; i < dnaMutantes.length; i++) {
			this.buscarFilasColumnas(result,dnaMutantes[i]);
			this.difereciaMatrizDna = result.size() - dnaMutantes[i].length();
			this.buscarDiagonalAnteriorDesdeArriba(result, dnaMutantes[i]);
			this.buscarDiagonalPrincipalDesdeArriba(result, dnaMutantes[i]);
			this.buscarDiagonalPrinciparInferiorDesdeAbajo(result, dnaMutantes[i]);
			this.buscarDiagonalSuperiorDesdeabajo(result, dnaMutantes[i]);
		}

		Adnalizado adnalizado = new Adnalizado(requestMutante.toString(),totalMutamtes > 1 ? "M" : "H" );
		this.repositorioServicioAdnalizado.save(adnalizado);
		return totalMutamtes > 1 ;
	}

	public void buscarFilasColumnas(List<String> result, String dna) {
		for (int j = 0; j < result.size(); j++) {
			// Se busca ocurrencia en las filas
			if (result.get(j).contains(dna))
				this.totalMutamtes++;
			// Se crea la coumna
			String secuencia = "";
			for (int x = 0; x < result.size() - 1; x++) {
				secuencia += result.get(x).charAt(j);
			}
			// Se busca ocurrencia en la columna
			if (secuencia.contains(dna))
				this.totalMutamtes++;
		}
	}

	public void buscarDiagonalAnteriorDesdeArriba(List<String> result, String dna) {

		for (int y = difereciaMatrizDna; y >= 0; y--) {
			String secuencia = "";
			for (int j = 0; j < result.size() - y; j++) {
				secuencia += result.get(y + j).charAt(j);
			}
			if (secuencia.contains(dna))
				this.totalMutamtes++;
		}
	}

	public void buscarDiagonalPrincipalDesdeArriba(List<String> result,
			String dna) {
		for (int y = 1; y <= difereciaMatrizDna; y++) {
			String secuencia = "";
			for (int j = 0; j < result.size() - y; j++) {
				secuencia += result.get(j).charAt(y + j);
			}
			if (secuencia.contains(dna))
				this.totalMutamtes++;
		}
	}

	public void buscarDiagonalPrinciparInferiorDesdeAbajo(List<String> result,
			String dna) {
		for (int y = difereciaMatrizDna + 1; y < result.size(); y++) {
			String secuencia = "";
			for (int j = 0; j <= y; j++) {
				secuencia += result.get(y - j).charAt(j);
			}
			if (secuencia.contains(dna))
				this.totalMutamtes++;
		}
	}

	public void buscarDiagonalSuperiorDesdeabajo(List<String> result, String dna) {
		for (int y = 0; y < difereciaMatrizDna; y++) {
			String secuencia = "";
			for (int j = y + 1; j < result.size(); j++) {
				secuencia += result.get(result.size() - j + y)
						.charAt(j);
			}

			if (secuencia.contains(dna))
				this.totalMutamtes++;
		}
	}
}
