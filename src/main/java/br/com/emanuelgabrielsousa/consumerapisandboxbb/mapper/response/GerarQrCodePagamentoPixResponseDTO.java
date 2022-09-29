package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author emanuel.sousa
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GerarQrCodePagamentoPixResponseDTO {

    private String timestampCriacaoSolicitacao;
    private String estadoSolicitacao;
    private String codigoConciliacaoSolicitante;
    private int numeroVersaoSolicitacaoPagamento;
    private String linkQrCode;
    private String qrCode;


}
