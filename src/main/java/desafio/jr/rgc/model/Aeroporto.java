package desafio.jr.rgc.model;


public class Aeroporto {

    private String nome;

    private String cidade;

    private String pais;

    private String icao;

    private String iata;

    public Aeroporto() {
    }

    public Aeroporto(String cidade, String iata, String icao, String nome, String pais) {
        this.cidade = cidade;
        this.iata = iata;
        this.icao = icao;
        this.nome = nome;
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
