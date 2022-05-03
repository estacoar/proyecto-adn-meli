package com.analizaradn.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
	String mensaje;
    public void SetMensaje(String mensaje) {
         this.mensaje = mensaje;
    }
}
