package com.analizaradn.api.dominio.servicio;

import com.analizaradn.api.dominio.modelo.Adnalizado;

public interface ServicioAdnalizado {
	public Adnalizado save(Adnalizado adnalizado);
	public Long countMutantDna();
	public Long countHumanDna();
}
