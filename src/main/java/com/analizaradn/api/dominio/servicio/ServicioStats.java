package com.analizaradn.api.dominio.servicio;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.analizaradn.api.infraestructura.repositorio.RepositorioServicioAdnalizado;

public class ServicioStats {
	
	public RepositorioServicioAdnalizado  repositorioAdnalizado;

	public ServicioStats(RepositorioServicioAdnalizado repositorioAdnalizado) {
		this.repositorioAdnalizado = repositorioAdnalizado;
	}


	public JSONObject stats() throws JSONException {
		JSONObject result = new JSONObject();
		float mutante = this.repositorioAdnalizado.countMutantDna();
		float humano = this.repositorioAdnalizado.countHumanDna();
		
		float totalMutantesHumanos = mutante + humano;
		float ratio ;
		if ((mutante > 0 ) && (humano > 0)) {
		    ratio = (mutante / totalMutantesHumanos) / (humano / totalMutantesHumanos);
		}else if(mutante > 0){
			  ratio =  (mutante / totalMutantesHumanos);
		}else if(humano > 0){
		      ratio =  (humano / totalMutantesHumanos);
		}else{
			 ratio = 0f;
		}

		result.put("count_mutant_dna", mutante);
		result.put("count_human_dna", humano);
		result.put("ratio", ratio);
		return result;
	}
}
