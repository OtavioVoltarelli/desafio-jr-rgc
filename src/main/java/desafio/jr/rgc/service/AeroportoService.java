package desafio.jr.rgc.service;

import desafio.jr.rgc.client.IAeroportoClient;
import desafio.jr.rgc.exceptions.AeroportoNaoEncontradoException;
import desafio.jr.rgc.exceptions.ApiExternaIndisponivelException;
import desafio.jr.rgc.model.Aeroporto;
import desafio.jr.rgc.model.AeroportoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportoService {

    private final IAeroportoClient client;

    public AeroportoService(IAeroportoClient client) {
        this.client = client;
    }

    public Aeroporto buscaAeroportoPorICAO(String codigoIcao)
    {

        List<AeroportoDTO> dtos = client.buscaAeroportoPorICAO(codigoIcao.toUpperCase());

        if (dtos.isEmpty()) {
            throw new AeroportoNaoEncontradoException("Aeroporto com código Icao " + codigoIcao + " não encontrado");
        }

        AeroportoDTO aeroportoDTO = dtos.getFirst();
        Aeroporto aeroporto = new Aeroporto();

        aeroporto.setNome(aeroportoDTO.getName());
        aeroporto.setCidade(aeroportoDTO.getCity());
        aeroporto.setPais("EUA");
        aeroporto.setIcao(aeroportoDTO.getCodigoIcao());
        aeroporto.setIata(aeroportoDTO.getCodigoIata());

        return aeroporto;
    }
}
