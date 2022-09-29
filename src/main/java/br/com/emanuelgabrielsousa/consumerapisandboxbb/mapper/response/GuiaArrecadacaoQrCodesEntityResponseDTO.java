package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiaArrecadacaoQrCodesEntityResponseDTO {

    private int numeroConvenio;
    private String indicadorCodigoBarras;
    private String codigoGuiaRecebimento;
    private String emailDevedor;
    private int codigoPaisTelefoneDevedor;
    private int dddTelefoneDevedor;
    private String numeroTelefoneDevedor;
    private String codigoSolicitacaoBancoCentralBrasil;
    private String descricaoSolicitacaoPagamento;
    private float valorOriginalSolicitacao; //exemplo: 19.98
    private String cpfDevedor;
    private String nomeDevedor;
    private int quantidadeSegundoExpiracao;
    private List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional;
}
