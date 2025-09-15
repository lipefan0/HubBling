package br.com.upvisibility.hub_bling.business.request.produtos;

import java.util.List;

public record ProdutoRequest(
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
        List<VariacaoProdutoRequest> variacoes
) {
}
