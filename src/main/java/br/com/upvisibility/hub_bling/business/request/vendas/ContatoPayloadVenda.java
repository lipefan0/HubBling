package br.com.upvisibility.hub_bling.business.request.vendas;

import jakarta.validation.constraints.NotNull;

public record ContatoPayloadVenda(
        @NotNull
        Long id,
        String tipoPessoa,
        String numeroDocumento
) {
}
