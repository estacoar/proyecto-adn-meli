package com.analizaradn.api.infraestructura.controlador;

import com.analizaradn.api.dominio.servicio.ServicioStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControladorStats {
	public ServicioStats servicioStats;
	@Autowired
	public ControladorStats(ServicioStats servicioStats) {
		this.servicioStats = servicioStats;
	}
	@RequestMapping(value = "/stats")
	@GetMapping
	public   ResponseEntity<String>  stats() throws  Exception {
		return new ResponseEntity<>(servicioStats.stats().toString(), HttpStatus.OK);
	}
}
