package br.com.upvisibility.hub_bling.business.response.vendas;

public record ContatoResponseVenda(
        Long id,
        String nome,
        String tipoPessoa,
        String numeroDocumento
) {
}
