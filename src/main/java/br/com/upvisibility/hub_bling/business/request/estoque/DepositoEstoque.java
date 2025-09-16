package br.com.upvisibility.hub_bling.business.request.estoque;

import jakarta.validation.constraints.NotNull;

public record DepositoEstoque(
        @NotNull
        Long id
) {
}
