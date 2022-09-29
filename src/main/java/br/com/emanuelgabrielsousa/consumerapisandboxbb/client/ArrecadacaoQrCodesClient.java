package br.com.emanuelgabrielsousa.consumerapisandboxbb.client;

import br.com.emanuelgabrielsousa.consumerapisandboxbb.client.exceptions.RecursoInacessivelException;
import br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response.GuiaArrecadacaoQrCodeResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * @author emanuel.sousa
 */

@Component
public class ArrecadacaoQrCodesClient {

    private final Logger log = LoggerFactory.getLogger(ArrecadacaoQrCodesClient.class);

    @Value("${chave.gw.dev.app-key}")
    private String chaveDevAppKey;

    @Value("${base.uri.sandbox-bb}")
    private String baseUriSandboxBB;

    private final RestTemplate restTemplate;

    public ArrecadacaoQrCodesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @param txid
     * @param numeroConvenio
     * @return GuiaArrecadacaoQrCodeResponseDTO
     */
    public GuiaArrecadacaoQrCodeResponseDTO buscarArrecadacaoQrCodePagamentoPixPorId(String txid, String numeroConvenio) {
        log.info("Consultar um QR Code de pagamentos instantâneos (PIX) por guia de recebimento (com ou sem código de barras) por ID - {};{}", txid, numeroConvenio);

        try {

            var url = baseUriSandboxBB + "/arrecadacao-qrcodes/" + txid + "?gw-dev-app-key=" + chaveDevAppKey + "&" + "numeroConvenio=" + numeroConvenio;
            log.info("URL: {}", url);

            GuiaArrecadacaoQrCodeResponseDTO response = restTemplate.getForObject(url, GuiaArrecadacaoQrCodeResponseDTO.class, txid);

            return response;

        } catch (ResourceAccessException ex) {
            throw new RecursoInacessivelException(ex.getMessage());
        }
    }
}
