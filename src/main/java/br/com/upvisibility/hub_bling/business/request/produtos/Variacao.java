package br.com.upvisibility.hub_bling.business.request.produtos;

public record Variacao(
        String nome,
        Integer ordem,
        ClonarProdutoPai produtoPai
) {
}
