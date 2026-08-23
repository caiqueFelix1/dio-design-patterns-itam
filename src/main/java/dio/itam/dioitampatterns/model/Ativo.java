package dio.itam.dioitampatterns.model;

import dio.itam.dioitampatterns.state.AtivoState;
import dio.itam.dioitampatterns.state.EmSolicitacaoState;

public class Ativo {
    private String patrimonio;
    private String nome;
    private AtivoState estado;

    public Ativo(String patrimonio, String nome) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.estado = new EmSolicitacaoState();
    }

    public void avancarCiclo() {
        estado.proximoPasso(this);
    }

    public void enviarParaManutencao() {
        estado.colocarEmManutencao(this);
    }

    public void baixarAtivo() {
        estado.descomissionar(this);
    }

    public String getStatusAtual() {
        return estado.getNomeEstado();
    }

    public String getPatrimonio() { return patrimonio; }
    public String getNome() { return nome; }
    public void setEstado(AtivoState estado) { this.estado = estado; }
}