package br.com.upvisibility.hub_bling.business.response.vendas;

import java.util.List;

public record VendaListResponse(
        List<VendaResponse> data
) {
}
