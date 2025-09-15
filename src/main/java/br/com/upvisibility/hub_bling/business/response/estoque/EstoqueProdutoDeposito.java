package br.com.upvisibility.hub_bling.business.response.estoque;

public record EstoqueProdutoDeposito(
        ProdutoEstoqueResponse produto,
        Float saldoFisicoTotal,
        Float saldoVirtualTotal
) {
}
