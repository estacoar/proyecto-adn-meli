package com.analizaradn.api.dominio.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "adnalizado")
public class Adnalizado implements Serializable {

	private static final long serialVersionUID = -8009911721699760645L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 250 )
	private String adn;
	
	@Column(length = 1 )
	private String ind;

	public Adnalizado(String adn, String ind) {
		this.adn = adn;
		this.ind = ind;
	}
}
