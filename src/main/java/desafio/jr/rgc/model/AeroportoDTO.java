package desafio.jr.rgc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AeroportoDTO {

    @JsonProperty("facility_name")
    private String name;

    private String city;

    @JsonProperty("faa_ident")
    private String codigoIata;

    @JsonProperty("icao_ident")
    private String codigoIcao;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCodigoIata() {
        return codigoIata;
    }

    public void setCodigoIata(String codigoIata) {
        this.codigoIata = codigoIata;
    }

    public String getCodigoIcao() {
        return codigoIcao;
    }

    public void setCodigoIcao(String codigoIcao) {
        this.codigoIcao = codigoIcao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}