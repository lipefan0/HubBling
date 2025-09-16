package br.com.upvisibility.hub_bling.business.response.produtos;

import br.com.upvisibility.hub_bling.business.response.estoque.EstoqueProdutoListResponse;

public record ProdutosList(
        Long id,
        Long idProdutoPai,
        String descricao,
        String codigo,
        Float preco,
        Float precoCusto,
        EstoqueProdutoListResponse estoque,
        String tipo,
        String situacao,
        String formato,
        String descricaoCurta,
        String imagemURL
) {
}
