package br.com.upvisibility.hub_bling.business;

import br.com.upvisibility.hub_bling.business.request.contatos.ContatoRequest;
import br.com.upvisibility.hub_bling.business.response.contatos.ContatoCreatedIdResponse;
import br.com.upvisibility.hub_bling.business.response.contatos.ContatoResponse;
import br.com.upvisibility.hub_bling.infra.client.BlingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final BlingClient blingClient;

    public ContatoCreatedIdResponse createContato(String token, ContatoRequest request) {
        return blingClient.criarContato("Bearer " + token, request);
    }

    public ContatoResponse buscarContatoPorDocumento(String token, String documento) {
        return blingClient.buscarContatoPorDocumento("Bearer " + token, documento);
    }

    public ContatoResponse buscarContatoPorId(String token, String id) {
        return blingClient.buscarContatoPorId("Bearer " + token, id);
    }
}
