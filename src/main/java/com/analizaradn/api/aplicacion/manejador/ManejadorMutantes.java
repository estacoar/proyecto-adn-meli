package com.analizaradn.api.aplicacion.manejador;

import com.analizaradn.api.aplicacion.fabrica.FabricaMutantes;
import com.analizaradn.api.dominio.modelo.RequestMutante;
import org.springframework.stereotype.Component;

import com.analizaradn.api.dominio.servicio.ServicioIsMutant;

@Component
public class ManejadorMutantes {

	private ServicioIsMutant servicioIsMutant;
	private FabricaMutantes fabricaMutantes;

	public ManejadorMutantes(ServicioIsMutant servicioIsMutant, FabricaMutantes fabricaMutantes) {
		this.servicioIsMutant = servicioIsMutant;
		this.fabricaMutantes = fabricaMutantes;
	}
	public boolean ejecutar(String[] requestMutante)
			throws ClassNotFoundException {
		RequestMutante mutanteAdn = fabricaMutantes.crearRequestMutante(requestMutante);
		return servicioIsMutant.isMutant(mutanteAdn);
	}
}
