package br.com.upvisibility.hub_bling.business.response.estoque;

import java.util.List;

public record EstoqueProdutoGeral(
        ProdutoEstoqueResponse produto,
        Float saldoFisicoTotal,
        Float saldoVirtualTotal,
        List<DepositoEstoqueResponse> depositos
) {
}
