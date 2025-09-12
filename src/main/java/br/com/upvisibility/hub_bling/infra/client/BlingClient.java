package br.com.upvisibility.hub_bling.infra.client;

import br.com.upvisibility.hub_bling.business.request.auth.PayloadGerarTokenRequest;
import br.com.upvisibility.hub_bling.business.request.auth.PayloadRefreshTokenBling;
import br.com.upvisibility.hub_bling.business.response.auth.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "bling",
        url = "${bling.url}"
)
public interface BlingClient {

    @PostMapping("/oauth/token")
    TokenResponse GerarTokenBling(
            @RequestHeader String credentials,
            @RequestBody PayloadGerarTokenRequest request
    );

    @PostMapping("/oauth/token")
    TokenResponse RefreshTokenBling(
            @RequestHeader String credentials,
            @RequestBody PayloadRefreshTokenBling request
    );


}
