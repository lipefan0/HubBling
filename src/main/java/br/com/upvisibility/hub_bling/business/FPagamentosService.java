package br.com.upvisibility.hub_bling.business;

import br.com.upvisibility.hub_bling.business.request.fpagamentos.FPagamentoRequest;
import br.com.upvisibility.hub_bling.business.response.fpagamentos.FPagamentoCreatedResponse;
import br.com.upvisibility.hub_bling.business.response.fpagamentos.FPagamentoResponse;
import br.com.upvisibility.hub_bling.infra.client.BlingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FPagamentosService {

    private final BlingClient blingClient;

    public FPagamentoCreatedResponse criarFormaPagamento(String token, FPagamentoRequest request) {
        return blingClient.criarFormaPagamento("Bearer " + token, request);
    }

    public FPagamentoResponse listarFormasPagamentos(String token) {
        return blingClient.listarFormasPagamentos("Bearer " + token);
    }

    public FPagamentoResponse buscarFormaPagamentoPorNome(String token, String nome) {
        return blingClient.buscarFormaPagamentoPorNome("Bearer " + token, nome);
    }
}
