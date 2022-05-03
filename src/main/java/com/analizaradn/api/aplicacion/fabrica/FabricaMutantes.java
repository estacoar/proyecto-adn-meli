package com.analizaradn.api.aplicacion.fabrica;

import com.analizaradn.api.dominio.modelo.RequestMutante;
import org.springframework.stereotype.Component;
@Component
public class FabricaMutantes {
	public RequestMutante crearRequestMutante(String[] requestMutante){
		return new RequestMutante(requestMutante);
	}
}
