package com.analizaradn.api.infraestructura.repositorio;

import com.analizaradn.api.dominio.modelo.Adnalizado;
import com.analizaradn.api.dominio.repositorio.RepositorioAdnalizado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RepositorioServicioAdnalizadoTest {

    @Mock
    private RepositorioAdnalizado repositorioAdnalizado;

    @Mock
    private RepositorioServicioAdnalizado repositorioServicioAdnalizado;

    @Test
    public void  validarRepositorioAdnalizadoSave(){
        Adnalizado adnalizado = new Adnalizado();
        adnalizado.setId(1);
        adnalizado.setAdn("{'ATGCGA', 'CAGTGC', 'TTATGT', 'AGAAGG', 'CCCCTA', 'TCACTG'}");
        adnalizado.setInd("M");

        doReturn(adnalizado).when(repositorioAdnalizado).save(adnalizado);

        Adnalizado  adn = repositorioServicioAdnalizado.save(adnalizado);
    }
}
