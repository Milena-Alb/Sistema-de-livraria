package dio.padroes_projeto.desafio_dio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Localizacao {
    @Id
    private String codLocalizacao;
    private String corredor;
    private String prateleira;
    private String estante;
    private String secao;

    public String getCodLocalizacao() {
        return codLocalizacao;
    }

    public void setCodLocalizacao(String codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }
}

