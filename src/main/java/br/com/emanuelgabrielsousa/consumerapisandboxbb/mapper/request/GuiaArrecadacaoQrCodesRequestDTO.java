package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.request;

import br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response.ListaInforAdicionalResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author emanuel.sousa
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiaArrecadacaoQrCodesRequestDTO {

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
