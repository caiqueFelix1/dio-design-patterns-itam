package dio.itam.dioitampatterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AtivoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve criar um novo ativo via API REST com sucesso")
    void testCriarAtivoEndpoint() throws Exception {
        mockMvc.perform(post("/ativos")
                        .param("patrimonio", "NOTE-REST-01")
                        .param("nome", "ThinkPad"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patrimonio").value("NOTE-REST-01"))
                .andExpect(jsonPath("$.nome").value("ThinkPad"))
                .andExpect(jsonPath("$.statusAtual").value("EM_SOLICITACAO"));
    }

    @Test
    @DisplayName("Deve avançar o ciclo de vida do ativo via endpoint PATCH")
    void testAvancarCicloEndpoint() throws Exception {
        mockMvc.perform(post("/ativos")
                .param("patrimonio", "NOTE-REST-02")
                .param("nome", "MacBook Air"));

        mockMvc.perform(patch("/ativos/NOTE-REST-02/avancar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusAtual").value("EM_USO"));
    }
}
