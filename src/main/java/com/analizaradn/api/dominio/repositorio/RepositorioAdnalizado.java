package com.analizaradn.api.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.analizaradn.api.dominio.modelo.Adnalizado;

@Repository
public interface RepositorioAdnalizado extends JpaRepository<Adnalizado, Long> {
	@Query(value = "select IFNULL(count(adn),0) from adnalizado where ind ='M' ", nativeQuery = true)
	Long countMutantDna();
	
	@Query(value = "select IFNULL(count(adn),0) from adnalizado where ind ='H' ", nativeQuery = true)
	Long countHumanDna();
}
