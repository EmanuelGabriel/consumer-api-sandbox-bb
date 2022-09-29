package br.com.emanuelgabrielsousa.consumerapisandboxbb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author emanuel.sousa
 */

@Configuration
public class RestTemplateConfig {

    private final Logger log = LoggerFactory.getLogger(RestTemplateConfig.class);

    private static final int TIMEOUT = 6000;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder,
                                     AuthorizedClientServiceOAuth2AuthorizedClientManager clientManager) {
        return builder.additionalRequestCustomizers(request -> {

            OAuth2AuthorizeRequest auth2AuthorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId("sandboxbb-client")
                    .principal("SandboxApiBB")
                    .build();

            try {

                OAuth2AuthorizedClient authorize = clientManager.authorize(auth2AuthorizeRequest);

                if (authorize != null) {
                    OAuth2AccessToken accessToken = authorize.getAccessToken();
                    request.getHeaders().setBearerAuth(accessToken.getTokenValue());
                }

            }catch (ClientAuthorizationException e){
                log.error("Erro client: {}", e.getMessage());
            }

        })
                .setConnectTimeout(Duration.ofMillis(TIMEOUT))
                .setReadTimeout(Duration.ofMillis(TIMEOUT))
                .build();
    }
}
