package br.com.upvisibility.hub_bling.business.request.produtos;

public record VariacaoProdutoRequest(
        String nome,
        String codigo,
        Float preco,
        String tipo,
        String situacao,
        String formato,
        String descricaoCurta,
        String unidade,
        Float pesoLiquido,
        Float pesoBruto,
        String gtin,
        String gtinEmbalagem,
        String tipoProducao,
        String marca,
        String descricaoComplementar,
        String observacoes,
        Variacao variacao
) {
}
