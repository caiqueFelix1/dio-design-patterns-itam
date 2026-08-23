package dio.itam.dioitampatterns.service;

import dio.itam.dioitampatterns.model.Ativo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AtivoService {
    private final Map<String, Ativo> repositorio = new HashMap<>();

    public Ativo criarAtivo(String patrimonio, String nome) {
        Ativo ativo = new Ativo(patrimonio, nome);
        repositorio.put(patrimonio, ativo);
        return ativo;
    }

    public Ativo buscarAtivo(String patrimonio) {
        return repositorio.get(patrimonio);
    }

    public Ativo avancar(String patrimonio) {
        Ativo ativo = buscarAtivo(patrimonio);
        if (ativo != null) ativo.avancarCiclo();
        return ativo;
    }

    public Ativo manutencao(String patrimonio) {
        Ativo ativo = buscarAtivo(patrimonio);
        if (ativo != null) ativo.enviarParaManutencao();
        return ativo;
    }

    public Ativo descomissionar(String patrimonio) {
        Ativo ativo = buscarAtivo(patrimonio);
        if (ativo != null) ativo.baixarAtivo();
        return ativo;
    }
}
