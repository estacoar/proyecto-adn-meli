package com.analizaradn.api.infraestructura.repositorio;

import com.analizaradn.api.dominio.modelo.Adnalizado;
import com.analizaradn.api.dominio.repositorio.RepositorioAdnalizado;
import com.analizaradn.api.dominio.servicio.ServicioAdnalizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepositorioServicioAdnalizado implements ServicioAdnalizado {
	@Autowired
	private RepositorioAdnalizado repositorioAdnalizado;
	@Override
	@Transactional
	public Adnalizado save(Adnalizado adnalizado) {
		return repositorioAdnalizado.save(adnalizado);
	}
	@Override
	public Long countMutantDna() {
		return this.repositorioAdnalizado.countMutantDna();
	}
	@Override
	public Long countHumanDna() {
		// TODO Auto-generated method stub
		return this.repositorioAdnalizado.countHumanDna();
	}

}
