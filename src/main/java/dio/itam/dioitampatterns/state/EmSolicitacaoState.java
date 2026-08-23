package dio.itam.dioitampatterns.state;

import dio.itam.dioitampatterns.model.Ativo;

public class EmSolicitacaoState implements AtivoState {
    @Override
    public void proximoPasso(Ativo ativo) {
        System.out.println("[ITAM] Ativo aprovado e entregue ao usuário.");
        ativo.setEstado(new EmUsoState());
    }

    @Override
    public void colocarEmManutencao(Ativo ativo) {
        System.out.println("[ERRO] Um ativo em solicitação não pode ir para manutenção.");
    }

    @Override
    public void descomissionar(Ativo ativo) {
        System.out.println("[ITAM] Solicitação cancelada/descomissionada.");
        ativo.setEstado(new DescomissionadoState());
    }

    @Override
    public String getNomeEstado() {
        return "EM_SOLICITACAO";
    }
}
