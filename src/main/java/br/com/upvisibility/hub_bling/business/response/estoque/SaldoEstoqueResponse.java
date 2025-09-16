package br.com.upvisibility.hub_bling.business.response.estoque;

import java.util.List;

public record SaldoEstoqueResponse(
        List<EstoqueProdutoGeral> data
) {
}
