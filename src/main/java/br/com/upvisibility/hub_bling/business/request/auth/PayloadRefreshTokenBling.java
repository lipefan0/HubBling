package br.com.upvisibility.hub_bling.business.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PayloadRefreshTokenBling(
        @JsonProperty("grant_type")
        String grantType,
        @JsonProperty("refresh_token")
        String refreshToken
) {
}
