package br.com.upvisibility.hub_bling.business.request.vendas;

public record DescontoPayloadVenda(
        Float valor,
        UnidadeDesconto unidade
) {
}
