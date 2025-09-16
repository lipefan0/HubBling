package br.com.upvisibility.hub_bling.business.response.fpagamentos;

import java.util.List;

public record FPagamentoCreatedResponse(
        List<FPagamentoCreatedId> data
) {
}
