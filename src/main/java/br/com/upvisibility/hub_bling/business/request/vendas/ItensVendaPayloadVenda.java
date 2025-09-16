package br.com.upvisibility.hub_bling.business.request.vendas;

import jakarta.validation.constraints.NotNull;

public record ItensVendaPayloadVenda(
        String codigo,
        String unidade,
        Float quantidade,
        Float desconto,
        @NotNull
        Float valor,
        @NotNull
        String descricao,
        @NotNull
        ItemVendaId produto
) {
}
