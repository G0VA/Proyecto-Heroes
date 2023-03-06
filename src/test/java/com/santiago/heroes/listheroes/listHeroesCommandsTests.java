package com.santiago.heroes.listheroes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_IN;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_OUT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebAppConfiguration
@SpringBootTest
public class listHeroesCommandsTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private static final String URI = "/heroes/listHeroesByName";

    @BeforeEach
    void init() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    /*
    Test que hace la peticion /heroes/listHeroesByName con el patron "MAN"
    -Debe devolver 3 ya que es el resultado de los Heroes que contienen "MAN" en su nombre. Esto se genera al iniciar con
        el data.sql alojado en la carpeta resources.
     */

    @Test
    void test_1() throws Exception {
        ListHeroesByName_IN in = new ListHeroesByName_IN();
        in.setPatron("MAN");

        ObjectMapper mapper = new ObjectMapper();

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URI)
                .content(mapper.writeValueAsString(in))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

        ListHeroesByName_OUT out = mapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), ListHeroesByName_OUT.class);

        assertEquals(3, out.getHeroes().size());
    }
}
