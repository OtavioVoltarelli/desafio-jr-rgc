package desafio.jr.rgc.client;

import desafio.jr.rgc.model.AeroportoDTO;

import java.util.List;


public interface IAeroportoClient {

    public List<AeroportoDTO> buscaAeroportoPorICAO(String codigoICAO);

}
