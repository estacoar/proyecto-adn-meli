package com.analizaradn.api.dominio.servicio;

import com.analizaradn.api.aplicacion.comando.ComandoRequestMutante;
import com.analizaradn.api.dominio.modelo.Adnalizado;
import com.analizaradn.api.dominio.modelo.RequestMutante;
import com.analizaradn.api.infraestructura.repositorio.RepositorioServicioAdnalizado;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServicioIsMutantTest {
    @Mock
    private RepositorioServicioAdnalizado repositorioServicioAdnalizado;
    private ServicioIsMutant servicioIsMutant;

    @Before
    public void inicializar() {
        servicioIsMutant = new ServicioIsMutant(repositorioServicioAdnalizado);
    }

    @Test
    public void validarAdnCuandoEsMutante() throws Exception {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        RequestMutante requestMutante = RequestMutante.builder().dna(adn).build();
        Adnalizado adnalizado = Adnalizado.builder().adn("{'ATGCGA', 'CAGTGC', 'TTATGT', 'AGAAGG', 'CCCCTA', 'TCACTG'}").id(1).build();

        doReturn(adnalizado).when(repositorioServicioAdnalizado).save(adnalizado);
        boolean respuesta = servicioIsMutant.isMutant(requestMutante);
        assertEquals(true,respuesta);
    }

    @Test
    public void validarAdnCuandoEsHumano() throws Exception {
        String[] adn = {"TTGCGA", "CTGTGC", "TTATGT", "AGAAGG", "CCCTTA", "TCACTG"};
        RequestMutante requestMutante = RequestMutante.builder().dna(adn).build();
        Adnalizado adnalizado = Adnalizado.builder().adn("{'TTGCGA', 'CTGTGC', 'TTATGT', 'AGAAGG', 'CCCTTA', 'TCTCTG'}").id(1).build();

        doReturn(adnalizado).when(repositorioServicioAdnalizado).save(adnalizado);
        boolean respuesta = servicioIsMutant.isMutant(requestMutante);
        assertEquals(false,respuesta);
    }
}
