package dio.itam.dioitampatterns;

import dio.itam.dioitampatterns.model.Ativo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtivoStateTest {

    @Test
    @DisplayName("Deve iniciar o ativo no estado EM_SOLICITACAO")
    void testEstadoInicial() {
        Ativo ativo = new Ativo("NOTE-001", "Dell Latitude");
        assertEquals("EM_SOLICITACAO", ativo.getStatusAtual());
    }

    @Test
    @DisplayName("Deve transacionar de EM_SOLICITACAO para EM_USO com sucesso")
    void testAvancarParaEmUso() {
        Ativo ativo = new Ativo("NOTE-001", "Dell Latitude");
        ativo.avancarCiclo();
        assertEquals("EM_USO", ativo.getStatusAtual());
    }

    @Test
    @DisplayName("Deve bloquear transição inválida de DESCOMISSIONADO para EM_USO")
    void testBloquearTransicaoInvalida() {
        Ativo ativo = new Ativo("NOTE-001", "Dell Latitude");
        ativo.baixarAtivo();
        assertEquals("DESCOMISSIONADO", ativo.getStatusAtual());

        ativo.avancarCiclo();
        assertEquals("DESCOMISSIONADO", ativo.getStatusAtual());
    }

    @Test
    @DisplayName("Deve enviar ativo EM_USO para manutenção com sucesso")
    void testEnviarParaManutencao() {
        Ativo ativo = new Ativo("NOTE-001", "Dell Latitude");
        ativo.avancarCiclo();
        assertEquals("EM_USO", ativo.getStatusAtual());

        ativo.enviarParaManutencao();
        assertEquals("EM_MANUTENCAO", ativo.getStatusAtual());
    }

    @Test
    @DisplayName("Deve barrar envio para manutencao de um ativo que esta em solicitacao")
    void testBloquearManutencaoEmSolicitacao() {
        Ativo ativo = new Ativo("NOTE-002", "MacBook Pro");

        assertEquals("EM_SOLICITACAO", ativo.getStatusAtual());

        ativo.enviarParaManutencao();
        assertEquals("EM_SOLICITACAO", ativo.getStatusAtual());
    }
}
