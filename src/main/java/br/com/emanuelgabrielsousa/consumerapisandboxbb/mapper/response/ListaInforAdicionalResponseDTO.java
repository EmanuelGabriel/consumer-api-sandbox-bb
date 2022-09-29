package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response;

public class ListaInforAdicionalResponseDTO {

    private String codigoInformacaoAdicional;
    private String textoInformacaoAdicional;

    public ListaInforAdicionalResponseDTO() {
    }

    public ListaInforAdicionalResponseDTO(String codigoInformacaoAdicional, String textoInformacaoAdicional) {
        this.codigoInformacaoAdicional = codigoInformacaoAdicional;
        this.textoInformacaoAdicional = textoInformacaoAdicional;
    }

    public String getCodigoInformacaoAdicional() {
        return codigoInformacaoAdicional;
    }

    public void setCodigoInformacaoAdicional(String codigoInformacaoAdicional) {
        this.codigoInformacaoAdicional = codigoInformacaoAdicional;
    }

    public String getTextoInformacaoAdicional() {
        return textoInformacaoAdicional;
    }

    public void setTextoInformacaoAdicional(String textoInformacaoAdicional) {
        this.textoInformacaoAdicional = textoInformacaoAdicional;
    }
}
