package br.com.upvisibility.hub_bling.business.response.lojas;

import java.util.List;

public record LojaResponse(
        List<LojaList> data
) {
}
