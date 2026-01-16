package desafio.jr.rgc.controller;

import desafio.jr.rgc.model.Aeroporto;
import desafio.jr.rgc.service.AeroportoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aeroportos")
public class AeroportoController {

    private final AeroportoService service;

    public AeroportoController(AeroportoService service) {
        this.service = service;
    }

    @GetMapping("{codigoICAO}")
    public ResponseEntity<Aeroporto> buscaAeroportoPorICAO(@PathVariable String codigoICAO) {
        Aeroporto aeroporto = service.buscaAeroportoPorICAO(codigoICAO);
        return ResponseEntity.ok(aeroporto);
    }
}
