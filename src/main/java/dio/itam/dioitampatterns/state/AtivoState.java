package dio.itam.dioitampatterns.state;

import dio.itam.dioitampatterns.model.Ativo;

public interface AtivoState {
    void proximoPasso(Ativo ativo);
    void colocarEmManutencao(Ativo ativo);
    void descomissionar(Ativo ativo);
    String getNomeEstado();
}