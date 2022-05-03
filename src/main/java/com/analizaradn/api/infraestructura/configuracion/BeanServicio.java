package com.analizaradn.api.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.analizaradn.api.infraestructura.repositorio.RepositorioServicioAdnalizado;
import com.analizaradn.api.dominio.servicio.ServicioIsMutant;
import com.analizaradn.api.dominio.servicio.ServicioStats;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanServicio {
	@Bean
	public ServicioIsMutant  ServicioIsMutant(RepositorioServicioAdnalizado repositorioServicioAdnalizado){
		return new  ServicioIsMutant(repositorioServicioAdnalizado );
	}
	@Bean 
	public ServicioStats ServicioStats(RepositorioServicioAdnalizado repositorioServicioAdnalizado){	
		return new ServicioStats(repositorioServicioAdnalizado);
	}
}
