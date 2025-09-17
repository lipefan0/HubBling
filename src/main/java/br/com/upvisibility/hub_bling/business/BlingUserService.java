package br.com.upvisibility.hub_bling.business;

import br.com.upvisibility.hub_bling.business.request.auth.PayloadGerarTokenRequest;
import br.com.upvisibility.hub_bling.business.request.auth.PayloadRefreshTokenBling;
import br.com.upvisibility.hub_bling.business.response.auth.TokenResponse;
import br.com.upvisibility.hub_bling.business.response.empresa.EmpresaResponse;
import br.com.upvisibility.hub_bling.business.response.empresa.EmpresaWrapperResponse;
import br.com.upvisibility.hub_bling.infra.client.BlingClient;
import br.com.upvisibility.hub_bling.infra.entity.BlingUser;
import br.com.upvisibility.hub_bling.infra.repository.BlingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class BlingUserService {

    private final BlingUserRepository blingUserRepository;
    private final BlingClient blingClient;

    @Value("${bling.credentials.client-id}")
    private String clientId;

    @Value("${bling.credentials.client-secret}")
    private String clientSecret;

    public BlingUser save(BlingUser blingUser) {
        return blingUserRepository.save(blingUser);
    }

    public BlingUser findByUserId(Long userId) {
        return blingUserRepository.findBlingUserByUserId(userId)
                .orElseThrow(() -> new RuntimeException("BlingUser not found with id: " + userId));
    }

    public BlingUser findByEmail(String email) {
        return blingUserRepository.findBlingUserByCompanyEmail(email)
                .orElseThrow(() -> new RuntimeException("BlingUser not found with email: " + email));
    }

    public TokenResponse createToken(PayloadGerarTokenRequest payload) {
        String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        return blingClient.GerarTokenBling("Basic " + credentials, payload);
    }

    public TokenResponse refreshToken(PayloadRefreshTokenBling payload) {
        String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        return blingClient.RefreshTokenBling("Basic " + credentials, payload);
    }

    public EmpresaWrapperResponse getEmpresa(String token) {
        EmpresaResponse response = blingClient.getEmpresaDadosBasicos("Bearer " + token);
        return response.data();
    }

}
