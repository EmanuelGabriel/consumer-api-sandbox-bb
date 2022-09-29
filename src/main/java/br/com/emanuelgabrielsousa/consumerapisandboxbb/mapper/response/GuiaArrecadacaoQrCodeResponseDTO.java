package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuiaArrecadacaoQrCodeResponseDTO {

    private String codigoGuiaRecebimento;
    private String codigoConciliacaoSolicitante;
    private String emailDevedor;
    private int codigoPaisTelefoneDevedor;
    private int dddTelefoneDevedor;
    private String numeroTelefoneDevedor;
    private String timestampCriacaoSolicitacao;
    // default: 3600;
    private long quantidadeSegundoExpiracao;
    private String estadoSolicitacao;
    private String numeroVersaoSolicitacaoPagamento;
    private String linkQrCode;
    private String qrCode;
    private String cpfDevedor;
    private String cnpjDevedor;
    private String nomeDevedor;
    // 300.00,
    private double valorOriginalSolicitacao;
    // e2572aa4-52d6-4527-bc69-60c0699ea50d - CHAVE PIX DO ENTE PÚBLICO
    private String codigoSolicitacaoBancoCentralBrasil;
    private String descricaoSolicitacaoPagamento;
    private List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional;
    private String codigoIdentificadorPagamento;
    private long valorPagamento;
    private String timestampPagamento;
    private int cpfPagador;
    private int cnpjPagador;
    private String nomeClientePagador;
    private String textoInformativoPagador;

    public GuiaArrecadacaoQrCodeResponseDTO() {
    }

    public String getCodigoGuiaRecebimento() {
        return codigoGuiaRecebimento;
    }

    public void setCodigoGuiaRecebimento(String codigoGuiaRecebimento) {
        this.codigoGuiaRecebimento = codigoGuiaRecebimento;
    }

    public String getCodigoConciliacaoSolicitante() {
        return codigoConciliacaoSolicitante;
    }

    public void setCodigoConciliacaoSolicitante(String codigoConciliacaoSolicitante) {
        this.codigoConciliacaoSolicitante = codigoConciliacaoSolicitante;
    }

    public String getEmailDevedor() {
        return emailDevedor;
    }

    public void setEmailDevedor(String emailDevedor) {
        this.emailDevedor = emailDevedor;
    }

    public int getCodigoPaisTelefoneDevedor() {
        return codigoPaisTelefoneDevedor;
    }

    public void setCodigoPaisTelefoneDevedor(int codigoPaisTelefoneDevedor) {
        this.codigoPaisTelefoneDevedor = codigoPaisTelefoneDevedor;
    }

    public int getDddTelefoneDevedor() {
        return dddTelefoneDevedor;
    }

    public void setDddTelefoneDevedor(int dddTelefoneDevedor) {
        this.dddTelefoneDevedor = dddTelefoneDevedor;
    }

    public String getNumeroTelefoneDevedor() {
        return numeroTelefoneDevedor;
    }

    public void setNumeroTelefoneDevedor(String numeroTelefoneDevedor) {
        this.numeroTelefoneDevedor = numeroTelefoneDevedor;
    }

    public String getTimestampCriacaoSolicitacao() {
        return timestampCriacaoSolicitacao;
    }

    public void setTimestampCriacaoSolicitacao(String timestampCriacaoSolicitacao) {
        this.timestampCriacaoSolicitacao = timestampCriacaoSolicitacao;
    }

    public long getQuantidadeSegundoExpiracao() {
        return quantidadeSegundoExpiracao;
    }

    public void setQuantidadeSegundoExpiracao(long quantidadeSegundoExpiracao) {
        this.quantidadeSegundoExpiracao = quantidadeSegundoExpiracao;
    }

    public String getEstadoSolicitacao() {
        return estadoSolicitacao;
    }

    public void setEstadoSolicitacao(String estadoSolicitacao) {
        this.estadoSolicitacao = estadoSolicitacao;
    }

    public String getNumeroVersaoSolicitacaoPagamento() {
        return numeroVersaoSolicitacaoPagamento;
    }

    public void setNumeroVersaoSolicitacaoPagamento(String numeroVersaoSolicitacaoPagamento) {
        this.numeroVersaoSolicitacaoPagamento = numeroVersaoSolicitacaoPagamento;
    }

    public String getLinkQrCode() {
        return linkQrCode;
    }

    public void setLinkQrCode(String linkQrCode) {
        this.linkQrCode = linkQrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getCpfDevedor() {
        return cpfDevedor;
    }

    public void setCpfDevedor(String cpfDevedor) {
        this.cpfDevedor = cpfDevedor;
    }

    public String getCnpjDevedor() {
        return cnpjDevedor;
    }

    public void setCnpjDevedor(String cnpjDevedor) {
        this.cnpjDevedor = cnpjDevedor;
    }

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public double getValorOriginalSolicitacao() {
        return valorOriginalSolicitacao;
    }

    public void setValorOriginalSolicitacao(double valorOriginalSolicitacao) {
        this.valorOriginalSolicitacao = valorOriginalSolicitacao;
    }

    public String getCodigoSolicitacaoBancoCentralBrasil() {
        return codigoSolicitacaoBancoCentralBrasil;
    }

    public void setCodigoSolicitacaoBancoCentralBrasil(String codigoSolicitacaoBancoCentralBrasil) {
        this.codigoSolicitacaoBancoCentralBrasil = codigoSolicitacaoBancoCentralBrasil;
    }

    public String getDescricaoSolicitacaoPagamento() {
        return descricaoSolicitacaoPagamento;
    }

    public void setDescricaoSolicitacaoPagamento(String descricaoSolicitacaoPagamento) {
        this.descricaoSolicitacaoPagamento = descricaoSolicitacaoPagamento;
    }

    public List<ListaInforAdicionalResponseDTO> getListaInformacaoAdicional() {
        return listaInformacaoAdicional;
    }

    public void setListaInformacaoAdicional(List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional) {
        this.listaInformacaoAdicional = listaInformacaoAdicional;
    }

    public String getCodigoIdentificadorPagamento() {
        return codigoIdentificadorPagamento;
    }

    public void setCodigoIdentificadorPagamento(String codigoIdentificadorPagamento) {
        this.codigoIdentificadorPagamento = codigoIdentificadorPagamento;
    }

    public long getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(long valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getTimestampPagamento() {
        return timestampPagamento;
    }

    public void setTimestampPagamento(String timestampPagamento) {
        this.timestampPagamento = timestampPagamento;
    }

    public int getCpfPagador() {
        return cpfPagador;
    }

    public void setCpfPagador(int cpfPagador) {
        this.cpfPagador = cpfPagador;
    }

    public int getCnpjPagador() {
        return cnpjPagador;
    }

    public void setCnpjPagador(int cnpjPagador) {
        this.cnpjPagador = cnpjPagador;
    }

    public String getNomeClientePagador() {
        return nomeClientePagador;
    }

    public void setNomeClientePagador(String nomeClientePagador) {
        this.nomeClientePagador = nomeClientePagador;
    }

    public String getTextoInformativoPagador() {
        return textoInformativoPagador;
    }

    public void setTextoInformativoPagador(String textoInformativoPagador) {
        this.textoInformativoPagador = textoInformativoPagador;
    }
}
