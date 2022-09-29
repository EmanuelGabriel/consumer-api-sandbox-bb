package br.com.emanuelgabrielsousa.consumerapisandboxbb.controller;

import br.com.emanuelgabrielsousa.consumerapisandboxbb.client.ArrecadacaoQrCodesClient;
import br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response.GuiaArrecadacaoQrCodeResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author emanuel.sousa
 *
 */

@RestController
@RequestMapping(value = "/arrecadacao-qrcodes", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuiaArrecadacaoQrCodesController {

    private final Logger log = LoggerFactory.getLogger(GuiaArrecadacaoQrCodesController.class);

    private final ArrecadacaoQrCodesClient arrecadacaoQrCodesClient;

    public GuiaArrecadacaoQrCodesController(ArrecadacaoQrCodesClient arrecadacaoQrCodesClient) {
        this.arrecadacaoQrCodesClient = arrecadacaoQrCodesClient;
    }

    @GetMapping(value = "/{txid}")
    public ResponseEntity<GuiaArrecadacaoQrCodeResponseDTO> buscarArrecadacaoQrCodePagamentoPixPorID(
            @PathVariable String txid,
            @RequestParam(value = "numeroConvenio") String numeroConvenio) {
        log.info("GET /arrecadacao-qrcodes/{} - numeroConvenio:{}", txid, numeroConvenio);
        var resposta = arrecadacaoQrCodesClient.buscarArrecadacaoQrCodePagamentoPixPorId(txid, numeroConvenio);
        return resposta != null ? ResponseEntity.ok().body(resposta) : ResponseEntity.notFound().build();
    }
}
