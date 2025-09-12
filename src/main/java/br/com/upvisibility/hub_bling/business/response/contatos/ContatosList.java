package br.com.upvisibility.hub_bling.business.response.contatos;

public record ContatosList(
        Long id,
        String nome,
        String codigo,
        String situacao,
        String numeroDocumento,
        String telefone,
        String celular
) {
}
