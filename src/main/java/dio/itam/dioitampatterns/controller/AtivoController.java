package dio.itam.dioitampatterns.controller;

import dio.itam.dioitampatterns.model.Ativo;
import dio.itam.dioitampatterns.service.AtivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ativos")
public class AtivoController {
    private final AtivoService service;

    public AtivoController(AtivoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ativo> criar(@RequestParam String patrimonio, @RequestParam String nome) {
        Ativo ativo = service.criarAtivo(patrimonio, nome);
        return ResponseEntity.ok(ativo);
    }

    @PatchMapping("/{patrimonio}/avancar")
    public ResponseEntity<Ativo> avancarCiclo(@PathVariable String patrimonio) {
        Ativo ativo = service.avancar(patrimonio);
        return ativo != null ? ResponseEntity.ok(ativo) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{patrimonio}/manutencao")
    public ResponseEntity<Ativo> enviarManutencao(@PathVariable String patrimonio) {
        Ativo ativo = service.manutencao(patrimonio);
        return ativo != null ? ResponseEntity.ok(ativo) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{patrimonio}/descomissionar")
    public ResponseEntity<Ativo> descomissionar(@PathVariable String patrimonio) {
        Ativo ativo = service.descomissionar(patrimonio);
        return ativo != null ? ResponseEntity.ok(ativo) : ResponseEntity.notFound().build();
    }
}

