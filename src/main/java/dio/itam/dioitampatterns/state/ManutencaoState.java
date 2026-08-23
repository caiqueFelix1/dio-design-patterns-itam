package dio.itam.dioitampatterns.state;

import dio.itam.dioitampatterns.model.Ativo;

public class ManutencaoState implements AtivoState{
    @Override
    public void proximoPasso(Ativo ativo) {
        System.out.println("[ITAM] Manutenção concluída. Ativo retornado para operação.");
        ativo.setEstado(new EmUsoState());
    }

    @Override
    public void colocarEmManutencao(Ativo ativo) {
        System.out.println("[INFO] O ativo já está em manutenção.");
    }

    @Override
    public void descomissionar(Ativo ativo) {
        System.out.println("[ITAM] Ativo irrecuperável na manutenção. Descomissionado.");
        ativo.setEstado(new DescomissionadoState());
    }

    @Override
    public String getNomeEstado() {
        return "EM_MANUTENCAO";
    }
}
