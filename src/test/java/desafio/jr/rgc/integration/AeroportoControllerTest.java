package desafio.jr.rgc.integration;


import desafio.jr.rgc.client.IAeroportoClient;
import desafio.jr.rgc.exceptions.ApiExternaIndisponivelException;
import desafio.jr.rgc.model.Aeroporto;
import desafio.jr.rgc.model.AeroportoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import java.util.List;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AeroportoControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private IAeroportoClient client;

    @Test
    void deveRetornarDadosAeroporto() {
        AeroportoDTO aeroportoDTO = new AeroportoDTO();
        aeroportoDTO.setCity("ASHEVILLE");
        aeroportoDTO.setName("ASHEVILLE RGNL");
        aeroportoDTO.setCodigoIata("AVL");
        aeroportoDTO.setCodigoIcao("KAVL");

        List<AeroportoDTO> aeroportoDTOList = new ArrayList<>();
        aeroportoDTOList.add(aeroportoDTO);

        Mockito.when(client.buscaAeroportoPorICAO("KAVL"))
                .thenReturn(aeroportoDTOList);

        String url = "/api/aeroportos/KAVL";

        ResponseEntity<Aeroporto> response = testRestTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Aeroporto>() {} );

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(aeroportoDTO.getName(), response.getBody().getNome());
        Assertions.assertEquals(aeroportoDTO.getCity(), response.getBody().getCidade());
        Assertions.assertEquals(aeroportoDTO.getCodigoIcao(), response.getBody().getIcao());
        Assertions.assertEquals(aeroportoDTO.getCodigoIata(), response.getBody().getIata());

    }

    @Test
    void deveLancarErroQuandoApiExternaFalhar() {

        Mockito.when(client.buscaAeroportoPorICAO("ATL"))
                .thenThrow(new ApiExternaIndisponivelException("Erro na comunicação externa"));

        String url = "/api/aeroportos/ATL";

        ResponseEntity<String> response = testRestTemplate.exchange(url,
                HttpMethod.GET,
                null,
                String.class);

        Assertions.assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());

    }
}
