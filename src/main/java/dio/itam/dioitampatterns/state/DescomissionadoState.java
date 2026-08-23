package dio.itam.dioitampatterns.state;

import dio.itam.dioitampatterns.model.Ativo;

public class DescomissionadoState implements AtivoState {
    @Override
    public void proximoPasso(Ativo ativo) {
        System.out.println("[ERRO] Ativo descomissionado não pode retornar ao ciclo de uso.");
    }

    @Override
    public void colocarEmManutencao(Ativo ativo) {
        System.out.println("[ERRO] Ativo baixado não pode ir para manutenção.");
    }

    @Override
    public void descomissionar(Ativo ativo) {
        System.out.println("[INFO] O ativo já se encontra descomissionado.");
    }

    @Override
    public String getNomeEstado() {
        return "DESCOMISSIONADO";
    }
}
