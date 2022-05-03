package com.analizaradn.api.infraestructura.controlador;

import com.analizaradn.api.aplicacion.comando.ComandoRequestMutante;
import com.analizaradn.api.aplicacion.manejador.ManejadorMutantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControladorAdnMutante {
	private final ManejadorMutantes manejadorMutantes;
	@Autowired
	public ControladorAdnMutante(ManejadorMutantes manejadorMutantes) {
		this.manejadorMutantes = manejadorMutantes;
	}
	@RequestMapping(value= "/mutant")
	@POST
	public  ResponseEntity<String>  isMutant(@RequestBody ComandoRequestMutante requestMutante) {
		try {
			if (this.manejadorMutantes.ejecutar(requestMutante.getDna())){
				return new ResponseEntity<>(HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
