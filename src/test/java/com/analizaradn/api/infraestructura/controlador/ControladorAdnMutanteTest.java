package com.analizaradn.api.infraestructura.controlador;

import com.analizaradn.api.aplicacion.comando.ComandoRequestMutante;
import com.analizaradn.api.aplicacion.fabrica.FabricaMutantes;
import com.analizaradn.api.aplicacion.manejador.ManejadorMutantes;
import com.analizaradn.api.dominio.modelo.Adnalizado;
import com.analizaradn.api.dominio.modelo.RequestMutante;
import com.analizaradn.api.dominio.servicio.ServicioIsMutant;
import com.analizaradn.api.dominio.testdatabuilder.ComandoRequestMutanteTestDataBuilder;
import com.analizaradn.api.infraestructura.repositorio.RepositorioServicioAdnalizado;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ControladorAdnMutanteTest {

    @Mock
    private ManejadorMutantes manejadorMutantes;
    @Mock
    private ControladorAdnMutante controladorAdnMutante;
    @Mock
    private RepositorioServicioAdnalizado repositorioServicioAdnalizado;
    @Mock
    private ServicioIsMutant servicioIsMutant;
    @Mock
    private FabricaMutantes fabricaMutantes;
    @Before
    public void inicializar() {
        manejadorMutantes = new ManejadorMutantes(servicioIsMutant, fabricaMutantes);
        controladorAdnMutante = new ControladorAdnMutante(manejadorMutantes);
    }

    @Test
    public void  enviarAdnParaValidarMutanteTest() throws Exception {
        //Arrange
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        Adnalizado adnalizado = Adnalizado.builder().adn("{'ATGCGA', 'CAGTGC', 'TTATGT', 'AGAAGG', 'CCCCTA', 'TCACTG'}").id(1).build();
        RequestMutante mutanteAdn = RequestMutante.builder().dna(adn).build();
        ComandoRequestMutante comandoRequestMutante = ComandoRequestMutanteTestDataBuilder.builder().build().build();

        doReturn(adnalizado).when(repositorioServicioAdnalizado).save(adnalizado);
        doReturn(mutanteAdn).when(fabricaMutantes).crearRequestMutante(adn);
        doReturn(true).when(servicioIsMutant).isMutant(mutanteAdn);
        //Act
        ResponseEntity<String> respuesta = controladorAdnMutante.isMutant(comandoRequestMutante);

        //Assert
        assertEquals("<200 OK OK,[]>", respuesta.toString());
    }

    @Test
    public void  enviarAdnParaValidarHumanoTest() throws Exception {
        //Arrange
        String[] adn = {"TTGCGA", "CTGTGC", "TTATGT", "AGAAGG", "CCCTTA", "TCACTG"};
        Adnalizado adnalizado = Adnalizado.builder().adn("{'TTGCGA', 'CTGTGC', 'TTATGT', 'AGAAGG', 'CCCTTA', 'TCTCTG'}").id(1).build();
        RequestMutante mutanteAdn = RequestMutante.builder().dna(adn).build();
        ComandoRequestMutante comandoRequestMutante = ComandoRequestMutanteTestDataBuilder.builder().build().build();

        doReturn(adnalizado).when(repositorioServicioAdnalizado).save(adnalizado);
        doReturn(adnalizado).when(repositorioServicioAdnalizado).save(adnalizado);
        doReturn(mutanteAdn).when(fabricaMutantes).crearRequestMutante(adn);
        doReturn(false).when(servicioIsMutant).isMutant(mutanteAdn);
        //Act
        ResponseEntity<String> respuesta = controladorAdnMutante.isMutant(comandoRequestMutante);
        //Assert
        assertEquals("<403 FORBIDDEN Forbidden,[]>", respuesta.toString());
    }
}
