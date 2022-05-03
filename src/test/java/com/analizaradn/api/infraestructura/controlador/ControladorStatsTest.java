package com.analizaradn.api.infraestructura.controlador;

import com.analizaradn.api.dominio.modelo.Adnalizado;
import com.analizaradn.api.dominio.repositorio.RepositorioAdnalizado;
import com.analizaradn.api.dominio.servicio.ServicioStats;
import com.analizaradn.api.infraestructura.repositorio.RepositorioServicioAdnalizado;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ControladorStatsTest {

    @Mock
    private RepositorioServicioAdnalizado repositorioServicioAdnalizado;

    @Mock
    private ControladorStats controladorStats;

    @Mock
    private ServicioStats servicioStats;

    @Before
    public void inicializar() {
        servicioStats = new ServicioStats(repositorioServicioAdnalizado);
        controladorStats = new ControladorStats(servicioStats);
    }

    @Test
    public void  validarConsultarStats() throws Exception {
        doReturn(1L).when(repositorioServicioAdnalizado).countHumanDna();
        doReturn(1L).when(repositorioServicioAdnalizado).countHumanDna();

        ResponseEntity<String> stats = controladorStats.stats();
        assertEquals("<200 OK OK,{\"count_mutant_dna\":0,\"count_human_dna\":1,\"ratio\":1},[]>", stats.toString());
    }
}
