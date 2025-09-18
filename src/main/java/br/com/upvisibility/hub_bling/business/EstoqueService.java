package br.com.upvisibility.hub_bling.business;

import br.com.upvisibility.hub_bling.business.request.estoque.EstoqueRequest;
import br.com.upvisibility.hub_bling.business.response.estoque.SaldoEstoqueDepositoResponse;
import br.com.upvisibility.hub_bling.business.response.estoque.SaldoEstoqueResponse;
import br.com.upvisibility.hub_bling.infra.client.BlingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final BlingClient blingClient;

    public void registroEstoque(String token, EstoqueRequest estoqueRequest) {
        blingClient.criaRegistroEstoque("Bearer " + token, estoqueRequest);
    }

    public SaldoEstoqueResponse buscarSaldoEstoque(String token, List<Long> idProduto) {
        return blingClient.buscarSaldoEstoque("Bearer " + token, idProduto);
    }

    public SaldoEstoqueDepositoResponse buscarSaldoEstoqueDeposito(String token, List<Long> idProduto, Long idDeposito) {
        return blingClient.buscarSaldoEstoqueDeposito("Bearer " + token, idProduto, idDeposito);
    }
}
