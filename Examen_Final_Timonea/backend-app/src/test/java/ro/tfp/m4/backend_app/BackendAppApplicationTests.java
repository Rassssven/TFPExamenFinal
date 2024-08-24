package ro.tfp.m4.backend_app;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PlatformAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetAllGreetings() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.get("/greeting/getAll")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(
            MockMvcResultMatchers.status().isOk()
        )
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.length()", Matchers.greaterThan(0))
        );
    }

    @Test
    void shouldCreateANewGreeting() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.post("/greeting/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                "    \"description\": \"Test Greeting\"," +
                "    \"price\": 20.00," +
                "    \"typeID\": 1," +
                "    \"categoryID\": 1" +
                "}")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(
            MockMvcResultMatchers.status().isOk()
        )
        .andExpect(
            MockMvcResultMatchers.content().string(Matchers.containsString("Felicitarea a fost adaugata cu succes!"))
        );
    }
}
