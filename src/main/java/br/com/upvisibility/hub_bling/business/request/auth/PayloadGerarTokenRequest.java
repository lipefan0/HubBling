package br.com.upvisibility.hub_bling.business.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PayloadGerarTokenRequest(

        @JsonProperty("grant_type")
        String grantType,
        String code
) {
}
