package desafio.jr.rgc.client;

import desafio.jr.rgc.exceptions.ApiExternaIndisponivelException;
import desafio.jr.rgc.model.AeroportoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class AeroportoClient implements IAeroportoClient{

    @Value("${aviation.api.url}")
    private String aviationApi;

    private final RestTemplate restTemplate;

    public AeroportoClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<AeroportoDTO> buscaAeroportoPorICAO(String codigoIcao) {

        try {
            String url = aviationApi.concat("/v1/airports?apt=" + codigoIcao);

            Map<String, List<AeroportoDTO>> response = restTemplate.exchange(url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<Map<String, List<AeroportoDTO>>>() {
                            })
                    .getBody();

            List<AeroportoDTO> aeroportoDTOS = response.get(codigoIcao);

            return aeroportoDTOS;
        } catch (Exception e) {
            throw new ApiExternaIndisponivelException("Erro na comunicação externa: " + e);
        }
    }
}
