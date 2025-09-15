package br.com.upvisibility.hub_bling.business.response.produtos;

import java.util.List;

public record ProdutoCreatedResponse(
        List<ProdutosList> data
) {
}
