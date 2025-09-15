package br.com.upvisibility.hub_bling.business.response.lojas;

public record LojaList(
        Long id,
        String descricao,
        String tipo,
        Integer situacao
) {
}
