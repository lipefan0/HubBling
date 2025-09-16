package br.com.upvisibility.hub_bling.business.request.estoque;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record EstoqueRequest(
        @NotNull
        ProdutoEstoque produto,
        @NotNull
        DepositoEstoque deposito,
        @NotNull
        OperacaoEstoque operacao,
        Float preco,
        Float custo,
        @NotNull
        Float quantidade,
        String observacoes
) {
}
