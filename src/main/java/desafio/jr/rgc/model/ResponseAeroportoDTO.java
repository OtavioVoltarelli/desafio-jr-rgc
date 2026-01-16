package desafio.jr.rgc.model;

import java.util.List;
import java.util.Map;

public class ResponseAeroportoDTO {

    private Map<String, List<AeroportoDTO>> response;

    public Map<String, List<AeroportoDTO>> getResponse() {
        return response;
    }

    public void setResponse(Map<String, List<AeroportoDTO>> response) {
        this.response = response;
    }
}
