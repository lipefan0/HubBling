package br.com.upvisibility.hub_bling.business.request.fpagamentos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record FPagamentoRequest(
        @NotNull
        @Size(min = 1)
        String descricao,
        @NotNull
        TipoPagamento tipoPagamento,
        @NotNull
        String codicao,
        @NotNull
        Situacao situacao,
        @NotNull
        Padrao padrao,
        @NotNull
        Finalidade finalidade,
        @NotNull
        Destino destino,
        Taxas taxas
) {
}
