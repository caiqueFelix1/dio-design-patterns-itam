package dio.itam.dioitampatterns.state;

import dio.itam.dioitampatterns.model.Ativo;

public class EmUsoState implements AtivoState {
    @Override
    public void proximoPasso(Ativo ativo) {
        System.out.println("[INFO] O ativo já está em uso pelo colaborador.");
    }

    @Override
    public void colocarEmManutencao(Ativo ativo) {
        System.out.println("[ITAM] Ativo enviado para suporte técnico/manutenção.");
        ativo.setEstado(new ManutencaoState());
    }

    @Override
    public void descomissionar(Ativo ativo) {
        System.out.println("[ITAM] Ativo retirado de operação e descomissionado.");
        ativo.setEstado(new DescomissionadoState());
    }

    @Override
    public String getNomeEstado() {
        return "EM_USO";
    }
}
