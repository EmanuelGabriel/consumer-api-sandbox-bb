package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiaArrecadacaoQrCodeResponseDTO {

    private String codigoGuiaRecebimento;
    private String codigoConciliacaoSolicitante;
    private String emailDevedor;
    private int codigoPaisTelefoneDevedor;
    private int dddTelefoneDevedor;
    private String numeroTelefoneDevedor;
    private String timestampCriacaoSolicitacao;
    private long quantidadeSegundoExpiracao;
    private String estadoSolicitacao;
    private String numeroVersaoSolicitacaoPagamento;
    private String linkQrCode;
    private String qrCode;
    private String cpfDevedor;
    private String cnpjDevedor;
    private String nomeDevedor;
    private float valorOriginalSolicitacao; // 300.00
    private String codigoSolicitacaoBancoCentralBrasil; // e2572aa4-52d6-4527-bc69-60c0699ea50d - CHAVE PIX DO ENTE PÚBLICO
    private String descricaoSolicitacaoPagamento;
    private List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional;
    private String codigoIdentificadorPagamento;
    private float valorPagamento;
    private String timestampPagamento;
    private long cpfPagador;
    private long cnpjPagador;
    private String nomeClientePagador;
    private String textoInformativoPagador;


}
