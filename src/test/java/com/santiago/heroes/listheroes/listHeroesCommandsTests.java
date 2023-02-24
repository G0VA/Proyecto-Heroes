package com.santiago.heroes.listheroes;

import com.santiago.heroes.model.listheroes.ListHeroes_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import com.santiago.heroes.service.listheroes.ListHeroesCommands;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class listHeroesCommandsTests {

    @InjectMocks
    private ListHeroesCommands listHeroesCommands = new ListHeroesCommands();

    @Mock
    private HeroeRepository heroeRepository;

    @Test
    public void testListHeroesText() {
        ListHeroes_IN in = new ListHeroes_IN();

        List<Heroe> listHeroesByText = new ArrayList<>();
        Heroe heroe = new Heroe();
        heroe.setId(40L);
        heroe.setNombre("HOMBREMAN");
        heroe.setGrupo("TEST");
        listHeroesByText.add(heroe);
        Mockito.when(heroeRepository.getHeroes()).thenReturn(listHeroesByText);

        ListHeroes_OUT out = listHeroesCommands.execute(in);
    }
}
